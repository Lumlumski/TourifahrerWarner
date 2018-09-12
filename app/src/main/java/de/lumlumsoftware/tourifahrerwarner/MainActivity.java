package de.lumlumsoftware.tourifahrerwarner;

import android.app.Application;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import javax.xml.xpath.XPathConstants;

class TFWarnerApplication extends Application
{
    static MQTTClient mqttClient;

    public static void setMqttClient(MQTTClient client)
    {
        mqttClient = client;
    }

    public static MQTTClient getMqttClient()
    {
        return mqttClient;
    }
}

public class MainActivity extends AppCompatActivity
{
    MQTTClient mqttClient;
    void initializeMqttClient(MQTTClient client)
    {
        TFWarnerApplication.setMqttClient(client);
    }

    Button liveModeBtn;
    Button adminModeBtn;
    Button settingsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        liveModeBtn = (Button)findViewById(R.id.liveModeBtn);
        liveModeBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent liveModeIntent = new Intent(MainActivity.this, LiveModeActivity.class);
                startActivity(liveModeIntent);
            }
        });

        adminModeBtn = (Button)findViewById(R.id.adminModeBtn);
        adminModeBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent adminModeIntent = new Intent(MainActivity.this, PublishActivity.class);
                startActivity(adminModeIntent);
            }
        });

        settingsBtn = (Button)findViewById(R.id.settingsBtn);
        settingsBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent settingsIntent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(settingsIntent);
            }
        });

        startMqtt();
    }

    private void startMqtt(){
        mqttClient = new MQTTClient(getApplicationContext());
        initializeMqttClient(mqttClient);
        mqttClient.setCallback(new MqttCallbackExtended() {
            @Override
            public void connectComplete(boolean b, String s) {

            }

            @Override
            public void connectionLost(Throwable throwable) {

            }

            @Override
            public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
                Log.w("Debug",mqttMessage.toString());
                String[] splittedTopic = topic.split("/");
                String shownMsg = splittedTopic[splittedTopic.length-1] + ": " + mqttMessage.toString();
                Toast.makeText(MainActivity.this, shownMsg, Toast.LENGTH_LONG).show();
            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

            }
        });
    }
}

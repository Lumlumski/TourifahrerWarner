package de.lumlumsoftware.tourifahrerwarner;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.io.UnsupportedEncodingException;

public class PublishActivity extends AppCompatActivity
{
    MQTTClient mqttClient;
    TextInputEditText textInput;
    Button sendInfoBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish);
        mqttClient = TFWarnerApplication.getMqttClient();
        textInput = (TextInputEditText)findViewById(R.id.textInput);
        sendInfoBtn = (Button)findViewById(R.id.sendInfoBtn);

        sendInfoBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String topic = "tourifahrerwarner/nos/test";
                String payload = textInput.getText().toString();
                mqttClient.publish(topic, payload);
            }
        });
    }
}

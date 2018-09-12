package de.lumlumsoftware.tourifahrerwarner;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.io.UnsupportedEncodingException;

public class PublishActivity extends AppCompatActivity
{
    MQTTClient mqttClient;
    Spinner trackPartSpinner;
    Spinner occurenceSpinner;
    Button sendInfoBtn;

    String[] trackPartItems = new String[]{
            "Antoniusbuche"
            , "Tiergarten"
            , "Hohenrain"
            , "Hatzenbach"
            , "QuiddelbacherHoehe"
            , "Flugplatz"
            , "Schwedenkreuz"
            , "Aremberg"
            , "Fuchsroehre"
            , "AdenauerForst"
            , "Metzgesfeld"
            , "Kallenhard"
            , "Wehrseifen"
            , "ExMuehle"
            , "Bergwerk"
            , "Kesselchen"
            , "Klostertal"
            , "Karussell"
            , "HoheAcht"
            , "Wippermann"
            , "Eschbach"
            , "Bruennchen"
            , "Pflanzgarten"
            , "StefanBellofS"
            , "Schwalbenschwanz"
            , "Galgenkopf"
            , "DoettingerHoehe"};

    String[] occurenceItems = new String[]{
            "YellowFlag"
            , "TechnicalDefect"
            , "LossOfLiquids"
            , "NoOccurence"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish);
        mqttClient = TFWarnerApplication.getMqttClient();

        trackPartSpinner = (Spinner)findViewById(R.id.trackPartSpinner);
        final ArrayAdapter<String> trackPartAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, trackPartItems);
        trackPartSpinner.setAdapter(trackPartAdapter);

        occurenceSpinner = (Spinner)findViewById(R.id.occurenceSpinner);
        final ArrayAdapter<String> occurenceAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, occurenceItems);
        occurenceSpinner.setAdapter(occurenceAdapter);

        sendInfoBtn = (Button)findViewById(R.id.sendInfoBtn);
        sendInfoBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String topic = "tourifahrerwarner/nos/" + trackPartSpinner.getSelectedItem().toString();
                String payload = occurenceSpinner.getSelectedItem().toString();
                mqttClient.publish(topic, payload);
            }
        });
    }
}

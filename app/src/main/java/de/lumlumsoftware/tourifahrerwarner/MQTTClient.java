package de.lumlumsoftware.tourifahrerwarner;

import android.content.Context;
import android.util.Log;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.DisconnectedBufferOptions;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

public class MQTTClient
{
    MqttAndroidClient mqttAndroidClient;
    final String clientId = "TFWarner_" + UUID.randomUUID().toString();
    final String serverUri = "tcp://broker.hivemq.com:1883";
    final String subscriptionTopic = "tourifahrerwarner/nos/+";
    //final String username = "";
    //final String password = "";

    public MQTTClient(Context context)
    {
        mqttAndroidClient = new MqttAndroidClient(context, serverUri, clientId);
        connect();
    }

    public void setCallback(MqttCallbackExtended callback)
    {
        mqttAndroidClient.setCallback(callback);
    }

    private void connect()
    {
        MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
        mqttConnectOptions.setAutomaticReconnect(true);
        mqttConnectOptions.setCleanSession(true);
        //mqttConnectOptions.setUserName(username);
        //mqttConnectOptions.setPassword(password.toCharArray());

        try
        {
            mqttAndroidClient.connect(mqttConnectOptions, null, new IMqttActionListener()
            {
                @Override
                public void onSuccess(IMqttToken asyncActionToken)
                {

                    DisconnectedBufferOptions disconnectedBufferOptions = new DisconnectedBufferOptions();
                    disconnectedBufferOptions.setBufferEnabled(true);
                    disconnectedBufferOptions.setBufferSize(100);
                    disconnectedBufferOptions.setPersistBuffer(false);
                    disconnectedBufferOptions.setDeleteOldestMessages(false);
                    mqttAndroidClient.setBufferOpts(disconnectedBufferOptions);
                    subscribeToTopic();
                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception)
                {
                    Log.w("Mqtt", "Failed to connect to: " + serverUri + exception.toString());
                }
            });


        }
        catch (MqttException ex)
        {
            ex.printStackTrace();
        }
    }

    private void subscribeToTopic()
    {
        try
        {
            mqttAndroidClient.subscribe(subscriptionTopic, 0, null, new IMqttActionListener()
            {
                @Override
                public void onSuccess(IMqttToken asyncActionToken)
                {
                    Log.w("Mqtt","Subscribed!");
                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception)
                {
                    Log.w("Mqtt", "Subscribed fail!");
                }
            });

        }
        catch (MqttException ex)
        {
            System.err.println("Exceptionst subscribing");
            ex.printStackTrace();
        }
    }

    public void publish(String topic, String payload)
    {
        byte[] encodedPayload = new byte[0];

        try
        {
            encodedPayload = payload.getBytes("UTF-8");
            MqttMessage message = new MqttMessage(encodedPayload);
            //message.setRetained(true);
            mqttAndroidClient.publish(topic, message);
            Log.w("Publish", "Publishing " + message);
        }
        catch (UnsupportedEncodingException | MqttException e)
        {
            e.printStackTrace();
        }
    }
}
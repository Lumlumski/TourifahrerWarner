package de.lumlumsoftware.tourifahrerwarner;

import android.app.Application;

import de.lumlumsoftware.tourifahrerwarner.backend.MQTTClient;
import de.lumlumsoftware.tourifahrerwarner.backend.status.StatusData;

class TFWarnerApplication extends Application
{
    static MQTTClient mqttClient;
    static StatusData statusData;

    public static void setMqttClient(MQTTClient client)
    {
        mqttClient = client;
    }

    public static MQTTClient getMqttClient()
    {
        return mqttClient;
    }

    public static void setStatusData(StatusData data)
    {
        statusData = data;
    }

    public static StatusData getStatusData()
    {
        return statusData;
    }
}

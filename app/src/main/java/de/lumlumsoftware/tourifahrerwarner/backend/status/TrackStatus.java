package de.lumlumsoftware.tourifahrerwarner.backend.status;

public class TrackStatus
{
    final private String TOPIC = "track";
    private Status m_status;

    public enum Status
    {
        OPEN,
        CLOSED_FOR_BIKES,
        CLOSED
    }

    public TrackStatus()
    {
        m_status = Status.OPEN;
    }

    public String getTopic()
    {
        return TOPIC;
    }

    public Status getStatus()
    {
        return m_status;
    }

    public void setStatus(Status status)
    {
        m_status = status;
    }

    public static Status getTrackStatusForString(String statusString)
    {
        if (statusString == "open")
        {
            return Status.OPEN;
        }

        if (statusString == "closedForBikes")
        {
            return Status.CLOSED_FOR_BIKES;
        }

        return Status.CLOSED;
    }
}

package de.lumlumsoftware.tourifahrerwarner.backend.status;

import java.util.HashMap;
import java.util.Observable;


public class StatusData extends Observable
{
    private static StatusData INSTANCE;

    TrackStatus m_trackStatus;
    HashMap<TrackSection, SectionStatus> m_trackSectionStatusList;

    public StatusData()
    {
        m_trackStatus = new TrackStatus();
        m_trackSectionStatusList = new HashMap();
        m_trackSectionStatusList.put(TrackSection.ANTONIUSBUCHE, SectionStatus.NORMAL);
        m_trackSectionStatusList.put(TrackSection.TIERGARTEN, SectionStatus.NORMAL);
        m_trackSectionStatusList.put(TrackSection.HOHENRAIN, SectionStatus.NORMAL);
        m_trackSectionStatusList.put(TrackSection.HATZENBACH, SectionStatus.NORMAL);
        m_trackSectionStatusList.put(TrackSection.QUIDDELBACHER_HOEHE, SectionStatus.NORMAL);
        m_trackSectionStatusList.put(TrackSection.FLUGPLATZ, SectionStatus.NORMAL);
        m_trackSectionStatusList.put(TrackSection.SCHWEDENKREUZ, SectionStatus.NORMAL);
        m_trackSectionStatusList.put(TrackSection.AREMBERG, SectionStatus.NORMAL);
        m_trackSectionStatusList.put(TrackSection.FUCHSROEHRE, SectionStatus.NORMAL);
        m_trackSectionStatusList.put(TrackSection.ADENAUER_FORST, SectionStatus.NORMAL);
        m_trackSectionStatusList.put(TrackSection.METZGESFELD, SectionStatus.NORMAL);
        m_trackSectionStatusList.put(TrackSection.KALLENHARD, SectionStatus.NORMAL);
        m_trackSectionStatusList.put(TrackSection.WEHRSEIFEN, SectionStatus.NORMAL);
        m_trackSectionStatusList.put(TrackSection.EX_MUEHLE, SectionStatus.NORMAL);
        m_trackSectionStatusList.put(TrackSection.BERGWERK, SectionStatus.NORMAL);
        m_trackSectionStatusList.put(TrackSection.KESSELCHEN, SectionStatus.NORMAL);
        m_trackSectionStatusList.put(TrackSection.KLOSTERTAL, SectionStatus.NORMAL);
        m_trackSectionStatusList.put(TrackSection.KARUSSELL, SectionStatus.NORMAL);
        m_trackSectionStatusList.put(TrackSection.HOHE_ACHT, SectionStatus.NORMAL);
        m_trackSectionStatusList.put(TrackSection.WIPPERMANN, SectionStatus.NORMAL);
        m_trackSectionStatusList.put(TrackSection.ESCHBACH, SectionStatus.NORMAL);
        m_trackSectionStatusList.put(TrackSection.BRUENNCHEN, SectionStatus.NORMAL);
        m_trackSectionStatusList.put(TrackSection.PFLANZGARTEN, SectionStatus.NORMAL);
        m_trackSectionStatusList.put(TrackSection.STEFAN_BELLOF_S, SectionStatus.NORMAL);
        m_trackSectionStatusList.put(TrackSection.SCHWALBENSCHWANZ, SectionStatus.NORMAL);
        m_trackSectionStatusList.put(TrackSection.GALGENKOPF, SectionStatus.NORMAL);
        m_trackSectionStatusList.put(TrackSection.DOETTINGER_HOEHE, SectionStatus.NORMAL);
    }

    public StatusData getInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new StatusData();
        }

        return INSTANCE;
    }

    public void setTrackStatus(TrackStatus.Status status)
    {
        m_trackStatus.setStatus(status);
        setChanged();
        notifyObservers(m_trackStatus);
    }

    public void setStatusForTrackSection(TrackSection section, SectionStatus status)
    {
        m_trackSectionStatusList.put(section, status);
        //setChanged();
        //notifyObservers(m_trackSectionStatusList);
    }

    public SectionStatus getStatusForTrackSection(TrackSection section)
    {
        return m_trackSectionStatusList.get(section);
    }

    public String getTrackTopic()
    {
        return m_trackStatus.getTopic();
    }

    public enum TrackSection
    {
        NO_SECTION,
        ANTONIUSBUCHE,
        TIERGARTEN,
        HOHENRAIN,
        HATZENBACH,
        QUIDDELBACHER_HOEHE,
        FLUGPLATZ,
        SCHWEDENKREUZ,
        AREMBERG,
        FUCHSROEHRE,
        ADENAUER_FORST,
        METZGESFELD,
        KALLENHARD,
        WEHRSEIFEN,
        EX_MUEHLE,
        BERGWERK,
        KESSELCHEN,
        KLOSTERTAL,
        KARUSSELL,
        HOHE_ACHT,
        WIPPERMANN,
        ESCHBACH,
        BRUENNCHEN,
        PFLANZGARTEN,
        STEFAN_BELLOF_S,
        SCHWALBENSCHWANZ,
        GALGENKOPF,
        DOETTINGER_HOEHE
    }

    public enum SectionStatus
    {
        NORMAL,
        ACCIDENT,
        YELLOW_FLAG,
        TECHNICAL_DEFECT,
        LIQUIDS
    }

    public String getTopicForTrackSection(TrackSection section)
    {
        String topic = new String();

        switch (section)
        {
            case ANTONIUSBUCHE:
                topic = "antoniusbuche";
                break;
            case TIERGARTEN:
                topic = "tiergarten";
                break;
            case HOHENRAIN:
                topic = "hohenrain";
                break;
            case HATZENBACH:
                topic = "hatzenbach";
                break;
            case QUIDDELBACHER_HOEHE:
                topic = "quiddelbacherhoehe";
                break;
            case FLUGPLATZ:
                topic = "flugplatz";
                break;
            case SCHWEDENKREUZ:
                topic = "schwedenkreuz";
                break;
            case AREMBERG:
                topic = "aremberg";
                break;
            case FUCHSROEHRE:
                topic = "fuchsroehre";
                break;
            case ADENAUER_FORST:
                topic = "adenauerforst";
                break;
            case METZGESFELD:
                topic = "metzgesfeld";
                break;
            case KALLENHARD:
                topic = "kallenhard";
                break;
            case WEHRSEIFEN:
                topic = "wehrseifen";
                break;
            case EX_MUEHLE:
                topic = "exmuehle";
                break;
            case BERGWERK:
                topic = "bergwerg";
                break;
            case KESSELCHEN:
                topic = "kesselchen";
                break;
            case KLOSTERTAL:
                topic = "klostertal";
                break;
            case KARUSSELL:
                topic = "karussell";
                break;
            case HOHE_ACHT:
                topic = "hoheacht";
                break;
            case WIPPERMANN:
                topic = "wippermann";
                break;
            case ESCHBACH:
                topic = "eschbach";
                break;
            case BRUENNCHEN:
                topic = "bruennchen";
                break;
            case PFLANZGARTEN:
                topic = "pflanzgarten";
                break;
            case STEFAN_BELLOF_S:
                topic = "stefanbellofs";
                break;
            case SCHWALBENSCHWANZ:
                topic = "schwalbenschwanz";
                break;
            case GALGENKOPF:
                topic = "galgenkopf";
                break;
            case DOETTINGER_HOEHE:
                topic = "doettingerhoehe";
                break;
            case NO_SECTION:
            default:
                break;
        }

        return topic;
    }

    public TrackSection getTrackSectionForTopic(String topic)
    {
        TrackSection section = TrackSection.NO_SECTION;

        switch (topic)
        {
            case "antoniusbuche":
                section = TrackSection.ANTONIUSBUCHE;
                break;
            case "tiergarten":
                section = TrackSection.TIERGARTEN;
                break;
            case "hohenrain":
                section = TrackSection.HOHENRAIN;
                break;
            case "hatzenbach":
                section = TrackSection.HATZENBACH;
                break;
            case "quiddelbacherhoehe":
                section = TrackSection.QUIDDELBACHER_HOEHE;
                break;
            case "flugplatz":
                section = TrackSection.FLUGPLATZ;
                break;
            case "schwedenkreuz":
                section = TrackSection.SCHWEDENKREUZ;
                break;
            case "aremberg":
                section = TrackSection.AREMBERG;
                break;
            case "fuchsroehre":
                section = TrackSection.FUCHSROEHRE;
                break;
            case "adenauerforst":
                section = TrackSection.ADENAUER_FORST;
                break;
            case "metzgesfeld":
                section = TrackSection.METZGESFELD;
                break;
            case "kallenhard":
                section = TrackSection.KALLENHARD;
                break;
            case "wehrseifen":
                section = TrackSection.WEHRSEIFEN;
                break;
            case "exmuehle":
                section = TrackSection.EX_MUEHLE;
                break;
            case "bergwerg":
                section = TrackSection.BERGWERK;
                break;
            case "kesselchen":
                section = TrackSection.KESSELCHEN;
                break;
            case "klostertal":
                section = TrackSection.KLOSTERTAL;
                break;
            case "karussell":
                section = TrackSection.KARUSSELL;
                break;
            case "hoheacht":
                section = TrackSection.HOHE_ACHT;
                break;
            case "wippermann":
                section = TrackSection.WIPPERMANN;
                break;
            case "eschbach":
                section = TrackSection.ESCHBACH;
                break;
            case "bruennchen":
                section = TrackSection.BRUENNCHEN;
                break;
            case "pflanzgarten":
                section = TrackSection.PFLANZGARTEN;
                break;
            case "stefanbellofs":
                section = TrackSection.STEFAN_BELLOF_S;
                break;
            case "schwalbenschwanz":
                section = TrackSection.SCHWALBENSCHWANZ;
                break;
            case "galgenkopf":
                section = TrackSection.GALGENKOPF;
                break;
            case "doettingerhoehe":
                section = TrackSection.DOETTINGER_HOEHE;
                break;
        }

        return section;
    }
}
package com.example.mymosque;

import com.google.gson.annotations.SerializedName;

public class AdModel
{
    @SerializedName("ads_id")
    private String ads_id;
    private String duration;
    private String file_name;
    private String file_path;
    private String show_time;
    private String m_id;
    private String is_active;
    private String timestamp;
    private String start_date;
    private String end_date;

    public AdModel(String ads_id, String duration, String file_name, String file_path, String show_time, String m_id, String is_active, String timestamp, String start_date, String end_date) {
        this.ads_id = ads_id;
        this.duration = duration;
        this.file_name = file_name;
        this.file_path = file_path;
        this.show_time = show_time;
        this.m_id = m_id;
        this.is_active = is_active;
        this.timestamp = timestamp;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public String getAds_id() {
        return ads_id;
    }

    public void setAds_id(String ads_id) {
        this.ads_id = ads_id;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public String getShow_time() {
        return show_time;
    }

    public void setShow_time(String show_time) {
        this.show_time = show_time;
    }

    public String getM_id() {
        return m_id;
    }

    public void setM_id(String m_id) {
        this.m_id = m_id;
    }

    public String getIs_active() {
        return is_active;
    }

    public void setIs_active(String is_active) {
        this.is_active = is_active;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }
}

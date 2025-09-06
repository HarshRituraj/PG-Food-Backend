package com.example.pg_food_backend.dto;

import java.util.Date;

public class ResponseDto {
    private int yesCount;
    private int noCount;
    private int notSureCount;
    private Date date;

    public ResponseDto() {
    }

    public ResponseDto(int yesCount, int noCount, int notSureCount, Date date) {
        this.yesCount = yesCount;
        this.noCount = noCount;
        this.notSureCount = notSureCount;
        this.date = date;
    }

    public int getYesCount() {
        return yesCount;
    }

    public void setYesCount(int yesCount) {
        this.yesCount = yesCount;
    }

    public int getNoCount() {
        return noCount;
    }

    public void setNoCount(int noCount) {
        this.noCount = noCount;
    }

    public int getNotSureCount() {
        return notSureCount;
    }

    public void setNotSureCount(int notSureCount) {
        this.notSureCount = notSureCount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "yesCount=" + yesCount +
                ", noCount=" + noCount +
                ", notSureCount=" + notSureCount +
                ", date=" + date +
                '}';
    }
}

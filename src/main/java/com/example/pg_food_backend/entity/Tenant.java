package com.example.pg_food_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

@Entity
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tenantId;
    private int roomNo;
    private String response;
    private Date date;

    public Tenant() {
    }

    public Tenant(long tenantId, int roomNo, String response, Date date) {
        this.tenantId = tenantId;
        this.roomNo = roomNo;
        this.response = response;
        this.date = date;
    }

    public long getTenantId() {
        return tenantId;
    }

    public void setTenantId(long tenantId) {
        this.tenantId = tenantId;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Tenant{" +
                "tenantId=" + tenantId +
                ", roomNo=" + roomNo +
                ", response='" + response + '\'' +
                ", date=" + date +
                '}';
    }
}

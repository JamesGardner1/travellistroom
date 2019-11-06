package com.example.travelwishlist;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.text.DateFormat;
import java.util.Date;


@Entity
public class Place {


    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    private String name;

    private Date date;

    private String reason;

    public Place(@NonNull String name, String reason) {
        this.name = name;
        this.reason = reason;
        this.date = new Date();
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {this.name = name;}

    public String getReason() { return reason;}

    public void setReason(String reason) {this.reason = reason;}

    public String getDateCreated() {
        return DateFormat.getDateInstance().format(date);
    }



    // Return Data Record
    @Override
    public String toString() {
        return "Place{" + "name=" + name + ", reason=" + reason + ", date=" + date + '}';
    }
}

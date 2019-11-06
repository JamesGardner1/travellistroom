package com.example.travelwishlist;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.text.DateFormat;
import java.util.Date;


@Entity
public class Place {


    @PrimaryKey
    private String name;

    private Date dateCreated;

    private String reason;

    public Place(String name, String reason) {
        this.name = name;
        this.reason = reason;
        this.dateCreated = new Date();
    }

    public String getName() {
        return name;
    }

    public String getReason() { return reason;}

    public String getDateCreated() {
        return DateFormat.getDateInstance().format(dateCreated);
    }

    // Return Data Record
    @Override
    public String toString() {
        return "Place{" + "name=" + name + ", reason=" + reason + ", date" + dateCreated + '}';
    }
}

package com.example.unibooks.model

import androidx.room.Entity;
import androidx.room.Primarykey;

@Entity(tableName="book_event")
public class MeetUp{
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String title;
    public String location;
    public String date;
}
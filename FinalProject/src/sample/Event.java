package sample;

import javafx.scene.control.TextField;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event {
    public String name;
    public Date date;
    public String desc;

    //constructor
    public Event(String n, Date da, String de){
        this.name = n;
        this.date = da;
        this.desc = de;

    }

    public void writeToFile(TextField listName) throws IOException{

        FileWriter fw = new FileWriter(listName.getText()+".txt",true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(name+",\r");
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        bw.write(df.format(date)+".\r");
        bw.write(desc+"\r");
        bw.write(";\r");
        bw.close();
    }



    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public String getDesc() {
        return desc;
    }



    public String toString() {
        return name;
    }
}


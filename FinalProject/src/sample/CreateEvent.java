package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class CreateEvent {
    private static String name;
    private static String date;
    private static String desc;
    private static FileReader fr;
    private static BufferedReader br;
    private static ArrayList<Event> events = new ArrayList<>();



    public static ArrayList createAllEvents(String fileName) throws IOException, ParseException {
        fr = new FileReader(fileName);
        br = new BufferedReader(fr);
        String line;
        String eventString = "";
        while ((line = br.readLine()) != null) {
            if (!line.equals(";")) {
                eventString += line;
            } else {
                parseEvent(eventString);
                eventString = "";
            }

        }
        System.out.println(events);
        return events;

    }

    private static void parseEvent(String string) throws ParseException {
        {
            int pos = 0;
            int newpos = 0;
            String name;
            Date date;
            String desc;

            for (int i = 0; i < string.length(); i++) {
                if (string.substring(i, i + 1).equals(",")) {
                    pos = i;
                }

                if (string.substring(i, i + 1).equals(".")) {
                    newpos = i;

                }
            }

            name = string.substring(0, pos);

            date = new SimpleDateFormat("dd-MM-yyyy").parse(string.substring(pos + 1, newpos));

            desc = string.substring(newpos + 1);


            events.add(new Event(name, date, desc));

            System.out.println(events);


        }


    }
}


package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class Controller {
    public TextField textGetName;
    public TextArea textGetDescription;
    public DatePicker pickerGetDate;

    public ListView<Event> eventList = new ListView<>();

    public Label labelName;
    public Label labelDesc;
    public Label labelDate;

    public Button removeButton;

    public TextField saveListName;
    public TextField loadListName;

    public ListView<String> listList = new ListView<>();

    public Label monthYear;

    public ListView<Event> listSun = new ListView<>();
    public ListView<Event> listMon = new ListView<>();
    public ListView<Event> listTue = new ListView<>();
    public ListView<Event> listWed = new ListView<>();
    public ListView<Event> listThu = new ListView<>();
    public ListView<Event> listFri = new ListView<>();
    public ListView<Event> listSat = new ListView<>();

    public Label labelSun;
    public Label labelMon;
    public Label labelTue;
    public Label labelWed;
    public Label labelThu;
    public Label labelFri;
    public Label labelSat;

    public ArrayList<Label> days = new ArrayList<>();

    public int weekNum = 0;

    //labels for the weekly planner
    public Label labelDesc1;
    public Label labelName1;
    public Label errorLabel;
    public Button createButton;


    public void addEvent(ActionEvent actionEvent) { //adds event and clears the entry fields and disables remove button. Should not add if empty
        if(textGetName.getText().isEmpty()||pickerGetDate.getValue()==null||textGetDescription.getText().isEmpty()) {
            errorLabel.setText("error: invalid or missing input");

        }
        else {
            Event temp = new Event(textGetName.getText(), java.sql.Date.valueOf(pickerGetDate.getValue()), textGetDescription.getText());
            eventList.getItems().add(temp);
            //clear labels
            textGetName.clear();
            pickerGetDate.setValue(null);
            textGetDescription.clear();
            errorLabel.setText("");
            //disable remove button
            removeButton.setDisable(true);
        }

    }




    public void displayEvent(MouseEvent mouseEvent) { //shows selected event's info and enables remove button (the isHover was used so the program would know which list's event to display)
        if (eventList.isHover()) {
            Event temp = eventList.getSelectionModel().getSelectedItem();
            labelName.setText(temp.getName());
            labelDesc.setText(temp.getDesc());
            SimpleDateFormat df = new SimpleDateFormat("E, dd MMM yyyy");
            labelDate.setText(df.format(temp.getDate()));
            removeButton.setDisable(false);
        }
        if (listMon.isHover()) {
            Event temp1 = listMon.getSelectionModel().getSelectedItem();
            labelName1.setText(temp1.getName());
            labelDesc1.setText(temp1.getDesc());
        }
        if (listTue.isHover()) {
            Event temp2 = listTue.getSelectionModel().getSelectedItem();
            labelName1.setText(temp2.getName());
            labelDesc1.setText(temp2.getDesc());
        }
        if (listWed.isHover()) {
            Event temp3 = listWed.getSelectionModel().getSelectedItem();
            labelName1.setText(temp3.getName());
            labelDesc1.setText(temp3.getDesc());
        }
        if (listThu.isHover()) {
            Event temp4 = listThu.getSelectionModel().getSelectedItem();
            labelName1.setText(temp4.getName());
            labelDesc1.setText(temp4.getDesc());
        }
        if (listFri.isHover()) {
            Event temp5 = listFri.getSelectionModel().getSelectedItem();
            labelName1.setText(temp5.getName());
            labelDesc1.setText(temp5.getDesc());
        }
        if (listSat.isHover()) {
            Event temp6 = listSat.getSelectionModel().getSelectedItem();
            labelName1.setText(temp6.getName());
            labelDesc1.setText(temp6.getDesc());
        }
        if (listSun.isHover()) {
            Event temp7 = listSun.getSelectionModel().getSelectedItem();
            labelName1.setText(temp7.getName());
            labelDesc1.setText(temp7.getDesc());
        }



    }



    public void removeEvent(ActionEvent actionEvent) {//removes event from list and disables remove button
        Event temp;
        temp = eventList.getSelectionModel().getSelectedItem();
        eventList.getItems().remove(temp);
        labelName.setText("");
        labelDesc.setText("");
        labelDate.setText("");
        removeButton.setDisable(true);
    }

    public void saveList(ActionEvent actionEvent) throws IOException { //saves the events in the list to a file using the writeToFile function. also clears labels and list name
        ObservableList<Event> myList = eventList.getItems();
        for (Event f : myList) {
            f.writeToFile(saveListName);
        }
        listList.getItems().add(saveListName.getText());
        eventList.getItems().clear();
        labelName.setText("");
        labelDesc.setText("");
        labelDate.setText("");
        saveListName.clear();
    }


    public void loadList(ActionEvent actionEvent) throws IOException, ParseException {
        eventList.getItems().clear();
        listList.getItems().clear();
        ArrayList<Event> events = CreateEvent.createAllEvents(loadListName.getText() + ".txt");
        for (Event f : events) {
            eventList.getItems().add(f);
        }
        loadListName.clear();


    }

    public void clearPlanner() {
        listMon.getItems().clear();
        listTue.getItems().clear();
        listWed.getItems().clear();
        listThu.getItems().clear();
        listFri.getItems().clear();
        listSat.getItems().clear();
        listSun.getItems().clear();


    }




    public void createDatesAndEvents() { //goes through the current week and changes labels and lists accordingly
        //clear labels
        labelName1.setText("");
        labelDesc1.setText("");

        clearPlanner();//clears all lists

        //adds the labels of the lists to an arraylist
        days.add(labelSun);
        days.add(labelMon);
        days.add(labelTue);
        days.add(labelWed);
        days.add(labelThu);
        days.add(labelFri);
        days.add(labelSat);


        //creates a calendar
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.WEEK_OF_YEAR, weekNum);//determines the week based on the weekNum controlled by the two buttons

        for (int i = Calendar.SUNDAY; i <= Calendar.SATURDAY; i++) {//creates all the days of the week
            cal.set(Calendar.DAY_OF_WEEK, i);

            days.get(i - 1).setText(cal.getTime().toString().substring(0, 3) + " " + cal.getTime().toString().substring(8, 10));//sets the labels to show day of week and the date


            SimpleDateFormat df = new SimpleDateFormat("MMMMMM yyyy");
            monthYear.setText(df.format(cal.getTime())); //sets label to show the current month and year


            //sets the label for the 1st date of each month to show month name, avoiding confusion
            if(cal.getTime().toString().substring(8, 10).equals("01")){
                days.get(i - 1).setText(cal.getTime().toString().substring(0, 3) + " " + cal.getTime().toString().substring(8, 10)+ " (" + cal.getTime().toString().substring(4, 7)+")");
            }


            //adds items from eventList to the weekly planner
            ObservableList<Event> myList = eventList.getItems();
            for (Event f : myList) { // goes through events and displays the ones for the week shown
                SimpleDateFormat df2 = new SimpleDateFormat("dd MMM yyyy");
                if (df2.format(f.getDate()).equals(df2.format(cal.getTime()))){
                    SimpleDateFormat df3 = new SimpleDateFormat("E");//date format to just show day of week
                    switch (df3.format(f.getDate())) {
                        case "Mon":
                            listMon.getItems().add(f);
                            break;
                        case "Tue":
                            listTue.getItems().add(f);
                            break;
                        case "Wed":
                            listWed.getItems().add(f);
                            break;
                        case "Thu":
                            listThu.getItems().add(f);
                            break;
                        case "Fri":
                            listFri.getItems().add(f);
                            break;
                        case "Sat":
                            listSat.getItems().add(f);
                            break;
                        case "Sun":
                            listSun.getItems().add(f);
                            break;
                    }

                }

            }


        }


    }


    public static String initializeMonthYear(Label l, Date d){//display current month and year
        SimpleDateFormat df = new SimpleDateFormat("MMMMMM yyyy");
        l.setText(df.format(d));
        return (l.getText());
    }


    public void initializePlanner(javafx.event.Event event) {//every time planner tab is visited, this code will run
        initializeMonthYear(monthYear,new Date());

        createDatesAndEvents();//executes the method above

    }


    //buttons are used to increase or decrease weekNum number which lets future or past weeks be viewed
    public void prevWeek(ActionEvent actionEvent) {
        weekNum--;
        createDatesAndEvents();//refreshes planner (changes labels)

    }

    public void nextWeek (ActionEvent actionEvent){
        weekNum++;
        createDatesAndEvents();//refreshes planner (changes labels)

    }

}
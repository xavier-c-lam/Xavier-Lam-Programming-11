package sample;

import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class TestSet {
    private Event testEvent;
    private JFXPanel panel = new JFXPanel();
    private Controller controller = new Controller();

    @Before
    public void setUp() throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        testEvent = new Event("Test",df.parse("02-02-2020"),"Testing");
    }

    @Test
    public void testInitializeMonthYear() throws Exception {//tests label that shows month and year
        controller.monthYear = new Label();
        SimpleDateFormat df = new SimpleDateFormat("MM-yyyy");
        String expectedMonthYear = "March 2020";
        String actualMonthYear = Controller.initializeMonthYear(controller.monthYear, df.parse("03-2020"));
        assertEquals(expectedMonthYear,actualMonthYear);
    }

    @Test
    public void testEventToString() {//tests the toString method of the event class
        String expResult = "Test";
        assertEquals(expResult, testEvent.toString());
    }

    public void addEvenTestInitializer() {//initializes components for the addEvent tests
        controller.errorLabel = new Label();
        controller.eventList = new ListView<>();
        controller.createButton = new Button();
        controller.pickerGetDate = new DatePicker();
        controller.textGetDescription = new TextArea();
        controller.textGetName = new TextField();
        controller.removeButton = new Button();
    }

    @Test
    public void testAddEvent() {//tests the addEvent method
        addEvenTestInitializer();

        //create mock controller components/inputs
        controller.pickerGetDate.setValue(LocalDate.of(2020, 02, 02));
        controller.textGetDescription.setText("Testing");
        controller.textGetName.setText("Test");


        //simulated button press
        ActionEvent a = new ActionEvent();
        controller.addEvent(a);
        controller.createButton.fireEvent(a);

        //test if event was added
        assertFalse(controller.eventList.getItems().isEmpty());

        //test if event is created properly by comparing to the "testEvent"
        assertEquals(testEvent.getName(),controller.eventList.getItems().get(0).getName());
        assertEquals(testEvent.getDate(),controller.eventList.getItems().get(0).getDate());
        assertEquals(testEvent.getDesc(),controller.eventList.getItems().get(0).getDesc());

        //check if remove button is disabled
        assertTrue(controller.removeButton.isDisabled());

        //check if input fields are cleared
        assertEquals("",controller.textGetName.getText());
        assertEquals("",controller.textGetDescription.getText());
        assertNull(controller.pickerGetDate.getValue());
    }

    @Test
    public void testAddEventIsEmpty() { //addEvent Method, case in which input is missing
        addEvenTestInitializer();

        //create mock controller components/inputs
        controller.pickerGetDate.setValue(null);
        controller.textGetDescription.setText("");
        controller.textGetName.setText("");


        //simulated button press
        ActionEvent a = new ActionEvent();
        controller.addEvent(a);
        controller.createButton.fireEvent(a);

        //check if remove button is still enabled
        assertFalse(controller.removeButton.isDisabled());

        //check if error message appears
        assertEquals("error: invalid or missing input", controller.errorLabel.getText());

        //event list should be empty
        assertTrue(controller.eventList.getItems().isEmpty());
    }

}
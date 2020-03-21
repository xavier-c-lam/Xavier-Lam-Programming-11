public class Teacher { //teachers in the school
    private String firstName;
    private String lastName;
    private String subject;


    Teacher() {
        firstName = "";
        lastName = "";
        subject = "";

    }

    Teacher(String firstName, String lastName, String subject) { //constructor
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String toString() { // shows name and subject when printed
        return "Name: " + this.firstName + " " + this.lastName + "  Subject: " + this.subject;

    }
}
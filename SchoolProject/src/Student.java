public class Student { // students in the school
    private String firstName;
    private String lastName;
    private int grade;
    static int sNum;
    private int studentNum;

    Student() {
        firstName = "";
        lastName = "";
        grade = 0;
        studentNum = sNum;
        sNum++;
    }
    Student(String firstName, String lastName, int grade){//constructor
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        this.studentNum = sNum;
        sNum++;//student number increases and is different for each new student

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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
    }

    public String toString(){ //shows name and grade when printed
        return "Name: " + this.firstName + " " + this.lastName + "  Grade: " + this.grade;

    }

}

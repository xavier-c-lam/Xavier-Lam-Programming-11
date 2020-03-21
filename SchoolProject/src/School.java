import java.util.ArrayList;

public class School { //the school
    private String name;
    private String city;
    private int districtNum;


    School() {
        name = "";
        city = "";
        districtNum = 0;

    }
    School(String name, String city, int districtNum){
        this.name  = name;
        this.city = city;
        this.districtNum = districtNum;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getDistrictNum() {
        return districtNum;
    }

    public void setDistrictNum(int districtNum) {
        this.districtNum = districtNum;
    }

    public String toString() {
        return "Name: " + this.name + "  City: " + this.city + "  District #: " + this.districtNum;
    }


    ArrayList<Teacher> teachers = new ArrayList<>();
    ArrayList<Student> students = new ArrayList<>();
    ArrayList courses = new ArrayList();

    public void addTeacher(Teacher x){ //adds a teacher to the list
        courses.add(x.getSubject());
        teachers.add(x);
    }
    public void addStudent(Student x){ //adds a student to list
        students.add(x);
    }

    public void removeTeacher(Teacher x){ //removes a teacher from the list
        teachers.remove(x);
        courses.remove(x.getSubject());
    }
    public void removeStudent(Student x){ //removes a student from list
        students.remove(x);
    }

    public void showTeachers(){ //shows list of all teachers
        System.out.println("TEACHER LIST:");   
        teachers.forEach(System.out::println);

    }
    public void showStudents(){ //shows list of all students
        System.out.println("STUDENT LIST:");
        students.forEach(System.out::println);

    }
    public void showCourses(){ //shows all courses taught by teachers on the list
        System.out.println("Courses:");
        courses.forEach(System.out::println);
    }



}

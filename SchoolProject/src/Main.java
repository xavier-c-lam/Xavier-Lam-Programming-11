public class Main {
    public static void main(String[] args) {
        School pg = new School("Point Grey", "Vancouver", 39);
        Student xavier = new Student("Xavier", "Lam", 11);
        Student bob = new Student("Bob", "Joe", 12);
        Student fred = new Student("Fred", "Joe", 10);
        Student tom = new Student("Tom", "Cruise", 12);
        Student jim = new Student("Jim", "Smith", 9);
        Student joe = new Student("Joe", "Joe", 12);
        Student jack = new Student("Jack", "Bro", 8);
        Student chris = new Student("Chris", "Evans", 9);
        Student lisa = new Student("Lisa", "Smith", 12);
        Student sam = new Student("Sam", "Jackson", 12);

        Teacher hamilton = new Teacher("Alex", "Hamilton", "socials");
        Teacher smith = new Teacher("John", "Smith", "math");
        Teacher michael = new Teacher("George", "Michael", "band");

        pg.addStudent(xavier);
        pg.addStudent(bob);
        pg.addStudent(fred);
        pg.addStudent(tom);
        pg.addStudent(jim);
        pg.addStudent(joe);
        pg.addStudent(jack);
        pg.addStudent(chris);
        pg.addStudent(lisa);
        pg.addStudent(sam);


        pg.addTeacher(hamilton);
        pg.addTeacher(smith);
        pg.addTeacher(michael);

        pg.showStudents();
        pg.showTeachers();
        pg.showCourses();

        pg.removeStudent(sam);
        pg.removeStudent(xavier);
        pg.removeTeacher(hamilton);

        System.out.println("");

        pg.showStudents();
        pg.showTeachers();
        pg.showCourses();








    }

}

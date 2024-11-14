class Person {

  private String name;
  private String birthDate;

  Person(String name, String birthDate) {
    this.name = name;
    this.birthDate = birthDate;
  }

  String getName() {
    return name;
  }

  void setName(String name) {
    this.name = name;
  }

  String getBirthDate() {
    return birthDate;
  }

  void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }

  void displayPersonDetails() {
    System.out.println("Name: " + name);
    System.out.println("Birth Date: " + birthDate);
  }
}

class CollegeGraduate extends Person {
  private double GPA;
  private int graduationYear;

  CollegeGraduate(String name, String birthDate, double GPA, int graduationYear) {
    super(name, birthDate);
    this.GPA = GPA;
    this.graduationYear = graduationYear;
  }

  double getGPA() {
    return GPA;
  }

  void setGPA(double GPA) {
    this.GPA = GPA;
  }

  int getGraduationYear() {
    return graduationYear;
  }

  void setGraduationYear(int graduationYear) {
    this.graduationYear = graduationYear;
  }

  void displayGraduateDetails() {
    super.displayPersonDetails();
    System.out.println("GPA: " + GPA);
    System.out.println("Graduation Year: " + graduationYear);
  }
}

class Personmain {
  public static void main(String[] args) {

    Person person = new Person("John Doe", "1990-05-15");
    System.out.println("Person Details:");
    person.displayPersonDetails();
        
    CollegeGraduate graduate = new CollegeGraduate("Jane Smith", "1998-07-20", 3.8, 2020);
    System.out.println("\nCollege Graduate Details:");
    graduate.displayGraduateDetails();
  }
}
class SeatsFilledException extends Exception {
    public SeatsFilledException(String message) {
        super(message);
    }
}

class Student {
    private static final int YEAR_OF_JOINING = 2024;
    private static final int MAX_REGISTRATION_NUMBER = 240025;
    private static int currentRegistrationNumber = 240001;

    private int registrationNumber;
    private String name;

    public Student(String name) throws SeatsFilledException {
        this.name = name;
        this.registrationNumber = generateRegistrationNumber();
        if (this.registrationNumber > MAX_REGISTRATION_NUMBER) {
            throw new SeatsFilledException("Registration number exceeds allowed limit: " + this.registrationNumber);
        }
    }

    private int generateRegistrationNumber() {
        return currentRegistrationNumber++;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', registrationNumber=" + registrationNumber + "}";
    }
}

public class Main3 {
    public static void main(String[] args) {
        try {
            Student student1 = new Student("Yashika");
            System.out.println(student1);
            
            Student student2 = new Student("Pakhi");
            System.out.println(student2);

            for (int i = 0; i < 25; i++) {
                new Student("Student" + i);
            }
            
            try {
                Student student3 = new Student("Saksham");
                System.out.println(student3);
            } catch (SeatsFilledException e) {
                System.out.println(e.getMessage());
            }
            
        } catch (SeatsFilledException e) {
            System.out.println(e.getMessage());
        }
    }
}

import java.util.Scanner;

class InvalidDayException extends Exception {
    public InvalidDayException(String message) {
        super(message);
    }
}

class InvalidMonthException extends Exception {
    public InvalidMonthException(String message) {
        super(message);
    }
}

class CurrentDate {
    private int day;
    private int month;
    private int year;

    public void createDate() throws InvalidDayException, InvalidMonthException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter day: ");
        day = scanner.nextInt();
        System.out.print("Enter month: ");
        month = scanner.nextInt();
        System.out.print("Enter year: ");
        year = scanner.nextInt();

        if (month < 1 || month > 12) {
            throw new InvalidMonthException("Invalid month: " + month);
        }

        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeapYear(year)) {
            daysInMonth[1] = 29;
        }

        if (day < 1 || day > daysInMonth[month - 1]) {
            throw new InvalidDayException("Invalid day: " + day);
        }
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public void displayDate() {
        System.out.println("Current date is: " + day + "/" + month + "/" + year);
    }
}

public class Main2 {
    public static void main(String[] args) {
        CurrentDate date = new CurrentDate();
        try {
            date.createDate();
            date.displayDate();
        } catch (InvalidDayException | InvalidMonthException e) {
            System.out.println(e.getMessage());
        }
    }
}

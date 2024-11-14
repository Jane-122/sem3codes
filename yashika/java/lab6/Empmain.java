import java.util.Scanner;

class EMPLOYEE {
  String Ename;
  int Eid;
  double Basic;
  double DA;
  double Gross_Sal;
  double Net_Sal;


  EMPLOYEE(String ename, int eid, double basic) {
    Ename = ename;
    Eid = eid;
    Basic = basic;
    compute_net_sal();
  }

  void read() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter Employee ID: ");
    Eid = sc.nextInt();
    sc.nextLine();
    System.out.print("Enter Employee Name: ");
    Ename = sc.nextLine();
    System.out.print("Enter Basic Salary: ");
    Basic = sc.nextDouble();
    compute_net_sal();
  }

  void compute_net_sal() {
    DA = 0.52 * Basic;
    Gross_Sal = Basic + DA;
    double IT = 0.30 * Gross_Sal;
    Net_Sal = Gross_Sal - IT;
  }


  void display() {
    System.out.println("Employee ID: " + Eid);
    System.out.println("Employee Name: " + Ename);
    System.out.println("Basic Salary: " + Basic);
    System.out.println("Net Salary: " + Net_Sal);
  }

  void calculateSalary() {
    compute_net_sal();
  }
}

class PartTimeEmp extends EMPLOYEE {
  int hoursWorked;
  static final double hourlyRate = 15.50;


  PartTimeEmp(String ename, int eid, int hoursWorked) {
    super(ename, eid, 0); 
    this.hoursWorked = hoursWorked;
    compute_net_sal();
  }

  @Override
  void compute_net_sal() {
    Net_Sal = hoursWorked * hourlyRate;
  }

  @Override
  void calculateSalary() {
    compute_net_sal();
  }

  @Override
  void display() {

    System.out.println("Employee ID: " + Eid);
    System.out.println("Employee Name: " + Ename);
    System.out.println("Hours Worked: " + hoursWorked);
    System.out.println("Hourly Rate: " + hourlyRate);
    System.out.println("Net Salary: " + Net_Sal);
  }
}

class FullTimeEmp extends EMPLOYEE {
  double bonus;
  double deductions;

  
  FullTimeEmp(String ename, int eid, double basic, double bonus, double deductions) {
    super(ename, eid, basic);
    this.bonus = bonus;
    this.deductions = deductions;
    compute_net_sal();
  }

  @Override
  void compute_net_sal() {
    DA = 0.52 * Basic;
    Gross_Sal = Basic + DA + bonus - deductions;
    double IT = 0.30 * Gross_Sal;
    Net_Sal = Gross_Sal - IT;
  }

  @Override
  void calculateSalary() {
    compute_net_sal();
  }

  @Override
  void display() {

    System.out.println("Employee ID: " + Eid);
    System.out.println("Employee Name: " + Ename);
    System.out.println("Basic Salary: " + Basic);
    System.out.println("Bonus: " + bonus);
    System.out.println("Deductions: " + deductions);
    System.out.println("Net Salary: " + Net_Sal);
  }
}

public class Empmain {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("\nEnter the number of full-time employees: ");
    int n = sc.nextInt();
    FullTimeEmp[] fullTimeEmployees = new FullTimeEmp[n];

    for (int i = 0; i < n; i++) {
      System.out.println("\nEnter details for Full-Time Employee " + (i + 1) + ":");
      System.out.print("Enter Employee ID: ");
      int id = sc.nextInt();
      sc.nextLine(); 
      System.out.print("Enter Employee Name: ");
      String name = sc.nextLine();
      System.out.print("Enter Basic Salary: ");
      double basic = sc.nextDouble();
      System.out.print("Enter Bonus: ");
      double bonus = sc.nextDouble();
      System.out.print("Enter Deductions: ");
      double deductions = sc.nextDouble();
      fullTimeEmployees[i] = new FullTimeEmp(name, id, basic, bonus, deductions);
    }

    System.out.print("\nEnter the number of part-time employees: ");
    int m = sc.nextInt();
    PartTimeEmp[] partTimeEmployees = new PartTimeEmp[m];

    for (int i = 0; i < m; i++) {
      System.out.println("\nEnter details for Part-Time Employee " + (i + 1) + ":");
      System.out.print("Enter Employee ID: ");
      int id = sc.nextInt();
      sc.nextLine(); 
      System.out.print("Enter Employee Name: ");
      String name = sc.nextLine();
      System.out.print("Enter Hours Worked: ");
      int hours = sc.nextInt();
      partTimeEmployees[i] = new PartTimeEmp(name, id, hours);
    }

    System.out.println("\nFull-Time Employee Details:");
    for (int i = 0; i < n; i++) {
      fullTimeEmployees[i].display();
    }

    System.out.println("\nPart-Time Employee Details:");
    for (int i = 0; i < m; i++) {
      partTimeEmployees[i].display();
    }
  }
}
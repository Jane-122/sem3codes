import java.util.Scanner;

class EMPLOYEE {
   String Ename;
   int Eid;
   double Basic;
   double DA;
   double Gross_Sal;
   double Net_Sal;

   EMPLOYEE() {
      Ename = "Unknown";
      Eid = 0;
      Basic = 0.0;
      compute_net_sal();
   }

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
}

public class Empconst {
   public static void main(String[] args) {
      EMPLOYEE emp = new EMPLOYEE();
      System.out.println("Default Constructor:");
      emp.display();

      Scanner sc = new Scanner(System.in);
      System.out.print("\nEnter the number of employees: ");
      int n = sc.nextInt();
      EMPLOYEE[] employees = new EMPLOYEE[n];

      for (int i = 0; i < n; i++) {
         employees[i] = new EMPLOYEE();
         System.out.println("\nEnter details for Employee " + (i + 1) + ":");
         employees[i].read();
      }

      System.out.println("\nEmployee Details:");
      for (int i = 0; i < n; i++) {
         System.out.println("\nDetails of Employee " + (i + 1) + ":");
         employees[i].display();
      }
   }
}
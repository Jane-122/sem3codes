import java.util.Scanner;

class EMPLOYEE
{
	String ename;
	int eid;
	int basic;
	double da;
	double gross_sal;
	double net_sal;

	void read()
	{
		Scanner in=new Scanner(System.in);
		System.out.println("Enter employee name ");
		ename=in.nextLine();
		System.out.println("Enter employee id ");
		eid=in.nextInt();
		System.out.println("Enter basic salary ");
		basic=in.nextInt();
	}

	void compute_net_sal()
	{
		da=0.52*basic;
		gross_sal=basic+da;
		double it=0.3*gross_sal;
		net_sal=gross_sal-it;
	}

	void display()
	{
		System.out.println("Employee name "+ename);
		System.out.println("Employee id "+eid);
		System.out.println("Net Salary "+net_sal);
	}


}

class Empdemo
{
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		System.out.println("Enter no of employees ");
		int n=in.nextInt();
		EMPLOYEE[] emp=new EMPLOYEE[n];
		for (int i=0;i<n;i++)
		{
			emp[i]=new EMPLOYEE();
			emp[i].read();
			emp[i].compute_net_sal();
			emp[i].display();
		}
	}
}


























import java.util.Scanner;

class Customer
{
	private int id;
	private String name;
	private double cl;

	Customer()
	{
		this.id=0;
		this.name="";
		this.cl=0.0;
	}

	Customer(int id,String name,double cl)
	{
		this.id=id;
		this.name=name;
		this.cl=cl;
	}

	int getid()
	{
		return id;
	}

	String getname()
	{
		return name;
	}

	double getcl()
	{
		return cl;
	}

	void setid(int id)
	{
		this.id=id;
	}

	void setname(String name)
	{
		this.name=name;
	}

	void setcl(double cl)
	{
		this.cl=cl;
	}

	void display()
	{
		System.out.println("name "+this.name);
		System.out.println("id "+this.id);
		System.out.println("credit limit "+this.cl);
	}

}

class Custdemo
{
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		Customer cust[]=new Customer[5];

		for(int i=0;i<cust.length;i++)
		{
			System.out.println("Enter details for customer "+(i+1));
			System.out.println("Enter customer name ");
			String name=in.nextLine();
			System.out.println("Enter customer id ");
			int id=in.nextInt();
			in.nextLine();
			System.out.println("Enter credit limit ");
			double cl=in.nextDouble();
			in.nextLine();
			cust[i]=new Customer(id,name,cl);

		}

		for (int i=0;i<5;i++)
		{
			cust[i].display();
		}

	}
}








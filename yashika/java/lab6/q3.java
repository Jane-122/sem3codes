class Person
{
	private String name;
	private String dob;

	Person(String name, String dob)
	{
		this.name=name;
		this.dob=dob;
	}

	String getname()
	{
		return name;
	}

	void setname(String name)
	{
		this.name=name;
	}

	String getdob()
	{
		return dob;
	}

	void setdob(String dob)
	{
		this.dob=dob;
	}

	void display1()
	{
		System.out.println("Name "+name);
		System.out.println("DOB "+dob);
	}
}

class Colgrad extends Person
{
	private double gpa;
	private int gyear;

	Colgrad(String name, String dob, double gpa, int gyear)
	{
		super(name,dob);
		this.gpa=gpa;
		this.gyear=gyear;
	}

	double getgpa()
	{
		return gpa;
	}

	void setgpa(double gpa)
	{
		this.gpa=gpa;
	}

	int getgyear()
	{
		return gyear;
	}

	void setgyear(int gyear)
	{
		this.gyear=gyear;
	}

	void display2()
	{
		super.display1();
		System.out.println("GPA "+gpa);
		System.out.println("Grad year "+gyear);
	}
}

	class q3 {
    public static void main(String[] args) {

    Person person = new Person("John Doe", "1990-05-15");
    System.out.println("Person Details:");
    person.display1();
        
    Colgrad graduate = new Colgrad("Jane Smith", "1998-07-20", 3.8, 2020);
    System.out.println("\nCollege Graduate Details:");
    graduate.display2();
  }

















}




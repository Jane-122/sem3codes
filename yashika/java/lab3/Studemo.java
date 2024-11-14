class STUDENT
{
	String sname;
	int marks_array[];
	int total;
	double avg;

	void assign(String name, int marks[])
	{
		sname=name;
		marks_array=marks;
	}

	void compute()
	{
		total=0;
		for (int mark : marks_array)
		{
			total=total+mark;
		}
		avg=total/marks_array.length;
	}

	void display()
	{
		System.out.println("Student Name "+sname);
		System.out.println("Marks - ");
		for (int mark : marks_array)
		{
			System.out.println(mark+" ");
		}
		System.out.println("Total "+total);
		System.out.println("Average "+avg);
	}
}

class Studemo
{
	public static void main(String[] args)
	{
		STUDENT stu=new STUDENT();
		int marks[]={10,20,30};
		stu.assign("yashika",marks);
		stu.compute();
		stu.display();
	}
}











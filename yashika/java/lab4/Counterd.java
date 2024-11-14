class Counter
{
	static int count=0;

	Counter()
	{
		count++;
	}

	static void showcount()
	{
		System.out.println("no of objects created "+count);
	}
}

class Counterd
{
	public static void main(String[] args)
	{
		Counter c1=new Counter();
		Counter c2=new Counter();
		Counter c3=new Counter();
		Counter.showcount();

	}
}
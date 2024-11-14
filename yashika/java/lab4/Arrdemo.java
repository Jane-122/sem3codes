class IntArr
{
	int arr[];

	IntArr()
	{
		this.arr=new int[0];
	}

	IntArr(int arr[])
	{
		this.arr=arr;
	}

	void display()
	{
		for(int num : arr)
		{
			System.out.println(num+" ");
		}
	}

	void search(int elem)
	{
		for (int num : arr)
		{
			if (num==elem)
			{
				System.out.println(elem+"found");
				break;
		}
	}

	boolean compare(IntArr obj)
	{
		if (this.arr.length!=obj.arr.length)
			return false;
		else{
			for(int i=0;i<this.arr.length;i++)
			{
				if (this.arr[i]!=obj.arr[i])
					return false;
			}	
		}
		return true;
	}
}

class Arrdemo
{
	public static void main(String[] args)
	{
		IntArr a1=new IntArr(new int[]{1,2,3,4,5});
		IntArr a2=new IntArr(new int[]{1,2,3,3,4});

		a1.display();
		a2.display();

		a1.search(4);
	}
}














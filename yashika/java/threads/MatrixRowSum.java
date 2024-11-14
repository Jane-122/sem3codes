import java.util.*;

class NewThread implements Runnable
{
	Thread t;
	int arr[],sum;
	NewThread(int arr[])
	{
		t=new Thread(this);
		this.arr=arr;
		this.sum=0;
	}
	public void run()
	{
		for (int i=0;i<arr.length;i++)
		{
			sum+=arr[i];
		}
	}
	public int getSum()
	{
		return sum;
	}
}

class MatrixRowSum
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no of rows and columns ");
		int rows=sc.nextInt();
		int cols=sc.nextInt();

		int matrix[][]=new int[rows][cols];

		System.out.println("Enter elements ");
		for (int i=0;i<rows;i++)
		{
			for (int j=0;j<cols;j++)
			{
				matrix[i][j]=sc.nextInt();
			}
		}
		System.out.println("Matrix");
		for (int i=0;i<rows;i++)
		{
			for (int j=0;j<cols;j++)
			{
				System.out.println(matrix[i][j]+" ");
			}
			System.out.println();
		}

		NewThread threads[]=new NewThread[rows];

		for (int i=0;i<rows;i++)
		{
			threads[i]=new NewThread(matrix[i]);
			threads[i].t.start();
		}

		int totalSum=0;
		for (int i=0;i<rows;i++)
		{
			try{
				threads[i].t.join();
				int rowSum=threads[i].getSum();
				System.out.println("Sum of row"+(i+1)+":"+rowSum);
				totalSum+=rowSum;
			}
			catch (InterruptedException e) {}
		}
		System.out.println("Total sum of matrix is "+totalSum);

	}
}























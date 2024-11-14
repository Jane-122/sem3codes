import java.util.Scanner;

class BankAccount
{
	Scanner in=new Scanner(System.in);
	String name;
	int accno;
	String acctype;
	float bal;
	static float roi;

	BankAccount()
	{
		this.name="default";
		this.accno=0000000000;
		this.acctype="null";
		this.bal=0;
		roi=5;
	}

	BankAccount(String name,int accno,String acctype,float bal)
	{
		this.name=name;
		this.accno=accno;
		this.acctype=acctype;
		this.bal=bal;
	}

	void deposit()
	{
		System.out.println("Enter amount to be deposited ");
		float dep=in.nextFloat();
		bal+=dep;
	}

	void withdraw()
	{
		System.out.println("Enter the amount to withdraw ");
		float with=in.nextFloat();
		if (bal<with)
		{
			System.out.println("error ");
		}
		else {bal-=with;}
	}

	void display()
	{
		System.out.println("name "+name);
		System.out.println("account number "+accno);
		System.out.println("account type "+acctype);
		System.out.println("balance amount "+bal);
	}

	static void roi_display()
	{
		System.out.println("rate of interest "+roi);
	}

}

class Bankdemo
{
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);

		BankAccount b1=new BankAccount();
		b1.display();
		b1.roi_display();

	System.out.println("Enter name ");
	String name=in.nextLine();
	System.out.println("Enter account no ");
	int accno=in.nextInt();
	in.nextLine();
	System.out.println("Enter account type ");
	String acctype=in.nextLine();
	System.out.println("Enter balance ");
	float bal=in.nextFloat();

	BankAccount b2=new BankAccount(name,accno,acctype,bal);

	System.out.println("Enter 1 to deposit ");
	System.out.println("Enter 2 to withdraw ");
	System.out.println("Enter 3 to display ");
	int ch=in.nextInt();

	if (ch==1)
	{
		b2.deposit();
	}
	else if (ch==2)
    {
		b2.withdraw();
	}
	else if (ch==3)
	{
		b2.display();
		BankAccount.roi_display();
	}
	else{System.out.println("invalid input ");}
}
}


















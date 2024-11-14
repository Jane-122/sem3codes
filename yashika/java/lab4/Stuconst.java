import java.util.Scanner;

class STUDENT
{
    String sname;
    int marks_array[];
    int total;
    double avg;

    STUDENT()
    {
        sname="unknown";
        marks_array=new int[0];
        total=0;
        avg=0.0;
    }

    STUDENT(String name,int marks[])
    {
        sname=name;
        marks_array=marks;
        compute();
    }

    void assign(String name, int marks[])
    {
        sname=name;
        marks_array=marks;
        compute();
    }

    void compute()
    {
        total=0;
        for (int mark : marks_array)
        {
            total=total+mark;
        }
        if (marks_array.length>0)
        {avg=total/marks_array.length;}
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

class Studemo2
{
    public static void main(String[] args)
    {
        STUDENT studef=new STUDENT();
        System.out.println("Default constructor ");
        studef.display();

        Scanner in=new Scanner(System.in);
        System.out.println("Enter no of students ");
        int n=in.nextInt();
        in.nextLine();

        STUDENT students[]=new STUDENT[n];

        for (int i=0;i<n;i++)
        {

            System.out.println("Enter name of student "+(i+1));
            String name=in.nextLine();

            System.out.println("Enter no of subjects ");
            int num=in.nextInt();
            in.nextLine();
            int marks[]=new int[num];

            System.out.println("Enter marks ");
            for(int j=0;j<num;j++)
            {
                marks[j]=in.nextInt();
            }
            in.nextLine();

            students[i]=new STUDENT(name,marks);
        }

        for (int i=0;i<n;i++)
        {
            System.out.println("Details for Student "+(i+1));
            students[i].display();
        }
    }
}

import java.util.Scanner;

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

class ScienceStudent extends STUDENT
{
    private int practicalMarks;

    ScienceStudent(String name,int marks[],int practicalMarks)
    {
        sname=name;
        marks_array=marks;
        this.practicalMarks=practicalMarks;
        compute();
    }

    void compute()
    {
        super.compute();
        total+=practicalMarks;
        avg=total/(marks_array.length+1);
    }

    void displayPracticalMarks()
    {
        System.out.println("Practical marks "+practicalMarks);
    }

    void display()
    {
        super.display();
        displayPracticalMarks();
    }

}

class ArtsStudent extends STUDENT
{
    private String electiveSubject;

    ArtsStudent(String name, int marks[], String electiveSubject)
    {
        sname=name;
        marks_array=marks;
        this.electiveSubject=electiveSubject;
        compute();
    }

    void display()
    {
        super.display();
        System.out.println("Elective subject "+electiveSubject);
    }
}

class Studmain
{
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter no of students ");
        int n=in.nextInt();
        in.nextLine();

        STUDENT students[]=new STUDENT[n];

        for (int i=0;i<n;i++)
        {

            System.out.println("Enter detail for student "+(i+1));
            System.out.println("Enter 1 for science student and 2 for arts student ");
            int ch=in.nextInt();
            in.nextLine();

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

            if (ch==1)
            {
                System.out.println("Enter practical marks ");
                int practicalMarks=in.nextInt();
                in.nextLine();
                students[i]=new ScienceStudent(name,marks,practicalMarks);
            }

            else if (ch==2)
            {
                System.out.println("Enter elective subject ");
                String electiveSubject=in.nextLine();
                students[i]=new ArtsStudent(name,marks,electiveSubject);
            }

        }

        for (int i=0;i<n;i++)
        {
            System.out.println("Details for Student "+(i+1));
            students[i].display();
        }
    }
}



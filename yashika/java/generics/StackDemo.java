class Stack<T>
{
    T[] arr;
    int top,size;
    Stack(int size)
    {
        this.size=size;
        this.arr=(T[]) new Object[size];
        this.top=-1;
    }

    public void push(T x)
    {
        if (top==size-1)
        {
            System.out.println("Stack is full");
            return;
        }
        arr[++top]=x;
    }

    public T pop()
    {
        if (top==-1)
        {
            System.out.println("Stack is empty");
            return null;
        }
        return arr[top--];
    }

    public void display()
    {
        if (top==-1)
        {
            System.out.println("Stack is empty ");
            return;
        }
        System.out.println("Stack contents: ");
        for (int i=0;i<=top;i++)
        {
            System.out.println(arr[i]);
        }
    }
}

class Student
{
    String name;
    int rollNum;

    Student(String name, int rollNum)
    {
        this.name=name;
        this.rollNum=rollNum;
    }

    @Override
    public String toString()
    {
        return "Student Name: "+name+", Roll No: "+rollNum;
    }
}

class Employee
{
    String name;
    int empID;

    Employee(String name, int empID)
    {
        this.name=name;
        this.empID=empID;
    }

    @Override
    public String toString()
    {
        return "Employee Name: "+name+", Employee ID: "+empID;
    }
}

public class StackDemo
{
    public static void main(String[] args)
    {
      Stack<Student> studentStack=new Stack<>(2);
      studentStack.push(new Student("Chan",101));
      studentStack.push(new Student("Mon",102));

      studentStack.display();

        System.out.println("Popped: " + studentStack.pop());

        studentStack.display();

        Stack<Employee> employeeStack = new Stack<>(2);
        employeeStack.push(new Employee("Charlie", 1001));
        employeeStack.push(new Employee("David", 1002));

        employeeStack.display();

        System.out.println("Popped: " + employeeStack.pop());

        employeeStack.display();
    }
}





























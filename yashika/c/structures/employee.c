#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct dateofbirth
{
	int day;
	int month;
	int year;
};

struct address
{
	int houseno;
	int zipcode;
	char state[50];
};

typedef struct 
{
	char name[50];
	struct dateofbirth dob;
	struct address add;	
}Employee;

void read(Employee *e)
{
	printf("Enter name ");
	scanf("%s",e->name);
	printf("Enter date of birth ");
	scanf("%d%d%d",&e->dob.day,&e->dob.month,&e->dob.year);
	printf("Enter house no and zipcode ");
	scanf("%d%d",&e->add.houseno,&e->add.zipcode);
	printf("Enter state ");
	scanf("%s",e->add.state);
}

void display(Employee *e)
{
	printf("Employee name is %s\n",e->name);
	printf("DOB is %d %d %d \n",e->dob.day,e->dob.month,e->dob.year);
	printf("Address %d,%d,%s\n",e->add.houseno,e->add.zipcode,e->add.state);
}

void main()
{
	int i,n;
	printf("Enter no of employees ");
	scanf("%d",&n);
	Employee *e=(Employee*)malloc(n*sizeof(Employee));
	for(i=0;i<n;i++)
	{
		read(&e[i]);
	}
	for(i=0;i<n;i++)
	{
		display(&e[i]);
	}
	free(e);
}










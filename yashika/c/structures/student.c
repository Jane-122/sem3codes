#include <string.h>
#include <stdio.h>
#include <stdlib.h>

typedef struct
{
	char name[100];
	int rollno;
	float cg;
}student;

void read(student *s)
{
	printf("Enter name ");
	scanf("%s",s->name);
	printf("Enter rollno ");
	scanf("%d",&(s->rollno));
	printf("Enter cgpa ");
	scanf("%f",&(s->cg));
}

void display(student *s)
{
	printf("%s with roll number %d has %0.2f cgpa\n",s->name,s->rollno,s->cg);
}

void sort(student *s,int n)
{
	int i,j;
	student temp;
	for (i=0;i<n-1;i++)
	{
		for(j=0;j<n-i-1;j++)
		{
			if(s[j].rollno>s[j+1].rollno)
			{
				temp=s[j];
				s[j]=s[j+1];
				s[j+1]=temp;
			}
		}
	}

}


int main()
{
	int i,n;
	printf("Enter no of students ");
	scanf("%d",&n);
	student *s=(student*)malloc(n*sizeof(student));
	for(i=0;i<n;i++)
	{
		read(&s[i]);
	}
	sort(s,n);
	for(i=0;i<n;i++)
	{
		display(&s[i]);
	}
	free(s);
	return 0;
}





























//smallest element in a dynamically allocated array using pointers

#include<stdio.h>
#include<stdlib.h>

int small(int *p,int n)
{
	int i;
	int smallest=*p;
	for (i=1;i<n;i++)
	{
	 	if (smallest>*(p+i))
	 		smallest=*(p+i);
	}
	return smallest;
}

void main()
{
	int i,n;
	int *p;
	printf("Enter no of elements ");
	scanf("%d",&n);
	p=(int*)malloc(n*sizeof(int));
	printf("Enter elements");
	for(i=0;i<n;i++)
	{
		scanf("%d",p+i);
	}
	int s;
	s=small(p,n);
	printf("%d is smallest ",s);
}
//passing pointers to a function
#include <stdio.h>

void swap(int *a,int *b)
{
	int temp;
	temp=*a;
	*a=*b;
	*b=temp;
}

void main()
{
	int a,b;
	printf("Enter a and b ");
	scanf("%d%d",&a,&b);
	swap(&a,&b);
	printf("a is %d and b is %d",a,b);
}
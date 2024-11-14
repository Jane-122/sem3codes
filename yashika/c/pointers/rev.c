//reverse elements of an integer array using pointers

#include <stdio.h>

void reverse(int *p,int n)
{
	int i,temp;
	for(i=0;i<n/2;i++)
	{
		temp=*(p+i);
		*(p+i)=*(p+n-i-1);
		*(p+n-i-1)=temp;
	}
}

void main()
{
	int a[10],i,n;
	printf("Enter the no of elements ");
	scanf("%d",&n);
	printf("Enter the elements ");
	for (i=0;i<n;i++)
	{
		scanf("%d",&a[i]);
	}
	reverse(a,n);
	for (i=0;i<n;i++)
	{
		printf("%d\t",a[i]);
	}
}
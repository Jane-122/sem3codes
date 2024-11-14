#include <stdio.h>
#include <stdlib.h>

int *createarray(int n)
{
	int *a;
	a=(int*)malloc(n*sizeof(int));
	for(int i=0;i<n;i++)
	{
		a[i]=i+1;
	}
	return a;
}

void main()
{
	int n;
	printf("Enter no of elements ");
	scanf("%d",&n);
	int *arr;
	arr=createarray(n);
	for(int i=0;i<n;i++)
	{
		printf("%d",arr[i]);
	}
	free(arr);
}
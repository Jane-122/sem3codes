#include <stdio.h>
#include <stdlib.h>

int *a(int **arr)
{
	return arr[0];
}

void main()
{
	int **arr=(int**)calloc(1,sizeof(int*));
	arr[0]=(int*)calloc(3,sizeof(int));
	int *b=a(arr);
	for (int i=0;i<3;i++)
	{
		printf("%d",*(b+i));
	}
}
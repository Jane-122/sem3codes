#include<stdio.h>
#include<stdlib.h>
#include<string.h>

void main()
{
	int i,n;
	char *sports[10];
	char str[100];
	printf("Enter the number of sports ");
	scanf("%d",&n);
	printf("Enter sport name ");
	for(i=0;i<n;i++)
	{
		scanf("%s",str);
		sports[i]=(char*)calloc(strlen(str)+1,sizeof(char));
		strcpy(sports[i],str);
	}
	printf("list of sports\n");
	for(i=0;i<n;i++)
	{
		printf("%s\n",sports[i]);
	}

	for(i=0;i<n;i++)
	{
		free(sports[i]);
	}
}
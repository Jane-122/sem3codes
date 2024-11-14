#include <stdio.h>
#include <stdlib.h>

#define MAX 5

struct node
{
	int info;
	struct node *link;
};
typedef struct node *NODE;


NODE deletefront(NODE first)
{
	NODE temp;
	if (first==NULL)
	{
		printf("List empty, cant delete\n");
		return first;
	}

	temp=first;
	temp=temp->link;
	printf("Item deleted=%d\n",first->info);
	free(first);
	return temp;
}

NODE insertrear(int item, NODE first)
{
	NODE temp;
	NODE cur;

	temp=(struct node*)malloc(1*sizeof(struct node));
	temp->info=item;
	temp->link=NULL;

	if (first==NULL) return temp;

	cur=first;
	while(cur->link!=NULL)
	{
		cur=cur->link;
	}
	cur->link=temp;
	return first;
}


void display(NODE first)
{
	NODE temp;
	if (first==NULL)
	{
		printf("list empty\n");
		return;
	}

	printf("linked list contents\n");

	temp=first;
	while(temp!=NULL)
	{
		printf("%d ",temp->info);
		temp=temp->link;
	}
	printf("\n");
}

void main()
{
	NODE a[MAX];
	int ch,item,i;

	for (i=0;i<MAX;i++)
	{
		a[i]=NULL;
	}

	for(;;)
	{
		printf("Enter queue no - 0,1,2,3,4 \n");
		scanf("%d",&i);

		printf("1-Insert rear\n2-Delete front\n");
		printf("3-Display\n4-Exit\n");
		printf("Enter choice \n");
		scanf("%d",&ch);

		switch(ch)
		{
		case 1:
			printf("Enter item to insert \n");
			scanf("%d",&item);

			a[i]=insertrear(item,a[i]);

			break;

		case 2:
			a[i]=deletefront(a[i]);
			break;

		case 3:
			display(a[i]);
			break;

		default:
			exit(0);
		}
	}
}

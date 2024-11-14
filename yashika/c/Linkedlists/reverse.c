#include <stdio.h>
#include <stdlib.h>

struct node
{
	int info;
	struct node *link;
};
typedef struct node *NODE;

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

NODE reverse(NODE first)
{
	NODE cur,temp;
	cur=NULL;
	while(first!=NULL)
	{
		temp=first->link;
		first->link=cur;

		cur=first;
		first=temp;
	}
	return cur;
}

void main()
{
	NODE first=NULL;
	int ch,item;

	for(;;)
	{
		printf("1-Insert Rear\n2-Display\n3-Reverse\n4-Quit\n");
		printf("Enter choice \n");
		scanf("%d",&ch);

		switch(ch)
		{
		case 1:
			printf("Enter item to insert \n");
			scanf("%d",&item);

			first=insertrear(item,first);

			break;

		case 2:
			display(first);
			break;

		case 3:
			first=reverse(first);
			break;
			
		default:
			exit(0);
		}
	}
}

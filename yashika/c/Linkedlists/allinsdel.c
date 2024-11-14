#include <stdio.h>
#include <stdlib.h>

struct node
{
	int info;
	struct node *link;
};
typedef struct node *NODE;

NODE insertfront(int item, NODE first)
{
	NODE temp;
	temp=(struct node*)malloc(1*sizeof(struct node));
	temp->info=item;
	temp->link=first;
	return temp;
}

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

NODE deleterear(NODE first)
{
	NODE cur,prev;

	if (first==NULL)
	{
		printf("List empty, cant delete");
		return first;
	}

	if (first->link==NULL)
	{
		printf("Item deleted is %d\n",first->info);
		free(first);
		return NULL;
	}

	prev=NULL;
	cur=first;
	while(cur->link!=NULL)
	{
		prev=cur;
		cur=cur->link;
	}

	printf("Item deleted is %d\n",cur->info);
	free(cur);

	prev->link=NULL;

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
	NODE first=NULL;
	int ch,item;

	for(;;)
	{
		printf("1-Insert front\n2-Delete front\n");
		printf("3-Insert rear\n4-Delete rear\n");
		printf("5-Display\n6-Exit\n");
		printf("Enter choice \n");
		scanf("%d",&ch);

		switch(ch)
		{
		case 1:
			printf("Enter item to insert \n");
			scanf("%d",&item);

			first=insertfront(item,first);

			break;

		case 2:
			first=deletefront(first);
			break;

		case 3:
			printf("Enter item to insert \n");
			scanf("%d",&item);

			first=insertrear(item,first);

			break;

		case 4:
			first=deleterear(first);
			break;

		case 5:
			display(first);
			break;

		default:
			exit(0);
		}
	}
}


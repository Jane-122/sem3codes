#include <stdio.h>
#include <stdlib.h>

struct node
{
	int info;
	struct node *link;
};

typedef struct node* NODE;

NODE insertfront(int item, NODE last)
{
	NODE temp;

	temp=(struct node*)malloc(1*sizeof(struct node));
	temp->info=item;

	if (last==NULL)
		last=temp;
	else
		temp->link=last->link;
	last->link=temp;

	return last;
}

NODE insertrear(int item, NODE last)
{
	NODE temp;

	temp=(struct node*)malloc(1*sizeof(struct node));
	temp->info=item;

	if (last==NULL)
		last=temp;
	else
		temp->link=last->link;
	last->link=temp;

	return temp;
}

NODE deletefront(NODE last)
{
	NODE temp,first;

	if (last==NULL)
	{
		printf("List empty\n");
		return NULL;
	}

	if (last->link==last)
	{
		printf("The item deleted is %d\n",last->info);
		free(last);
		return NULL;
	}

	first=last->link;
	last->link=first->link;
	printf("Item deleted is %d\n",first->info);
	free(first);
	return last;
}

NODE deleterear(NODE last)
{
	NODE prev;
	if (last==NULL)
	{
		printf("List empty");
		return NULL;
	}

	if (last->link==last)
	{
		printf("The item deleted is %d\n",last->info);
		free(last);
		return NULL;
	}

	prev=last->link;
	while (prev->link!=last)
	{
		prev=prev->link;
	}

	prev->link=last->link;
	printf("Item deleted is %d\n",last->info);
	free(last);
	return prev;
}

void display(NODE last)
{
	NODE temp;

	if (last==NULL)
	{
		printf("List empty\n");
		return;
	}

	printf("Linked list contents\n");

	temp=last->link;
	while (temp!=last)
	{
		printf("%d ",temp->info);
		temp=temp->link;
	}

	printf("%d\n",temp->info);
}

void main()
{
	NODE last;
	int ch,item;

	last=NULL;

	for (;;)
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

			last=insertfront(item,last);

			break;

		case 2:
			last=deletefront(last);
			break;

		case 3:
			printf("Enter item to insert \n");
			scanf("%d",&item);

			last=insertrear(item,last);

			break;

		case 4:
			last=deleterear(last);
			break;

		case 5:
			display(last);
			break;

		default:
			exit(0);
		}
	}
}





















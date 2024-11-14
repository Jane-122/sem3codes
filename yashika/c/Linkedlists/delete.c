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

NODE deleteinfo(int key,NODE first)
{
	NODE prev,cur;

	if (first==NULL)
	{
		printf("List is empty\n");
		return NULL;
	}

	if (key==first->info)
	{
		cur=first;
		first=first->link;
		free(cur);
		return first;
	}

	prev=NULL;
	cur=first;

	while (cur!=NULL)
	{
		if(key==cur->info) break;
		prev=cur;
		cur=cur->link;
	}

	if (cur==NULL)
	{
		printf("Search is unsuccessful\n");
		return first;
	}

	prev->link=cur->link;

	free(cur);

	return first;
}

void main()
{
	NODE first=NULL;
	int ch,item;

	for(;;)
	{
		printf("1-Insert Front\n2-Display\n3-Delete Element\n4-Quit\n");
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
			display(first);
			break;

		case 3:
			int key;
			printf("Enter element to delete\n");
			scanf("%d",&key);
			first=deleteinfo(key,first);
			break;

		default:
			exit(0);
		}
	}
}



#include <stdio.h>
#include <stdlib.h>

struct node
{
	int info;
	struct node *llink;
	struct node *rlink;
};

typedef struct node* NODE;

NODE insertfront(int item, NODE head)
{
	NODE temp,cur;

	temp=(struct node*)malloc(1*sizeof(struct node));
	temp->info=item;

	cur=head->rlink;

	head->rlink=temp;
	temp->llink=head;
	temp->rlink=cur;
	cur->llink=temp;

	return head;
}

NODE insertrear(int item, NODE head)
{
	NODE temp,cur;

	temp=(struct node*)malloc(1*sizeof(struct node));
	temp->info=item;

	cur=head->llink;

	head->llink=temp;
	temp->rlink=head;
	temp->llink=cur;
	cur->rlink=temp;

	return head;
}

NODE deletefront(NODE head)
{
	NODE cur,next;

	if (head->rlink==head)
	{
		printf("List empty\n");
		return head;
	}

	cur=head->rlink;
	next=cur->rlink;

	head->rlink=next;
	next->llink=head;

	printf("Node deleted is %d\n",cur->info);

	free(cur);
	return head;
}

NODE deleterear(NODE head)
{
	NODE cur,prev;

	if (head->llink==head)
	{
		printf("List empty\n");
		return head;
	}

	cur=head->llink;
	prev=cur->llink;

	head->llink=prev;
	prev->rlink=head;

	printf("Node deleted is %d\n",cur->info);

	free(cur);
	return head;
}

void display(NODE head)
{
	NODE temp;

	if (head->rlink==head)
	{
		printf("List empty\n");
		return;
	}

	printf("Contents of the list are\n");

	temp=head->rlink;
	while(temp!=head)
	{
		printf("%d ",temp->info);
		temp=temp->rlink;
	}

	printf("\n");
}

void main()
{
	NODE head;
	int ch,item;

	head=(struct node*)malloc(1*sizeof(struct node));
	head->rlink=head;
	head->llink=head;

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

			head=insertfront(item,head);

			break;

		case 2:
			head=deletefront(head);
			break;

		case 3:
			printf("Enter item to insert \n");
			scanf("%d",&item);

			head=insertrear(item,head);

			break;

		case 4:
			head=deleterear(head);
			break;

		case 5:
			display(head);
			break;

		default:
			exit(0);
		}
	}
}





















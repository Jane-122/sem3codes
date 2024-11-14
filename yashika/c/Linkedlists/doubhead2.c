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

NODE insertright(int item,NODE head)
{
	NODE temp,cur,next;

	if (head->rlink==head)
	{
		printf("List is empty\n");
		return head;
	}

	cur=head->rlink;

	while (cur!=head)
	{
		if (item==cur->info) break;
		cur=cur->rlink;
	}

	if (cur==head)
	{
		printf("Key not found\n");
		return head;
	}

	next=cur->rlink;

	printf("Enter the item to insert towards right of %d=",item);
	temp=(struct node*)malloc(1*sizeof(struct node));
	scanf("%d",&temp->info);

	cur->rlink=temp;
	temp->llink=cur;
	next->llink=temp;
	temp->rlink=next;

	return head;
}

NODE insertleft(int item, NODE head)
{
	NODE temp,cur,prev;

	if (head->rlink==head)
	{
		printf("List empty\n");
		return head;
	}

	cur=head->rlink;
	while (cur!=head)
	{
		if (item==cur->info) break;
		cur=cur->rlink;
	}

	if (cur==head)
	{
		printf("Key not found\n");
		return head;
	}

	prev=cur->llink;

	printf("Enter the item to insert towards left of %d=",item);
	temp=(struct node*)malloc(1*sizeof(struct node));
	scanf("%d",&temp->info);

	prev->rlink=temp;
	temp->llink=prev;
	cur->llink=temp;
	temp->rlink=cur;

	return head;
}

NODE deleteitem(int item,NODE head)
{
	NODE prev,cur,next;

	if (head->rlink==head)
	{
		printf("List is empty\n");
		return head;
	}

	cur=head->rlink;
	while (cur!=head)
	{
		if (item==cur->info) break;
		cur=cur->rlink;
	}

	if (cur==head)
	{
		printf("Item not found\n");
		return head;
	}

	prev=cur->llink;
	next=cur->rlink;
	prev->rlink=next;
	next->llink=prev;

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
		printf("1-Insert front\n2-Insert front of key\n3-Delete key\n");
		printf("4-Insert before key\n");
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
			printf("Enter key \n");
			scanf("%d",&item);

			head=insertright(item,head);

			break;

		case 3:
			printf("Enter item to delete\n");
			scanf("%d",&item);

			head=deleteitem(item,head);
			break;

		case 4:
			printf("Enter key \n");
			scanf("%d",&item);

			head=insertleft(item,head);

			break;

		case 5:
			display(head);
			break;

		default:
			exit(0);
		}
	}
}




























































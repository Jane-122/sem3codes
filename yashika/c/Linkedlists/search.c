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

NODE search(int key, NODE first)
{
	NODE cur;
	if (first==NULL) return NULL;

	cur=first;
	while (cur!=NULL)
	{
		if (key==cur->info) return cur;
		cur=cur->link;
	}
	return NULL;
}

void main()
{
	NODE first=NULL;
	int ch,item;

	for(;;)
	{
		printf("1-Insert Front\n2-Display\n3-Search\n4-Quit\n");
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
			printf("Enter element to search\n");
			scanf("%d",&key);
			NODE result;
			result = search(key, first);
            if (result != NULL) {
                printf("Item %d found in the list.\n", key);
            } else {
                printf("Item %d not found in the list.\n", key);
            }
            break;
		default:
			exit(0);
		}
	}
}




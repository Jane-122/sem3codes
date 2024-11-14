#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct node
{
	int info;
	struct node *llink;
	struct node *rlink;
};

typedef struct node* NODE;

NODE insert(int item,NODE root)
{
	NODE temp;
	NODE cur;       //child node
	NODE prev;      //parent node

	char direction[10];
	int i;

	temp=(struct node*)malloc(1*sizeof(struct node));
	temp->info=item;
	temp->llink=temp->rlink=NULL;

	if (root==NULL) return temp;

	printf("Give the directions where you want to insert (Ex-LRLR)\n");
	scanf("%s",direction);

	prev=NULL;
	cur=root;
	for(i=0;i<strlen(direction);i++)
	{
		if (cur==NULL) break;
		prev=cur;

		if (direction[i]=='L')
			cur=cur->llink;
		else
			cur=cur->rlink;
	}

	if (cur!=NULL || i!=strlen(direction))
	{
		printf("Insertion not possible\n");
		free(temp);
		return root;
	}

	if (direction[i-1]=='L')
		prev->llink=temp;
	else
		prev->rlink=temp;
	return root;
}


void ipreorder(NODE root)
{
	NODE cur,s[20];
	int top=-1;

	if (root==NULL)
	{
		printf("Tree is empty\n");
		return;
	}
	cur=root;

	for (;;)
	{
		while (cur!=NULL)
		{
			printf("%d ",cur->info);
			s[++top]=cur;
			cur=cur->llink;
		}

		 if (top == -1) 
            return;

        cur = s[top--];
        cur = cur->rlink;  
	}
}

void iinorder(NODE root)
{
	NODE cur,s[20];
	int top=-1;

	if (root==NULL)
	{
		printf("Tree is empty\n");
		return;
	}
	cur=root;

	for (;;)
	{
		while(cur!=NULL)
		{
			s[++top]=cur;
			cur=cur->llink;
		}

		if (top!=-1)
		{
			cur=s[top--];
			printf("%d ",cur->info);
			cur=cur->rlink;
		}
		else
			return;
	}
}

void ipostorder(NODE root)
{
	struct stack
	{
		NODE address;
		int flag;
	};

	NODE cur;
	struct stack s[20];
	int top=-1;

	if (root==NULL)
	{
		printf("Tree is empty\n");
		return;
	}

	cur=root;

	for (;;)
	{
		while(cur!=NULL)
		{
			s[++top].address=cur;
			s[top].flag=1;
			cur=cur->llink;
		}

		while(s[top].flag<0)
		{
			cur=s[top--].address;
			printf("%d ",cur->info);
			if (top==-1) return;
		}

		cur=s[top].address;
		cur=cur->rlink;
		s[top].flag=-1;
	}
}

void main()
{
	NODE root=NULL;
	int ch,item;

	for(;;)
	{
		printf("1-Insert\n2-Preorder\n");
		printf("3-Inorder\n4-Postorder\n");
		printf("5-Exit\n");

		printf("Enter choice\n");
		scanf("%d",&ch);

		switch(ch)
		{
		case 1:
			printf("Enter the item to be inserted\n");
			scanf("%d",&item); 
			root=insert(item,root);
			break;

		case 2:
			ipreorder(root);
			printf("\n");
			break;

		case 3:
			iinorder(root);
			printf("\n");
			break;


		case 4:
			ipostorder(root);
			printf("\n");
			break;


		default: exit(0);

		}
	}
}































































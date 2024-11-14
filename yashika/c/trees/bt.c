#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX 10

struct node
{
	int info;
	struct node *llink;
	struct node *rlink;
};

typedef struct node* NODE;

void preorder(NODE root)   //root left right
{
	if (root==NULL) return;

	printf("%d ",root->info);
	preorder(root->llink);
	preorder(root->rlink);
}

void postorder(NODE root)  //left right root
{
	if (root==NULL) return;

	postorder(root->llink);
	postorder(root->rlink);
	printf("%d ",root->info);
}

void inorder(NODE root)  //left root right
{
	if (root==NULL) return;

	inorder(root->llink);
	printf("%d ",root->info);
	inorder(root->rlink);
}

void display(NODE root, int level)
{
	int i;
	if (root==NULL) return;
	display(root->rlink,level+1);
	for(i=0;i<level;i++) printf("  ");
	printf("%d\n",root->info);
	display(root->llink,level+1);
}

void levelorder(NODE root)
{
	NODE q[MAX],cur;
	int front=0,rear=-1;

	q[++rear]=root;

	while (front<=rear)
	{
		cur=q[front++];
		printf("%d ",cur->info);

		if (cur->llink!=NULL)
			q[++rear]=cur->llink;
		if (cur->rlink!=NULL)
			q[++rear]=cur->rlink;
	}
	printf("\n");
}

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

void main()
{
	NODE root=NULL;
	int ch,item;

	for(;;)
	{
		printf("1-Insert\n2-Preorder\n");
		printf("3-Postorder\n4-Inorder\n");
		printf("5-Level Order\n6-Exit\n");

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
			if (root==NULL)
				printf("Tree is empty\n");
			else
			{
				printf("The given tree is\n");
				display(root,1);
				printf("Preorder traversal\n");
				preorder(root);
				printf("\n");
			}
			break;

		case 3:
			if (root==NULL)
				printf("Tree is empty\n");
			else
			{
				printf("The given tree is \n");
				display(root,1);
				printf("Postorder traversal\n");
				postorder(root);
				printf("\n");
			}
			break;

		case 4:
			if (root==NULL)
				printf("Tree is empty\n");
			else
			{
				printf("The given tree is \n");
				display(root,1);
				printf("Inorder traversal\n");
				inorder(root);
				printf("\n");
			}
			break;

		case 5:
			if (root==NULL)
				printf("Tree is empty\n");
			else
			{
				printf("The given tree is\n");
				display(root,1);
				printf("Level order traversal\n");
				levelorder(root);
				printf("\n");
			}
			break;

		default: exit(0);
			
		}
	}
}






































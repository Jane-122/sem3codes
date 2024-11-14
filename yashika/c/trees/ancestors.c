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

int printAncestors(NODE root, int target)
{
	if (root == NULL) return 0;
	if (root->info == target) return 1;
	if ( printAncestors(root->llink, target) || printAncestors(root->rlink, target) )
	{
		printf("%d ",root->info);
		return 1;
	}
	return 0;
}

int main()
{
    NODE root = NULL;  // Initialize root as NULL
    int choice, item, target;

    while (1)
    {
        printf("\nMenu:\n");
        printf("1. Insert Node\n");
        printf("2. Print Ancestors\n");
        printf("3. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice)
        {
        case 1:
            // Insert a new node
            printf("Enter the item to insert: ");
            scanf("%d", &item);
            root = insert(item, root);
            break;

        case 2:
            // Print ancestors of a target node
            if (root == NULL)
            {
                printf("Tree is empty\n");
                break;
            }

            printf("Enter the target node to find ancestors: ");
            scanf("%d", &target);

            printf("Ancestors of node %d: ", target);
            if (!printAncestors(root, target))
                printf("No ancestors found or node not in tree.\n");
            printf("\n");
            break;

        case 3:
            // Exit
            printf("Exiting...\n");
            exit(0);
            break;

        default:
            printf("Invalid choice. Please try again.\n");
        }
    }

    return 0;
}










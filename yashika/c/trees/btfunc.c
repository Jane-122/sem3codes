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


int search(NODE root, int ele)
{
    if (root == NULL) 
        return 0;

    if (root->info == ele)
        return 1;

    // Search left subtree
    if (search(root->llink, ele)) 
        return 1;

    // Search right subtree
    return search(root->rlink, ele);
}


NODE copy(NODE root)
{
	NODE temp;
	if (root==NULL)
	{
		return NULL;
	}
	temp=(struct node*)malloc(1*sizeof(struct node));
	temp->info=root->info;
	temp->llink=copy(root->llink);
	temp->rlink=copy(root->rlink);
	return temp;
}

int max(int a,int b)
{
	return (a>b)?a:b;
}

int height(NODE root)
{
    if (root == NULL) 
        return -1;  // The height of an empty tree is -1

    int leftHeight = height(root->llink);  // Recursive call for the left subtree
    int rightHeight = height(root->rlink); // Recursive call for the right subtree

    return 1 + max(leftHeight, rightHeight); // Add 1 for the current node and return the maximum height
}


int countnode(NODE root)
{
    static int count = 0;
	if(root!=NULL)
	{
		countnode(root->llink);
		count++;
		countnode(root->rlink);
	}
    return count;
}

int countleaf(NODE root)
{
	static int count = 0;
	if (root!=NULL)
	{
        countleaf(root->llink);
        if (root->llink==NULL && root->rlink==NULL) count++;
		countleaf(root->rlink);
	}
	return count;
}

int isequal(NODE root1,NODE root2)
{
	if (root1==NULL || root2==NULL)
	{
		return (root1==root2);
	}
	return (root1->info==root2->info)
	&& isequal(root1->llink,root2->llink)
	&& isequal(root1->rlink,root2->rlink);
}


int main()
{
    NODE root = NULL;
    NODE root_copy = NULL;
    int choice, item, ele;

    while (1)
    {
        printf("\nBinary Tree Operations Menu:\n");
        printf("1. Insert node\n");
        printf("2. Search for an element\n");
        printf("3. Copy the tree\n");
        printf("4. Find the height of the tree\n");
        printf("5. Count total nodes\n");
        printf("6. Count leaf nodes\n");
        printf("7. Check if two trees are equal\n");
        printf("8. Exit\n");

        printf("\nEnter your choice: ");
        scanf("%d", &choice);

        switch (choice)
        {
            case 1:
                printf("Enter the element to insert: ");
                scanf("%d", &item);
                root = insert(item, root);
                break;

            case 2:
                printf("Enter the element to search: ");
                scanf("%d", &ele);
                if (search(root, ele)) {
                    printf("Element %d found in the tree.\n", ele);
                } else {
                    printf("Element %d not found in the tree.\n", ele);
                }
                break;

            case 3:
                root_copy = copy(root);
                printf("Tree copied successfully.\n");
                break;

            case 4:
                printf("Height of the tree is: %d\n", height(root));
                break;

            case 5:
                printf("Total number of nodes in the tree: %d\n", countnode(root));
                break;

            case 6:
                printf("Total number of leaf nodes in the tree: %d\n", countleaf(root));
                break;

            case 7:
                if (isequal(root, root_copy)) {
                    printf("The trees are equal.\n");
                } else {
                    printf("The trees are not equal.\n");
                }
                break;

            case 8:
                printf("Exiting the program.\n");
                exit(0);

            default:
                printf("Invalid choice. Please try again.\n");
        }
    }

    return 0;
}







































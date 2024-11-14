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
	NODE temp,cur,prev;

	temp=(struct node*)malloc(1*sizeof(struct node));
	temp->info=item;
	temp->llink=NULL;
	temp->rlink=NULL;

	if (root==NULL) return temp;

	prev=NULL;
	cur=root;

	while(cur!=NULL)
	{
		prev=cur;
		if (item==cur->info)
		{
			printf("Duplicate items are not allowed\n");
			free(temp);
			return root;
		}

		if (item<cur->info)
			cur=cur->llink;
		else
			cur=cur->rlink;
	}

	if (item<prev->info)
		prev->llink=temp;
	else
		prev->rlink=temp;

	return root;
}

NODE isearch(int item,NODE root)
{
	NODE cur;

	if (root==NULL) return NULL;

	cur=root;
	while (cur!=NULL)
	{
		if (item==cur->info) return cur;

		if (item<cur->info)
			cur=cur->llink;
		else
			cur=cur->rlink;
	}
	return NULL;
}


NODE rsearch(int item,NODE root)
{
	if (root==NULL) return root;
	if (item==root->info) return root;
	if (item<root->info)
		return rsearch(item,root->llink);
	return rsearch(item,root->rlink);
}

NODE max(NODE root)
{
	NODE cur;

	if (root==NULL) return root;

	cur=root;
	while (cur->rlink!=NULL)
	{
		cur=cur->rlink;
	}
	return cur;
}

NODE min(NODE root)
{
	NODE cur;
	if (root==NULL) return root;

	cur=root;
	while(cur->llink!=NULL)
		cur=cur->llink;
	return cur;
}

NODE deleteitem(int item,NODE root)
{
	NODE cur,parent,suc,q;

	if (root==NULL)
	{
		printf("tree is empty! Item not found\n");
		return root;
	}

	parent=NULL,cur=root;
	while(cur!=NULL)
	{
		if (item==cur->info) break;
		parent=cur;
		cur=(item<cur->info) ? cur->llink : cur->rlink;
	}

	if (cur==NULL)
	{
		printf("Item not found\n");
		return root;
	}

	if (cur->llink==NULL)
		q=cur->rlink;
	else if (cur->rlink==NULL)
		q=cur->llink;
	else
	{
		suc=cur->rlink;
		while (suc->llink!=NULL)
			suc=suc->llink;
		suc->llink=cur->llink;

		q=cur->rlink;
	}

	if (parent==NULL) return q;

	if (cur==parent->llink)
		parent->llink=q;
	else
		parent->rlink=q;
	free(cur);
	return root;
}

int main()
{
    NODE root = NULL;
    NODE foundNode;
    int choice, item;
    
    while (1)
    {
        printf("\nBinary Search Tree Operations Menu:\n");
        printf("1. Insert an element\n");
        printf("2. Search for an element (Iterative)\n");
        printf("3. Search for an element (Recursive)\n");
        printf("4. Find maximum element\n");
        printf("5. Find minimum element\n");
        printf("6. Delete element\n");
        printf("7. Exit\n");
        
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
                printf("Enter the element to search (Iterative): ");
                scanf("%d", &item);
                foundNode = isearch(item, root);
                if (foundNode != NULL)
                    printf("Element %d found in the tree.\n", item);
                else
                    printf("Element %d not found in the tree.\n", item);
                break;
            
            case 3:
                printf("Enter the element to search (Recursive): ");
                scanf("%d", &item);
                foundNode = rsearch(item, root);
                if (foundNode != NULL)
                    printf("Element %d found in the tree.\n", item);
                else
                    printf("Element %d not found in the tree.\n", item);
                break;
            
            case 4:
                foundNode = max(root);
                if (foundNode != NULL)
                    printf("Maximum element in the tree is: %d\n", foundNode->info);
                else
                    printf("The tree is empty.\n");
                break;
            
            case 5:
                foundNode = min(root);
                if (foundNode != NULL)
                    printf("Minimum element in the tree is: %d\n", foundNode->info);
                else
                    printf("The tree is empty.\n");
                break;

            case 6:
            	printf("Enter item to be deleted\n");
            	scanf("%d",&item);
            	root=deleteitem(item,root);
            	break;
            
            case 7:
                printf("Exiting the program.\n");
                exit(0);
                
            default:
                printf("Invalid choice. Please try again.\n");
        }
    }
    
    return 0;
}




















































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

NODE concat(NODE first,NODE sec)
{
	NODE cur;
	if (first==NULL) return sec;
	if (sec==NULL) return first;

	cur=first;
	while(cur->link!=NULL)
	{
		cur=cur->link;
	}

	cur->link=sec;

	return first;
}


int main() {
    NODE first = NULL, second = NULL;
    int ch, item;

    for (;;) {
        printf("1-Insert Front (First List)\n");
        printf("2-Insert Front (Second List)\n");
        printf("3-Display (First List)\n");
        printf("4-Display (Second List)\n");
        printf("5-Concatenate Lists\n");
        printf("6-Quit\n");
        printf("Enter choice: ");
        scanf("%d", &ch);

        switch (ch) {
        case 1:
            printf("Enter item to insert in first list: ");
            scanf("%d", &item);
            first = insertfront(item, first);
            break;

        case 2:
            printf("Enter item to insert in second list: ");
            scanf("%d", &item);
            second = insertfront(item, second);
            break;

        case 3:
            display(first);
            break;

        case 4:
            display(second);
            break;

        case 5:
            first = concat(first, second);  // Concatenate the second list to the first
            second = NULL;  // After concatenation, second list becomes empty
            printf("Lists have been concatenated.\n");
            break;

        case 6:
            exit(0);

        default:
            printf("Invalid choice. Please try again.\n");
        }
    }

    return 0;
}



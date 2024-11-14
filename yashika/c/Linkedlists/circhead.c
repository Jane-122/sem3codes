
#include <stdio.h>
#include <stdlib.h>

struct node {
    int info;
    struct node* link;
};

typedef struct node* NODE;

NODE insertfront(int item, NODE head) {
    NODE temp;
    temp = (struct node*)malloc(sizeof(struct node));
    temp->info = item;
    temp->link = head->link;
    head->link = temp;
    return head;
}

NODE insertrear(int item, NODE head) {
    NODE temp, cur;
    temp = (struct node*)malloc(sizeof(struct node));
    temp->info = item;
    cur = head->link;
    while (cur->link != head) {
        cur = cur->link;
    }
    cur->link = temp;
    temp->link = head;
    return head;
}

void display(NODE head) {
    NODE temp;
    if (head->link == head) {
        printf("List is empty\n");
        return;
    }
    printf("Linked list contents:\n");
    temp = head->link;
    while (temp != head) {
        printf("%d ", temp->info);
        temp = temp->link;
    }
    printf("\n");
}

int main() {
    NODE head = (struct node*)malloc(sizeof(struct node));
    head->link = head;
    int choice, item;
    do {
        printf("\nMenu:\n");
        printf("1. Insert at front\n");
        printf("2. Insert at rear\n");
        printf("3. Display list\n");
        printf("4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);
        switch (choice) {
            case 1:
                printf("Enter the value to insert at the front: ");
                scanf("%d", &item);
                head = insertfront(item, head);
                break;
            case 2:
                printf("Enter the value to insert at the rear: ");
                scanf("%d", &item);
                head = insertrear(item, head);
                break;
            case 3:
                display(head);
                break;
            case 4:
                printf("Exiting the program...\n");
                break;
            default:
                printf("Invalid choice! Please try again.\n");
        }
    } while (choice != 4);
    return 0;
}

#include <stdio.h>
#include <stdlib.h>

struct node {
    int info;
    struct node *link;
};

typedef struct node* NODE;

// Function to insert a node at the front of the list
NODE insertfront(int item, NODE first) {
    NODE temp;
    temp = (struct node*)malloc(sizeof(struct node));
    temp->info = item;
    temp->link = first;
    return temp;
}

// Function to insert a node at the rear of the list
NODE insertrear(int item, NODE first) {
    NODE temp, cur;
    temp = (struct node*)malloc(sizeof(struct node));
    temp->info = item;
    temp->link = NULL;

    if (first == NULL) return temp;

    cur = first;
    while (cur->link != NULL) {
        cur = cur->link;
    }
    cur->link = temp;
    return first;
}

// Function to display the list
void display(NODE first) {
    NODE temp;
    if (first == NULL) {
        printf("List empty\n");
        return;
    }

    printf("Linked list contents: ");
    temp = first;
    while (temp != NULL) {
        printf("%d ", temp->info);
        temp = temp->link;
    }
    printf("\n");
}

// Function to check if an element exists in the list
int exists(NODE first, int item) {
    NODE temp = first;
    while (temp != NULL) {
        if (temp->info == item) {
            return 1;
        }
        temp = temp->link;
    }
    return 0;
}

// Function to perform UNION of two sets (lists)
NODE unionSets(NODE list1, NODE list2) {
    NODE result = NULL;
    NODE temp = list1;

    // Add all elements of list1 to the result list
    while (temp != NULL) {
        result = insertrear(temp->info, result);
        temp = temp->link;
    }

    // Add elements of list2 to the result list if they are not already in the list
    temp = list2;
    while (temp != NULL) {
        if (!exists(result, temp->info)) {
            result = insertrear(temp->info, result);
        }
        temp = temp->link;
    }

    return result;
}

// Function to perform INTERSECTION of two sets (lists)
NODE intersectionSets(NODE list1, NODE list2) {
    NODE result = NULL;
    NODE temp = list1;

    // Traverse through list1 and check if elements are present in list2
    while (temp != NULL) {
        if (exists(list2, temp->info)) {
            result = insertrear(temp->info, result);
        }
        temp = temp->link;
    }

    return result;
}

int main() {
    NODE list1 = NULL, list2 = NULL;
    int choice, item;

    while (1) {
        printf("Menu:\n");
        printf("1. Insert in List 1 (Front)\n");
        printf("2. Insert in List 2 (Front)\n");
        printf("3. Display List 1\n");
        printf("4. Display List 2\n");
        printf("5. Union of List 1 and List 2\n");
        printf("6. Intersection of List 1 and List 2\n");
        printf("7. Exit\n");
        printf("Enter choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter item to insert into List 1: ");
                scanf("%d", &item);
                list1 = insertfront(item, list1);
                break;

            case 2:
                printf("Enter item to insert into List 2: ");
                scanf("%d", &item);
                list2 = insertfront(item, list2);
                break;

            case 3:
                printf("List 1: ");
                display(list1);
                break;

            case 4:
                printf("List 2: ");
                display(list2);
                break;

            case 5:
                // Perform union
                printf("Union of List 1 and List 2: ");
                NODE unionResult = unionSets(list1, list2);
                display(unionResult);
                break;

            case 6:
                // Perform intersection
                printf("Intersection of List 1 and List 2: ");
                NODE intersectionResult = intersectionSets(list1, list2);
                display(intersectionResult);
                break;

            case 7:
                exit(0);

            default:
                printf("Invalid choice. Please try again.\n");
        }
    }

    return 0;
}

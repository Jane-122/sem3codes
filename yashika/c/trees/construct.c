#include<stdio.h>
#include<stdlib.h>

struct node {
    int data;
    struct node* left;
    struct node* right;
};

// Function to create a new node
struct node* create(int data) {
    struct node* newnode = (struct node*)malloc(sizeof(struct node));
    newnode->data = data;
    newnode->left = NULL;
    newnode->right = NULL;
    return newnode;
}

// Function to build the tree
struct node* buildtree(int* arr, int* index) {
    if (arr[*index] == -1) {
        (*index)++;
        return NULL;
    }

    struct node* root = create(arr[*index]);
    (*index)++;

    root->left = buildtree(arr, index);
    root->right = buildtree(arr, index);

    return root;
}

// Pre-order Traversal (Root -> Left -> Right)
void preorder(struct node* root) {
    if (root == NULL) {
        return;
    }
    printf("%d ", root->data);
    preorder(root->left);
    preorder(root->right);
}

// In-order Traversal (Left -> Root -> Right)
void inorder(struct node* root) {
    if (root == NULL) {
        return;
    }
    inorder(root->left);
    printf("%d ", root->data);
    inorder(root->right);
}

// Post-order Traversal (Left -> Right -> Root)
void postorder(struct node* root) {
    if (root == NULL) {
        return;
    }
    postorder(root->left);
    postorder(root->right);
    printf("%d ", root->data);
}

// Level-order Traversal (Breadth-first)
void levelorder(struct node* root) {
    if (root == NULL) {
        return;
    }

    struct node* queue[100];  // Array-based queue
    int front = 0, rear = 0;

    // Start by adding the root node to the queue
    queue[rear++] = root;

    while (front < rear) {
        struct node* current = queue[front++];  // Dequeue by incrementing front
        printf("%d ", current->data);

        // Enqueue left child
        if (current->left != NULL) {
            queue[rear++] = current->left;
        }

        // Enqueue right child
        if (current->right != NULL) {
            queue[rear++] = current->right;
        }
    }
}

int main() {
    int arr[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
    int index = 0;

    // Build the tree and assign root
    struct node* root = buildtree(arr, &index);

    // Print the traversals
    printf("Pre-order Traversal: ");
    preorder(root);
    printf("\n");

    printf("In-order Traversal: ");
    inorder(root);
    printf("\n");

    printf("Post-order Traversal: ");
    postorder(root);
    printf("\n");

    printf("Level-order Traversal: ");
    levelorder(root);
    printf("\n");

    return 0;
}
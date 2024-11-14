#include <stdio.h>
#include <stdlib.h>

#define MAX 100

typedef struct {
    int arr[MAX];
    int top;
} Stack;

void push(Stack *s, int value) {
    if (s->top < MAX - 1) {
        s->arr[++(s->top)] = value;
    }
}

int pop(Stack *s) {
    if (s->top >= 0) {
        return s->arr[(s->top)--];
    }
    return -1; // return an invalid value if stack is empty
}

int peek(Stack *s) {
    if (s->top >= 0) {
        return s->arr[s->top];
    }
    return -1; // return an invalid value if stack is empty
}

int isEmpty(Stack *s) {
    return s->top == -1;
}

void deleteKElements(int arr[], int n, int k) {
    Stack s;
    s.top = -1;
    
    // Iterate through the array
    for (int i = 0; i < n; i++) {
        // If the stack is not empty and the top of the stack is less than the current element
        while (!isEmpty(&s) && s.arr[s.top] < arr[i] && k > 0) {
            pop(&s);
            k--;
        }
        // Push the current element onto the stack
        push(&s, arr[i]);
    }
    
    // If we still need to remove more elements (i.e., k > 0), remove from the top
    while (k > 0 && !isEmpty(&s)) {
        pop(&s);
        k--;
    }
    
    // To maintain the original order of elements after stack operations
    int result[MAX];
    int resultSize = 0;
    
    // Transfer elements from stack to the result array
    while (!isEmpty(&s)) {
        result[resultSize++] = pop(&s);
    }
    
    // The result array is in reverse order, so print from end to start
    for (int i = resultSize - 1; i >= 0; i--) {
        printf("%d ", result[i]);
    }
    printf("\n");
}

int main() {
    int arr[] = {20, 10, 25, 30, 40};
    int n = sizeof(arr) / sizeof(arr[0]);
    int k = 2;

    printf("Output: ");
    deleteKElements(arr, n, k);

    return 0;
}

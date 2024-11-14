#include <stdio.h>
#include <stdlib.h>
#define max 5
typedef struct{
    char arr[max];
    int top;
} Stack; 

int isEmpty(Stack *s){
    return s->top == -1;
}

int isFull(Stack *s){
    return s->top == max-1;
}

void pop(Stack *s){
    if(isEmpty(s))
        printf("Underflow\n");
    else 
        printf("char:%c",s->arr[s->top--]);
}

void push(Stack *s){
    if(isFull(s))
        printf("Overflow\n");
    else{
        printf("Enter char to push: ");
        scanf(" %c",&s->arr[++s->top]);
    }
}

void display(Stack *s){
    if(isEmpty(s))
        printf("Stack is empty\n");
    else{
        for(int i=0;i<=s->top;i++)
            printf("%c\t",s->arr[i]);
    }
    printf("\n");
}

int main(){
    Stack s;
    s.top = -1;
    int ch = 0;
    while (ch!=4)
    {
        printf("Enter 1 to push\n");
        printf("Enter 2 to pop\n");
        printf("Enter 3 to display\n");
        printf("Enter 4 to exit\n");
        printf("Enter your choice: ");
        scanf(" %d",&ch);
        switch (ch)
        {
        case 1:
            push(&s);
            break;
        
        case 2:
            pop(&s);
            break;
        
        case 3:
            display(&s);
            break;
        default:
            exit(0);
            break;
        }
    }
    return 0;
}

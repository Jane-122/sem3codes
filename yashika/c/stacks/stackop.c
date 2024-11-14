#include <stdio.h>
#include <stdlib.h>
#define max 5

typedef struct
{
	char arr[max];
	int top;
} stack;

int isempty(stack *s)
{
	return s->top==-1;
}

int isfull(stack *s)
{
	return s->top==max-1;
}

void pop(stack *s)
{
	if (isempty(s))
		printf("underflow\n");
	else
		printf("char : %c\n",s->arr[s->top--]);
}

void push(stack *s){
	if (isfull(s))
	 printf("overflow\n");
	else
	{
		printf("Enter char to push ");
		scanf(" %c",&s->arr[++s->top]);
	}
}

void display(stack *s)
{
	if (isempty(s))
		printf("empty stack\n");
	else
	{
		for (int i=0;i<=s->top;i++)
			printf("%c\t",s->arr[i]);
	}
}

int main()
{
	stack s;
	s.top=-1;
	int ch=0;
	while (ch!=4)
	{
		printf("enter 1 to push\n");
		printf("enter 2 to pop\n");
		printf("enter 3 to display\n");
		printf("enter 4 to exit\n");
		printf("enter choice ");
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































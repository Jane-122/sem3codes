#include <stdio.h>
#include <stdio.h>
#include <stdlib.h>

#define max 32

typedef struct 
{
	int arr[max];
	int top;
}Stack;

void init(Stack *s)
{
	s->top=-1;
}

int isempty(Stack *s)
{
	return s->top==-1;
}

int isfull(Stack *s)
{
	return s->top==max-1;
}

void push(Stack *s,int elem)
{
	if (!isfull(s))
	{
		s->arr[++s->top]=elem;
	}
}

int pop(Stack *s)
{
	if (!isempty(s))
	{
		return s->arr[s->top--];
	}
	return -1;
}


void main()
{
	Stack s;
	init(&s);
}





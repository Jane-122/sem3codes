#include <stdio.h>
#include <stdlib.h>

struct node
{
	int coeff;
	int expon;
	struct node *link;
};

typedef struct node *NODE;

void display(NODE first)
{
	NODE temp;

	if (first==NULL)
	{
		printf("Polynomial does not exist\n");
		return;
	}

	temp=first;
	while(temp!=NULL)
	{
		if (temp->coeff<0)
			printf("%2d x^%2d ",temp->coeff,temp->expon);
		else
			printf("+%2d x^%2d ",temp->coeff,temp->expon);

		temp=temp->link;
	}

	printf("\n");
}

NODE attach(int coeff, int expon, NODE first)
{
	NODE temp,cur;

	temp=(struct node*)malloc(1*sizeof(struct node));

	temp->coeff=coeff;
	temp->expon=expon;
	temp->link=NULL;

	if (first==NULL) return temp;

	cur=first;
	while (cur->link!=NULL)
	{
		cur=cur->link;
	}

	cur->link=temp;
	return first;

}

NODE readpoly(NODE first)
{
	int i=1;
	int coeff;
	int expon;

	printf("Enter the coefficient as -999 to end the polynomial\n");
	while(1)
	{
		printf("Enter the %d term\n",i++);
		printf("Coeff=");
		scanf("%d",&coeff);

		if (coeff==-999) break;

		printf("pow x=");
		scanf("%d",&expon);

		first=attach(coeff,expon,first);
	}
	return first;
}

int compare(int x,int y)
{
	if (x==y)
		return 0;
	else if (x>y)
		return 1;
	else
		return -1;
}

NODE polyadd(NODE a,NODE b)
{
	NODE c=NULL;
	int coeff;

	while (a!=NULL && b!=NULL)
	{
		switch(compare(a->expon,b->expon))
		{
		case 0:
			coeff=a->coeff+b->coeff;

			if (coeff!=0) c=attach(coeff,a->expon,c);

			a=a->link;
			b=b->link;

			break;

		case 1:
			c=attach(a->coeff,a->expon,c);
			a=a->link;
			break;

		default:
			c=attach(b->coeff,b->expon,c);
			b=b->link;
		}
	}

	while (a!=NULL)
	{
		c=attach(a->coeff,a->expon,c);
		a=a->link;
	}

	while (b!=NULL)
	{
		c=attach(b->coeff,b->expon,c);
		b=b->link;
	}

	return c;
}


void main()
{
	NODE poly1=NULL,poly2=NULL,poly3=NULL;

	printf("Enter the first polynomial\n");
	poly1=readpoly(poly1);

	printf("Enter the second polynomial\n");
	poly2=readpoly(poly2);

	poly3=polyadd(poly1,poly2);

	printf("Polynomial 1 ");
	display(poly1);

	printf("Polynomial 2 ");
	display(poly2);

	printf("Polynomial 3 ");
	display(poly3);

}













































#include <stdio.h>
#include <stdlib.h>

struct node
{
	int coeff;
	int expon;
	struct node *link;
};

typedef struct node *NODE;

void display(NODE head)
{
	NODE temp;

	if (head->link==head)
	{
		printf("Polynomial does not exist\n");
		return;
	}

	temp=head->link;
	while(temp!=head)
	{
		if (temp->coeff<0)
			printf("%2d x^%2d ",temp->coeff,temp->expon);
		else
			printf("+%2d x^%2d ",temp->coeff,temp->expon);

		temp=temp->link;
	}

	printf("\n");
}

NODE attach(int coeff, int expon, NODE head)
{
	NODE temp,cur;

	temp=(struct node*)malloc(1*sizeof(struct node));

	temp->coeff=coeff;
	temp->expon=expon;

	cur=head->link;
	while (cur->link!=head)
	{
		cur=cur->link;
	}

	cur->link=temp;
	temp->link=head;

	return head;

}

NODE readpoly(NODE head)
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

		head=attach(coeff,expon,head);
	}
	return head;
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

NODE polyadd(NODE head1,NODE head2,NODE head3)
{
	NODE a,b;
	int coeff;

	a=head1->link;
	b=head2->link;

	while (a!=head1 && b!=head2)
	{
		switch(compare(a->expon,b->expon))
		{
		case 0:
			coeff=a->coeff+b->coeff;

			if (coeff!=0) head3=attach(coeff,a->expon,head3);

			a=a->link;
			b=b->link;

			break;

		case 1:
			head3=attach(a->coeff,a->expon,head3);
			a=a->link;
			break;

		default:
			head3=attach(b->coeff,b->expon,head3);
			b=b->link;
		}
	}

	while (a!=head1)
	{
		head3=attach(a->coeff,a->expon,head3);
		a=a->link;
	}

	while (b!=head2)
	{
		head3=attach(b->coeff,b->expon,head3);
		b=b->link;
	}

	return head3;
}


void main()
{
	NODE head1,head2,head3;

	head1=(struct node *)malloc(1*sizeof(struct node));
	head2=(struct node *)malloc(1*sizeof(struct node));
	head3=(struct node *)malloc(1*sizeof(struct node));

	head1->link=head1;
	head2->link=head2;
	head3->link=head3;

	printf("Enter the first polynomial\n");
	head1=readpoly(head1);

	printf("Enter the second polynomial\n");
	head2=readpoly(head2);

	head3=polyadd(head1,head2,head3);

	printf("Polynomial 1 ");
	display(head1);

	printf("Polynomial 2 ");
	display(head2);

	printf("Polynomial 3 ");
	display(head3);

}



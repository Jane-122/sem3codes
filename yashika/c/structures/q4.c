/*
Use Pointers to structures and dynamic memory management functions in the following programs

Create a structure STUDENT consisting of variables of structures:
i.DOB {day, month (use pointer ), year},
ii.STU_INFO {reg_no, name(use pointer), address},
iii.COLLEGE {college_name (use pointer), university_name}
where structure types from i to iii are declared outside the STUDENT independently. 
Show how to read and display member variables of DOB type if pointer variable is created for DOB inside STUDENT and 
STUDENT variable is also a pointer variable. The program should read and display the values of all members of STUDENT structure.
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>


typedef struct {
    int day;
    char *month;  
    int year;
} DOB;

typedef struct {
    int reg_no;
    char *name;   
    char address[100];
} STU_INFO;


typedef struct {
    char *college_name;    
    char university_name[50];
} COLLEGE;


typedef struct {
    DOB *dob;          
    STU_INFO *info;     
    COLLEGE *college;   
} STUDENT;

void readStudent(STUDENT *student) {

   student->dob = (DOB*)malloc(sizeof(DOB));
   student->dob->month = (char*)malloc(20 * sizeof(char)); 

   student->info = (STU_INFO*)malloc(sizeof(STU_INFO));
   student->info->name = (char*)malloc(50 * sizeof(char)); 

   student->college = (COLLEGE*)malloc(sizeof(COLLEGE));
   student->college->college_name = (char*)malloc(100 * sizeof(char));

   printf("Enter Date of Birth (dd mm yyyy): ");
   scanf("%d %s %d", &student->dob->day, student->dob->month, &student->dob->year);

   printf("Enter Registration Number: ");
   scanf("%d", &student->info->reg_no);
   printf("Enter Name: ");
   scanf(" %[^\n]", student->info->name);
   printf("Enter Address: ");
   scanf(" %[^\n]", student->info->address);

   printf("Enter College Name: ");
   scanf(" %[^\n]", student->college->college_name);
   printf("Enter University Name: ");
   scanf(" %[^\n]", student->college->university_name);
}

void displayStudent(const STUDENT *student) {
   printf("\nDate of Birth: %02d %s %d\n", student->dob->day, student->dob->month, student->dob->year);

   printf("Registration Number: %d\n", student->info->reg_no);
   printf("Name: %s\n", student->info->name);
   printf("Address: %s\n", student->info->address);

   printf("College Name: %s\n", student->college->college_name);
   printf("University Name: %s\n", student->college->university_name);
}

int main() {

   STUDENT *student = (STUDENT*)malloc(sizeof(STUDENT));

   readStudent(student);

   displayStudent(student);

   return 0;
}
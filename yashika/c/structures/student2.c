/*
Use Pointers to structures and dynamic memory management functions in the following programs

Write a C program to implement the following functions. Use pointers and dynamic memory management functions.
i. To read one Student object where Student is a structure with name, roll number and CGPA as the data members
ii. To display one Student object
iii. To sort an array of Student structures according to the roll number.
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
   char name[50];
   int roll_number;
   float cgpa;
} Student;

void readStudent(Student* student) {
   printf("Enter student name: ");
   scanf("%s", student->name);
   printf("Enter roll number: ");
   scanf("%d", &student->roll_number);
   printf("Enter CGPA: ");
   scanf("%f", &student->cgpa);
}

void displayStudent(const Student* student) {
   printf("Name: %s\n", student->name);
   printf("Roll Number: %d\n", student->roll_number);
   printf("CGPA: %.2f\n", student->cgpa);
}

void sortStudentsByRollNumber(Student* students, int n) {
   for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
         if (students[j].roll_number > students[j + 1].roll_number) {
            Student temp = students[j];
            students[j] = students[j + 1];
            students[j + 1] = temp;
         }
      }
   }
}

int main() {

   int n;

   printf("Enter the number of students: ");
   scanf("%d", &n);

   Student* students = (Student*)malloc(n * sizeof(Student));

   for (int i = 0; i < n; i++) {
      printf("Enter details for student %d:\n", i + 1);
      readStudent(&students[i]);
   }

   sortStudentsByRollNumber(students, n);

   printf("\nStudents sorted by roll number:\n");
   for (int i = 0; i < n; i++) {
      displayStudent(&students[i]);
      printf("\n");
   }

   return 0;
}
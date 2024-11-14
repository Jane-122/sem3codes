/*
Use Pointers to structures and dynamic memory management functions in the following programs

Samuel wants to store the data of his employees, which includes the following fields: 
(i) Name of the employee 
(ii) Date of birth which is a collection of {day, month, year} 
(iii) Address which is a collection of {house number, zip code and state}.
Write a 'C' program to read and display the data of N employees using pointers to array of structures.
*/


#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int day;
    int month;
    int year;
} Date;


typedef struct {
    int house_number;
    int zip_code;
    char state[30];
} Address;

typedef struct {
    char name[50];
    Date dob;
    Address address;
} Employee;

void readEmployee(Employee* emp) {
    printf("Enter the name of the employee: ");
    scanf(" %[^\n]", emp->name);
    printf("Enter the date of birth (dd mm yyyy): ");
    scanf("%d %d %d", &emp->dob.day, &emp->dob.month, &emp->dob.year);
    printf("Enter the house number: ");
    scanf("%d", &emp->address.house_number);
    printf("Enter the zip code: ");
    scanf("%d", &emp->address.zip_code);
    printf("Enter the state: ");
    scanf(" %[^\n]", emp->address.state); 
}

void displayEmployee(const Employee* emp) {
    printf("Name: %s\n", emp->name);
    printf("Date of Birth: %02d-%02d-%d\n", emp->dob.day, emp->dob.month, emp->dob.year);
    printf("Address: House No: %d, Zip Code: %d, State: %s\n", emp->address.house_number, emp->address.zip_code, emp->address.state);
}

int main() {
   int n;

   printf("Enter the number of employees: ");
   scanf("%d", &n);

   Employee* employees = (Employee*)malloc(n * sizeof(Employee));

   for (int i = 0; i < n; i++) {
      printf("\nEnter details for employee %d:\n", i + 1);
      readEmployee(&employees[i]);
   }

   printf("\nDisplaying the details of all employees:\n");
   for (int i = 0; i < n; i++) {
      printf("\nEmployee %d:\n", i + 1);
      displayEmployee(&employees[i]);
   }

   return 0;
}
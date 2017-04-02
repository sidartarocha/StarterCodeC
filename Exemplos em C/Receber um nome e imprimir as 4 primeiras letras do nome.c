/*Receber um nome e imprimir as 4 primeiras letras do nome.*/
#include<string.h>
#include<stdio.h>
#include<conio.h>
int main()
{
    char nome[20],i;
    printf("digite um nome : ");
    
    gets(nome);
    system("cls");
    for(i=0;i<4;i=i+1)
    printf("%c",nome[i]);
    printf("\n\n");
    
   
    system("pause");
}

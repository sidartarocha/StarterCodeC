#include<stdio.h>
#include<stdlib.h>
int maiuscula(char c)
{
 if(c>='a' && c<='z')
 c=c-'a'+'A';
 
 return c;
 
}
int main()
{
char nome[100];
char may[100];
int i;
printf("Digite um nome (em minusculo):\n");
fflush(stdin);
gets(nome);
printf("%i",strlen(nome));
for(i=0;nome[i];i++)
may[i]=maiuscula(nome[i]);

printf("\n%s\n\n",may);
getch();


}
 
 
 

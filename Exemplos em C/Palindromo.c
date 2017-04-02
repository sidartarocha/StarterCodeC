
#include<stdio.h>
#include<stdlib.h>
int palindromo(char str[])
{
    int i;
    int t=strlen(str);
    for(i=strlen(str)-1;i>=0;i--)
    {
     if(str[t-i-1]!=str[i])
     return 0;
                       
     }
 return 1;
}
int main()
{
char str[100]="1210";
printf("%i",palindromo(str));
getch();
}
 

#include <stdio.h>
#include <conio.h>
#include <math.h>
int convert(int num)
{
int resto=0,t=1;
int bin=0;
if(num==0 || num==1)
return num;
else
{
 while(num!=1)
  {
   resto=num%2;
   num=num/2;
   bin=bin + resto*t;
   t=t*10;
   if(num==1)
   bin=bin + num*t;

   
  }
 
  return bin;
 }
}
int main()
{
    int num;
    printf("Digite  um numero :");
    scanf("%i",&num);
    printf("%i equivale a %i em binario...",num,convert(num));
    getch();
}

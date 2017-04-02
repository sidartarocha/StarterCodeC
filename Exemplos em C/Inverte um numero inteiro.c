#include <stdio.h>
#include <conio.h>
#include <math.h>

int invert(int num)
{
    int n=0;//contador de algarismos...
    int unidade=0,inverso=0,resto=0;
   
    
    
 
    do 
    {
     unidade=num%10;
    num=num/10;
     inverso=inverso*10 + unidade;
    
     
     }while(num!=0);//aqui ocorre a inversão...
    
    return inverso;
    
}
int main()
{
     int num;
    printf("Digite um numero pra ver invertido:");
    scanf("%i",&num);
    printf("%i\n",invert(num));
    getch();
}

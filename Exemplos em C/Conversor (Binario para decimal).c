#include<stdio.h>
#include<conio.h>
#include<math.h>

int convert(int bin);
int main()
{
    int bin;
    int num;
    int i;
    printf("Digite um numero binario:");
    scanf("%i",&bin);
    num=convert(bin);
    printf("%i equivale a %i\n",bin,num);
    getch();
}
int convert(int bin)
{
    if(bin==1 || bin==0)
    {
     return bin;
     }else
     {
      
    int soma=0;
    int i;
    int cont=0;
    int resto,unidade;
   
   i=0;//reinializa variavel auxiliar..
   while(resto!=0)
   {
   unidade=bin%10;
   if(unidade!=0)
   {
    soma=soma+pow(2,i);
           
     }
  resto=bin/10;
  bin=resto;
  i++;
  }
  return soma;
 }

}

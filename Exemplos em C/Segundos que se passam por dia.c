#include<stdio.h>
int main()
{
    int h,m,s,seg=0;
    printf("Digite a Hora :");
    scanf("%i",&h);
    printf("Digite os minutos :");
    scanf("%i",&m);
    printf("digite os segundos : ");
    scanf("%i",&s);
    seg=h*3600 + m*60 +s;
    printf("até a  hora %i:%0i:%i se passou %i segundos no dia\n",h,m,s,seg);
    system("pause");
}
    

int main()
{
    int a1,a2,a3;//angulos de um triangulo..
    printf("Digite o 1º angulo:");
    scanf("%i",&a1);
    printf("Digite o 2º angulo:");
    scanf("%i",&a2);
    if(a1+a2<180)
    {
    a3=180-a1-a2;
    if(a1==90 || a2==90 || a3==90)  
    printf("Triangulo Retangulo\n");
    else if(a1>90 || a2>90 || a3>90)  
    printf("Triangulo Obtusangulo\n");
    else 
    printf("Triangulo Acutangulo\n");
    }else
    {
         printf("Os angulos digitados não correspondem a um triangulo\n");
         }
    getch();
}

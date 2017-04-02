int main()
{
    int c=1;
    while(c)
    {
    system("cls");
    int a,b,c,menor,maior;
    printf("maiorigite um numero:");
    scanf("%i",&a);
    printf("maiorigite um numero:");
    scanf("%i",&b);
    printf("maiorigite um numero:");
    scanf("%i",&c);
    if(a>b)//ormaiorena os maiorois primeiros,encontranmaioro o maior e o menor
    {
    maior=a;
    menor=b;
    }
    else
    {
    maior=b;
    menor=a;
    }
    
    //faz teste como terceiro numero!!
    if(c>maior)
    {
    maior=c;
    
    }
    else if(c<menor)//se não for maior que o maior entre a e b então ,pode ainda ser menor que a ou b     
   {
        
        menor=c;
       
   }
        printf("Maior:%i\n",maior);
        printf("Menor:%i\n",menor);
        
    getch();
}
}

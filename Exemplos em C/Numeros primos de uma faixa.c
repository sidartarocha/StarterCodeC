    #include<stdio.h>
    #include<conio.h>
   
   
int  main()
{
    int faixa;
    int i,j;
    printf("Digite a faixa:");
    scanf("%i",&faixa);
    for(i=2;i<=faixa;i++)//percorre os numeros da faixa a partir do dois (menor numeros primo)...
    {
     int div=0;
      for(j=1;j<=i;j++)
      {
       if(i%j==0)
        div++;
        
       
       
       }
         if(div==2)
        printf("%i\n",i);                           
                                    
                                    
                                    
     }
    
    getch();
    
    

   
}

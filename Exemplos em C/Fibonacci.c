int fib (int pos)
{
           int i;
        
           int aux1=0,aux2=1,fib=0;
           for(i=0;i<=pos;i++)
           {
            if(i==0 || i==1)
            printf("%i,",i);
            else{
                 
        
            fib=aux1+aux2;
            printf("%i,",fib);
            aux1=aux2;
            aux2=fib;
                              
             }
        
      }
      
}
int main()
{
    int pos;
    printf("Digite a posição de Fib:");
    scanf("%i",&pos);
    fib(pos);
 
    getch();
}

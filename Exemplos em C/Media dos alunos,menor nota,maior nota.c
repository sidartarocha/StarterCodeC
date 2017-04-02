int main()
{
    float i,cont=0;
    float nota=0,media=0,soma=0;
    float menor=10,maior=0;
    for(i=1;i<=10;i++)
    {
     cont++;
      printf("Digite uma nota :");
      scanf("%f",&nota);
      soma=soma+nota;
      if(nota>maior)
      maior=nota;
      if(nota<menor)
      menor=nota;
       media=soma/cont;
      
      
            }
            
            printf("\n\nMedia:%f\n",media);
            printf("Maior:%f\n",maior);
            printf("Menor:%f\n\n",menor);
            
   system("pause");   
 }

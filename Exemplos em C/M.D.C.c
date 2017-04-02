//M.D.C com dedução de formula para obtenção  do M.D.C
#include<stdio.h>
#include<conio.h>
main()
{
      int a,b;
      int menor,maior,resto;
      printf("Digite um  numero:");
      scanf("%d",&a);
      printf("Digite um  numero:");
      scanf("%d",&b);
      if(a>b)
      {
      menor=b;
      maior=a;
      }else
      {
       menor=a;
      maior=b;
      }
      resto=maior%menor;
      if(resto==0)
      {
       printf("M.D.C(%d,%d)=%d",a,b,menor);
      }else if (menor%resto==0 && maior%resto==0)
       {
                        
       printf("M.D.C(%d,%d)=%d\n",a,b,resto);       
        }else
        {
         printf("M.D.C(%d,%d)=%d\n",a,b,1);  
         }
                        
          
 
 
        
         
      getch();
      
      
}

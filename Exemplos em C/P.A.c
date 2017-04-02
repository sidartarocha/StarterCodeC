int main()
{
    int pa;
    int i,n,Term_inic,Term,r;//r-razão 
    int soma=0;
    printf("Digite o termo inicial da P.A:");
    scanf("%i",&Term_inic);
    printf("Digite a Razao da PA:");
    scanf("%i",&r);
    printf("Digite N (o termo que vc quer ver!)");
    scanf("%i",&n);
    for(i=0;i<n;i++)
    {
     Term=Term_inic + r*i;
     soma=soma+Term;
     printf("%i,",Term);
  }
 printf("\tSOMA:%i",soma);
 getch();
}  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    


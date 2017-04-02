int main()
{
  char nome[100];
  char sigla[10];
  printf("Digite um nome :");
  gets(nome);
  int i=0;
  int t=0;
  for(i=0;nome[i];i++)
  {
  if(i==0 || nome[i-1]==' ')
  printf("%c.",nome[i]);
             
                      
  }

    getch();
}

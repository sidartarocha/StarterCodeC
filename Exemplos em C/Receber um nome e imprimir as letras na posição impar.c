#include <string.h>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include <stdio.h>
main()
{

int pp,tam,x;
char APELIDO[100];
printf ("[%c]Informe um apelido: ");
gets(APELIDO);
tam=strlen(APELIDO);
printf("\nAs letras na posicao impar sao:");
for(pp=1;pp<=tam-1;pp=pp+2)

printf(" %c ",APELIDO[pp]);
printf("\n\nNome digitado: %s\t",APELIDO);
printf ("\n\n");
system("PAUSE");

return 0;
}

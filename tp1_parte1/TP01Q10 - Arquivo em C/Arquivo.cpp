#include <stdio.h>
#include <stdlib.h>
#include <string.h>
/* Ana Carolina Medeiros
*/
//Metodos pre chamados para o funcionamento do software
char* writeArq();
void arq(int n);

//Main
int main(){
    int n;
    const char *c = NULL;
    c = writeArq();
    n =  atoi(c);
    arq(n);
    return 0;
}//Fim main

//Metodo que escreve no arquivo Arq.txt e retorna um char
char* writeArq(){
    FILE *file = fopen("Arq.txt","w");
      char c[1000];
      static char n[1000];
      fgets(c,1000,stdin);
      strcpy(n, c);
        while(fgets(c,1000,stdin) != NULL){
          fputs(c, file);
        }
            fclose(file);
      return n;
}//Fim metodo

//Metodo para ler o arquivo Arq.txt
void arq(int n){
  FILE *file = fopen("Arq.txt","r");
  char c[1000];
  char s = c[1000] - (double) c[1000];
      for(int i = 0; i< n;i++){
          for(int j = 0; j< n - i;j++){
              if(j == n-i-1){
                fgets(c,1000,file);
                  if(strlen(c) != 0){
                      if(s== 0){
                        printf("%g\n", atof(c));
                      }
                      else{
                        printf("%d\n", atoi(c));
                      }
                  }
                }else{
                  fgets(c,1000,file);
                }
              }
              rewind(file);
              int j = 0;
      }
      fclose(file);
}//Fim metodo

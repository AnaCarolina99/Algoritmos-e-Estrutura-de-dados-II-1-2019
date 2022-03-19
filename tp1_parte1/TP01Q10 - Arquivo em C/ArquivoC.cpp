/**
 *@author: Darlan Francisco
 *Date: 18/08/2018
 */

#include<stdio.h>
#include<stdlib.h>
#include<string.h>

//metodos usandos no programa arquivo em c
char* escreverArquivo();
void lerArquivo(int t);

//main do programa em c
int main(int args, char* argv[]){
    const char *l = NULL;
    int t;
    l = escreverArquivo();
    t = atoi(l);
    lerArquivo(t);
    return 0;
}

//metodo para escrever o arquivo
char* escreverArquivo(){
    FILE *arq = fopen("arquivo.txt","w");
    char e[1000];
    static char numero[1000];
    fgets(e, 1000, stdin);
    strcpy(numero, e);
    while (fgets(e, 1000, stdin) != NULL){
        fputs(e, arq);
    }
    fclose(arq);
    return numero;
}

//metodo para ler o arquivo
void lerArquivo(int t){
    FILE *arq1 = fopen("arquivo.txt", "r");
    char e[1000];
    char aux = e[1000] - (double)e[1000];
    for( int i = 0 ; i < t; i++ ){
        for( int j=0 ; j<t - i; j++ ){
            if(j == t - i - 1){
                fgets(e, 1000, arq1); 
                if(strlen(e) != 0){
                    if(aux == 0) {
                        printf("%g\n",atof(e)); 
                    }else{
                        printf("%d\n",atoi(e)); 
                    }
                }
            }else{
            fgets(e, 1000, arq1);
            }
        }
        rewind(arq1);
        int j = 0;
    }
    fclose(arq1);
}

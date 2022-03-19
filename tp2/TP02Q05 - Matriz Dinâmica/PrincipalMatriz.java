class Celula {
  //Atributos da Celula
   public int elemento;
   public Celula inf, sup, esq, dir;

   //Construtor 1
   public Celula(){
      this(0, null, null, null, null);
   }//Fim contrutor

   //Construtor 2
   public Celula(int elemento){
      this(elemento, null, null, null, null);
   }//Fim contrutor

   //Construtor 3
   public Celula(int elemento, Celula inf, Celula sup, Celula esq, Celula dir){
      this.elemento = elemento;
      this.inf = inf;
      this.sup = sup;
      this.esq = esq;
      this.dir = dir;
   }//Fim contrutor

}//Fim classe Celula

class Matriz{
  //Atributos
    private Celula inicio;
    private int linhas, colunas;

    //Construtor 1
      public Matriz(int tamanho){
        this.linhas = this.colunas = tamanho;
      }//Fim Construtor

      //Construtor 2
      public Matriz(int linhas, int colunas){
        this.linhas = linhas;
        this.colunas = colunas;

          Celula col = null;
          Celula lin = null;

            for(int i = 0; i < linhas;i++){
                for(int j = 0;j < colunas ; j++){
                    if(i == 0 && j ==0){
                      inicio = new Celula();
                      col = inicio;
                      lin = inicio;
                    }else if(j != 0){
                        col.dir = new Celula();
                        col.dir. esq = col;
                        col = col.dir;

                          if(i != 0){
                            col.esq.sup.dir.inf = col;
                            col.sup = col.esq.sup.dir;
                          }

                       }
                    }//Fim for 2

                      if(i + 1 != linhas){
                          lin.inf = new Celula();
                          lin.inf.sup = lin;
                          lin = lin.inf;
                          col = lin;
                }

            }//Fim for 1
      }//Fim Construtor

      //Metodo para inserir elementos na matriz
        public void inserir(){
          String[] aux = new String[linhas];
            for(int i = 0;i<linhas;aux[i] = MyIO.readLine(),i++);
            int i = 0;
            int j = 0;
              for(Celula linha = inicio;linha !=null;linha = linha.inf,j++){
                String[] valor = aux[j].split(" ");
                i = 0;
                  for(Celula col = linha;col != null;col = col.dir,i++){
                    col.elemento = Integer.parseInt(valor[i]);

                  }//Fim for 2

              }//Fim for 1
        }//Fim inserir

        //Metodo que recebe as duas matrizes, somam
        //E retornam uma matriz somada
        public static Matriz soma(Matriz matriz1,Matriz matriz2){
          Matriz resposta = new Matriz(matriz1.linhas,matriz2.colunas);
            for(Celula linha = resposta.inicio,linha1 = matriz1.inicio,linha2 = matriz2.inicio;linha !=null;linha = linha.inf,linha1 = linha1.inf,linha2 = linha2.inf){
              for(Celula coluna = linha,coluna1 = linha1,coluna2 = linha2;coluna != null;coluna = coluna.dir,coluna1 = coluna1.dir,coluna2 = coluna2.dir){
                coluna.elemento = coluna1.elemento + coluna2.elemento;
              }
            }
            return resposta;
        }//Fim soma

        //Metodo que recebe as duas matrizes, multiplica
        //E retornam uma matriz multiplicada
       public static Matriz multiplicacao(Matriz matriz1,Matriz matriz2, int mult){
            Matriz resposta = new Matriz(matriz1.linhas,matriz2.colunas);
              for(Celula linha = resposta.inicio,linhaA = matriz1.inicio;linha!=null;linha = linha.inf,linhaA = linhaA.inf){
                  for(Celula coluna = linha,colunaB = matriz2.inicio;coluna != null;coluna = coluna.dir,colunaB = colunaB.dir){
                    mult = 0;
                      for(Celula colunaA = linhaA, linhaB = colunaB;colunaA != null;colunaA = colunaA.dir,linhaB = linhaB.inf){
                          mult += colunaA.elemento * linhaB.elemento;
                      }
                      coluna.elemento = mult;
                  }
              }
              return resposta;
        }//Fim multiplicacao

        //Metodo para printar a matriz feita
        public void mostrar(){
            for(Celula linha = inicio;linha!=null;linha = linha.inf){
              for(Celula coluna = linha;coluna!= null;coluna = coluna.dir){
                System.out.print(coluna.elemento + " ");
              }
              System.out.println();
            }
        }//Fim mostrar

        //Metodo que chama o metodo diagonal principal
        // e envia um espaco em branco tambem
        public void mostrarDiagonalPrincipal(){
          mostrarDiagonalPrincipal(inicio);
          System.out.println();
        }//Fim mostrarDiagonalPrincipal

        //Metodo que mostra a diagonal principal da matriz
        public void mostrarDiagonalPrincipal(Celula celula){
          System.out.print(celula.elemento + " ");
            if((celula.dir != null) && (celula.dir.inf != null))
            mostrarDiagonalPrincipal(celula.dir.inf );
        }//Fim mostrarDiagonalPrincipal

        //Metodo que chama o metodo diagonal Secundaria
        // e envia um espaco em branco tambem
        public void mostrarDiagonalSecundaria(){
            Celula linhaFinal;
              for(linhaFinal = inicio; linhaFinal.dir != null; linhaFinal = linhaFinal.dir);
                mostrarDiagonalSecundaria(linhaFinal);
                System.out.println();
        }//Fim mostrarDiagonalSecundaria

        //Metodo que mostra a diagonal Secundaria da matriz
        public void mostrarDiagonalSecundaria(Celula celula){
          System.out.print(celula.elemento + " ");
            if((celula.esq !=null) && (celula.esq.inf !=null))
              mostrarDiagonalSecundaria(celula.esq.inf);
        }//Fim mostrarDiagonalSecundaria

  }//Fim classe Matriz

class PrincipalMatriz {
   public static void main(String[] args){
     //entrada da quantiadade de casos
      int cont = Integer.parseInt(MyIO.readLine());
      int linha = 0;
      int coluna = 0;
        for(int i = 0;i<cont;i++){
          //entrar os valores da linha e coluna
          linha = Integer.parseInt(MyIO.readLine());
          coluna = Integer.parseInt(MyIO.readLine());
          Matriz m = new Matriz(linha,coluna);
          //inserir a 1 matriz
          m.inserir();
          //entrar os valores da linha e coluna de novo
          linha = Integer.parseInt(MyIO.readLine());
          coluna = Integer.parseInt(MyIO.readLine());
          Matriz m2 = new Matriz(linha,coluna);
          //inserir a 2 matriz
          m2.inserir();
          //mostrar as diagonais principal e Secundaria da 1 matriz
          m.mostrarDiagonalPrincipal();
          m.mostrarDiagonalSecundaria();
          //somar matriz 1 e 2 e logo apos mostrar o resultado
          Matriz.soma(m,m2).mostrar();
          //multiplicar matriz 1 e 2 e logo apos mostrar o resultado
          Matriz.multiplicacao(m,m2,0).mostrar();
        }//fim for

   }//Fim main
}//Fim classe PrincipalMatriz

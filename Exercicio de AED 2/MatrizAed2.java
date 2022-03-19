class Celula {
   public int elemento;
   public Celula inf, sup, esq, dir;

   public Celula(){
      this(0, null, null, null, null);
   }

   public Celula(int elemento){
      this(elemento, null, null, null, null);
   }

   public Celula(int elemento, Celula inf, Celula sup, Celula esq, Celula dir){
      this.elemento = elemento;
      this.inf = inf;
      this.sup = sup;
      this.esq = esq;
      this.dir = dir;
   }
}

class Matriz {
   private Celula inicio;
   private int linhas, colunas;

   public Matriz (){
      this(3, 3);
   }

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

   public void inserir(){
     int x =linhas * colunas;
     int s[] = new int[x];
      for(int i = 0;i<x;i++){
        s[i] = i;
      }
      int i = 0;
      for(Celula linh = inicio;linh!=null;linh=linh.inf){
        for(Celula col = linh; col!=null;col=col.dir,i++){
          col.elemento = s[i];
        }
      }
   }

   public int soma(){
     int soma = 0;
     for(Celula linh = inicio;linh!=null;linh=linh.inf){
       for(Celula col = linh; col!=null;col=col.dir){
        soma+= col.elemento;
       }
     }
     return soma;
   }

   public int multi(){
     int i = 0;
     int multi = 0;
     for(Celula linh = inicio;linh!=null;linh=linh.inf){
       for(Celula col = linh; col!=null;col=col.dir,i++){
            multi+= col.elemento * linh.elemento;
       }
   }
    return multi;
 }

   //Metodo para printar a matriz feita
   public void mostrar(){
       for(Celula linha = inicio;linha!=null;linha = linha.inf){
         for(Celula coluna = linha;coluna!= null;coluna = coluna.dir){
           System.out.print(coluna.elemento + " ");
         }
         System.out.println();
       }
   }//Fim mostrar

   public void mostrarDiagonalPrincipal(){
     Celula i = inicio;
     System.out.println(i.elemento + " ");
      while(i.dir!= null && i.dir.inf!= null){
          i = i.dir.inf;
          System.out.println(i.elemento + " ");
      }
   }

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

   /*
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
*/

}

class MatrizAed2 {

   public static void main(String[] args){
      Matriz m1;
      m1 = new Matriz(3,3);
      m1.inserir();
      m1.mostrar();
      System.out.println(m1.soma());
      System.out.println(m1.multi());
      m1.mostrarDiagonalPrincipal();
      System.out.println("Diagonal Secundaria");
      m1.mostrarDiagonalSecundaria();

   }
}

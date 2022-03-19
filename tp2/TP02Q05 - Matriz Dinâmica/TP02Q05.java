import java.nio.charset.*;
import java.util.Scanner;
import java.io.*;
import java.*;
//Este e outros exercicios foram feitos em conjunto com colegas.
class TP02Q05 {

   public static void main(String args []) {

      int quantidade = Integer.parseInt(MyIO.readLine());
      int linhas = 0;
      int colunas = 0;

      for (int i = 0; i < quantidade; i++) {
         
         linhas = Integer.parseInt(MyIO.readLine());
         colunas = Integer.parseInt(MyIO.readLine());
         Matriz matriz1 = new Matriz(linhas, colunas);
         matriz1.inserir();
         linhas = Integer.parseInt(MyIO.readLine());
         colunas = Integer.parseInt(MyIO.readLine());
         Matriz matriz2 = new Matriz(linhas, colunas);
         matriz2.inserir();
         matriz1.mostrarDiagonalPrincipal();
         matriz1.mostrarDiagonalSecundaria();
         Matriz.somatorio(matriz1, matriz2).mostar();
         Matriz.multiplicacao(matriz1, matriz2, 0).mostar();
      }
   }

}

class Celula {
    
    public int elemento;
    public Celula inferior, superior, esquerda, direita;

    public Celula() {
        this(0, null, null, null, null);
    }

    public Celula(int elemento) {
        this(elemento, null, null, null, null);
    }

    public Celula(int elemento, Celula inferior, Celula superior, Celula esquerda, Celula direita) {
        this.elemento = elemento;
        this.inferior = inferior;
        this.superior = superior;
        this.esquerda = esquerda;
        this.direita  = direita;
    }
}

class Matriz {
    
    private Celula inicio;
    private int linhas, colunas;

    public Matriz (int tamanho) {
        this.linhas = this.colunas = tamanho;
    }

    public Matriz (int linhas, int colunas) {

        this.linhas = linhas;
        this.colunas = colunas;
        Celula col = null;
        Celula lin = null;

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {

                if (i == 0 && j == 0) {
                inicio = new Celula();
                col = inicio;
                lin = inicio;
                } else if (j != 0) {
                col.direita = new Celula();
                col.direita.esquerda = col;
                col = col.direita;

                if (i != 0) {
                    col.esquerda.superior.direita.inferior = col;
                    col.superior = col.esquerda.superior.direita;
                }
                }
            }

            if (i + 1 != linhas) {
                lin.inferior = new Celula();
                lin.inferior.superior = lin;
                lin = lin.inferior;
                col = lin;
            }
        }
    }


    public void inserir() {
        
        String[] aux = new String[linhas];
        for (int i = 0; i < linhas; aux[i] = MyIO.readLine(), i++);
        
        int i = 0, j = 0;
        for (Celula linha = inicio; linha != null; linha = linha.inferior, j++) {
            String[] valor = aux[j].split(" ");
            i = 0;
            for (Celula col = linha; col != null; col = col.direita, i++) {
                col.elemento = Integer.parseInt(valor[i]);
            }
        }
    }


    public static Matriz somatorio(Matriz matriz1, Matriz matriz2) {
        
        Matriz resposta = new Matriz(matriz1.linhas, matriz2.colunas);

        for (Celula linha = resposta.inicio, linha1 = matriz1.inicio, linha2 = matriz2.inicio; linha != null; linha = linha.inferior, linha1 = linha1.inferior, linha2 = linha2.inferior) {
            for (Celula coluna = linha, coluna1 = linha1, coluna2 = linha2; coluna != null; coluna = coluna.direita, coluna1 = coluna1.direita, coluna2 = coluna2.direita) {
                coluna.elemento = coluna1.elemento + coluna2.elemento;
            }
        }
        return resposta;
    }

    public static Matriz multiplicacao(Matriz matriz1, Matriz matriz2, int mult) {

        Matriz resposta = new Matriz(matriz1.linhas, matriz2.colunas);

        for (Celula linha = resposta.inicio , linhaA = matriz1.inicio; linha != null; linha = linha.inferior , linhaA = linhaA.inferior) {
            for (Celula coluna = linha , colunaB = matriz2.inicio; coluna != null; coluna = coluna.direita , colunaB = colunaB.direita) {
                mult = 0;
                for (Celula colunaA = linhaA , linhaB = colunaB; colunaA != null; colunaA = colunaA.direita , linhaB = linhaB.inferior) {
                mult += colunaA.elemento * linhaB.elemento;
                }
                coluna.elemento = mult;
            }
        }
        return resposta;
    }

    public void mostar() {

        for (Celula linha = inicio; linha != null; linha = linha.inferior) {
            for (Celula coluna = linha; coluna != null; coluna = coluna.direita) {
                System.out.print(coluna.elemento + " ");
            }
            System.out.println();
        }
    }
    
    public void mostrarDiagonalPrincipal() {
        mostrarDiagonalPrincipal(inicio);
        System.out.println();
    }

    public void mostrarDiagonalPrincipal(Celula celula) {

        System.out.print(celula.elemento + " ");

        if ((celula.direita != null) && (celula.direita.inferior != null)) mostrarDiagonalPrincipal(celula.direita.inferior);
    }

    public void mostrarDiagonalSecundaria() {

        Celula linhaFinal;

        for (linhaFinal = inicio; linhaFinal.direita != null; linhaFinal = linhaFinal.direita);
        mostrarDiagonalSecundaria(linhaFinal);
        System.out.println();

    }

    public void mostrarDiagonalSecundaria(Celula celula) {

        System.out.print(celula.elemento + " ");

        if ((celula.esquerda != null) && (celula.esquerda.inferior != null)) mostrarDiagonalSecundaria(celula.esquerda.inferior);
    }
}

/**
 * Principal para Arvore Binaria de Pesquisa
 * @author Max do Val Machado
 */
 import java.util.Random;

public class Principal {
   public static void main(String[] args) throws Exception {
      ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
      Random gerador = new Random();
      int Selena[] = new int[30];
         for(int i = 0;i<5;i++){
            arvoreBinaria.inserir(gerador.nextInt(100));
         }

/*Exemplo de arvore completa
         arvoreBinaria.inserir(8);
         arvoreBinaria.inserir(4);
         arvoreBinaria.inserir(12);
         arvoreBinaria.inserir(2);
         arvoreBinaria.inserir(6);
         arvoreBinaria.inserir(1);
         arvoreBinaria.inserir(3);
         arvoreBinaria.inserir(5);
         arvoreBinaria.inserir(7);
         arvoreBinaria.inserir(10);
         arvoreBinaria.inserir(9);
         arvoreBinaria.inserir(11);
         arvoreBinaria.inserir(14);
         arvoreBinaria.inserir(13);
         arvoreBinaria.inserir(15);
*/
      System.out.println("QUESTAO 1");
      arvoreBinaria.mostrarCentral();
      arvoreBinaria.mostrarPre();
      arvoreBinaria.mostrarPos();
      System.out.println("QUESTAO 2");
      int c = 0;
         c = arvoreBinaria.pesq4();
         System.out.println(c);
     System.out.println("QUESTAO 3");
      if(arvoreBinaria.pesq44() == true){
         System.out.println("Todos sao multiplos de 4");
      }
      else{
      System.out.println("Todos nao sao multiplos de 4");
      }

      /*System.out.println("QUESTAO 4");
      System.out.println("Altura: " + arvoreBinaria.getAltura());
        if(arvoreBinaria.completa() == true){
          System.out.println("Arvore completa");
        }
        else {
          System.out.println("Arvore incompleta");
        }*/

        System.out.println("QUESTAO 4");
        if(arvoreBinaria.elemento() == true){
          System.out.println("Arvore completa");
        }
        else {
          System.out.println("Arvore incompleta");
        }

   }
}

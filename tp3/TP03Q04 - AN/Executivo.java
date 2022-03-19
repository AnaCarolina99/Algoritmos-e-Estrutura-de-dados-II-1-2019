import java.time.LocalDateTime;
import java.time.LocalDate;
import java.io.*;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

/**
 * No da arvore binaria
 * @author Max do Val Machado
 */
class No{
  public boolean cor;
  public Presidente elemento;
  public No esq, dir;
  public No (){
      this(null);
  }
  public No (Presidente elemento){
      this(elemento, false, null, null);
  }
  public No (Presidente elemento, boolean cor){
      this(elemento, cor, null, null);
  }
  public No (Presidente elemento, boolean cor, No esq, No dir){
    this.cor = cor;
    this.elemento = elemento;
    this.esq = esq;
    this.dir = dir;
  }
}

/**
 * Arvore binaria de pesquisa
 * @author Max do Val Machado
 */
 class Alvinegra {
    private No raiz; // Raiz da arvore.
    private int comp;

    /**
     * Construtor da classe.
     */
    public Alvinegra() {
        raiz = null;
    }

    //Retorna a quantidade de Comparacoes
         public int comp(){
             return comp;
           }

    /**
     * Metodo publico iterativo para pesquisar elemento.
     * @param elemento Elemento que sera procurado.
     * @return <code>true</code> se o elemento existir,
     * <code>false</code> em caso contrario.
     */
    public boolean pesquisar(String elemento) {
        return pesquisar(elemento, raiz);
    }

    /**
     * Metodo privado recursivo para pesquisar elemento.
     * @param elemento Elemento que sera procurado.
     * @param i No em analise.
     * @return <code>true</code> se o elemento existir,
     * <code>false</code> em caso contrario.
     */
    private boolean pesquisar(String elemento, No i) {
      boolean resp;
        if (i == null) {
          comp++;
          MyIO.println(" "+convertUTF8toISO("NÃO"));
         resp = false;

      } else if (elemento.equals(i.elemento.getNome())) {
        comp++;
        MyIO.println(" "+convertUTF8toISO("SIM"));
         resp = true;

      } else if (elemento.compareTo(i.elemento.getNome())< 0) {
        comp++;
        MyIO.print(" esq");
         resp = pesquisar(elemento, i.esq);

      } else {
        comp++;
        MyIO.print(" dir");
         resp = pesquisar(elemento, i.dir);
      }
      return resp;
    }

    //Metodo que converte uma String UTF-8 em um ISO e retorna a mesma ja convertida
    public static String convertUTF8toISO(String endereco){
        String s = null;
        try{
          s = new String(endereco.getBytes("ISO-8859-1"),"UTF-8");
        }
        catch (java.io.UnsupportedEncodingException e){
          return null;
        }
        return s;
    }//Fim Metodo

    /**
     * Metodo publico iterativo para exibir elementos.
     */
    public void mostrarCentral() {
        System.out.print("[ ");
        mostrarCentral(raiz);
        System.out.println("]");
    }

    /**
     * Metodo privado recursivo para exibir elementos.
     * @param i No em analise.
     */
    private void mostrarCentral(No i) {
        if (i != null) {
            mostrarCentral(i.esq); // Elementos da esquerda.
            System.out.print(i.elemento + ((i.cor) ? "(p) " : "(b) ")); // Conteudo do no.
            mostrarCentral(i.dir); // Elementos da direita.
        }
    }

    /**
     * Metodo publico iterativo para exibir elementos.
     */
    public void mostrarPre() {
        System.out.print("[ ");
        mostrarPre(raiz);
        System.out.println("]");
    }

    /**
     * Metodo privado recursivo para exibir elementos.
     * @param i No em analise.
     */
    private void mostrarPre(No i) {
        if (i != null) {
            System.out.print(i.elemento + ((i.cor) ? "(p) " : "(b) ")); // Conteudo do no.
            mostrarPre(i.esq); // Elementos da esquerda.
            mostrarPre(i.dir); // Elementos da direita.
        }
    }

    /**
     * Metodo publico iterativo para exibir elementos.
     */
    public void mostrarPos() {
        System.out.print("[ ");
        mostrarPos(raiz);
        System.out.println("]");
    }

    /**
     * Metodo privado recursivo para exibir elementos.
     * @param i No em analise.
     */
    private void mostrarPos(No i) {
        if (i != null) {
            mostrarPos(i.esq); // Elementos da esquerda.
            mostrarPos(i.dir); // Elementos da direita.
            System.out.print(i.elemento + ((i.cor) ? "(p) " : "(b) ")); // Conteudo do no.
        }
    }


    /**
     * Metodo publico iterativo para inserir elemento.
     * @param elemento Elemento a ser inserido.
     * @throws Exception Se o elemento existir.
     */
    public void inserir(Presidente elemento) throws Exception {
      //Se a arvore estiver vazia
      if(raiz == null){
        comp++;
         raiz = new No(elemento, false);
         //System.out.println("Antes, zero elementos. Agora, raiz(" + raiz.elemento + ").");

      //Senao, se a arvore tiver um elemento
      } else if (raiz.esq == null && raiz.dir == null){
        comp++;
         if (raiz.elemento.getNome().compareTo(elemento.getNome()) >0){
            raiz.esq = new No(elemento, true);
            //System.out.println("Antes, um elemento. Agora, raiz(" + raiz.elemento + ") e esq(" + raiz.esq.elemento +").");
         } else {
           comp++;
            raiz.dir = new No(elemento, true);
            //System.out.println("Antes, um elemento. Agora, raiz(" + raiz.elemento + ") e dir(" + raiz.dir.elemento +").");
         }

      //Senao, se a arvore tiver dois elementos (raiz e dir)
      } else if (raiz.esq == null){
          comp++;
         if(raiz.elemento.getNome().compareTo(elemento.getNome()) >0){
            raiz.esq = new No(elemento);


         } else if (raiz.dir.elemento.getNome().compareTo(elemento.getNome()) >0){
           comp++;
            raiz.esq = new No(raiz.elemento);
            raiz.elemento = elemento;


         } else {
           comp++;
            raiz.esq = new No(raiz.elemento);
            raiz.elemento = raiz.dir.elemento;
            raiz.dir.elemento = elemento;

         }

         raiz.esq.cor = raiz.dir.cor = false;

      //Senao, se a arvore tiver dois elementos (raiz e esq)
      } else if (raiz.dir == null){
          comp++;
         if(raiz.elemento.getNome().compareTo(elemento.getNome()) < 0){
            raiz.dir = new No(elemento);

         } else if (raiz.esq.elemento.getNome().compareTo(elemento.getNome()) < 0){
            raiz.dir = new No(raiz.elemento);
            raiz.elemento = elemento;

         } else {
            raiz.dir = new No(raiz.elemento);
            raiz.elemento = raiz.esq.elemento;
            raiz.esq.elemento = elemento;

         }

         raiz.esq.cor = raiz.dir.cor = false;

      //Senao, a arvore tem tres ou mais elementos
      } else {
        comp++;
           inserir(elemento, null, null, null, raiz);
      }

      raiz.cor = false;
   }

   private void balancear(No bisavo, No avo, No pai, No i){
     //Se o pai tambem e preto, reequilibrar a arvore, rotacionando o avo
     if(pai.cor == true){

        //4 tipos de reequilibrios e acoplamento
        if(pai.elemento.getNome().compareTo(avo.elemento.getNome()) >0){ // rotacao a esquerda ou direita-esquerda
           if(i.elemento.getNome().compareTo(pai.elemento.getNome()) >0){
              avo = rotacaoEsq(avo);
           } else {
              avo = rotacaoDirEsq(avo);
           }

        } else { // rotacao a direita ou esquerda-direita
           if(i.elemento.getNome().compareTo(pai.elemento.getNome()) <0){
              avo = rotacaoDir(avo);
           } else {
              avo = rotacaoEsqDir(avo);
           }
        }

        if (bisavo == null){
           raiz = avo;
        } else {
           if(avo.elemento.getNome().compareTo(bisavo.elemento.getNome()) < 0){
              bisavo.esq = avo;
           } else {
              bisavo.dir = avo;
           }
        }

        //reestabelecer as cores apos a rotacao
        avo.cor = false;
        avo.esq.cor = avo.dir.cor = true;

     } //if(pai.cor == true)
  }
    /**
     * Metodo privado recursivo para inserir elemento.
     * @param elemento Elemento a ser inserido.
     * @param avo No em analise.
     * @param pai No em analise.
     * @param i No em analise.
     * @throws Exception Se o elemento existir.
     */
    private void inserir(Presidente elemento, No bisavo, No avo, No pai, No i) throws Exception {
      if (i == null) {
        comp++;
       if(elemento.getNome().compareTo(pai.elemento.getNome()) < 0){
         comp++;
          i = pai.esq = new No(elemento, true);
       } else {
         comp++;
          i = pai.dir = new No(elemento, true);
       }
       if(pai.cor == true){
         comp++;
          balancear(bisavo, avo, pai, i);
       }
    } else {
      comp++;
      //Achou um 4-no: eh preciso fragmeta-lo e reequilibrar a arvore
       if(i.esq != null && i.dir != null && i.esq.cor == true && i.dir.cor == true){
          i.cor = true;
          i.esq.cor = i.dir.cor = false;
          if(i == raiz){
             i.cor = false;
          }else if(pai.cor == true){
             balancear(bisavo, avo, pai, i);
          }
       }
       if (elemento.getNome().compareTo(i.elemento.getNome()) < 0) {
          inserir(elemento, avo, pai, i, i.esq);
       } else if (elemento.getNome().compareTo(i.elemento.getNome()) >0) {
          inserir(elemento, avo, pai, i, i.dir);
        }else if (elemento.getNome().equals(i.elemento.getNome())){

       } else {
          throw new Exception("Erro inserir (elemento repetido)!");
       }
    }
  }

   private No rotacaoDir(No no) {
      //System.out.println("Rotacao DIR(" + no.elemento + ")");
      No noEsq = no.esq;
      No noEsqDir = noEsq.dir;

      noEsq.dir = no;
      no.esq = noEsqDir;

      return noEsq;
   }

   private No rotacaoEsq(No no) {
      //System.out.println("Rotacao ESQ(" + no.elemento + ")");
      No noDir = no.dir;
      No noDirEsq = noDir.esq;

      noDir.esq = no;
      no.dir = noDirEsq;
      return noDir;
   }

   private No rotacaoDirEsq(No no) {
      no.dir = rotacaoDir(no.dir);
      return rotacaoEsq(no);
   }

   private No rotacaoEsqDir(No no) {
      no.esq = rotacaoEsq(no.esq);
      return rotacaoDir(no);
   }
}

/**
 *
 * @author Ana Carolina Medeiros Gonçalves
 * Feito com a ajuda de Darlan Francisco e Ana Luiza Pacheco
 */

class Presidente{
//Atributos
private int id;
private int idade;
private String nome;
private String localNascimento;
private String localMorte;
private String antecessor;
private String sucessor;
private String vice;
private String pagina;
private long paginaTam;
private LocalDateTime dataNascimento;
private LocalDateTime inicioMandato;
private LocalDateTime fimMandato;
private LocalDateTime dataMorte;
//Atributos criados para complementar o codigo
private int contMorte;
private int contSucessor;

 	//Construtor 1
public Presidente(){
   this.id = 0;
   this.idade = 0;
   this.nome = "";
   this.localNascimento = "";
   this.localMorte = "";
   this.antecessor = "";
   this.sucessor = "";
   this.vice = "";
   this.pagina = "";
   this.paginaTam = 0;
   this.dataNascimento = LocalDateTime.of(1,1,1,1,1);
   this.inicioMandato = LocalDateTime.of(1,1,1,1,1);
   this.fimMandato = LocalDateTime.of(1,1,1,1,1);
   this.dataMorte = LocalDateTime.of(1,1,1,1,1);
   this.contMorte = 0;
   this.contSucessor = 0;
 }//Fim Construtor

 	//Construtor 2
 public Presidente(int id,int idade,String nome,String localNascimento,String localMorte,
 String antecessor,String sucessor,String vice,String pagina,long paginaTam,
  LocalDateTime dataNascimento,LocalDateTime inicioMandato,LocalDateTime fimMandato,
  LocalDateTime dataMorte){

    this.id = id;
    this.idade = idade;
    this.nome = nome;
    this.localNascimento = localNascimento;
    this.localMorte = localMorte;
    this.antecessor = antecessor;
    this.sucessor = sucessor;
    this.vice = vice;
    this.pagina = pagina;
    this.paginaTam = paginaTam;
    this.dataNascimento = dataNascimento;
    this.inicioMandato = inicioMandato;
    this.fimMandato = fimMandato;
    this.dataMorte = dataMorte;
 }//Fim Construtor

//Metodo get
 public int getId(){
    return this.id;
 }//Fim metodo

//Metodo set
 public void setId(int id){
    this.id = id;
 }//Fim metodo

//Metodo get
 public int getIdade(){
    return this.idade;
 }//Fim metodo

//Metodo set
 public void setIdade(int idade){
    this.idade = idade;
 }//Fim metodo

//Metodo get
 public String getNome(){

    return this.nome;
 }//Fim metodo

//Metodo set
 public void setNome(String nome){
    this.nome = nome;
 }//Fim metodo

//Metodo get
 public String getLocalNascimento(){
    return this.localNascimento;
 }//Fim metodo

//Metodo set
 public void setLocalNascimento(String localNascimento){
    this.localNascimento = localNascimento;
 }//Fim metodo

//Metodo get
 public String getLocalMorte(){
    return this.localMorte;
 }//Fim metodo

//Metodo set
 public void setLocalMorte(String localMorte){
    this.localMorte = localMorte;
 }//Fim metodo

//Metodo get
 public String getAntecessor(){
    return this.antecessor;
 }//Fim metodo

//Metodo set
 public void setAntecessor(String antecessor){
    this.antecessor = antecessor;
 }//Fim metodo

//Metodo get
 public String getSucessor(){
    return this.sucessor;
 }//Fim metodo

//Metodo set
 public void setSucessor(String sucessor){
    this.sucessor = sucessor;
 }//Fim metodo

//Metodo get
 public String getVice(){
    return this.vice;
 }//Fim metodo

//Metodo set
 public void setVice(String vice){
    this.vice = vice;
 }//Fim metodo

//Metodo get
 public String getPagina(){
    return this.pagina;
 }//Fim metodo

//Metodo set
 public void setPagina(String pagina){
    this.pagina = pagina;
 }//Fim metodo

//Metodo get
 public long getPaginaTam(){
    return this.paginaTam;
 }//Fim metodo

//Metodo set
 public void setPaginaTam(long paginaTam){
    this.paginaTam = paginaTam;
 }//Fim metodo

//Metodo get
 public LocalDateTime getDataNascimento(){
    return this.dataNascimento;
 }//Fim metodo

//Metodo set
 public void setDataNascimento(LocalDateTime dataNascimento){
    this.dataNascimento = dataNascimento;
 }//Fim metodo

//Metodo get
 public LocalDateTime getInicioMandato(){
    return this.inicioMandato;
 }//Fim metodo

//Metodo set
 public void setInicioMandato(LocalDateTime inicioMandato){
    this.inicioMandato = inicioMandato;
 }//Fim metodo

//Metodo get
 public LocalDateTime getFimMandato(){
    return this.fimMandato;
 }//Fim metodo

//Metodo set
 public void setFimMandato(LocalDateTime fimMandato){
    this.fimMandato = fimMandato;
 }//Fim metodo

//Metodo get
 public LocalDateTime getDataMorte(){
    return this.dataMorte;
 }//Fim metodo

//Metodo set
 public void setDataMorte(LocalDateTime dataMorte){
    this.dataMorte = dataMorte;
 }//Fim metodo

public Presidente clone(){
  Presidente p = new Presidente();

  p.id = this.id;
  p.idade = this.idade;
  p.nome = this.nome;
  p.localNascimento = this.localNascimento;
  p.localMorte = this.localMorte;
  p.antecessor = this.antecessor;
  p.sucessor = this.sucessor;
  p.vice = this.vice;
  p.pagina = this.pagina;
  p.paginaTam = this.paginaTam;
  p.dataNascimento = this.dataNascimento;
  p.inicioMandato = this.inicioMandato;
  p.fimMandato = this.fimMandato;
  p.dataMorte = this.dataMorte;
  p.contMorte = this.contMorte;
  p.contSucessor = this.contSucessor;
    return p;
}//Fim clone

/*Metodo ler que recebe o html requisitado pelo usuario
/	Chama todos os metodos que leem o arquivo e envia como parametro o endereco
*/
public void ler(String endereco){
MyIO.setCharset("UTF-8");
  contaTam(endereco);
  lerTudo(endereco);
  lerAntecessor(endereco);
  lerSucessor(endereco);
  lerMorte(endereco);

}//Fim metodo

/*Metodo contaTam que recebe o html requisitado pelo usuario
/	Metodo que conta a quantidade de caracteres na pagina html requisitado pelo usuario
/ Salva o valor na variavel cont
*/
public void contaTam(String endereco){
    long cont = 0;
    File arquivo=new File(endereco);
    cont+=arquivo.length();
     setPaginaTam(cont);
}//Fim metodo

/*Metodo lerTudo que recebe o html requisitado pelo usuario
/	Metodo que procura e salva as variaveis requisitadas
/ Procura os atributos id, data de nascimento,local de nascimento,
/inicio de mandato,fim de mandato, vice e nome completo
/Salva os valores nas variaveis designadas
*/
public void lerTudo(String endereco){
  //Variaveis nome da pagina
  setPagina(endereco);
  //Abrir arquivo
  Arq.openRead(endereco);
  String id2 = "";
  String nome2 = "";
  String localN = "";
  String localDataN = "";
  String localDataM = "";
  String localM = "";
  String vice2= "";
  String idade2 =  "";
  String dataN= "";
  String inicioM= "";
  String fimM= "";
  String dataM= "";
  int cont = 0;
  int contMorte = 0;

      try{
          //Titulos a serem pesquisados
          String tituloId = "title=\"Lista de presidentes do Brasil\"";
          String tituloNome = "Nome completo";
          String tituloVice = "Vice-presidente";
          String tituloNascimento = "Nascimento" ;
          String tituloMorte = "Morte";
          String tituloP = "Período";

          //Achar e salvar Id
            endereco = Arq.readLine();
              while(endereco.contains(tituloId)== false)endereco = Arq.readLine();
                  id2 = endereco.replaceAll("<[^>]*>", "");
                  id2 = id2.replaceAll("&#32","");
                  id2 = id2.replaceAll("[^0-9]","");
                  setId(Integer.parseInt(id2));

                  //Achar e salvar Inicio e Fim do mandato
                    endereco = Arq.readLine();
                    String fimMandato2 = "";
                    while(endereco.contains(tituloP)== false)endereco = Arq.readLine();
                    inicioM =  Arq.readLine();
                    inicioM =  Arq.readLine();
                    inicioM = inicioM.replaceAll("<[^>]*>","");
                    inicioM = inicioM.replaceAll(";","");
                    inicioM = inicioM.replaceAll(" de ","-");
                    inicioM = inicioM.replaceAll("º","");
                    inicioM = inicioM.replaceAll("té","");
                    inicioM = inicioM.replaceAll("&#32","");
                    inicioM = inicioM.replaceAll("&#160","");
                    inicioM = inicioM.replaceAll("janeiro","1");
                    inicioM = inicioM.replaceAll("fevereiro","2");
                    inicioM = inicioM.replaceAll("março","3");
                    inicioM = inicioM.replaceAll("abril","4");
                    inicioM = inicioM.replaceAll("maio","5");
                    inicioM = inicioM.replaceAll("junho","6");
                    inicioM = inicioM.replaceAll("julho","7");
                    inicioM = inicioM.replaceAll("agosto","8");
                    inicioM = inicioM.replaceAll("setembro","9");
                    inicioM = inicioM.replaceAll("outubro","10");
                    inicioM = inicioM.replaceAll("novembro","11");
                    inicioM = inicioM.replaceAll("dezembro","12");
                    //Dividir a String em duas partes
                    String []auxM = inicioM.split("a");
                    inicioM = auxM[0];
                    fimM = auxM[1];
                    //Dividir a String em 3 partes para encontrar
                    //dia , mes e ano do inicio do mandato
                    String []auxM2 = inicioM.split("-");
                      String diaI = auxM2[0];
                      String mesI = auxM2[1];
                      String anoI = auxM2[2];
                      anoI = anoI.trim();
                      //Dividir a String em 3 partes para encontrar
                      //dia , mes e ano do fim do mandato
                      String []auxM3 = fimM.split("-");
                        String diaF = auxM3[0];
                        diaF = diaF.trim();
                        String mesF = auxM3[1];
                        String anoF = auxM3[2];
                        anoF = anoF.replaceAll("[^0-9]","");
                        //converter a String ja repartida em int
                        int dayI = Integer.parseInt(diaI);
                        int mouthI = Integer.parseInt(mesI);
                        int yearI = Integer.parseInt(anoI);
                        int dayF = Integer.parseInt(diaF);
                        int mouthF = Integer.parseInt(mesF);
                        int yearF = Integer.parseInt(anoF);
                        //Conversao de int para LocalDateTime
                        LocalDateTime inicio = LocalDateTime.of(yearI,mouthI,dayI,0,0);
                        LocalDateTime fim = LocalDateTime.of(yearF,mouthF,dayF,0,0);
                        setFimMandato(fim);
                        setInicioMandato(inicio);

                        //Achar e salvar vice-presidente
                        endereco = Arq.readLine();
                        while(endereco.contains(tituloVice) == false)endereco= Arq.readLine();
                            vice2 = Arq.readLine();
                            vice2 = Arq.readLine();
                            vice2 = vice2.replaceAll("<[^>]*>","");
                            vice2 = vice2.trim();
                            setVice(vice2);

                    //Achar e salvar Nome
                    endereco = Arq.readLine();
                  while(endereco.contains(tituloNome) == false)endereco =  Arq.readLine();
                  nome2 = Arq.readLine();
                  nome2 = Arq.readLine();
                  nome2 = nome2.replaceAll("<[^>]*>","");
                  nome2 = nome2.trim();
                  setNome(nome2);

                  //Achar e salvar Data de Nascimento, Local de Nascimento e Idade
                  while(endereco.contains(tituloNascimento)== false) endereco = Arq.readLine();
                  dataN = Arq.readLine();
                  dataN = Arq.readLine();
                  dataN = dataN.replaceAll("<[^>]*>","");
                  dataN = dataN.replaceAll("&#32","");
                  dataN = dataN.replaceAll("&#160","");
                  dataN = dataN.replaceAll(";","");
                  dataN = dataN.replaceAll("º","");
                  dataN = dataN.replaceAll("","");
                  dataN = dataN.replaceAll(" de ","-");
                  dataN = dataN.replaceAll("janeiro","1");
                  dataN = dataN.replaceAll("fevereiro","2");
                  dataN = dataN.replaceAll("março","3");
                  dataN = dataN.replaceAll("abril","4");
                  dataN = dataN.replaceAll("maio","5");
                  dataN = dataN.replaceAll("junho","6");
                  dataN = dataN.replaceAll("julho","7");
                  dataN = dataN.replaceAll("agosto","8");
                  dataN = dataN.replaceAll("setembro","9");
                  dataN = dataN.replaceAll("outubro","10");
                  dataN = dataN.replaceAll("novembro","11");
                  dataN = dataN.replaceAll("dezembro","12");
                  dataN = dataN.replace("(","-").replace(")","-");
                  localNascimento(dataN);
                  String dataN1 = "";
                  String dataN2 = "";
                  String dataN3 = "";

                  //Dividir a String em 3 partes para encontrar
                  //dia , mes e ano da data de nascimento
                  String aux[] = dataN.split("-");
                  dataN1 = aux[0];
                  dataN2 = aux[1];
                  dataN3 = aux[2];
                  dataN3 = dataN3.replaceAll("[^0-9]","");

                  //converter a String ja repartida em int
                  int dia = Integer.parseInt(dataN1);
                  int mes = Integer.parseInt(dataN2);
                  int ano = Integer.parseInt(dataN3);

                  //Calculo para encontrar a idade atual do Presidente designado
                  int anoAtual = 2019;
                  int idade = anoAtual - ano;
                  //converter int para LocalDateTime
                  LocalDateTime date = LocalDateTime.of(ano,mes,dia,0,0);
                  setDataNascimento(date);
                  setIdade(idade);

      }catch(IllegalStateException ex){
        MyIO.println("Excecao");
      }

}//Fim metodo

/*Metodo localNascimento que recebe a String
/	Metodo que separa do resto da String o local de nascimento
/ Salva o local de nascimento na variavel nascimento
*/
public void localNascimento(String nascimento){
    nascimento = nascimento.replaceAll("[0-9]","");
    nascimento = nascimento.replaceAll("-"," ");
    nascimento = nascimento.replaceAll("anos","");
    nascimento = nascimento.replace("(","").replace(")","");
    nascimento = nascimento.replace("Rio Janeiro","Rio de Janeiro");
    nascimento = nascimento.trim();
    setLocalNascimento(nascimento);
}//Fim metodo

/*Metodo lerAntecessor que recebe o html requisitado pelo usuario
/	Metodo que procura antecessor e salva em uma variavel
/ Salva a String na variavel antecessor2
*/
public void lerAntecessor(String endereco){
  Arq.openRead(endereco);
  String antecessor2 = "";
    endereco = Arq.readLine();
  while(endereco.contains("Antecessor") == false) endereco = Arq.readLine();
    antecessor2 = Arq.readLine();
    antecessor2 = Arq.readLine();
    antecessor2 = antecessor2.replaceAll("<[^>]*>","");
    antecessor2 = antecessor2.trim();
    setAntecessor(antecessor2);
}//Fim metodo

/*Metodo lerSucessor que recebe o html requisitado pelo usuario
/	Metodo que procura sucessor e salva em uma variavel
/ Salva a String na variavel sucessor2
*/
public void lerSucessor(String endereco){
  Arq.openRead(endereco);
  String sucessor2 = "";
  if(!endereco.equals("/tmp/presidente/Jair_Bolsonaro.html")){
    endereco = Arq.readLine();
        while(endereco.contains("Sucessor")== false)endereco = Arq.readLine();
          sucessor2 = Arq.readLine();
          sucessor2 = Arq.readLine();
          sucessor2 = sucessor2.replaceAll("<[^>]*>","");
          sucessor2 = sucessor2.trim();
          setSucessor(sucessor2);
        //Contador para verificar se no metodo imprimir() o presidente tem sucessor
          contSucessor++;
  }
}//Fim metodo


/*Metodo lerMorte que recebe o html requisitado pelo usuario
/	Metodo que procura a data de morte e local de morte e salva em uma variavel
/ Salva a String na variavel localM
*/
public void lerMorte(String endereco ){
  Arq.openRead(endereco);
  String localM = "";

        while(Arq.hasNext()==true){
          endereco = Arq.readLine();
        if(endereco.contains("<td scope")){
          if(endereco.contains("Morte")){
            localM = Arq.readLine();
            localM = Arq.readLine();
            localM = localM.replaceAll("<[^>]*>","");
            localM= localM.replaceAll("#160","");
            localM= localM.replaceAll("&","");
            localM= localM.replaceAll(";","");
            localM = localM.replaceAll(" de ","-");
            localM = localM.replaceAll("janeiro","1");
            localM = localM.replaceAll("fevereiro","2");
            localM = localM.replaceAll("março","3");
            localM = localM.replaceAll("abril","4");
            localM = localM.replaceAll("maio","5");
            localM = localM.replaceAll("junho","6");
            localM = localM.replaceAll("julho","7");
            localM = localM.replaceAll("agosto","8");
            localM = localM.replaceAll("setembro","9");
            localM = localM.replaceAll("outubro","10");
            localM = localM.replaceAll("novembro","11");
            localM = localM.replaceAll("dezembro","12");
            localMorte(localM);
            //Substituir '()' por -
            localM = localM.replace("(","-").replace(")","-");
            String localM1 = "";
            String localM2 = "";
            String localM3 = "";
            //Dividir a String em 3 partes para encontrar
            //dia , mes e ano da data de nascimento
            String aux[] = localM.split("-");
            localM1 = aux[0];
            localM2 = aux[1];
            localM3 = aux[2];
            localM3 = localM3.replaceAll("[^0-9]","");
            //converter a String ja repartida em int
            int dia = Integer.parseInt(localM1);
            int mes = Integer.parseInt(localM2);
            int ano = Integer.parseInt(localM3);
            //converter int para LocalDateTime
            LocalDateTime date = LocalDateTime.of(ano,mes,dia,0,0);
            //Contador para verificar no metodo imprimir() se o presidente ja á falecido ou nao
            contMorte++;
                setDataMorte(date);
          }
        }
      }
      Arq.close();
}//Fim metodo

/*Metodo localMorte que recebe uma String
/	Metodo que separa do resto da String o local de morte
/ Salva o local de morte na variavel morte
*/
  public void localMorte(String morte){
      morte = morte.replaceAll("[0-9]","");
      morte = morte.replaceAll("-"," ");
      morte = morte.replaceAll("anos","");
      morte = morte.replace("(","").replace(")","");
      morte = morte.replace("Rio Janeiro","Rio de Janeiro");
      morte = morte.trim();
      setLocalMorte(morte);
  }//Fim metodo


//Metodo para imprimir os atributos achados e salvos
  public void imprimir(int i){
    MyIO.setCharset("ISO-8859-1");
    //Converter no formato DateTimeFormatter
    DateTimeFormatter date = DateTimeFormatter.ofPattern("d/M/yyyy");

    //Printar se o presidente estiver vivo e com sucessor
  if(contMorte == 0 && contSucessor >= 1 ){
    MyIO.println("["+i+ "] "+getId()+ " ## " +convertUTF8toISO(getNome())+ " ## " +getInicioMandato().format(date)+" (I)"+ " ## "+getFimMandato().format(date) +" (F)"+ " ## "
        +getDataNascimento().format(date)+" em " +convertUTF8toISO(getLocalNascimento()) + " (N)"+ " ## "+getIdade()+ " ## "+getPagina()+ " ## " +getPaginaTam()+ " ## " +
        convertUTF8toISO(getAntecessor())+ " ## " +convertUTF8toISO(getSucessor())+ " ## " +convertUTF8toISO(getVice()));
  }

  //Printar se o presidente estiver morto e com sucessor
  else if(contMorte >= 1 && contSucessor >= 1){
    MyIO.println("["+i+ "] "+getId()+ " ## " +convertUTF8toISO(getNome())+ " ## " +getInicioMandato().format(date)+" (I)"+ " ## "+getFimMandato().format(date) +" (F)"+ " ## "
        +getDataNascimento().format(date)+" em " +convertUTF8toISO(getLocalNascimento()) + " (N)"+ " ## "+getIdade()+ " ## "+ getDataMorte().format(date) +" em " + convertUTF8toISO(getLocalMorte()) + " (M)"+ " ## "+getPagina()+ " ## " +getPaginaTam()+ " ## " +
        convertUTF8toISO(getAntecessor())+ " ## " +convertUTF8toISO(getSucessor())+ " ## " +convertUTF8toISO(getVice()));
  }

  //Printar se o presidente estiver vivo e sem sucessor
  else if(contMorte == 0 && contSucessor == 0){
    MyIO.println("["+i+ "] "+getId()+ " ## " +getNome()+ " ## " +getInicioMandato().format(date)+" (I)"+ " ## "+getFimMandato().format(date) +" (F)"+ " ## "
        +getDataNascimento().format(date)+" em " +convertUTF8toISO(getLocalNascimento()) + " (N)"+ " ## "+getIdade()+ " ## "+getPagina()+ " ## " +getPaginaTam()+ " ## " +
        getAntecessor()+" ## " +" ## " +convertUTF8toISO(getVice()));
  }
  //Zerar os contadores para o proximo presidente chamado
  contMorte = 0;
  contSucessor = 0;
}//Fim metodo

//Metodo que converte uma String UTF-8 em um ISO e retorna a mesma ja convertida
public static String convertUTF8toISO(String endereco){
    String s = null;
    try{
      s = new String(endereco.getBytes("ISO-8859-1"),"UTF-8");
    }
    catch (java.io.UnsupportedEncodingException e){
      return null;
    }
    return s;
}//Fim Metodo


}//Fim classe


public class Executivo{
  public static void main(String[] args)throws Exception{
    MyIO.setCharset("UTF-8");
    //instanciando Arvore
    Alvinegra arvore = new Alvinegra();
    long inicio = System.nanoTime();
    String[] entrada = new String[1000];
    int nEntrada = 0;
//Laco para ler vetor de String ate a flag "FIM"
      do{

        entrada[nEntrada] = MyIO.readLine();
      }while(entrada[nEntrada++].contains("FIM") == false);
      nEntrada--;

      String entrada2[] = new String[1000];
      int nEntrada2 = 0;
      int comp = 0;
      String[] linha= new String[10000];

//Laco para ler vetor de String ate a flag "FIM"
      do{

        entrada2[nEntrada2] = MyIO.readLine();
      }while(entrada2[nEntrada2++].contains("FIM")== false);
      nEntrada2--;


//laco para acessar o arquivo e imprimir seus dados
      for(int i = 0;i<nEntrada;i++){
        Presidente p = new Presidente();
        p.ler(entrada[i]);
        arvore.inserir(p);
      }
      int j = 0;
      //Laco para inserir na Classe lista e pesquisar se a sigla inserida
      //existe no arquivo que criamos na classe Presidente
    for(int i = 0; i<nEntrada2; i++){
      Presidente p = new Presidente();
      MyIO.print(entrada2[i] + " raiz");
      String d = entrada2[i];
      arvore.pesquisar(d);
    }//Fim for

    MyIO.print("\n");

    //Criaçao do Log e inicializacao de suas variaveis
    long fim = System.nanoTime();
    long com = fim - inicio;
    //Criacao e escrita do arquivo log
    Arq.openWrite("591513_arvoreAlvinegra.txt","ISO-8859-1");
    //Printacao das variaveis contidas no arquivo
    Arq.println("591513 \t Tempo:" + com +"s \t Comparaçoes:" +arvore.comp());
    //Fechamento do arquivo
    Arq.close();

  }//Fim main

}//Fim classe Executivo

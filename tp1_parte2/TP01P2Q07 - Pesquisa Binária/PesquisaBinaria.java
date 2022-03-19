
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.net.*;
import java.io.*;
import java.util.Scanner;
/**
 * Lista estatica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class Lista {
   private Presidente[] array;
   private int n;


   /**
    * Construtor da classe.
    */
   public Lista () {
      this(6);
   }


   /**
    * Construtor da classe.
    * @param tamanho Tamanho da lista.
    */
   public Lista (int tamanho){
      array = new Presidente[tamanho];
      n = 0;
   }


   /**
    * Insere um elemento na primeira posicao da lista e move os demais
    * elementos para o fim da lista.
    * @param x int elemento a ser inserido.
    * @throws Exception Se a lista estiver cheia.
    */
   public void inserirInicio(Presidente x) throws Exception {

      //validar insercao
      if(n >= array.length){
         throw new Exception("Erro ao inserir!");
      }

      //levar elementos para o fim do array
      for(int i = n; i > 0; i--){
         array[i] = array[i-1];
      }

      array[0] = x.clone();
      n++;
   }


   /**
    * Insere um elemento na ultima posicao da lista.
    * @param x int elemento a ser inserido.
    * @throws Exception Se a lista estiver cheia.
    */
   public void inserirFim(Presidente x) throws Exception {

      //validar insercao
      if(n >= array.length){
         throw new Exception("Erro ao inserir!");
      }

      array[n] = x;
      n++;
   }


   /**
    * Insere um elemento em uma posicao especifica e move os demais
    * elementos para o fim da lista.
    * @param x int elemento a ser inserido.
    * @param pos Posicao de insercao.
    * @throws Exception Se a lista estiver cheia ou a posicao invalida.
    */
   public void inserir(Presidente x, int pos) throws Exception {

      //validar insercao
      if(n >= array.length || pos < 0 || pos > n){
         throw new Exception("Erro ao inserir!");
      }

      //levar elementos para o fim do array
      for(int i = n; i > pos; i--){
         array[i] = array[i-1];
      }

      array[pos] = x.clone();
      n++;
   }


   /**
    * Remove um elemento da primeira posicao da lista e movimenta
    * os demais elementos para o inicio da mesma.
    * @return resp int elemento a ser removido.
    * @throws Exception Se a lista estiver vazia.
    */
   public Presidente removerInicio() throws Exception {

      //validar remocao
      if (n == 0) {
         throw new Exception("Erro ao remover!");
      }

      Presidente resp = array[0];
      n--;

      for(int i = 0; i < n; i++){
         array[i] = array[i+1];
      }

      return resp;
   }


   /**
    * Remove um elemento da ultima posicao da lista.
    * @return resp int elemento a ser removido.
    * @throws Exception Se a lista estiver vazia.
    */
   public Presidente removerFim() throws Exception {

      //validar remocao
      if (n == 0) {
         throw new Exception("Erro ao remover!");
      }

      return array[--n];
   }


   /**
    * Remove um elemento de uma posicao especifica da lista e
    * movimenta os demais elementos para o inicio da mesma.
    * @param pos Posicao de remocao.
    * @return resp int elemento a ser removido.
    * @throws Exception Se a lista estiver vazia ou a posicao for invalida.
    */
   public Presidente remover(int pos) throws Exception {

      //validar remocao
      if (n == 0 || pos < 0 || pos >= n) {
         throw new Exception("Erro ao remover!");
      }

      Presidente resp = array[pos];
      n--;

      for(int i = pos; i < n; i++){
         array[i] = array[i+1];
      }

      return resp;
   }


   /**
    * Mostra os elementos da lista separados por espacos.
    */
   public void mostrar (){
    //  System.out.print("[ ");
      for(int a = 0; a < n; a++){
					array[a].imprimir(a);
         //System.out.print(array[i] + " ");
      }
    //  System.out.println("]");
   }


   /**
    * Procura um elemento e retorna se ele existe.
    * @param x int elemento a ser pesquisado.
    * @return <code>true</code> se o array existir,
    * <code>false</code> em caso contrario.
    */
public boolean pesquisar(String x) {
     boolean retorno = false;
      int meio;
      int esq=0;
      int dir=n-1;
      while(dir>=esq){
           meio=(esq+dir)/2;
           if(x.compareTo(array[meio].getNome())==0){
              retorno=true;
              esq=n;
           }else
                if(x.compareTo(array[meio].getNome())>0){
                   esq=meio-1;
               }else{
                   dir=meio-1;
               }
       }
       return retorno;
   }

 } 
/**
 * Classe Presidente
 * @author Ana Luiza Pacheco Leite
 * com ajuda de Ana Carolina Medeiros e Darlan Francisco
 */
class Presidente{
//declaracao de variaveis
	private int id;
	private String nome;
	private int idade;
	private LocalDateTime dataNascimento;
	private String localNascimento;
	private LocalDateTime inicioMandato;
	private LocalDateTime fimMandato;
	private LocalDateTime dataMorte;
	private String localMorte;
	private String antecessor;
	private String sucessor;
	private String vice;
	private String pagina;
	private long paginaTam;
	private int isDead;
	private int hasSuccessor;

//construtores
	Presidente(){
		this.setId(0);
		this.setNome("");
		this.setIdade(0);
		this.setDataNascimento(null);
		this.setLocalNascimento("");
		this.setInicioMandato(null);
		this.setFimMandato(null);
		this.setDataMorte(null);
		this.setLocalMorte("");
		this.setAntecessor("");
		this.setSucessor("");
		this.setVice("");
		this.setPagina("");
		this.setPaginaTam(0);
	}
	Presidente(int id,String nome,int idade,LocalDateTime dataNascimento,String localNascimento,LocalDateTime inicioMandato,LocalDateTime fimMandato,
	LocalDateTime dataMorte,String localMorte,String antecessor,String sucessor,String vice,String pagina,long paginaTam){
		this.setId(id);
		this.setNome(nome);
		this.setIdade(idade);
		this.setDataNascimento(dataNascimento);
		this.setLocalNascimento(localNascimento);
		this.setInicioMandato(inicioMandato);
		this.setFimMandato(fimMandato);
		this.setDataMorte(dataMorte);
		this.setLocalMorte(localMorte);
		this.setAntecessor(antecessor);
		this.setSucessor(sucessor);
		this.setVice(vice);
		this.setPagina(pagina);
		this.setPaginaTam(paginaTam);
	}

//setters
 	public void setId(int id){
      		this.id = id;
    	}
	public void setNome(String nome){
      		this.nome = nome;
    	}
	public void setIdade(int idade){
      		this.idade = idade;
    	}
	public void setDataNascimento(LocalDateTime dataNascimento){
      		this.dataNascimento = dataNascimento;
    	}
	public void setLocalNascimento(String localNascimento){
      		this.localNascimento = localNascimento;
    	}
	public void setInicioMandato(LocalDateTime inicioMandato){
      		this.inicioMandato = inicioMandato;
    	}
	public void setFimMandato(LocalDateTime fimMandato){
      		this.fimMandato = fimMandato;
    	}
	public void setDataMorte(LocalDateTime dataMorte){
      		this.dataMorte = dataMorte;
    	}
	public void setLocalMorte(String localMorte){
      		this.localMorte = localMorte;
    	}
	public void setAntecessor(String antecessor){
      		this.antecessor = antecessor;
    	}
	public void setSucessor(String sucessor){
      		this.sucessor = sucessor;
    	}
	public void setVice(String vice){
      		this.vice = vice;
    	}
	public void setPagina(String pagina){
      		this.pagina = pagina;
    	}
	public void setPaginaTam(long paginaTam){
      		this.paginaTam = paginaTam;
    	}

//getters
	public int getId(){
      		return id;
    	}
	public String getNome(){
      		return nome;
    	}
	public int getIdade(){
      		return idade;
    	}
	public LocalDateTime getDataNascimento(){
      		return dataNascimento;
    	}
	public String getLocalNascimento(){
      		return localNascimento;
    	}
	public LocalDateTime getInicioMandato(){
      		return inicioMandato;
    	}
	public LocalDateTime getFimMandato(){
      		return fimMandato;
    	}
	public LocalDateTime getDataMorte(){
      		return dataMorte;
    	}
	public String getLocalMorte(){
      		return localMorte;
    	}
	public String getAntecessor(){
      		return antecessor;
    	}
	public String getSucessor(){
      		return sucessor;
    	}
	public String getVice(){
      		return vice;
    	}
	public String getPagina(){
      		return pagina;
    	}
	public long getPaginaTam(){
      		return paginaTam;
    	}

//classe clone
 	public Presidente clone(){
      		Presidente p = new Presidente();
      		p.setId(getId());
      		p.setNome(getNome());
      		p.setIdade(getIdade());
      		p.setDataNascimento(getDataNascimento());
      		p.setLocalNascimento(getLocalNascimento());
      		p.setInicioMandato(getInicioMandato());
     			p.setFimMandato(getFimMandato());
     			p.setDataMorte(getDataMorte());
     			p.setLocalMorte(getLocalMorte());
					p.setAntecessor(getAntecessor());
      		p.setSucessor(getSucessor());
      		p.setVice(getVice());
      		p.setPagina(getPagina());
      		p.setPaginaTam(getPaginaTam());
					p.isDead=this.isDead;
					p.hasSuccessor=this.hasSuccessor;
      		return p;
    	}//fim clone

			//imprimir saida
public void imprimir(int a){
        MyIO.setCharset("iso-8859-1");
		DateTimeFormatter data = DateTimeFormatter.ofPattern("d/M/yyyy");  //formatar LocalDateTime
		if(isDead==0&&hasSuccessor==1){ //quando presidente nao morreu
  			MyIO.println("["+a+"]"+getId()+ " ## " +convertUTF8toISO(getNome())+ " ## " +getInicioMandato().format(data)+" (I)"+ " ## "+getFimMandato().format(data) +" (F)"+ " ## "+getDataNascimento().format(data)+" em " +convertUTF8toISO(getLocalNascimento()) + " (N)"+ " ## "+getIdade()+ " ## "+getPagina()+ " ## " +getPaginaTam()+ " ## " +
        convertUTF8toISO(getAntecessor())+ " ## " +convertUTF8toISO(getSucessor())+ " ## " +convertUTF8toISO(getVice()));
 }else{
 		if(isDead==1&&hasSuccessor==1){ //quando presidente morreu
			MyIO.println("["+a+"]"+getId()+ " ## " +convertUTF8toISO(getNome())+ " ## " +getInicioMandato().format(data)+" (I)"+ " ## "+getFimMandato().format(data) +" (F)"+ " ## "
        +getDataNascimento().format(data)+" em " +convertUTF8toISO(getLocalNascimento()) + " (N)"+ " ## "+getIdade()+ " ## "+ getDataMorte().format(data) +" em " + convertUTF8toISO(getLocalMorte()) + " (M)"+ " ## "+getPagina()+ " ## " +getPaginaTam()+ " ## " +
        convertUTF8toISO(getAntecessor())+ " ## " +convertUTF8toISO(getSucessor())+ " ## " +convertUTF8toISO(getVice()));
		}else{
			if(isDead==0&&hasSuccessor==0){ //presidente atual
				MyIO.println("["+a+"]"+getId()+ " ## " +getNome()+ " ## " +getInicioMandato().format(data)+" (I)"+ " ## "+getFimMandato().format(data) +" (F)"+ " ## "
        +getDataNascimento().format(data)+" em " +convertUTF8toISO(getLocalNascimento()) + " (N)"+ " ## "+getIdade()+ " ## "+getPagina()+ " ## " +getPaginaTam()+ " ## " +
        getAntecessor()+" ## " +" ## " +convertUTF8toISO(getVice()));
			}
		}
	}
	//zerando isDead e hasSuccessor
	isDead=0;
	hasSuccessor=0;
 }//fim imprimir


public void ler(String endereco){
		setPagina(endereco);
		Arq.openRead(endereco);
		String idAux="";
		String achaId="title=\"Lista de presidentes do Brasil\"";

		String nomeAux ="";
		String achaNome ="Nome completo";

		String viceAux ="";
		String achaVice ="Vice-presidente";

		String dataNascimentoAux ="";
		String achaNascimento ="Nascimento";

		String idadeAux ="";


		String periodoAux = "";
		String periodoF = "";
		String achaPeriodo = "Período";
try{
		//Id
				while(endereco.contains(achaId)==false) endereco=Arq.readLine();
						idAux = endereco.replaceAll("<[^>]*>","");
						idAux = idAux.replaceAll("&#32","");
						idAux = idAux.replaceAll("[^0-9]","");
						setId(Integer.parseInt(idAux));

						endereco =Arq.readLine();
						//Período
							while(endereco.contains(achaPeriodo)==false) endereco=Arq.readLine();
									periodoAux=Arq.readLine();
									periodoAux=Arq.readLine();
									periodoAux=periodoAux.replaceAll("<[^>]*>","");
									periodoAux=periodoAux.trim();
									periodoAux = periodoAux.replaceAll("&#32","");
									periodoAux = periodoAux.replaceAll("&#160","");
									periodoAux = periodoAux.replaceAll("té","");
									periodoAux = periodoAux.replaceAll(";","");
									periodoAux = periodoAux.replaceAll("º","");
									periodoAux = periodoAux.replaceAll("","");
									periodoAux = periodoAux.replaceAll(" de ","-");
									periodoAux = periodoAux.replaceAll("janeiro","1");
									periodoAux = periodoAux.replaceAll("fevereiro","2");
									periodoAux = periodoAux.replaceAll("março","3");
									periodoAux = periodoAux.replaceAll("abril","4");
									periodoAux = periodoAux.replaceAll("maio","5");
									periodoAux = periodoAux.replaceAll("junho","6");
									periodoAux = periodoAux.replaceAll("julho","7");
									periodoAux = periodoAux.replaceAll("agosto","8");
									periodoAux = periodoAux.replaceAll("setembro","9");
									periodoAux = periodoAux.replaceAll("outubro","10");
									periodoAux = periodoAux.replaceAll("novembro","11");
									periodoAux = periodoAux.replaceAll("dezembro","12");
									String divP[] = periodoAux.split("a");
									periodoAux = divP[0];
									periodoF = divP[1];
									String []auxI1 = periodoAux.split("-");
									String day1 = auxI1[0];
									String month1 = auxI1[1];
									String year1 = auxI1[2];
									year1 = year1.trim();

									String []auxI2 = periodoF.split("-");
									String day2 = auxI2[0];
									day2 = day2.trim();
									String month2 = auxI2[1];
									String year2 = auxI2[2];
									year2 = year2.replaceAll("[^0-9]","");
									int dayI = Integer.parseInt(day1);
									int monthI = Integer.parseInt(month1);
									int yearI = Integer.parseInt(year1);
									int dayF = Integer.parseInt(day2);
									int monthF = Integer.parseInt(month2);
									int yearF = Integer.parseInt(year2);
									LocalDateTime begin = LocalDateTime.of(yearI,monthI,dayI,0,0);
									LocalDateTime end = LocalDateTime.of(yearF,monthF,dayF,0,0);
									setInicioMandato(begin);
									setFimMandato(end);

									endereco =Arq.readLine();
						//Vice
							while(endereco.contains(achaVice)==false) endereco=Arq.readLine();
									viceAux=Arq.readLine();
									viceAux=Arq.readLine();
									viceAux=viceAux.replaceAll("<[^>]*>","");
									viceAux=viceAux.trim();
									setVice(viceAux);

									endereco=Arq.readLine();
					//Nome
							while(endereco.contains(achaNome)==false) endereco=Arq.readLine();
									nomeAux=Arq.readLine();
									nomeAux=Arq.readLine();
									nomeAux=nomeAux.replaceAll("<[^>]*>","");
									nomeAux=nomeAux.trim();
									setNome(nomeAux);

									endereco=Arq.readLine();

					//data Nascimento e idade
							while(endereco.contains("Nascimento")== false) endereco = Arq.readLine();
		                  dataNascimentoAux = Arq.readLine();
		                  dataNascimentoAux = Arq.readLine();
		                  dataNascimentoAux = dataNascimentoAux.replaceAll("<[^>]*>","");
		                  dataNascimentoAux = dataNascimentoAux.replaceAll("&#32","");
		                  dataNascimentoAux = dataNascimentoAux.replaceAll("&#160","");
		                  dataNascimentoAux = dataNascimentoAux.replaceAll(";","");
		                  dataNascimentoAux = dataNascimentoAux.replaceAll("º","");
		                  dataNascimentoAux = dataNascimentoAux.replaceAll("","");
		                  dataNascimentoAux = dataNascimentoAux.replaceAll(" de ","-");
		                  dataNascimentoAux = dataNascimentoAux.replaceAll("janeiro","1");
		                  dataNascimentoAux = dataNascimentoAux.replaceAll("fevereiro","2");
		                  dataNascimentoAux = dataNascimentoAux.replaceAll("março","3");
		                  dataNascimentoAux = dataNascimentoAux.replaceAll("abril","4");
		                  dataNascimentoAux = dataNascimentoAux.replaceAll("maio","5");
		                  dataNascimentoAux = dataNascimentoAux.replaceAll("junho","6");
		                  dataNascimentoAux = dataNascimentoAux.replaceAll("julho","7");
		                  dataNascimentoAux = dataNascimentoAux.replaceAll("agosto","8");
		                  dataNascimentoAux = dataNascimentoAux.replaceAll("setembro","9");
		                  dataNascimentoAux = dataNascimentoAux.replaceAll("outubro","10");
		                  dataNascimentoAux = dataNascimentoAux.replaceAll("novembro","11");
		                  dataNascimentoAux = dataNascimentoAux.replaceAll("dezembro","12");
		                  dataNascimentoAux = dataNascimentoAux.replace("(","-").replace(")","-");
		                  localNascimento(dataNascimentoAux);
		                  String dataAux[] = dataNascimentoAux.split("-");
										  String diaAux = dataAux[0];;
										  String mesAux = dataAux[1];
										  String anoAux = dataAux[2];
		                  anoAux = anoAux.replaceAll("[^0-9]","");
		                  int dia = Integer.parseInt(diaAux);
		                  int mes = Integer.parseInt(mesAux);
		                  int ano = Integer.parseInt(anoAux);
		                  int anoAtual = 2019;
		                  int idade = anoAtual - ano;
		                  LocalDateTime date = LocalDateTime.of(ano,mes,dia,0,0);
		                  setDataNascimento(date);
		                  setIdade(idade);
					}catch (IllegalStateException exc){
							MyIO.println("Erro");
					}//fim try -catch
}//fim ler


/**
 * le informacoes dos antecessores
 *@param endereco a ser lido
 */
public void lerAntecessor(String endereco){
  Arq.openRead(endereco);
  String antecessorAux = "";
    endereco = Arq.readLine();
  while(endereco.contains("Antecessor") == false) endereco = Arq.readLine();
    antecessorAux = Arq.readLine();
    antecessorAux = Arq.readLine();
    antecessorAux = antecessorAux.replaceAll("<[^>]*>","");
    antecessorAux = antecessorAux.trim();
    setAntecessor(antecessorAux);

	}//fim lerAntecessor

/**
* le informacoes dos sucessores
*@param endereco a ser lido
*/
public void lerSucessor(String endereco){
  Arq.openRead(endereco);
  String sucessorAux = "";
	int contSucessor=0;
  if(!endereco.equals("/tmp/presidente/Jair_Bolsonaro.html")){
    endereco = Arq.readLine();
        while(endereco.contains("Sucessor")== false)endereco = Arq.readLine();
          sucessorAux = Arq.readLine();
          sucessorAux = Arq.readLine();
          sucessorAux = sucessorAux.replaceAll("<[^>]*>","");
          sucessorAux = sucessorAux.trim();
          setSucessor(sucessorAux);
         hasSuccessor++;
  }
}//fim lerSucessor

/**
 * le informacoes da morte
 *@param endereco a ser lido
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
                    localM = localM.replace("(","-").replace(")","-");
                    String localM1 = "";
                    String localM2 = "";
                    String localM3 = "";
                    String aux[] = localM.split("-");
                    localM1 = aux[0];
                    localM2 = aux[1];
                    localM3 = aux[2];
                    localM3 = localM3.replaceAll("[^0-9]","");
                    int dia = Integer.parseInt(localM1);
                    int mes = Integer.parseInt(localM2);
                    int ano = Integer.parseInt(localM3);
                    LocalDateTime date = LocalDateTime.of(ano,mes,dia,0,0);
                    isDead++;
                    setDataMorte(date);
                  }
                }
              }
              Arq.close();
}//fim lerMorte



/**
 * formata o local de nascimento
 *@param string com o local
 */
  public void localNascimento(String nascimentoData){
    nascimentoData = nascimentoData.replaceAll("[0-9]","");
    nascimentoData = nascimentoData.replaceAll("/"," ");
		nascimentoData = nascimentoData.replaceAll("-"," ");
    nascimentoData = nascimentoData.replaceAll("anos","");
    nascimentoData = nascimentoData.replace("(","").replace(")","");
    nascimentoData = nascimentoData.replace("Rio Janeiro","Rio de Janeiro"); //conserta o problema do "de" sumir de rio de janeiro
    nascimentoData = nascimentoData.trim();
    setLocalNascimento(nascimentoData);
  }//fim localNascimento

/**
 * formata o local de morte
 *@param string com o local
 */
	public void localMorte(String morte){
    morte = morte.replaceAll("[0-9]","");
    morte = morte.replaceAll("-"," ");
    morte = morte.replaceAll("anos","");
    morte = morte.replace("(","").replace(")","");
    morte = morte.replace("Rio Janeiro","Rio de Janeiro");
    morte = morte.trim();
    setLocalMorte(morte);
  }//fim localMorte

/**
 * conta o tamanho da pagina
 *@param string com o endereco
 */
	public void contaTam(String endereco){
	 	long cont = 0;
		File arquivo=new File(endereco);
		cont+=arquivo.length();
		setPaginaTam(cont);
	}//fim contaTam

/**
 * chama todos os metodos de leitura
 *@param endereco a ser lido
*/
	public void lerGeral(String endereco){
            MyIO.setCharset("UTF-8");
			ler(endereco);
			contaTam(endereco);
			lerAntecessor(endereco);
			lerSucessor(endereco);
			lerMorte(endereco);

	}//fim lerGeral


/*
*Feito por Ana Carolina Medeiros
*/
public static String convertUTF8toISO(String str) {
  String ret = null;
  try {
    ret = new String(str.getBytes("ISO-8859-1"), "UTF-8");
  }
  catch (java.io.UnsupportedEncodingException e) {
    return null;
  }
  return ret;
}
}//fim Presidente

public class PesquisaBinaria{
		public static void main(String args[]) throws Exception{
					MyIO.setCharset("UTF-8");
					String linha[]=new String[1000];
					int numEntrada=0;
					Lista lista=new Lista(1000);
					String linha2[] = new String[1000];
					String []linha3;
					int numEntrada2=0;

//ler entradas
					do{
						linha[numEntrada]=MyIO.readLine();
            MyIO.println("Oi");
					}while(linha[numEntrada++].contains("FIM")==false);
						numEntrada--;

					do{
						linha2[numEntrada2]=MyIO.readLine();
            MyIO.println("Oi 2");
					}while(linha2[numEntrada2++].contains("FIM")==false);
                        numEntrada2--;
//inserir elementos na lista
					for(int i=0;i<numEntrada;i++){
						Presidente r = new Presidente();
						r.lerGeral(linha[i]);
						lista.inserirFim(r);
					}
        for(int k = 0; k<numEntrada2; k++){
            MyIO.setCharset("ISO-8859-1");
            if(lista.pesquisar(linha2[k])){
                MyIO.println(convertUTF8toISO("SIM"));
            }else{
                MyIO.println(convertUTF8toISO("NÃO"));
            }
        }

}
	   //fim main
/*
*Feito por Ana Carolina Medeiros
*/
public static String convertUTF8toISO(String str) {
  String ret = null;
  try {
    ret = new String(str.getBytes("ISO-8859-1"), "UTF-8");
  }
  catch (java.io.UnsupportedEncodingException e) {
    return null;
  }
  return ret;
}


	}//fim PrincipalO

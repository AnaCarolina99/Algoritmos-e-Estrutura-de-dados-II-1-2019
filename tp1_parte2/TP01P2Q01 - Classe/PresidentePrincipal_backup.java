/**
	*@author: Darlan Francisco
	*Date: 21/02/2019
*/

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.io.*;

class Presidente{

	//variavel privada do tipo Int
    private int id;
    private int idade;

    //variavel privada do tipo String
    private String nome;
    private String localNascimento;
    private String localMorte;
  	private String antecessor;
  	private String sucessor;
  	private String vice;
  	private String pagina;

  	//variavel privada do tipo LocalDateTime
  	private LocalDateTime dataNascimento;
  	private LocalDateTime inicioMandato;
  	private LocalDateTime fimMandato;
  	private LocalDateTime dataMorte;

  	//variavel privada do tipo long
  	private long paginaTam;

  	//variavel para conta morte;
  	private int contMorte = 0;

  	//construtor vazio
  	public Presidente() {
   		this.id = 0;
   		this.nome = "";
    	this.idade = 0;
   		this.dataNascimento = LocalDateTime.of(1,1,1,1,1);
   		this.localNascimento = "";
   		this.inicioMandato = LocalDateTime.of(1,1,1,1,1);
   		this.fimMandato = LocalDateTime.of(1,1,1,1,1);
   		this.dataMorte = LocalDateTime.of(1,1,1,1,1);
   		this.localMorte = "";
   		this.antecessor = "";
   		this.sucessor = "";
   		this.vice = "";
   		this.pagina = "";
   		this.paginaTam = 0;
  	}

  	//construtor que recebe as variaveis usado no programa
  	public Presidente(int id, String nome, int idade, LocalDateTime dataNascimento, String localNascimento,
   		LocalDateTime inicioMandato, LocalDateTime fimMandato, LocalDateTime dataMorte, String localMorte,
   		String antecessor, String sucessor, String vice, String pagina, long paginaTam) {

   		this.id = id;
   		this.nome = nome;
   		this.idade = idade;
   		this.dataNascimento = dataNascimento;
   		this.localNascimento = localNascimento;
   		this.inicioMandato = inicioMandato;
   		this.fimMandato = fimMandato;
   		this.dataMorte = dataMorte;
   		this.localMorte = localMorte;
   		this.antecessor = antecessor;
   		this.sucessor = sucessor;
   		this.vice = vice;
   		this.pagina = pagina;
   		this.paginaTam = paginaTam;
  	}

  	/*
    	metodos set() para passar o valor
    	metodos get() para retorna o valor
  	*/

  	public int getId() {
		return this.id;
	}

  	public void setId(int id) {
   		this.id = id;
  	}

  	public String getNome() {
   		return this.nome;
  	}

  	public void setNome(String nome) {
   		this.nome = nome;
  	}

  	public int getIdade() {
   		return this.idade;
  	}

  	public void setIdade(int idade) {
   		this.idade = idade;
  	}

  	public LocalDateTime getdataNascimento() {
   		return this.dataNascimento;
  	}

  	public void setdataNascimento(LocalDateTime dataNascimento) {
   		this.dataNascimento = dataNascimento;
  	}

  	public String getLocalNascimento() {
   		return this.localNascimento;
  	}

  	public void setLocalNascimento(String localNascimento) {
   		this.localNascimento = localNascimento;
  	}

  	public LocalDateTime getInicioMandato() {
   		return this.inicioMandato;
  	}

   public void setInicioMandato(LocalDateTime inicioMandato) {
   		this.inicioMandato = inicioMandato;
  	}

  	public LocalDateTime getFimMandato() {
   		return this.fimMandato;
  	}

  	public void setFimMandato(LocalDateTime fimMandato) {
   		this.fimMandato = fimMandato;
  	}

  	public LocalDateTime getDataMorte() {
   		return this.dataMorte;
  	}

  	public void setDataMorte(LocalDateTime dataMorte) {
   		this.dataMorte = dataMorte;
  	}

    public String getLocalMorte() {
   		return this.localMorte;
  	}

  	public void setLocalMorte(String localMorte) {
   		this.localMorte = localMorte;
  	}

  	public String getAntecessor() {
   		return this.antecessor;
  	}

  	public void setAntecessor(String antecessor) {
   		this.antecessor = antecessor;
  	}

  	public String getSucessor() {
   		return this.sucessor;
  	}

  	public void setSucessor(String sucessor) {
   		this.sucessor = sucessor;
  	}

  	public String getVice() {
   		return this.vice;
  	}

  	public void setVice(String vice) {
   		this.vice = vice;
  	}

  	public String getPagina() {
   		return this.pagina;
  	}

  	public void setPagina(String pagina) {
   		this.pagina = pagina;
  	}

  	public long getPaginaTam() {
   		return this.paginaTam;
  	}

  	public void setPaginaTam(long paginaTam) {
   		this.paginaTam = paginaTam;
  	}

  	//metodo clone da class Presidente
  	public Presidente clone() {
   		Presidente p = new Presidente();
   		p.id = this.id;
   		p.nome = this.nome;
   		p.idade = this.idade;
   		p.dataNascimento = this.dataNascimento;
   		p.localNascimento = this.localNascimento;
   		p.inicioMandato = this.inicioMandato;
   		p.fimMandato = this.fimMandato;
   		p.dataMorte = this.dataMorte;
   		p.localMorte = this.localMorte;
   		p.antecessor = this.antecessor;
   		p.sucessor = this.sucessor;
   		p.vice = this.vice;
   		p.pagina = this.pagina;
   		p.paginaTam = this.paginaTam;
   		return p;
  	}

  	//metodo imprimir da class Presidente
  	public void imprimir() {

		//usado para converter a variavel
  		DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
  		if(contMorte == 0){
   			MyIO.println(this.id + " ## " + this.nome + " ## " + this.inicioMandato.format(date) + " (I)" + " ## " + this.fimMandato.format(date) + " (F)" + " ## " +
    		this.dataNascimento.format(date)  + " em" + this.localNascimento + " (N)" + " ## " + this.idade + " ## " + this.pagina + " ## " + this.paginaTam + " ## " +
    		this.antecessor + " ## " + this.sucessor + " ## " + this.vice);
   		}

   		else if(contMorte >= 1){
    		MyIO.println(this.id + " ## " + this.nome + " ## " + this.inicioMandato.format(date) + " (I)" + " ## " + this.fimMandato.format(date) + " (F)" + " ## " +
    		this.dataNascimento.format(date)  + " em" + this.localNascimento + " (N)" + " ## " + this.idade + " ## " + this.dataMorte.format(date) + "em"+  this.localMorte  + " (M)" + " ## " + this.paginaTam + " ## " +
    		this.antecessor + " ## " + this.sucessor + " ## " + this.vice);
  		}
  	}

  	//metodo que faz a conversao do mes indicado no arquivo para seu respectivo numero
  	public String conversaoDate(String aux){
  		aux = aux.replaceAll("janeiro", "1");
	    aux = aux.replaceAll("fevereiro", "2");
	    aux = aux.replaceAll("março", "3");
	    aux = aux.replaceAll("abril", "4");
	    aux = aux.replaceAll("maio", "5");
	    aux = aux.replaceAll("junho", "6");
	    aux = aux.replaceAll("julho", "7");
	    aux = aux.replaceAll("agosto", "8");
	    aux = aux.replaceAll("setembro", "9");
	    aux = aux.replaceAll("outubro", "10");
	    aux = aux.replaceAll("novembro", "11");
	    aux = aux.replaceAll("dezembro", "12");
	    aux = aux.replaceAll("de", "/");
	    aux = aux.replaceAll(" ", "");
	    return aux;
  	}

  	//metodo para ler o arquivo presidente.zip onde possui varios outros arquivos de presidentes em html
    public void ler(String s) {

        setPagina(s); //vai setar a pagina de acordo com a entrada do pub.in

        Arq.openRead(s);

        String id2 = "";
        String nome2 = "";
        String idade2 = "";
        String dataNascimento2= "";
        String localNascimento2 = "";
        String inicioMandato2 = "";
        String fimMandato2 = "";
        String dataMorte2 = "";
        String localMorte2 = "";
        String antecessor2 = "";
        String sucessor2 = "";
        String vice2 = "";
        String pagina2 = "";
        String paginaTam2 = "";

        /*
            Neste metodo ler usei o replaceAll() para coloca vazio em tudo que esta entre < e >(o que esta fora eh o que vc quer)
            usei o trim() coloca vazio em tudo que esta entre < e >(o que esta fora eh o que vc quer)
        */

        try{

        	boolean resp = false;

        	//Titulos usados para acha o caminho no html
            String titulo = "title=\"Lista de presidentes do Brasil\"";
            String titulo2 = "Nome completo";
            String titulo3 = "Antecessor";
            String titulo4 = "Sucessor";
            String titulo5 = "Vice-presidente";
            String titulo6 = "Período";
            String titulo7 = "Nascimento";
            String titulo8 = "Morte";


            //ID
            s = Arq.readLine();
            while(s.contains(titulo) == false) s = Arq.readLine();
            id2 = s.replaceAll("<[^>]*>", "");
            id2 = id2.replaceAll("&#32", "");
            id2 = id2.replaceAll("[^0-9]", "");
	        setId(Integer.parseInt(id2));

	        if(s.contains("Morte")){

	        	s = Arq.readLine();
	        	while(s.contains(titulo8) == false) s = Arq.readLine();
	            localMorte2 = Arq.readLine();
		        localMorte2 = Arq.readLine();
	            localMorte2 = localMorte2.replaceAll("<[^>]*>", "");
	            localMorte2 = localMorte2.replaceAll("&#32", "");
	            localMorte2 = localMorte2.replaceAll("&#160", "");
	            localMorte2 = localMorte2.replaceAll(";", "");
	            localMorte2 = localMorte2.replaceAll("º", "");
	            localMorte2 = localMorte2.replace("(","-").replace(")","-");
            	String []auxDivi = localMorte2.split("-");
            	localMorte2 = auxDivi[0];
            	String auxDivi1 = auxDivi[1];
            	String auxDivi2 = auxDivi[2];
            	localMorte2 = localMorte2.replaceAll("de", "/");
            	localMorte2 = localMorte2.replaceAll(" ", "");
            	localMorte2 = conversaoDate(localMorte2);
            	String []divM = localMorte2.split("/");
            	int diaM = Integer.parseInt(divM[0]);
            	int mesM = Integer.parseInt(divM[1]);
            	int anoM = Integer.parseInt(divM[2]);
            	auxDivi1 = auxDivi1.replaceAll("[^0-9]", "");
            	LocalDateTime morteM = LocalDateTime.of(anoM, mesM, diaM, 0, 0);
           	 	contMorte++;
            	setDataMorte(morteM);
            	setIdade(Integer.parseInt(auxDivi1));
            	setLocalMorte(auxDivi2);

	        	while(s.contains(titulo7) == false) s = Arq.readLine();
            	dataNascimento2 = Arq.readLine();
            	dataNascimento2 = Arq.readLine();
           		dataNascimento2 = dataNascimento2.replaceAll("<[^>]*>", "");
           		dataNascimento2 = dataNascimento2.replaceAll("&#32", "");
           		dataNascimento2 = dataNascimento2.replaceAll("&#160", "");
           		dataNascimento2 = dataNascimento2.replaceAll(";", "");
           		dataNascimento2 = dataNascimento2.replaceAll("º", "");
           		MyIO.println(dataNascimento2);
           		dataNascimento2 = dataNascimento2.replace("(","-").replace(")","-");
           		String []auxDiv3 = dataNascimento2.split("-");
           		dataNascimento2 = auxDiv3[0];
           		String anos2 = auxDiv3[1];
           		String local2 = auxDiv3[2];
           		dataNascimento2 = conversaoDate(dataNascimento2);
           		//MyIO.println(dataNascimento2);
           		anos2 = anos2.replaceAll("[^0-9]", "");
           		//divisao da data para a conversao
           		String []auxDiv4 = dataNascimento2.split("/");
           		String diaIn3 = auxDiv4[0];
           		String mesIn3 = auxDiv4[1];
 				String anoIn3 = auxDiv4[2];
 				//conversao da variaveis para int
 				int diaInD2 = Integer.parseInt(diaIn3);
 				int mesInD2 = Integer.parseInt(mesIn3);
 				int anoInD2 = Integer.parseInt(anoIn3);
 				//salva as datas em LocalDateTime
 				LocalDateTime inD2 = LocalDateTime.of(anoInD2, mesInD2, diaInD2, 0, 0);
 				setdataNascimento(inD2);
           		setLocalNascimento(local2);
        	}else{

            	//Data de nascimento
	        	s = Arq.readLine();
            	while(s.contains(titulo7) == false) s =  Arq.readLine();
            	dataNascimento2 = Arq.readLine();
            	dataNascimento2 = Arq.readLine();
           		dataNascimento2 = dataNascimento2.replaceAll("<[^>]*>", "");
           		dataNascimento2 = dataNascimento2.replaceAll("&#32", "");
           		dataNascimento2 = dataNascimento2.replaceAll("&#160", "");
           		dataNascimento2 = dataNascimento2.replaceAll(";", "");
           		dataNascimento2 = dataNascimento2.replaceAll("º", "");
           		dataNascimento2 = dataNascimento2.replace("(","-").replace(")","-");
           		String []auxDiv = dataNascimento2.split("-");
           		dataNascimento2 = auxDiv[0];
           		String anos = auxDiv[1];
           		String local = auxDiv[2];
           		dataNascimento2 = conversaoDate(dataNascimento2);
           		dataNascimento2 = dataNascimento2.trim();
           		anos = anos.replaceAll("[^0-9]", "");
           		//divisao da data para a conversao
           		String []auxDiv2 = dataNascimento2.split("/");
           		String diaIn2 = auxDiv2[0];
           		String mesIn2 = auxDiv2[1];
 				String anoIn2 = auxDiv2[2];
 				//conversao da variaveis para int
 				int diaInD = Integer.parseInt(diaIn2);
 				int mesInD = Integer.parseInt(mesIn2);
 				int anoInD = Integer.parseInt(anoIn2);
 				int anoAtual = 2019;
 				int valorAno = anoAtual - anoInD;
 				//salva as datas em LocalDateTime
 				LocalDateTime inD = LocalDateTime.of(anoInD, mesInD, diaInD, 0, 0);
 				setdataNascimento(inD);
           		setIdade(valorAno);
           		setLocalNascimento(local);
            }

	        //Inicio e fim do mandato
	        s = Arq.readLine();
	        while(s.contains(titulo6) == false) s = Arq.readLine();
	        inicioMandato2 = Arq.readLine();
	        inicioMandato2 = Arq.readLine();
	        inicioMandato2 = inicioMandato2.replaceAll("<[^>]*>", "");
	        inicioMandato2 = inicioMandato2.replaceAll("&#32", "");
	        inicioMandato2 = inicioMandato2.replaceAll(";", "");
	        inicioMandato2 = inicioMandato2.replaceAll("º", "");
	        inicioMandato2 = conversaoDate(inicioMandato2);
	        inicioMandato2 = inicioMandato2.trim();
	        String []divisao = inicioMandato2.split("a");
	        inicioMandato2 = divisao[0];
	        fimMandato2 = divisao[1];
	        //divide o dia mes e ano para uma respectiva varial
	        //conversao do inicio do mandato
	        String []divisao2 = inicioMandato2.split("/");
	        String dia1 = divisao2[0];
	        String mes1 = divisao2[1];
	        String ano1 = divisao2[2];
	        //conversao do fim do mandato
	        String []divisao3 = fimMandato2.split("/");
	        String dia2 = divisao3[0];
	        String mes2 = divisao3[1];
	        String ano2 = divisao3[2];
	        ano2 = ano2.replaceAll("[^0-9]", "");
	        //conversao de variaveis para inteiro do inicio do mandato
	        int diaIn = Integer.parseInt(dia1);
	        int mesIn = Integer.parseInt(mes1);
	        int anoIn = Integer.parseInt(ano1);
	        //conversao de variavies ṕara inteiro do fim do mandato
	        int diaFm = Integer.parseInt(dia2);
	        int mesFm = Integer.parseInt(mes2);
	        int anoFm = Integer.parseInt(ano2);
	        LocalDateTime inicio = LocalDateTime.of(anoIn, mesIn, diaIn, 0, 0);
	        LocalDateTime fim = LocalDateTime.of(anoFm, mesFm, diaFm, 0, 0);
	        setInicioMandato(inicio);
	        setFimMandato(fim);

	        //Vice-Presidente
            s = Arq.readLine();
            while(s.contains(titulo5) == false ) s = Arq.readLine();
            vice2 = Arq.readLine();
            vice2 = Arq.readLine();
            vice2 = vice2.replaceAll("<[^>]*>", "");
            vice2 = vice2.trim();
            setVice(vice2);

            //Antecessor
            s = Arq.readLine();
            while(s.contains(titulo3) == false) s = Arq.readLine();
            antecessor2 = Arq.readLine();
            antecessor2 = Arq.readLine();
            antecessor2 = antecessor2.replaceAll("<[^>]*>", "");
            antecessor2 = antecessor2.trim();
            setAntecessor(antecessor2);

            //Sucessor
            s = Arq.readLine();
            while(s.contains(titulo4) == false) s = Arq.readLine();
            sucessor2 = Arq.readLine();
            sucessor2 = Arq.readLine();
            sucessor2 = sucessor2.replaceAll("<[^>]*>","");
            sucessor2 = sucessor2.trim();
            setSucessor(sucessor2);

            //Nome
            s = Arq.readLine();
            while(s.contains(titulo2) == false) s = Arq.readLine();
            nome2 = Arq.readLine();
            nome2 = Arq.readLine();
            nome2 = nome2.replaceAll("<[^>]*>", "");
            nome2 = nome2.trim();
            setNome(nome2);
        }
        catch(IllegalStateException ex){
            System.err.println("Fim do arquivo");
        }
    }
}

class PresidentePrincipal_backup {

	public static void main(String[] args) {

		MyIO.setCharset("UTF-8");

   		Presidente p = new Presidente();
   		String[] entrada = new String[1000];
   		String linha;
   		int nEntrada = 0;

   		do {
    		entrada[nEntrada] = MyIO.readLine();
   		} while (entrada[nEntrada++].equals("FIM") == false);

   		nEntrada--;

   		for (int i = 0; i < nEntrada; i++) {
    		p.ler(entrada[i]);
    		//p.imprimir();
   		}
  	}
}

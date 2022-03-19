import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.net.*;
import java.io.*;
import java.util.Scanner;


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
	public LocalDateTime getdataNascimento(){
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
      		p.setDataNascimento(getdataNascimento());
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
      		return p;
    	}//fim clone

			//imprimir saida
public void imprimir(){
		DateTimeFormatter date = DateTimeFormatter.ofPattern("d/M/yyyy");
  MyIO.println(getId()+ " ## " + getNome() + " ## " + getInicioMandato().format(date) + " (I)" + " ## "+getFimMandato().format(date)+ " (F)" + " ## "
	+getdataNascimento().format(date)  + " em " + getLocalNascimento() + " (N)" + " ## " + getIdade() + " ## " + getPagina() + " ## " +getPaginaTam() + " ## "
	 +getAntecessor() + " ## " + getSucessor() + " ## " + getVice()
	);

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

      }

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
          contSucessor++;
  }

      }
public void lerMorte(String endereco ){
  Arq.openRead(endereco);
  String localM = "";
	int contMorte=0;

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
                    contMorte++;
                        setDataMorte(date);
                  }
                }
              }
              Arq.close();
}
//formata o local de nascimento
  public void localNascimento(String nascimentoData){
    nascimentoData = nascimentoData.replaceAll("[0-9]","");
    nascimentoData = nascimentoData.replaceAll("/"," ");
		nascimentoData = nascimentoData.replaceAll("-"," ");
    nascimentoData = nascimentoData.replaceAll("anos","");
    nascimentoData = nascimentoData.replace("(","").replace(")","");
    nascimentoData = nascimentoData.replace("Rio Janeiro, Distrito Federal","Rio de Janeiro, Distrito Federal"); //conserta o problema do "de" sumir de rio de janeiro
    nascimentoData = nascimentoData.trim();
    setLocalNascimento(nascimentoData);
  }

	public void localMorte(String morte){
    morte = morte.replaceAll("[0-9]","");
    morte = morte.replaceAll("-"," ");
    morte = morte.replaceAll("anos","");
    morte = morte.replace("(","").replace(")","");
    morte = morte.replace("Rio Janeiro","Rio de Janeiro");
    morte = morte.trim();
    setLocalMorte(morte);

  }
	public void contaTam(String endereco){
	 	long cont = 0;
		File arquivo=new File(endereco);
		cont+=arquivo.length();
		setPaginaTam(cont);
	}


	public void lerGeral(String endereco){
			ler(endereco);
			contaTam(endereco);
			lerAntecessor(endereco);
			lerSucessor(endereco);
			lerMorte(endereco);

	}

}

	public class PrincipalO{
		public static void main(String args[]) throws Exception{
			MyIO.setCharset("UTF-8");
			Presidente o =new Presidente();
			Scanner s = new Scanner(System.in);
			String linha[]=new String[100];
			int numEntrada=0;
			do{
				linha[numEntrada]=s.next();

	}while(linha[numEntrada++].equals("FIM")==false);
			numEntrada--;
			for(int i = 0;i<numEntrada;i++){
	           o.lerGeral(linha[i]);
	           o.imprimir();
	  }
	   }//fim main

	}//fim instituicao

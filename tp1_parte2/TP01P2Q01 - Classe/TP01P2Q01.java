import java.*;
import java.time.*;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Presidente {
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

	//Construtor vazio:
	Presidente () {
		this.id = this.idade=0;
		this.nome = this.localNascimento = this.localMorte = this.antecessor = this.sucessor = this.vice = this.pagina ="";
		this.dataNascimento = this.inicioMandato = this.fimMandato = this.dataMorte=null;
                this.paginaTam=0;
        }

        Presidente (int id, String nome, int idade, LocalDateTime dataNascimento,
                String localNascimento, LocalDateTime inicioMandato,
                LocalDateTime fimMandato, LocalDateTime dataMorte, String localMorte,
                String antecessor, String sucessor, String vice,
                String pagina, long paginaTam) {

                this.id=id;
                this.nome=nome;
                this.idade=idade;
                this.dataNascimento=dataNascimento;
                this.localNascimento=localNascimento;
                this.inicioMandato=inicioMandato;
                this.fimMandato=fimMandato;
                this.dataMorte=dataMorte;
                this.localMorte=localMorte;
                this.antecessor=antecessor;
                this.sucessor=sucessor;
                this.vice=vice;
                this.pagina=pagina;
                this.paginaTam=paginaTam;
        }

        int getId() {
            return this.id;
        }

        void setId (int id) {
            this.id=id;
        }

        String getNome() {
            return this.nome;
        }

        void setNome(String nome) {
            this.nome=nome;
        }

        LocalDateTime getDataNascimento() {
            return this.dataNascimento;
        }

        void setDataNascimento(LocalDateTime dataNascimento) {
            this.dataNascimento=dataNascimento;
        }

        String getLocalNascimento () {
            return this.localNascimento;
        }

        void setLocalNascimento (String localNascimento) {
            this.localNascimento= localNascimento;
        }

        LocalDateTime getInicioMandato() {
            return this.inicioMandato;
        }

        void setInicioMandato(LocalDateTime inicioMandato) {
            this.inicioMandato=inicioMandato;
        }

        LocalDateTime getFimMandato() {
            return this.fimMandato;
        }

        void setFimMandato (LocalDateTime fimMandato) {
            this.fimMandato=fimMandato;
        }

        LocalDateTime getDataMorte() {
            return this.dataMorte;
        }

        void setDataMorte(LocalDateTime dataMorte) {
            this.dataMorte=dataMorte;
        }

        String getLocalMorte() {
            return this.localMorte;
        }

        void setLocalMorte(String localMorte) {
            this.localMorte=localMorte;
        }

        String getAntecessor () {
            return this.antecessor;
        }

        void setAntecessor(String antecessor) {
            this.antecessor=antecessor;
        }

        String getSucessor () {
            return this.sucessor;
        }

        void setSucessor(String sucessor) {
            this.sucessor=sucessor;
        }

        String getVice () {
            return this.vice;
        }

        void setVice (String vice){
            this.vice=vice;
        }

        String getPagina(){
            return this.pagina;
        }

        void setPagina (String pagina) {
            this.pagina=pagina;
        }

        long getPaginaTam () {
            return this.paginaTam;
        }

        void setPaginaTam (long paginaTam) {
            this.paginaTam = paginaTam;
        }//fim dos metodos get e set


        /*void ler () {
            int i=0;

            //Arq.openRead("/t", "iso-8859-1");

            while (Arq.hasNext() && i<=posicao) {
                Arq.readLine();
                i++;

                if(i==posicao) {
                    String [] vet = Arq.readLine().split("\t");//quebra a 'linha' em substrings para obter as informacoes

                    setId(Integer.parseInt(vet[0]));
                    setNome(vet[1]);
                    setDataNascimento()
                }
            }

        }*/

        void ler (String url) {
            Arq.openRead(url);//talvez precise setar iso-8859-1
            //int count=0;
            //String idTitulo = "tittle=\"Lista de presidentes do Brasil\"";

          String vice1 = "";

              url = Arq.readLine();
              while(url.contains("Vice") ==  false)url = Arq.readLine();
              vice1 = Arq.readLine();
               vice1 = Arq.readLine();
               vice1 = vice1.replaceAll("<[^>]*>","");
               vice1 = vice1.trim();
              MyIO.println(vice1);


            //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");

            //while(Arq.hasNext()) {

                //String[] vet = Arq.readLine().split(" ");//.split("\n");
              	//MyIO.println(Arq.readLine().split("\t"));
		//  count++;

              //  MyIO.println(count);
                //setNome(vet[1]);
                //setDataNascimento(LocalDateTime.parse(vet[3]));


                /*  Pattern p = Pattern.compile(url);

                Matcher findNome = p.matcher("Nome completo");
                boolean isFindNome = findNome.matches();

                if(isFindNome==true) {

                }//Matcher findIdade = p.matcher("anos");
                */

                //seria o imprimir:
		//MyIO.println("pos");

		// for (int i=0; i<vet.length-1; i++) {
                  // MyIO.println("a "+ vet[i]);
                //}

		//imprimir(vet);



	}// fim ler()
	void imprimir() {
      MyIO.println(getId() + " ## ");
  	}
}//fim Presidente

public class TP01P2Q01 {
    public static void main (String [] args) {
        Presidente p = new Presidente ();
        String[] s = new String[1000];
        Scanner scan = new Scanner(System.in);
        int cont = 0;

        do{
            s[cont] = scan.next();
        }while(s[cont++].equals("FIM")== false);
        cont --;
        for(int i = 0;i<cont;i++){
            p.ler(s[i]);
            p.imprimir();
        }
    }
}

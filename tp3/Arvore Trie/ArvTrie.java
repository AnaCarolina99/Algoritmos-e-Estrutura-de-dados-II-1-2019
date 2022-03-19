import java.time.LocalDateTime;
import java.time.LocalDate;
import java.io.*;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

/**
 *@author: Darlan Francisco
 *Date: 28/05/2019
 */

class No {

    public char elemento;
    public int tamanho = 255;
    public No[] prox;
    public boolean folha;

    public No() {
        this(' ');
    }

    public No(char elemento) {
        this.elemento = elemento;
        prox = new No[tamanho];
        for (int i = 0; i < tamanho; i++) {
            prox[i] = null;
        }
        folha = false;
    }

    public static int hash(char x) {
        return (int) x;
    }
}

class ArvoreTrie {

    private No raiz;

    public ArvoreTrie() {
        raiz = new No();
    }

    public void inserir(String s) throws Exception {
        inserir(s, raiz, 0);
    }

    public void inserir(String s, No no, int i) throws Exception {
        if (pesquisar(s) == false) {
            if (no.prox[s.charAt(i)] == null) {
                no.prox[s.charAt(i)] = new No(s.charAt(i));
                if (i == s.length() - 1) {
                    no.prox[s.charAt(i)].folha = true;
                } else {
                    inserir(s, no.prox[s.charAt(i)], i + 1);
                }
            } else if (no.prox[s.charAt(i)].folha == false && i < s.length() - 1) {
                inserir(s, no.prox[s.charAt(i)], i + 1);
            }
        }
    }

    public boolean pesquisar(String s) throws Exception {
        return pesquisar(s, raiz, 0);
    }

    public boolean pesquisar(String s, No no, int i) throws Exception {
        boolean resp;
        if (no.prox[s.charAt(i)] == null) {
            resp = false;
        } else if (i == s.length() - 1) {
            resp = (no.prox[s.charAt(i)].folha == true);
        } else if (i < s.length() - 1) {
            resp = pesquisar(s, no.prox[s.charAt(i)], i + 1);
        } else {
            throw new Exception("Erro ao pesquisar!");
        }
        return resp;
    }

    public void mostrar() {
        mostrar("", raiz);
    }

    public void mostrar(String s, No no) {
        if (no.folha == true) {} else {
            for (int i = 0; i < no.prox.length; i++) {
                if (no.prox[i] != null) {
                    mostrar(s + no.elemento, no.prox[i]);
                }
            }
        }
    }
}

class Presidente {

    //variavel privada do tipo inteiro
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

    //variavel privada do tipo long
    private long paginaTam;

    //variaveis privadas do tipo localDateTime
    private LocalDateTime dataNascimento;
    private LocalDateTime inicioMandato;
    private LocalDateTime fimMandato;
    private LocalDateTime dataMorte;

    //variavies auxiliar usada durante o programa
    private int contMorte;
    private int contSucessor;
    public String nomeAux;


    //objeto vazio do tipo presidente
    public Presidente() {

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
        this.dataNascimento = LocalDateTime.of(1, 1, 1, 1, 1);
        this.inicioMandato = LocalDateTime.of(1, 1, 1, 1, 1);
        this.fimMandato = LocalDateTime.of(1, 1, 1, 1, 1);
        this.dataMorte = LocalDateTime.of(1, 1, 1, 1, 1);
        this.contMorte = 0;
        this.contSucessor = 0;
        this.nomeAux = "";
    }
    public Presidente(int id, int idade, String nome, String localNascimento, String localMorte,
        String antecessor, String sucessor, String vice, String pagina, long paginaTam,
        LocalDateTime dataNascimento, LocalDateTime inicioMandato, LocalDateTime fimMandato,
        LocalDateTime dataMorte) {

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

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalNascimento() {
        return this.localNascimento;
    }

    public void setLocalNascimento(String localNascimento) {
        this.localNascimento = localNascimento;
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

    public LocalDateTime getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(LocalDateTime dataNascimento) {
        this.dataNascimento = dataNascimento;
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

    //metodo clone
    public Presidente clone() {

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
    }

    //metodo que faz a conversao do mes indicado no arquivo para seu respectivo numero
    public String conversaoDate(String aux) {
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
        return aux;
    }

    //metodo que ler suas outras respectivas variavies
    public void ler2(String s) {

        setPagina(s);
        Arq.openRead(s);

        //todos os tipos de variavies em string para a leitura do html
        String id2 = "";
        String nome2 = "";
        String localN = "";
        String localDataN = "";
        String localDataM = "";
        String localM = "";
        String antecessor2 = "";
        String sucessor2 = "";
        String vice2 = "";
        int paginaTam2 = 0;
        String idade2 = "";
        String dataN = "";
        String inicioM = "";
        String fimM = "";
        String dataM = "";
        int cont = 0;
        int contMorte = 0;

        try {

            String tituloId = "title=\"Lista de presidentes do Brasil\"";
            String tituloNome = "Nome completo";
            String tituloAntecessor = "Antecessor";
            String tituloSucessor = "Sucessor";
            String tituloVice = "Vice-presidente";
            String tituloNascimento = "Nascimento";
            String tituloMorte = "Morte";

            s = Arq.readLine();
            while (s.contains(tituloId) == false) s = Arq.readLine();
            id2 = s.replaceAll("<[^>]*>", "");
            id2 = id2.replaceAll("&#32", "");
            id2 = id2.replaceAll("[^0-9]", "");
            setId(Integer.parseInt(id2));
            String tituloP = "Período";
            s = Arq.readLine();
            String fimMandato2 = "";

            while (s.contains(tituloP) == false) s = Arq.readLine();
            inicioM = Arq.readLine();
            inicioM = Arq.readLine();
            inicioM = inicioM.replaceAll("<[^>]*>", "");
            inicioM = inicioM.replaceAll(";", "");
            inicioM = inicioM.replaceAll(" de ", "-");
            inicioM = inicioM.replaceAll("º", "");
            inicioM = inicioM.replaceAll("té", "");
            inicioM = inicioM.replaceAll("&#32", "");
            inicioM = inicioM.replaceAll("&#160", "");
            inicioM = conversaoDate(inicioM);
            String[] auxM = inicioM.split("a");
            inicioM = auxM[0];
            fimM = auxM[1];
            String[] auxM2 = inicioM.split("-");
            String diaI = auxM2[0];
            String mesI = auxM2[1];
            String anoI = auxM2[2];
            anoI = anoI.trim();
            String[] auxM3 = fimM.split("-");
            String diaF = auxM3[0];
            diaF = diaF.trim();
            String mesF = auxM3[1];
            String anoF = auxM3[2];
            anoF = anoF.replaceAll("[^0-9]", "");
            int dia2 = Integer.parseInt(diaI);
            int mes2 = Integer.parseInt(mesI);
            int ano2 = Integer.parseInt(anoI);
            int dia3 = Integer.parseInt(diaF);
            int mes3 = Integer.parseInt(mesF);
            int ano3 = Integer.parseInt(anoF);
            LocalDateTime inicio = LocalDateTime.of(ano2, mes2, dia2, 0, 0);
            LocalDateTime fim = LocalDateTime.of(ano3, mes3, dia3, 0, 0);

            setFimMandato(fim);
            setInicioMandato(inicio);

            s = Arq.readLine();
            while (s.contains(tituloVice) == false) s = Arq.readLine();
            vice2 = Arq.readLine();
            vice2 = Arq.readLine();
            vice2 = vice2.replaceAll("<[^>]*>", "");
            vice2 = vice2.trim();
            setVice(vice2);

            s = Arq.readLine();
            while (s.contains(tituloNome) == false) s = Arq.readLine();
            nome2 = Arq.readLine();
            nome2 = Arq.readLine();
            nome2 = nome2.replaceAll("<[^>]*>", "");
            nome2 = nome2.trim();
            setNome(nome2);

            while (s.contains(tituloNascimento) == false) s = Arq.readLine();
            dataN = Arq.readLine();
            dataN = Arq.readLine();
            dataN = dataN.replaceAll("<[^>]*>", "");
            dataN = dataN.replaceAll("&#32", "");
            dataN = dataN.replaceAll("&#160", "");
            dataN = dataN.replaceAll(";", "");
            dataN = dataN.replaceAll("º", "");
            dataN = dataN.replaceAll("", "");
            dataN = dataN.replaceAll(" de ", "-");
            dataN = conversaoDate(dataN);
            dataN = dataN.replace("(", "-").replace(")", "-");
            localNascimento(dataN);
            String dataN1 = "";
            String dataN2 = "";
            String dataN3 = "";
            String aux[] = dataN.split("-");
            dataN1 = aux[0];
            dataN2 = aux[1];
            dataN3 = aux[2];
            dataN3 = dataN3.replaceAll("[^0-9]", "");
            int dia = Integer.parseInt(dataN1);
            int mes = Integer.parseInt(dataN2);
            int ano = Integer.parseInt(dataN3);
            int anoAtual = 2019;
            int idade = anoAtual - ano;
            LocalDateTime date = LocalDateTime.of(ano, mes, dia, 0, 0);
            setDataNascimento(date);
            setIdade(idade);
        } catch (IllegalStateException ex) {
            MyIO.println("Error");
        }
    }

    //metodo para ler o localNascimento
    public void localNascimento(String s) {

        s = s.replaceAll("[0-9]", "");
        s = s.replaceAll("-", " ");
        s = s.replaceAll("anos", "");
        s = s.replace("(", "").replace(")", "");
        s = s.replace("Rio Janeiro", "Rio de Janeiro");
        s = s.trim();
        setLocalNascimento(s);
    }

    //metodo para ler o localMorte
    public void localMorte(String s) {

        s = s.replaceAll("[0-9]", "");
        s = s.replaceAll("-", " ");
        s = s.replaceAll("anos", "");
        s = s.replace("(", "").replace(")", "");
        s = s.replace("Rio Janeiro", "Rio de Janeiro");
        s = s.trim();
        setLocalMorte(s);
    }

    //metodo ler para ler a morte de alguns presidentes
    public void lerMorte(String s) {

        Arq.openRead(s);
        String localM = "";

        while (Arq.hasNext() == true) {
            s = Arq.readLine();
            if (s.contains("<td scope")) {
                if (s.contains("Morte")) {
                    localM = Arq.readLine();
                    localM = Arq.readLine();
                    localM = localM.replaceAll("<[^>]*>", "");
                    localM = localM.replaceAll("#160", "");
                    localM = localM.replaceAll("&", "");
                    localM = localM.replaceAll(";", "");
                    localM = localM.replaceAll(" de ", "-");
                    localM = conversaoDate(localM);
                    localMorte(localM);
                    localM = localM.replace("(", "-").replace(")", "-");
                    String localM1 = "";
                    String localM2 = "";
                    String localM3 = "";
                    String aux[] = localM.split("-");
                    localM1 = aux[0];
                    localM2 = aux[1];
                    localM3 = aux[2];
                    localM3 = localM3.replaceAll("[^0-9]", "");
                    int dia = Integer.parseInt(localM1);
                    int mes = Integer.parseInt(localM2);
                    int ano = Integer.parseInt(localM3);
                    LocalDateTime date = LocalDateTime.of(ano, mes, dia, 0, 0);
                    contMorte++;
                    setDataMorte(date);
                }
            }
        }
        Arq.close();
    }

    //metodo para ler o Antecessor
    public void lerAntecessor(String s) {

        Arq.openRead(s);
        String antecessor2 = "";
        s = Arq.readLine();
        while (s.contains("Antecessor") == false) s = Arq.readLine();
        antecessor2 = Arq.readLine();
        antecessor2 = Arq.readLine();
        antecessor2 = antecessor2.replaceAll("<[^>]*>", "");
        antecessor2 = antecessor2.trim();
        setAntecessor(antecessor2);

    }

    //metodo para ler o sucessor
    public void lerSucessor(String s) {

        Arq.openRead(s);
        String sucessor2 = "";
        if (!s.equals("/tmp/presidente/Jair_Bolsonaro.html")) {
            s = Arq.readLine();
            while (s.contains("Sucessor") == false) s = Arq.readLine();
            sucessor2 = Arq.readLine();
            sucessor2 = Arq.readLine();
            sucessor2 = sucessor2.replaceAll("<[^>]*>", "");
            sucessor2 = sucessor2.trim();
            setSucessor(sucessor2);
            contSucessor++;
        }
    }

    //metodo que conta o tamanho da pagina
    public void contaTam(String s) {

        long cont = 0;
        File arquivo = new File(s);
        cont += arquivo.length();
        setPaginaTam(cont);
    }

    //metodo ler que chama os demais metodos
    public void ler(String s) {
        MyIO.setCharset("UTF-8");
        contaTam(s);
        ler2(s);
        lerAntecessor(s);
        lerSucessor(s);
        lerMorte(s);
    }

    //metdo para imprimir de acordo o local morte e sucessor
    public void imprimir() {

        MyIO.setCharset("ISO-8859-1");

        DateTimeFormatter date = DateTimeFormatter.ofPattern("d/M/yyyy");

        if (contMorte == 0 && contSucessor >= 1) {
            MyIO.println(getId() + " ## " + convertUTF8toISO(getNome()) + " ## " + getInicioMandato().format(date) + " (I)" + " ## " + getFimMandato().format(date) + " (F)" + " ## " +
                getDataNascimento().format(date) + " em " + convertUTF8toISO(getLocalNascimento()) + " (N)" + " ## " + getIdade() + " ## " + getPagina() + " ## " + getPaginaTam() + " ## " +
                convertUTF8toISO(getAntecessor()) + " ## " + convertUTF8toISO(getSucessor()) + " ## " + convertUTF8toISO(getVice()));
        } else if (contMorte >= 1 && contSucessor >= 1) {
            MyIO.println(getId() + " ## " + convertUTF8toISO(getNome()) + " ## " + getInicioMandato().format(date) + " (I)" + " ## " + getFimMandato().format(date) + " (F)" + " ## " +
                getDataNascimento().format(date) + " em " + convertUTF8toISO(getLocalNascimento()) + " (N)" + " ## " + getIdade() + " ## " + getDataMorte().format(date) + " em " + convertUTF8toISO(getLocalMorte()) + " (M)" + " ## " + getPagina() + " ## " + getPaginaTam() + " ## " +
                convertUTF8toISO(getAntecessor()) + " ## " + convertUTF8toISO(getSucessor()) + " ## " + convertUTF8toISO(getVice()));
        } else if (contMorte == 0 && contSucessor == 0) {
            MyIO.println(getId() + " ## " + getNome() + " ## " + getInicioMandato().format(date) + " (I)" + " ## " + getFimMandato().format(date) + " (F)" + " ## " +
                getDataNascimento().format(date) + " em " + convertUTF8toISO(getLocalNascimento()) + " (N)" + " ## " + getIdade() + " ## " + getPagina() + " ## " + getPaginaTam() + " ## " +
                getAntecessor() + " ## " + " ## " + convertUTF8toISO(getVice()));
        }

        contMorte = 0;
        contSucessor = 0;
    }

    //metodo para pegar o nome
    public String pegaNome() {
        nomeAux = getNome();
        return nomeAux;
    }

    //metodo desenvolvido por Ana Carolina Meideiros
    public static String convertUTF8toISO(String str) {
        String ret = null;
        try {
            ret = new String(str.getBytes("ISO-8859-1"), "UTF-8");
        } catch (java.io.UnsupportedEncodingException e) {
            return null;
        }
        return ret;
    }
}

public class ArvTrie {

    public static void main(String[] args) throws Exception {

        MyIO.setCharset("UTF-8");

        ArvoreTrie a1 = new ArvoreTrie();
        ArvoreTrie a2 = new ArvoreTrie();

        String[] entrada = new String[1000];
        String[] linha = new String[10000];

        String entrada3[] = new String[1000];
        String entrada2[] = new String[1000];

        int nEntrada = 0;
        int nEntrada2 = 0;
        int nEntrada3 = 0;

        int comp = 0;
        int j = 0;

        long inicio = System.nanoTime();

        boolean receber;


        do {
            entrada[nEntrada] = MyIO.readLine();

        } while (entrada[nEntrada++].contains("FIM") == false);
        nEntrada--;

        do {
            entrada2[nEntrada2] = MyIO.readLine();
        } while (entrada2[nEntrada2++].contains("FIM") == false);
        nEntrada2--;


        do {
            entrada3[nEntrada3] = MyIO.readLine();
        } while (entrada3[nEntrada3++].contains("FIM") == false);
        nEntrada3--;

        for (int i = 0; i < nEntrada; i++) {
            Presidente p = new Presidente();
            p.ler(entrada[i]);
            String x = p.getNome();
            a1.inserir(x);
        }

        for (int i = 0; i < nEntrada2; i++) {
            Presidente p = new Presidente();
            p.ler(entrada2[i]);
            String y = p.getNome();
            a1.inserir(y);
        }

        for (int i = 0; i < nEntrada3; i++) {
            String d = entrada3[i];
            receber = a1.pesquisar(d);
            if (receber == true) {
                MyIO.println("SIM");
            } else {
                printD("NÃO");
            }
        } 

        MyIO.print("\n");

        //Criaçao do Log e inicializacao de suas variaveis
        long fim = System.nanoTime();
        long com = fim - inicio;
        //Criacao e escrita do arquivo log
        Arq.openWrite("613838_ArvoreTrie.txt", "ISO-8859-1");
        //Printacao das variaveis contidas no arquivo
        Arq.println("613838 \t Tempo:" + com + "s \t Comparaçoes:");
        //Fechamento do arquivo
        Arq.close();
    }

    public static void printD(String resp) throws Exception {
        PrintStream out = new PrintStream(System.out, true, "ISO-8859-1");
        out.println(resp);
    }

    //metodo desenvolvido por Ana Carolina Meideiros
    public static String convertUTF8toISO(String str) {
        String ret = null;
        try {
            ret = new String(str.getBytes("ISO-8859-1"), "UTF-8");
        } catch (java.io.UnsupportedEncodingException e) {
            return null;
        }
        return ret;
    }

    //metodo desenvolvido por Darlan Francisco Gandos
    public static String toUTF8(String isoString) {
        String utf8String = null;
        if (null != isoString && !isoString.equals("")) {
            try {
                byte[] stringBytesISO = isoString.getBytes("ISO-8859-1");
                utf8String = new String(stringBytesISO, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                System.out.println("UnsupportedEncodingException is: " + e.getMessage());
                utf8String = isoString;
            }
        } else {
            utf8String = isoString;
        }
        return utf8String;
    }
}
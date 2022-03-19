/**
 *@author: Darlan Francisco
 *Date: 27/02/2019
 */

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

class Insercao{

    private int n;
    private Presidente[] array;
    public int numComp;
    public int numMovi;

    //contrutor
    public Insercao(int tamanho, Presidente[] array){
        n = tamanho;
        this.array = array;
        numComp = 0;
        numMovi = 0;
    }

    //metodo para insercao
    public void sort() {
        for (int i = 1; i < n; i++) {
            Presidente tmp = array[i];
            int j = i - 1;

            while ((j >= 0) && (array[j].getPaginaTam() > tmp.getPaginaTam())) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = tmp;
        }
    }

        //metodo para insercao
    public void insercao() {

        int k = 10; //valor padrao dado no enunciado do tp 02
        int inicio;
        int j;

        for (int i = 1; i < n; i++) {
            Presidente tmp = array[i];

            //metodo de ordenacao pela parte pacial
            if(i > k-1)
                inicio = k-1;
            else
                inicio = i-1;

            for(j = inicio; j >= 0 && (array[j].getPaginaTam() > tmp.getPaginaTam()); j--){
                array[j+1] = array[j];
            }
            array[j+1] = tmp;
        }

        //sort();
    }

    //metodo para fazer a troca
    public void swap(int i, int j){
        numMovi += 3;
        Presidente temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

class Lista {

    private Presidente[] array;
    private int n;

    //contrutor classe
    public Lista() {
        this(0);
    }

    //contrutor class que recebe o tamanho da lista
    public Lista(int tamanho) {
        array = new Presidente[tamanho];
        n = 0;
    }

    //retorna meu objeto de Presidente
    public Presidente[] getArray(){
        return array;
    }

    //retorna o valor de n
    public int getN(){
      return n;
    }

    //insere um elemento na primeira posicao da lista e move os demais elementos para o fim da lista
    public void inserirInicio(Presidente presidente) throws Exception {

        //validar insercao
        if (n >= array.length) {
            throw new Exception("Erro ao inserir!");
        }
        //levar elementos para o fim do array
        for (int i = n; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = presidente.clone();
        n++;
    }

    //insere um elemento na ultima posicao da lista
    public void inserirFim(Presidente presidente) throws Exception {

        //validar insercao
        if (n >= array.length) {
            throw new Exception("Erro ao inserir!");
        }

        array[n] = presidente;
        n++;
    }

    //remove um elemento da primeira posicao da lisa e movimenta
    public void inserir(Presidente presidente, int pos) throws Exception {

        //validar insercao
        if (n >= array.length || pos < 0 || pos > n) {
            throw new Exception("Erro ao inserir!");
        }

        //levar elementos para o fim do array
        for (int i = n; i > pos; i--) {
            array[i] = array[i - 1];
        }
        array[pos] = presidente;
        n = n + 1;
    }

    //remove um elemento da primeira posicao da lista e movimenta
    public Presidente removerInicio() throws Exception {

        //validar remocao
        if (n == 0) {
            throw new Exception("Erro ao remover!");
        }

        Presidente resp = array[0];
        n--;

        for (int i = 0; i < n; i++) {
            array[i] = array[i + 1];
        }

        return resp;
    }

    //remove um elemento de uma posicao especifica da lista e movimenta os demais elementos para o inicio da mesma
    public Presidente removerFim() throws Exception {

        //validar remocao
        if (n == 0) {
            throw new Exception("Erro ao remover!");
        }

        return array[--n];
    }

    //remove um elemento de uma posicao especifica da lista e movimenta os demias elementos para oo inicio da mesma
    public Presidente remover(int pos) throws Exception {

        //validar remocao
        if (n == 0 || pos < 0 || pos >= n) {
            throw new Exception("Erro ao remover!");
        }

        Presidente resp = array[pos];
        n--;

        for (int i = pos; i < n; i++) {
            array[i] = array[i + 1];
        }

        return resp;
    }

    //mostra os elementos da lista separados por espacos
    public void mostrar() {
        for (int i = 0; i < 10; i++) {
            array[i].imprimir(i);
        }
    }

    //procura um elemento se ele existe
    public boolean pesquisar(Presidente x) {
        boolean retorno = false;
        for (int i = 0; i < n && retorno == false; i++) {
            retorno = (array[i] == x);
        }
        return retorno;
    }
    public void mostrarRec() {
        System.out.print("[ ");
        mostrarRec(0);
        System.out.println("]");
    }

    public void mostrarRec(int i) {
        if (i < n) {
            System.out.print(array[i] + " ");
            mostrarRec(i + 1);
        }
    }

    //metodo compara o maior e menor numero(codigo)
    public void sort(){
        for(int i = 0; i < n; i++){
            int menor = i;
            for(int j = (i+1); j < n; j++){
                //numComp++;
                if(array[menor].getId() > array[j].getId()){
                    menor = j;
                }
            }
            swap(menor, i);
        }
    }

    //metodo para fazer a troca
    public void swap(int i, int j){
        //numMovi += 3;
        Presidente temp = array[i];
        array[i] = array[j];
        array[j] = temp;
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
    private int valor;


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
        this.valor = 0;
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
        int valor = 0;

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
    //auxiliar para tratar o erro de caracteres
    public void imprimir(int i) {

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

public class InsercaoParcial {

    public static void main(String[] args) throws Exception {

        MyIO.setCharset("UTF-8");
        Lista lista = new Lista(1000);
        String[] entrada = new String[1000];
        int nEntrada = 0;
        String[] linha;

        do {

            entrada[nEntrada] = MyIO.readLine();
            convertUTF8toISO(entrada[nEntrada]);
        } while (entrada[nEntrada++].equals("FIM") == false);
        nEntrada--;

        for (int i = 0; i < nEntrada; i++) {
            Presidente p = new Presidente();
            p.ler(entrada[i]);
            lista.inserirFim(p);
        }

        Insercao insercao = new Insercao(lista.getN(), lista.getArray());
        insercao.sort();
        lista.mostrar();
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

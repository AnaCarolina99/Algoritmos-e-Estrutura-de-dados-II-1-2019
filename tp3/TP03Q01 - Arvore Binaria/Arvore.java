import java.time.LocalDateTime;
import java.util.regex.*;
import java.io.*;

public class Arvore {

   /** 
	 * Main method.
    * @author Kaiser Gabriel Santos
    * @since 09/04/2019
    * @param String[] args are the arguments to our software.
    */
   public static void main(String[] args) {
		MyIO.setCharset("UTF-8");

		String[] input = new String[1000];
		String sentence = "", output = "";
      int nInput = 0;
		long start, end;
		Presidente p = new Presidente();
		Tree presidentes = new Tree();

		// Read pattern input
		do {
			input[nInput] = MyIO.readLine();
		} while (!input[nInput++].contains("FIM"));
  
		nInput--; // Disconsider last row with "FIM" word

		try {
			// For each input row, create an object Presidente with the  
			// info of the president and store in the list.
			for (int i = 0; i < nInput; i++)
				presidentes.add(Presidente.ler(input[i]));
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}

		start = System.currentTimeMillis();

		while (!(sentence = MyIO.readLine()).contains("FIM"))
			output += presidentes.find(sentence) + "\n";

		end = System.currentTimeMillis();

		Util.createLogFile(end - start, Tree.getNComp());

		MyIO.print(output);
   }

}

class Node {
	
	public Presidente element;
	public Node left, right;

	/** 
	 * Constructor method.
    * @author Kaiser Gabriel Santos
    * @since 09/04/2019
    * @param Presidente element is the element that be added in the tree.
    */
	public Node(Presidente element) {
		this(element, null, null);
	}

	/** 
	 * Constructor method.
    * @author Kaiser Gabriel Santos
    * @since 09/04/2019
    * @param Presidente element is the element that be added in the tree.
	 * @param Node left is the left node.
	 * @param Node right is the right node.
	 */
	public Node(Presidente element, Node left, Node right) {
		this.element = element;
		this.left = left;
		this.right = right;
	}
	
}


class Tree {
	
	private Node root;

	private static int nComp;

	/** 
	 * Constructor method.
    * @author Kaiser Gabriel Santos
    * @since 09/04/2019
    */
	public Tree() {
		this.root = null;
	}

	/** 
    * Gets the comparison number of array elements.
	 * @author Kaiser Gabriel Santos
	 * @since 03/03/2019
	 * @return int with comparison number of array elements.
	 */
	public static int getNComp() {
		return nComp;
	}

	/** 
    * Invokes a recursive method to find element in the tree.
    * @author Kaiser Gabriel Santos
	 * @since 09/04/2019
    * @param String element is the element that be searched in the tree.
	 * @return String with the path traveled.
    */
	public String find(String element) {
		return element + " raiz" + find(element, this.root);
	}

	/** 
	 * Search for an element in the tree, and 
	 * if it exists, return it.
	 * @author Kaiser Gabriel Santos
	 * @since 09/04/2019
    * @param String element is the element that be searched in the tree.
    * @param Node i is the tree's node.
	 * @return boolean true if the president 
	 * exists in the tree or false, otherwise.
	 */
	private String find(String element, Node i) {
		String resp = " ";

		if (i == null)
			resp += "N" + ((char) 195) + "O";

		else if (element.compareTo(i.element.getNome()) == 0)
			resp += "SIM";

		else if (element.compareTo(i.element.getNome()) < 0)
			resp += "esq" + find(element, i.left);

		else
			resp += "dir" + find(element, i.right);

		this.nComp += 3;
		  
		return resp;
	}

	/** 
    * Invokes a recursive method to show elements.
    * @author Kaiser Gabriel Santos
	 * @since 09/04/2019
    */
	public void showCenter() {
		System.out.print("[ ");
		showCenter(this.root);
		System.out.println("]");
	}

	/** 
    * Show elements.
    * @author Kaiser Gabriel Santos
	 * @since 09/04/2019
    * @param Node i is the tree's node.
    */
    private void showCenter(Node i) {
		if (i != null) {
			showCenter(i.left);
			System.out.print(i.element + " ");
			showCenter(i.right);
		}
    }

   /** 
    * Invokes a recursive method to show elements.
    * @author Kaiser Gabriel Santos
	 * @since 09/04/2019
    */
    public void showPre() {
		System.out.print("[ ");
		showPre(this.root);
		System.out.println("]");
	}

   /** 
    * Show elements.
    * @author Kaiser Gabriel Santos
	 * @since 09/04/2019
    * @param Node i is the tree's node.
    */
    private void showPre(Node i) {
		if (i != null) {
			System.out.print(i.element + " ");
			showPre(i.left);
			showPre(i.right);
		}
	}

	/** 
    * Invokes a recursive method to show elements.
    * @author Kaiser Gabriel Santos
	 * @since 09/04/2019
    */
	public void showPos() {
		System.out.print("[ ");
		showPos(this.root);
		System.out.println("]");
	}

	/** 
    * Show elements.
    * @author Kaiser Gabriel Santos
	 * @since 09/04/2019
    * @param Node i is the tree's node.
    */
	private void showPos(Node i) {
		if (i != null) {
			showPos(i.left);
			showPos(i.right);
			System.out.print(i.element + " ");
		}
	}

	/** 
	 * Invokes a recursive method to add a 
	 * president in the tree.
	 * @author Kaiser Gabriel Santos
	 * @since 09/04/2019
	 * @param Presidente element is the president 
	 * that will be inserted in the tree.
	 */
	public void add(Presidente element) throws Exception {
		this.root = add(element, this.root);
	}

	/** 
	 * Add a president in the tree.
	 * @author Kaiser Gabriel Santos
	 * @since 09/04/2019
	 * @param Presidente element is the president 
	 * that will be inserted in the tree.
    * @param Node i is the tree's node.
	 * @return Node with the added element.
	 */
	private Node add(Presidente element, Node i) throws Exception {
		if (i == null)
			i = new Node(element);

		else if (element.getNome().compareTo(i.element.getNome()) < 0)
			i.left = add(element, i.left);

		else if (element.getNome().compareTo(i.element.getNome()) > 0)
			i.right = add(element, i.right);

		else
			throw new Exception("Elemento existente na estrutura.");

		return i;
	}

	/** 
	 * Invokes a recursive method to remove a 
	 * president in the tree.
	 * @author Kaiser Gabriel Santos
	 * @since 09/04/2019
	 * @param Presidente element is the president 
	 * that will be removed in the tree.
	 */
	public void rm(Presidente element) throws Exception {
		this.root = rm(element, this.root);
	}

	/** 
	 * Removes a president in the tree.
	 * @author Kaiser Gabriel Santos
	 * @since 09/04/2019
	 * @param Presidente element is the president 
	 * that will be removed in the tree.
    * @param Node i is the tree's node.
	 * @return Node without removed element.
	 */
	private Node rm(Presidente element, Node i) throws Exception {
		if (i == null) 
         throw new Exception("Elemento inexistente na estrutura.");

		else if (element.getNome().compareTo(i.element.getNome()) < 0)
			i.left = rm(element, i.left);

		else if (element.getNome().compareTo(i.element.getNome()) > 0)
			i.right = rm(element, i.right);

		// Without right node.
		else if (i.right == null)
			i = i.left;

		// Without left node.
		else if (i.left == null)
			i = i.right;

		// With right and left nodes.
		else 
			i.left = predecessor(i, i.left);
		
		return i;
	}

	/** 
	 * Change removed node by predecessor.
	 * @author Kaiser Gabriel Santos
	 * @since 09/04/2019
	 * @param Node i is the node that be removed.
    * @param Node j is the left subtree's node.
	 * @return Node with changes.
	 */
	private Node predecessor(Node i, Node j) {
		// Exists right node.
		if (j.right != null) 
			j.right = predecessor(i, j.right);

		// Found max of the left subtree.
		else {
			i.element = j.element; // Replaces i by j.
			j = j.left; // Replaces j by j.left.
		}
		
		return j;
	}

}

class Presidente {

	private int id, idade;
	private String nome, localNascimento, localMorte,
			antecessor, sucessor, vice, pagina;
	private LocalDateTime dataNascimento, inicioMandato,
			fimMandato, dataMorte;
	private long paginaTam;
	private boolean morreu;

	/** 
	 * Constructor method.
    * @author Kaiser Gabriel Santos
    * @since 25/02/2019
    */
	public Presidente() {
		this(
				0,
				"",
				0,
				LocalDateTime.MIN,
				"",
				LocalDateTime.MIN,
				LocalDateTime.MIN,
				false,
				LocalDateTime.MIN,
				"",
				"",
				"",
				"",
				"",
				0
		);
	}

	/** 
	 * Constructor method.
    * @author Kaiser Gabriel Santos
    * @since 25/02/2019
	 * @param int id is the president's number.
	 * @param String nome is the president's name.
	 * @param int idade is the president's age.
	 * @param LocalDateTime dataNascimento is the president's birth date.
	 * @param String localNascimento is the president's birth local.
	 * @param LocalDateTime inicioMandato is the president's mandate start date.
	 * @param LocalDateTime fimMandato is the president's mandate end date.
	 * @param boolean morreu is true if president is dead or false if he is alive.
	 * @param LocalDateTime dataMorte is the president's death date.
	 * @param String localMorte is the president's death local.
	 * @param String antecessor is the president's predecessor name.
	 * @param String sucessor is the president's successor name.
	 * @param String vice is the president's vice name.
	 * @param String pagina is the president's HTML page path.
	 * @param long paginaTam is the president's file size.
    */
	public Presidente(
			int id,
			String nome,
			int idade,
			LocalDateTime dataNascimento,
			String localNascimento,
			LocalDateTime inicioMandato,
			LocalDateTime fimMandato,
			boolean morreu,
			LocalDateTime dataMorte,
			String localMorte,
			String antecessor,
			String sucessor,
			String vice,
			String pagina,
			long paginaTam
	) {
		this.id = id;
		this.idade = idade;
		this.nome = nome;
		this.localNascimento = localNascimento;
		this.localMorte = localMorte;
		this.antecessor = antecessor;
		this.sucessor = sucessor;
		this.vice = vice;
		this.pagina = pagina;
		this.morreu = morreu;
		this.dataNascimento = dataNascimento;
		this.inicioMandato = inicioMandato;
		this.fimMandato = fimMandato;
		this.dataMorte = dataMorte;
		this.paginaTam = paginaTam;
	}

	/** 
	 * Constructor method.
    * @author Kaiser Gabriel Santos
    * @since 25/02/2019
	 * @param Presidente p is the president that
	 * be stored in the attributes.
    */
	public Presidente(Presidente p) {
		this(
				p.id,
				p.nome,
				p.idade,
				p.dataNascimento,
				p.localNascimento,
				p.inicioMandato,
				p.fimMandato,
				p.morreu,
				p.dataMorte,
				p.localMorte,
				p.antecessor,
				p.sucessor,
				p.vice,
				p.pagina,
				p.paginaTam
		);
	}

	/** 
    * Get the id attribute.
	 * @author Kaiser Gabriel Santos
	 * @since 25/02/2019
	 * @return int with id attribute.
	 */
	public int getId() {
		return id;
	}

	/** 
    * Set the id attribute.
	 * @author Kaiser Gabriel Santos
	 * @since 25/02/2019
	 * @param int id is the value that must 
	 * be stored in the id attribute.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/** 
    * Get the age attribute.
	 * @author Kaiser Gabriel Santos
	 * @since 25/02/2019
	 * @return int with age attribute.
	 */
	public int getIdade() {
		return idade;
	}

	/** 
    * Set the age attribute.
	 * @author Kaiser Gabriel Santos
	 * @since 25/02/2019
	 * @param int age is the value that must 
	 * be stored in the age attribute.
	 */
	public void setIdade(int idade) {
		this.idade = idade;
	}

	/** 
    * Get the name attribute.
	 * @author Kaiser Gabriel Santos
	 * @since 25/02/2019
	 * @return int with name attribute.
	 */
	public String getNome() {
		return nome;
	}

	/** 
    * Set the name attribute.
	 * @author Kaiser Gabriel Santos
	 * @since 25/02/2019
	 * @param String name is the value that must 
	 * be stored in the name attribute.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/** 
    * Get the birth local attribute.
	 * @author Kaiser Gabriel Santos
	 * @since 25/02/2019
	 * @return int with birth local attribute.
	 */
	public String getLocalNascimento() {
		return localNascimento;
	}

	/** 
    * Set the birth local attribute.
	 * @author Kaiser Gabriel Santos
	 * @since 25/02/2019
	 * @param String birth local is the value that must 
	 * be stored in the birth local attribute.
	 */
	public void setLocalNascimento(String localNascimento) {
		this.localNascimento = localNascimento;
	}

	/** 
    * Get the death local attribute.
	 * @author Kaiser Gabriel Santos
	 * @since 25/02/2019
	 * @return int with death local attribute.
	 */
	public String getLocalMorte() {
		return localMorte;
	}

	/** 
    * Set the death local attribute.
	 * @author Kaiser Gabriel Santos
	 * @since 25/02/2019
	 * @param String death local is the value that must 
	 * be stored in the death local attribute.
	 */
	public void setLocalMorte(String localMorte) {
		this.localMorte = localMorte;
	}

	/** 
    * Get the predecessor attribute.
	 * @author Kaiser Gabriel Santos
	 * @since 25/02/2019
	 * @return int with predecessor attribute.
	 */
	public String getAntecessor() {
		return antecessor;
	}

	/** 
    * Set the predecessor attribute.
	 * @author Kaiser Gabriel Santos
	 * @since 25/02/2019
	 * @param String predecessor is the value that must 
	 * be stored in the predecessor attribute.
	 */
	public void setAntecessor(String antecessor) {
		this.antecessor = antecessor;
	}

	/** 
    * Get the successor attribute.
	 * @author Kaiser Gabriel Santos
	 * @since 25/02/2019
	 * @return int with successor attribute.
	 */
	public String getSucessor() {
		return sucessor;
	}

	/** 
    * Set the successor attribute.
	 * @author Kaiser Gabriel Santos
	 * @since 25/02/2019
	 * @param String successor is the value that must 
	 * be stored in the successor attribute.
	 */
	public void setSucessor(String sucessor) {
		this.sucessor = sucessor;
	}

	/** 
    * Get the vice-president attribute.
	 * @author Kaiser Gabriel Santos
	 * @since 25/02/2019
	 * @return int with vice-president attribute.
	 */
	public String getVice() {
		return vice;
	}

	/** 
    * Set the vice-president attribute.
	 * @author Kaiser Gabriel Santos
	 * @since 25/02/2019
	 * @param String vice-president is the value that must 
	 * be stored in the vice-president attribute.
	 */
	public void setVice(String vice) {
		this.vice = vice;
	}

	/** 
    * Get the page HTML's path attribute.
	 * @author Kaiser Gabriel Santos
	 * @since 25/02/2019
	 * @return int with page HTML's path attribute.
	 */
	public String getPagina() {
		return pagina;
	}

	/** 
    * Set the page HTML's path attribute.
	 * @author Kaiser Gabriel Santos
	 * @since 25/02/2019
	 * @param String page HTML's path is the value that must 
	 * be stored in the page HTML's path attribute.
	 */
	public void setPagina(String pagina) {
		this.pagina = pagina;
	}

	/** 
    * Get the birth date attribute.
	 * @author Kaiser Gabriel Santos
	 * @since 25/02/2019
	 * @return int with birth date attribute.
	 */
	public LocalDateTime getDataNascimento() {
		return dataNascimento;
	}

	/** 
    * Set the birth date attribute.
	 * @author Kaiser Gabriel Santos
	 * @since 25/02/2019
	 * @param String day is the value that must 
	 * be stored in the day of birth date attribute.
	 * @param String month is the value that must 
	 * be stored in the month of birth date attribute.
	 * @param String year is the value that must 
	 * be stored in the year of birth date attribute.
	 */
	public void setDataNascimento(String dia, String mes, String ano) {
		this.dataNascimento = LocalDateTime.of(Integer.parseInt(ano), 
			Util.getNumberOfMonth(mes), Integer.parseInt(dia), 0, 0);
	}

	/** 
    * Get the mandate starts date attribute.
	 * @author Kaiser Gabriel Santos
	 * @since 25/02/2019
	 * @return int with mandate starts date attribute.
	 */
	public LocalDateTime getInicioMandato() {
		return inicioMandato;
	}

	/** 
    * Set the mandate starts date attribute.
	 * @author Kaiser Gabriel Santos
	 * @since 25/02/2019
	 * @param String day is the value that must 
	 * be stored in the day of mandate starts date attribute.
	 * @param String month is the value that must 
	 * be stored in the month of mandate starts date attribute.
	 * @param String year is the value that must 
	 * be stored in the year of mandate starts date attribute.
	 */
	public void setInicioMandato(String dia, String mes, String ano) {
		this.inicioMandato = LocalDateTime.of(Integer.parseInt(ano), 
			Util.getNumberOfMonth(mes), Integer.parseInt(dia), 0, 0);
	}

	/** 
    * Get the mandate ends date attribute.
	 * @author Kaiser Gabriel Santos
	 * @since 25/02/2019
	 * @return int with mandate start date attribute.
	 */
	public LocalDateTime getFimMandato() {
		return fimMandato;
	}

	/** 
    * Set the mandate ends date attribute.
	 * @author Kaiser Gabriel Santos
	 * @since 25/02/2019
	 * @param String day is the value that must 
	 * be stored in the day of mandate ends date attribute.
	 * @param String month is the value that must 
	 * be stored in the month of mandate ends date attribute.
	 * @param String year is the value that must 
	 * be stored in the year of mandate ends date attribute.
	 */
	public void setFimMandato(String dia, String mes, String ano) {
		this.fimMandato = LocalDateTime.of(Integer.parseInt(ano), 
			Util.getNumberOfMonth(mes), Integer.parseInt(dia), 0, 0);
	}

	/** 
    * Get the death local attribute.
	 * @author Kaiser Gabriel Santos
	 * @since 25/02/2019
	 * @return int with death local attribute.
	 */
	public LocalDateTime getDataMorte() {
		return dataMorte;
	}

	/** 
    * Set the death date attribute.
	 * @author Kaiser Gabriel Santos
	 * @since 25/02/2019
	 * @param String day is the value that must 
	 * be stored in the day of death date attribute.
	 * @param String month is the value that must 
	 * be stored in the month of death date attribute.
	 * @param String year is the value that must 
	 * be stored in the year of death date attribute.
	 */
	public void setDataMorte(String dia, String mes, String ano) {
		this.dataMorte = LocalDateTime.of(Integer.parseInt(ano), 
			Util.getNumberOfMonth(mes), Integer.parseInt(dia), 0, 0);
	}

	/** 
    * Get the size of file HTML attribute.
	 * @author Kaiser Gabriel Santos
	 * @since 25/02/2019
	 * @return int with size of file HTML attribute.
	 */
	public long getPaginaTam() {
		return paginaTam;
	}

	/** 
    * Set the size of file HTML attribute.
	 * @author Kaiser Gabriel Santos
	 * @since 25/02/2019
	 * @param String size of file HTML is the value that must 
	 * be stored in the size of file HTML attribute.
	 */
	public void setPaginaTam(long paginaTam) {
		this.paginaTam = paginaTam;
	}

	/** 
    * Get the died attribute.
	 * @author Kaiser Gabriel Santos
	 * @since 25/02/2019
	 * @return int with died attribute.
	 */
	public boolean getMorreu() {
		return morreu;
	}

	/** 
    * Set the died attribute.
	 * @author Kaiser Gabriel Santos
	 * @since 25/02/2019
	 * @param boolean died is the value that must 
	 * be stored in the died attribute.
	 */
	public void setMorreu(boolean morreu) {
		this.morreu = morreu;
	}

	/** 
	 * Clone the object in another instance of this object.
    * @author Kaiser Gabriel Santos
	 * @since 25/02/2019
	 * @return Presidente with the content of the another 
	 * object Presidente.
    */
	public Presidente clone() {
		return new Presidente(this);
	}

	/** 
	 * Compare this object with other instanced object and
	 * determinate if are equal.
    * @author Kaiser Gabriel Santos
	 * @since 26/02/2019
	 * @return boolean true if the instances contains same values
	 * or false, otherwise.
    */
	public boolean compareTo(Presidente p) {
		return (getId() == p.getId());
	}

	/** 
	 * Print the president.
    * @author Kaiser Gabriel Santos
	 * @since 25/02/2019
    */
	public void imprimir() {
		MyIO.print(this.id + " ## ");
		MyIO.print(this.nome + " ## ");
		MyIO.print(this.inicioMandato.getDayOfMonth() + "/" +
			this.inicioMandato.getMonthValue() + "/" +
			this.inicioMandato.getYear() + " (I) ## ");
		MyIO.print(this.fimMandato.getDayOfMonth() + "/" + 
			this.fimMandato.getMonthValue() + "/" +
			this.fimMandato.getYear() + " (F) ## ");
		MyIO.print(this.dataNascimento.getDayOfMonth() + "/" + 	
			this.dataNascimento.getMonthValue() + "/" +
			this.dataNascimento.getYear() + " em ");
		MyIO.print(this.localNascimento + " (N) ## ");
		MyIO.print(this.idade + " ## ");

		if (this.morreu) {
			MyIO.print(this.dataMorte.getDayOfMonth() + "/" + 
				this.dataMorte.getMonthValue() + "/" +
				this.dataMorte.getYear() + " em ");
			MyIO.print(this.localMorte + " (M) ## ");
		}

		MyIO.print(this.pagina + " ## ");
		MyIO.print(this.paginaTam + " ## ");
		MyIO.print(this.antecessor + " ## ");
		MyIO.print(this.sucessor + " ## ");
		MyIO.print(this.vice + "\n");
	}

	/** 
	 * Read a brazilian president.
    * @author Kaiser Gabriel Santos
	 * @since 25/02/2019
    */
	public static Presidente ler(String row) {
		return Util.readHtml(row);
	}
}

class Util {

	/** 
	 * Creates log file with program execution time.
    * @author Kaiser Gabriel Santos
	 * @since 03/03/2019
    * @param long time is the program execution time.
    * @param int nComp is the comparation number of array elements.
    */
	 public static void createLogFile(long time, int nComp) {
		Arq.openWrite("625502_arvoreBinaria.txt");

		Arq.println("625502\t" + time + "\t" + nComp);

		Arq.close();
	}

	/** 
	 * Read HTML, remove tags and populate Presidente class with
	 * the info of each brazilian president.
    * @author Kaiser Gabriel Santos
	 * @since 25/02/2019
    * @param String path is the path of the HTML page that be analised.
    * @return Presidente with the content of the path.
    */
	 public static Presidente readHtml(String path) {
		Presidente p = new Presidente();
		String content = "", row = "",
			id = "", nasc = "", morte = "", mandate = "", 
			auxYear = "", auxDay = "";
		String[] auxIdade, auxLocalNasc;
		boolean foundId = false,
			foundMandate = false,
			foundVice = false, 
			foundPredecessor = false, 
			foundSuccessor = false,
			foundPlaceBirth = false,
			foundDeathLocal = false;
		int i = 0, j = 0, cAuxLocalNasc = 0, qtdYear = 0;
		File f = new File(path);

		Arq.openRead(path, "UTF-8");
   	content = removeTags(Arq.readAll());
		Arq.close();

		p.setPagina(path);
		p.setPaginaTam(f.length());

		for (; i < content.length(); i++) {
			// Find id
			if ((Character.toUpperCase(content.charAt(i)) == 'P' &&
			Character.toUpperCase(content.charAt(i + 1)) == 'R' &&
			Character.toUpperCase(content.charAt(i + 2)) == 'E' &&
			Character.toUpperCase(content.charAt(i + 3)) == 'S' &&
			Character.toUpperCase(content.charAt(i + 4)) == 'I' &&
			Character.toUpperCase(content.charAt(i + 5)) == 'D' &&
			Character.toUpperCase(content.charAt(i + 6)) == 'E' &&
			Character.toUpperCase(content.charAt(i + 7)) == 'N' &&
			Character.toUpperCase(content.charAt(i + 8)) == 'T' &&
			Character.toUpperCase(content.charAt(i + 9)) == 'E' &&
			Character.toUpperCase(content.charAt(i + 10)) == ' ' &&
			Character.toUpperCase(content.charAt(i + 11)) == 'D' &&
			Character.toUpperCase(content.charAt(i + 12)) == 'O' &&
			Character.toUpperCase(content.charAt(i + 13)) == ' ' &&
			Character.toUpperCase(content.charAt(i + 14)) == 'B' &&
			Character.toUpperCase(content.charAt(i + 15)) == 'R' &&
			Character.toUpperCase(content.charAt(i + 16)) == 'A' &&
			Character.toUpperCase(content.charAt(i + 17)) == 'S' &&
			Character.toUpperCase(content.charAt(i + 18)) == 'I' &&
			Character.toUpperCase(content.charAt(i + 19)) == 'L' &&
			Character.toUpperCase(content.charAt(i + 20)) == '\n') &&
			!foundId) {
				j = i;

				while (content.charAt(j) != '\n') {
					id = content.charAt(j) + id;
					j--;
				}

				if (isInt(String.valueOf(id.charAt(0)))) {
					p.setId(Integer.parseInt(String.valueOf(id.charAt(0))));

					if (isInt(String.valueOf(id.charAt(1)))) {
						p.setId(p.getId() * 10);
						p.setId(p.getId() + 
							Integer.parseInt(String.valueOf(id.charAt(1))));
					}
				}

				foundId = true;
			}

			// Find mandate
			if ((Character.toUpperCase(content.charAt(i)) == 'P' &&
			Character.toUpperCase(content.charAt(i + 1)) == 'E' &&
			Character.toUpperCase(content.charAt(i + 2)) == 'R' &&
			Character.toUpperCase(content.charAt(i + 3)) == (char) 205 && // Í
			Character.toUpperCase(content.charAt(i + 4)) == 'O' &&
			Character.toUpperCase(content.charAt(i + 5)) == 'D' &&
			Character.toUpperCase(content.charAt(i + 6)) == 'O' &&
			Character.toUpperCase(content.charAt(i + 7)) == '\n') && 
			!foundMandate) {
				j = i + 9;

				while (content.charAt(j) != '\n') {
					mandate += content.charAt(j);
					j++;
				}

				for (int k = 0; k < 4; k++)
					auxYear += mandate.split(" ")[4].charAt(k);

				auxDay = String.valueOf(mandate.split(" ")[0].charAt(0));

				if (mandate.split(" ")[0].length() > 1 && isInt(String.valueOf(mandate.split(" ")[0].charAt(1))))
					auxDay += String.valueOf(mandate.split(" ")[0].charAt(1));

				p.setInicioMandato(auxDay, 
					mandate.split(" ")[2], 
					auxYear);

				if (mandate.endsWith(auxYear))
					mandate = mandate
						.split(auxYear)[1]
						.trim() + " " + auxYear;
				else
					mandate = mandate
						.split(auxYear)[1]
						.trim();

				if (mandate.contains("&#32;")) {
					mandate = mandate.split("&#32;")[2];

					auxYear = "";
					auxDay = String.valueOf(mandate.split(" ")[0].charAt(0));

					if (mandate.split(" ")[0].length() > 1 && isInt(String.valueOf(mandate.split(" ")[0].charAt(1))))
						auxDay += String.valueOf(mandate.split(" ")[0].charAt(1));

					for (int k = 0; k < 4; k++)
						auxYear += mandate.split(" ")[4].charAt(k);

					p.setFimMandato(auxDay, 
						mandate.split(" ")[2], 
						auxYear);
				}

				else {
					auxYear = "";
					auxDay = String.valueOf(mandate.split(" ")[1].charAt(0));

					if (mandate.split(" ")[1].length() > 1 && isInt(String.valueOf(mandate.split(" ")[1].charAt(1))))
						auxDay += String.valueOf(mandate.split(" ")[1].charAt(1));

					for (int k = 0; k < 4; k++)
						auxYear += mandate.split(" ")[5].charAt(k);

					p.setFimMandato(auxDay, 
						mandate.split(" ")[3], 
						auxYear);
				}

				foundMandate = true;
			}

			// Find vice-president
			if ((Character.toUpperCase(content.charAt(i)) == 'V' &&
			Character.toUpperCase(content.charAt(i + 1)) == 'I' &&
			Character.toUpperCase(content.charAt(i + 2)) == 'C' &&
			Character.toUpperCase(content.charAt(i + 3)) == 'E' &&
			Character.toUpperCase(content.charAt(i + 4)) == '-' &&
			Character.toUpperCase(content.charAt(i + 5)) == 'P' &&
			Character.toUpperCase(content.charAt(i + 6)) == 'R' &&
			Character.toUpperCase(content.charAt(i + 7)) == 'E' &&
			Character.toUpperCase(content.charAt(i + 8)) == 'S' &&
			Character.toUpperCase(content.charAt(i + 9)) == 'I' &&
			Character.toUpperCase(content.charAt(i + 10)) == 'D' &&
			Character.toUpperCase(content.charAt(i + 11)) == 'E' &&
			Character.toUpperCase(content.charAt(i + 12)) == 'N' &&
			Character.toUpperCase(content.charAt(i + 13)) == 'T' &&
			Character.toUpperCase(content.charAt(i + 14)) == 'E' &&
			Character.toUpperCase(content.charAt(i + 15)) == '\n' &&
			Character.toUpperCase(content.charAt(i + 16)) == '\n') &&
			!foundVice) {
				j = i + 17;

				while (content.charAt(j) != '\n') {
					p.setVice(p.getVice() + content.charAt(j));
					j++;
				}

				foundVice = true;
			}

			// Find predecessor
			if ((Character.toUpperCase(content.charAt(i)) == 'A' &&
			Character.toUpperCase(content.charAt(i + 1)) == 'N' &&
			Character.toUpperCase(content.charAt(i + 2)) == 'T' &&
			Character.toUpperCase(content.charAt(i + 3)) == 'E' &&
			Character.toUpperCase(content.charAt(i + 4)) == 'C' &&
			Character.toUpperCase(content.charAt(i + 5)) == 'E' &&
			Character.toUpperCase(content.charAt(i + 6)) == 'S' &&
			Character.toUpperCase(content.charAt(i + 7)) == 'S' &&
			Character.toUpperCase(content.charAt(i + 8)) == 'O' &&
			Character.toUpperCase(content.charAt(i + 9)) == 'R' &&
			Character.toUpperCase(content.charAt(i + 10)) == '\n') &&
			!foundPredecessor) {
				j = i + 12;

				while (content.charAt(j) != '\n') {
					p.setAntecessor(p.getAntecessor() + content.charAt(j));
					j++;
				}

				foundPredecessor = true;
			}

			// Find successor
			if ((Character.toUpperCase(content.charAt(i)) == 'S' &&
			Character.toUpperCase(content.charAt(i + 1)) == 'U' &&
			Character.toUpperCase(content.charAt(i + 2)) == 'C' &&
			Character.toUpperCase(content.charAt(i + 3)) == 'E' &&
			Character.toUpperCase(content.charAt(i + 4)) == 'S' &&
			Character.toUpperCase(content.charAt(i + 5)) == 'S' &&
			Character.toUpperCase(content.charAt(i + 6)) == 'O' &&
			Character.toUpperCase(content.charAt(i + 7)) == 'R' &&
			Character.toUpperCase(content.charAt(i + 8)) == '\n') &&
			!foundSuccessor) {
				j = i + 10;

				while (content.charAt(j) != '\n') {
					p.setSucessor(p.getSucessor() + content.charAt(j));
					j++;
				}

				foundSuccessor = true;
			}

			// Find name
			if (Character.toUpperCase(content.charAt(i)) == 'N' &&
			Character.toUpperCase(content.charAt(i + 1)) == 'O' &&
			Character.toUpperCase(content.charAt(i + 2)) == 'M' &&
			Character.toUpperCase(content.charAt(i + 3)) == 'E' &&
			Character.toUpperCase(content.charAt(i + 4)) == ' ' &&
			Character.toUpperCase(content.charAt(i + 5)) == 'C' &&
			Character.toUpperCase(content.charAt(i + 6)) == 'O' &&
			Character.toUpperCase(content.charAt(i + 7)) == 'M' &&
			Character.toUpperCase(content.charAt(i + 8)) == 'P' &&
			Character.toUpperCase(content.charAt(i + 9)) == 'L' &&
			Character.toUpperCase(content.charAt(i + 10)) == 'E' &&
			Character.toUpperCase(content.charAt(i + 11)) == 'T' &&
			Character.toUpperCase(content.charAt(i + 12)) == 'O') {
				j = i + 15;

				while (content.charAt(j) != '\n') {
					p.setNome(p.getNome() + content.charAt(j));
					j++;
				}
			}

			// Find date and place of birth
			if ((Character.toUpperCase(content.charAt(i)) == 'N' &&
			Character.toUpperCase(content.charAt(i + 1)) == 'A' &&
			Character.toUpperCase(content.charAt(i + 2)) == 'S' &&
			Character.toUpperCase(content.charAt(i + 3)) == 'C' &&
			Character.toUpperCase(content.charAt(i + 4)) == 'I' &&
			Character.toUpperCase(content.charAt(i + 5)) == 'M' &&
			Character.toUpperCase(content.charAt(i + 6)) == 'E' &&
			Character.toUpperCase(content.charAt(i + 7)) == 'N' &&
			Character.toUpperCase(content.charAt(i + 8)) == 'T' &&
			Character.toUpperCase(content.charAt(i + 9)) == 'O' &&
			Character.toUpperCase(content.charAt(i + 10)) == '\n') &&
			!foundPlaceBirth) {
				j = i + 12;

				while (content.charAt(j) != '\n') {
					nasc += content.charAt(j);
					j++;
				}

				p.setDataNascimento(nasc.split(" ")[0], 
					nasc.split(" ")[2], 
					nasc.split(" ")[4]
						.split("&")[0]);

				auxIdade = nasc.split("&#160;\\(");
				auxLocalNasc = nasc.split(" ");

				if (auxIdade.length > 1) {
					p.setIdade(Integer.parseInt(auxIdade[1]
						.split("&#160;")[0]));
					p.setMorreu(false);
				}

				cAuxLocalNasc = auxLocalNasc.length;

				if (cAuxLocalNasc > 4) {
					p.setLocalNascimento(auxLocalNasc[5]);

					for (int k = 6; k < cAuxLocalNasc; k++) {
						p.setLocalNascimento(p.getLocalNascimento() + " " +
							auxLocalNasc[k]);
					}
				}

				foundPlaceBirth = true;
			}

			// Find date and place of death
			if ((Character.toUpperCase(content.charAt(i)) == 'M' &&
			Character.toUpperCase(content.charAt(i + 1)) == 'O' &&
			Character.toUpperCase(content.charAt(i + 2)) == 'R' &&
			Character.toUpperCase(content.charAt(i + 3)) == 'T' &&
			Character.toUpperCase(content.charAt(i + 4)) == 'E' &&
			Character.toUpperCase(content.charAt(i + 6)) == '\n' &&
			Character.toUpperCase(content.charAt(i - 1)) == '\n') &&
			!foundDeathLocal) {
				j = i + 7;

				p.setMorreu(true);

				while (content.charAt(j) != '\n') {
					morte += content.charAt(j);
					j++;
				}

				p.setDataMorte(morte.split(" ")[0], 
					morte.split(" ")[2], 
					morte.split(" ")[4]
						.split("&")[0]);
				p.setIdade(Integer.parseInt(morte
					.split("&#160;\\(")[1]
					.split("&")[0]));
				p.setLocalMorte(morte.split("&#160;anos\\) ")[1]);

				foundDeathLocal = true;
			}

			p.setIdade(LocalDateTime.now().getYear() - 
				p.getDataNascimento().getYear());
		}

		return p;
	}

	/** 
    * Remove HTML tags from a string.
    * @author Kaiser Gabriel Santos
	 * @since 25/02/2019
    * @param String content is the HTML page that be analised.
    * @return string with the content without HTML tags.
    */
	 private static String removeTags(String content) {
		return content.replaceAll("<[^>]*>", "");
	}

	/** 
    * Return the number of a month.
    * @author Kaiser Gabriel Santos
	 * @since 25/02/2019
    * @param String month is the name of the month that be analised.
    * @return int with the number of the month.
    */
	public static int getNumberOfMonth(String month) {
		int monthNum = 1;

		switch (month.toUpperCase()) {
			case "JANEIRO":
				monthNum = 1;
				break;
			case "FEVEREIRO":
				monthNum = 2;
				break;
			case "MAR" + ((char) 199) + "O":
			case "MARCO":
				monthNum = 3;
				break;
			case "ABRIL":
				monthNum = 4;
				break;
			case "MAIO":
				monthNum = 5;
				break;
			case "JUNHO":
				monthNum = 6;
				break;
			case "JULHO":
				monthNum = 7;
				break;
			case "AGOSTO":
				monthNum = 8;
				break;
			case "SETEMBRO":
				monthNum = 9;
				break;
			case "OUTUBRO":
				monthNum = 10;
				break;
			case "NOVEMBRO":
				monthNum = 11;
				break;
			case "DEZEMBRO":
				monthNum = 12;
				break;
		}

		return monthNum;
	}

   /** 
    * Verify if a String is an integer number.
    * @author Kaiser Gabriel Santos
	 * @since 05/02/2019
    * @param String p is the String that be analised.
    * @return boolean true if the words can be converted to int 
    * or false, otherwise.
    */
   private static boolean isInt(String p) {
      int aux = 0;
      boolean result = false;

      for (int i = 0; i < p.length(); i++) {
         if (p.charAt(i) >= '0' && p.charAt(i) <= '9')
            aux++;
      }

      if (p.length() == aux) 
         result = true;

      return result;
	}

}
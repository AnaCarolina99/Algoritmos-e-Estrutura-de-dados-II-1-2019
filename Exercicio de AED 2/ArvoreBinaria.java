/**
 * No da arvore binaria
 * @author Max do Val Machado
 */
class No {
	public int elemento; // Conteudo do no.
	public No esq, dir;  // Filhos da esq e dir.

	/**
	 * Construtor da classe.
	 * @param elemento Conteudo do no.
	 */
	public No(int elemento) {
		this(elemento, null, null);
	}

	/**
	 * Construtor da classe.
	 * @param elemento Conteudo do no.
	 * @param esq No da esquerda.
	 * @param dir No da direita.
	 */
	public No(int elemento, No esq, No dir) {
		this.elemento = elemento;
		this.esq = esq;
		this.dir = dir;
	}
}

/**
 * Arvore binaria de pesquisa
 * @author Max do Val Machado
 */
public class ArvoreBinaria {
	private No raiz; // Raiz da arvore.
      public int cont = 0;
   public int cont2 = 0;

	/**
	 * Construtor da classe.
	 */
	public ArvoreBinaria() {
		raiz = null;
	}

       public int pesq4(){
       return pesq4(raiz);
       }


   public int pesq4(No i){
   int resp = 0;
      if(i!=null){
          if ( i.elemento % 4==0 ) {
         resp += i.elemento;
         cont++;

      }
      resp +=pesq4( i.esq);
      resp +=pesq4( i.dir);
      }

      return resp;

   }

   public boolean pesq44(){
       return pesq44(raiz);
       }


   public boolean pesq44(No i){
   boolean resp = false;
      if(i!=null){
          if ( cont == cont2 ) {
         resp = true;
      }
       pesq44( i.esq);
       pesq44( i.dir);
      }

      return resp;

   }


	 public boolean completa(){
		 boolean resp = false;
		 	double veri1 = 0;
			double veri2 = 0;
			double altura = getAltura();
			veri1 = (Math.pow(2,altura) - 1) + (Math.pow(2,altura));
			veri2 = (Math.pow(2,altura+ 1)) - 1;
			System.out.println("Altura 1: " +veri1);
			System.out.println("Altura 2: " +veri2);
					if(veri1 == veri2){
						resp = true;
					}
					else{
						resp = false;
					}

			return resp;
	 }

	 public int getAltura(){
		 return getAltura(raiz);
 }

 public int getAltura(No r){
		 if(r == null){
			 return -1;
		 }
		 else{
			 int he = getAltura(r.esq);
			 int hd = getAltura(r.dir);
				 if(he<hd){
					 return hd + 1;
				 }
				 else{
					 return he+1;
				 }
		 }
 }



	/**
	 * Metodo publico iterativo para pesquisar elemento.
	 * @param x Elemento que sera procurado.
	 * @return <code>true</code> se o elemento existir,
	 * <code>false</code> em caso contrario.
	 */
	public boolean pesquisar(int x) {
		return pesquisar(x, raiz);
	}

	/**
	 * Metodo privado recursivo para pesquisar elemento.
	 * @param x Elemento que sera procurado.
	 * @param i No em analise.
	 * @return <code>true</code> se o elemento existir,
	 * <code>false</code> em caso contrario.
	 */
	private boolean pesquisar(int x, No i) {
      boolean resp;
		if (i == null) {
         resp = false;

      } else if (x == i.elemento) {
         resp = true;

      } else if (x < i.elemento) {
         resp = pesquisar(x, i.esq);

      } else {
         resp = pesquisar(x, i.dir);
      }
      return resp;
	}

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
			System.out.print(i.elemento + " "); // Conteudo do no.
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
			System.out.print(i.elemento + " "); // Conteudo do no.
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
			System.out.print(i.elemento + " "); // Conteudo do no.
		}
	}


	/**
	 * Metodo publico iterativo para inserir elemento.
	 * @param x Elemento a ser inserido.
	 * @throws Exception Se o elemento existir.
	 */
	public void inserir(int x){
		raiz = inserir(x, raiz);
	}

	/**
	 * Metodo privado recursivo para inserir elemento.
	 * @param x Elemento a ser inserido.
	 * @param i No em analise.
	 * @return No em analise, alterado ou nao.
	 * @throws Exception Se o elemento existir.
	 */
	private No inserir(int x, No i)  {
		if (i == null) {
         i = new No(x);
         cont2++;

      } else if (x < i.elemento) {
         i.esq = inserir(x, i.esq);

      } else if (x > i.elemento) {
         i.dir = inserir(x, i.dir);
      }

		return i;
	}

	/**
	 * Metodo publico iterativo para remover elemento.
	 * @param x Elemento a ser removido.
	 * @throws Exception Se nao encontrar elemento.
	 */
	public void remover(int x) throws Exception {
		raiz = remover(x, raiz);
	}

	/**
	 * Metodo privado recursivo para remover elemento.
	 * @param x Elemento a ser removido.
	 * @param i No em analise.
	 * @return No em analise, alterado ou nao.
	 * @throws Exception Se nao encontrar elemento.
	 */
	private No remover(int x, No i) throws Exception {

		if (i == null) {
         throw new Exception("Erro ao remover!");

      } else if (x < i.elemento) {
         i.esq = remover(x, i.esq);

      } else if (x > i.elemento) {
         i.dir = remover(x, i.dir);

      // Sem no a direita.
      } else if (i.dir == null) {
         i = i.esq;

      // Sem no a esquerda.
      } else if (i.esq == null) {
         i = i.dir;

      // No a esquerda e no a direita.
      } else {
         i.esq = antecessor(i, i.esq);
		}

		return i;
	}

	/**
	 * Metodo para trocar no removido pelo antecessor.
	 * @param i No que teve o elemento removido.
	 * @param j No da subarvore esquerda.
	 * @return No em analise, alterado ou nao.
	 */
	private No antecessor(No i, No j) {

      // Existe no a direita.
		if (j.dir != null) {
         // Caminha para direita.
			j.dir = antecessor(i, j.dir);

      // Encontrou o maximo da subarvore esquerda.
		} else {
			i.elemento = j.elemento; // Substitui i por j.
			j = j.esq; // Substitui j por j.ESQ.
		}
		return j;
	}

	public boolean elemento(){
	    return binariaCompleta(raiz);
	}

	public boolean binariaCompleta(No i){
	    boolean resp = false;
	    if(i != null){
	        if(i.esq != null && i.dir != null)
	            resp = binariaCompleta(i.esq) && binariaCompleta(i.dir);
	        else if(i.esq == null && i.dir == null)
	            resp = true;
	        else
	            resp = false;
	    }
	    return resp;
	}
}

//Podera cair na prova entao decora


/*
    preencher a árvore com 30 valores aleatorios(ramdom)


public int soma(){
    return soma(this.root,0);
}

public int soma(no i, int soma){
    if(i != null){
        if(i.elemento % 4 == 0){
            soma(i.esquerda, soma + i.elemento);
            soma(i.direita, soma + i.elemento);
        }
        else{
            soma(i.esquerda, soma);
            soma(i.direira, soma);
        }
    return soma;
}

/*
    verificar (true/false) se todos os elementos sao multiplos de 4

public boolean multiplo(){
    return multiplo(this.root);
}

public boolean multiplo(No i){
    boolean resp = false;
    if(i != null){
        if(i.elemento % 4 == 0)
            resp = multiplo(i.esquerda) && multiplo(i.direita);
        else
            resp = false;
    }
    return resp;
}


/*
   fazer o merge de duas arvores binarias

public No merge(No a1, No a2){
    No a3;
    a3 = merge(a1,a3);
    a3 = merge(a1,a3);
    return a3;
}

public No merge(No a1, No a2){
    if(a1 != null){
        a2 = adicionar(a1.elemento, a2);
        a2 = merge(a1.esquerda, a2);
        a2 = merge(a1.direira, a2);
    }
    return a2;
}


/*
    Verificar se a arvore binaria é ou não completa

public int elemento(No i){
    return binariaCompleta(this.root);
}

public boolean binariaCompleta(Node i){
    boolean resp = false;
    if(i != null){
        if(i.esquerda != null && i.direita != null)
            resp = binariaCompleta(i.esquerda) && binariaCompleta(i.direita);
        else if(i.esquerda == null && i.direta == null)
            resp = true;
        else
            resp = false
    }
    return resp;
}*/

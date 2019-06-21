package TrabDicionario;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Arquivo {
    
    private List<Node> roots;
    
    public Arquivo(){
        this.roots = new ArrayList<>();
    }
    
    private static final class Node {

        public Node father;
        public char element;
        public String significado;
        public List<Node> filhos;

        public Node(char element) {
            father = null;
            this.element = element;
            this.significado = null;
            this.filhos = new LinkedList<>();
        }
    }

	public void leitura() { // O(n)
		
        Path path1 = Paths.get("nomes.csv");
		try (Scanner sc = new Scanner(Files.newBufferedReader(path1, Charset.defaultCharset()))) {
			sc.useDelimiter("[;\n]");
			while (sc.hasNext()) {
            String palavra = sc.next();
            String sig = sc.next();
            addNode(palavra, sig);
			}

		} catch (IOException x) {
			System.err.format("Erro de E/S: %s%n", x);
		}

    }

    public ArrayList<Palavra> buscaPalavras(String entrada) {
        if(entrada == null) return null;
        
        ArrayList<Palavra> listaDePalavras = new ArrayList<>();
        entrada = entrada.toUpperCase();
        
        Node root = getRoot(entrada.charAt(0));
        Node subRoot = subTree(root, entrada, 1);
        
        listaDePalavras = positionsPreAux(subRoot, "", entrada, listaDePalavras);
        
        return listaDePalavras;
    }

    private ArrayList<Palavra> positionsPreAux(Node n, String palavraIncompleta, String iniciais, ArrayList<Palavra> listaDePalavras) {
        if(n == null)
            return listaDePalavras;
        if(n.significado != null && n.significado != "") {
            String iniciaisAux = "";
            if (iniciais.length() > 0) {
                for (int i = 0; i < iniciais.length() - 1; i++) {
                    iniciaisAux += iniciais.charAt(i);
                }
            }
            listaDePalavras.add(new Palavra(iniciaisAux + palavraIncompleta + n.element, n.significado));
        }
        if(n.filhos != null) {
            for (int i = 0; i < n.filhos.size(); i++) {
                positionsPreAux(n.filhos.get(i), palavraIncompleta + n.element, iniciais, listaDePalavras);
            }
        }
        return listaDePalavras;
    }

    private Node subTree(Node raiz, String entrada, int pos){ // O(n)
	
        if(raiz == null) {
            return raiz;
        }

        if (pos == entrada.length()) {
            return raiz;
        }

        if(raiz.filhos != null) {
            for (int i = 0; i < raiz.filhos.size(); i++) {
                if (raiz.filhos.get(i).element == entrada.charAt(pos)) {
                    raiz = subTree(raiz.filhos.get(i), entrada, pos + 1);
                    break;
                }
            }
        }
        return raiz;
    }

    private Node getRoot(char c) { // O(n)
        Node arvoreRoot = null;

        for (int i = 0; i < roots.size(); i++) {
            if (c == roots.get(i).element) {
                arvoreRoot = roots.get(i);
                break;
            }
        }
        if (arvoreRoot == null) {
            Node aux = new Node(c);
            roots.add(aux);
            arvoreRoot = aux;
        }
        return arvoreRoot;
    }


    public void addNode(String palavra, String sig) {

        Node root = getRoot(palavra.charAt(0));
        addNodeAux(palavra.toUpperCase(), sig, 1, root, "");

    }

    private void addNodeAux(String palavra, String sig, int pos, Node n, String print) {
        if (pos == palavra.length()) {
            n.significado = sig;
            return;
        }

        char letra = palavra.charAt(pos);
        Node aux = null;

        for (int i = 0; i < n.filhos.size(); i++) {
            if (letra == n.filhos.get(i).element) {
                aux = n.filhos.get(i);
                break;
            }
        }

        if (aux == null) {
            aux = new Node(letra);
            n.filhos.add(aux);
        }

        addNodeAux(palavra, sig, pos + 1, aux, print + letra);

    }
}


import java.util.NoSuchElementException;
import java.util.Objects;

public class BinaryTreeOfInteger {

    private static final class Node {
        public Node father;
        public Node left;
        public Node right;
        private Integer element;
        public Node(Integer element) {
            father = null;
            left = null;
            right = null;
            this.element = element;
        }
    }

    // Atributos
    private int count; //total de elementos da arvore
    private Node root; //referencia para o nodo raiz da arvore

    // Metodos
    public BinaryTreeOfInteger() {
        count = 0;
        root = null;
    }

    public void clear() {
        count = 0;
        root = null;
    }

    public boolean isEmpty() {
        return (root == null);
    }

    public int size() {
        return count;
    }

    public Integer getRoot() {
        if (isEmpty()) {
            throw new EmptyTreeException();
        }
        return root.element;
    }

    public void setRoot(Integer element) {
        if (isEmpty()) {
            throw new EmptyTreeException();
        }
        root.element = element;
    }

    public boolean addRoot(Integer element) {
        if (root != null) {
            return false;
        }
        Node node = new Node(element);
        root = node;
        count++;
        return true;
    }

    public boolean addLeft(Integer element, Integer father) {
        Node n = searchNodeRef(father, root);
        if (n == null) {
            return false;
        }
        if (n.left != null) {
            return false;
        }
        Node left = new Node(element);
        n.left = left;
        left.father = n;
        count++;
        return true;
    }
  
    public boolean addRight(Integer element, Integer father) {
        Node n = searchNodeRef(father, root);
        if (n == null) {
            return false;
        }
        if (n.right != null) {
            return false;
        }
        Node right = new Node(element);
        n.right = right;
        right.father = n;
        count++;
        return true;
    }

    public boolean isExternal(int element) {
        Node n = searchNodeRef(element, root);
        if (n != null) {
            if (n.left == null && n.right == null) {
                return true;
            }
        }
        return false;
    }

    public boolean isInternal(int element) {
        Node n = searchNodeRef(element, root);
        if (n != null) {
            if (n.left != null || n.right != null) {
                return true;
            }
        }
        return false;
    }

    public boolean hasLeft(Integer element) {
        Node n = searchNodeRef(element, root);
        if (n != null) {
            if (n.left != null) {
                return true;
            }
        }
        return false;
    }

    public boolean hasRight(Integer element) {
        Node n = searchNodeRef(element, root);
        if (n != null) {
            if (n.right != null) {
                return true;
            }
        }
        return false;
    }

    public Integer getLeft(Integer element) {
        Integer res = null;
        Node nAux = searchNodeRef(element, root);
        if (nAux != null) {
            if (nAux.left != null) {
                res = nAux.left.element;
            }
        }
        return res;
    }

    public Integer getRight(Integer element) {
        Integer res = null;
        Node nAux = searchNodeRef(element, root);
        if (nAux != null) {
            if (nAux.right != null) {
                res = nAux.right.element;
            }
        }
        return res;
    }

    public Integer getParent(Integer element) {
        Node n = this.searchNodeRef(element, root);
        if (n == null) {
            return null;
        } else if (n.father==null) {
            return null;
        }else {
            return n.father.element;
        }
    }    
    
    public boolean removeBranch(Integer element) {
        Node nAux = null;
        Node father = null;
        boolean rem = false;
        if (root != null) {
            if (root.element.equals(element)) {
                root = null;
                count = 0;
                rem = true;
            } else {
                nAux = searchNodeRef(element, root);
                if (nAux != null) {
                    father = nAux.father;
                    if (father.left == nAux) {
                        father.left = null;
                    } else {
                        father.right = null;
                    }
                    count = count - size(nAux);
                    rem = true;
                }
            }
        }
        return rem;
    }
    
    public boolean contains(Integer element) {
        Node nAux = searchNodeRef(element, root);
        return (nAux != null);
    }

    private Node searchNodeRef(Integer element, Node target) {
        Node res = null;
        if (target != null) {
            if (target.element.equals(element)) {
                res = target;
            } else {
                res = searchNodeRef(element, target.left);
                if (res == null) {
                    res = searchNodeRef(element, target.right);
                }
            }
        }
        return res;
    }
    

    ////////////////////////////////////////////////////
    // Implemente os métodos abaixo
    ////////////////////////////////////////////////////
    
    /**
     * Conta o total de nodos da subarvore cuja raiz esta sendo passada por 
     * parametro.
     * @param n referencia para o nodo a partir do qual sera feita a contagem
     * @return 
     */
    private int size(Node n) {
        return 0;
    }

    /** 
     * Retorna uma lista com todos os elementos da arvore na ordem de 
     * caminhamento pre-fixada. Deve chamar um metodo auxiliar recursivo.
     * @return LinkedListOfInteger lista com os elementos da arvore
     */
    public LinkedListOfInteger positionsPre() {
        return null;
    }

    /** 
     * Retorna uma lista com todos os elementos da arvore na ordem de 
     * caminhamento pos-fixada. Deve chamar um metodo auxiliar recursivo.
     * @return LinkedListOfInteger lista com os elementos da arvore
     */
    public LinkedListOfInteger positionsPos() {
        return null;
    }

    /** 
     * Retorna uma lista com todos os elementos da arvore na ordem de 
     * caminhamento central. Deve chamar um metodo auxiliar recursivo.
     * @return LinkedListOfInteger lista com os elementos da arvore
     */    
    public LinkedListOfInteger positionsCentral() {
        return null;
    }
    
    /** 
     * Retorna uma lista com todos os elementos da arvore na ordem de 
     * caminhamento em largura. 
     * @return LinkedListOfInteger lista com os elementos da arvore
     */  
    public LinkedListOfInteger positionsWidth() {
        LinkedListOfInteger res = new LinkedListOfInteger();

        return res;
    }

    /** 
     * Retorna uma string que contem todos os elementos da arvore na ordem de 
     * caminhamento central. Deve chamar um metodo auxiliar recursivo.
     * @return String com todos os elementos da arvore
     */     
    public String strPositionsCentral() {
        return "";
    }

    /**
     * Retorna o nivel do nodo no qual esta armazenado o elemento
     * passadado por parametro.
     * @param element o elemento que se quer saber o nivel.
     * @return o nivel do nodo onde esta o elemento, ou -1 se nao
     * encontrou o elemento.
     */
    public int level(Integer element) {
        return -1;
    }
   
    /**
     * Retorna a altura da arvore. Deve chamar um metodo auxiliar recursivo.
     * @return altura da arvore
     */
    public int height() {
        return -1;
    }
}

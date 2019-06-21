import java.util.EmptyStackException;

public class Pilha {

    /*
    * Implemete uma classe Pilha para manipular elementos do tipo inteiro
    * Considere os métodos: push, pop, isEmpty, isFull, top
    * Faça o teste dessa implementação considerando todos os métodos criados (utilize a MainClass que já esta criada).
    * */
    private int top;
    private int count;
    private char[] elem;
    //método construtor para uma estrutura de pilha estática
    public Pilha(int tam){
        elem = new char[tam];
        top = -1;

    }
    public void push(char e) {
        if(this.isFull())
            throw new ArrayIndexOutOfBoundsException();
        else{
            top++;
            elem[top] = e;
            count++;
        }
    }

    public char pop(){
        if(isEmpty()){throw new IllegalArgumentException();}
        else{
            char aux = elem[top];
            elem[top]= 0;
            top--;
            count--;
            return aux;
        }
    }

    public boolean isEmpty(){
        if(count==0){return true;}
        else{return false;}
    }

    public boolean isFull(){
        if (count == elem.length)
            return true;
        else
            return false;
    }

    public char top(){
        if (isEmpty()){
            throw new EmptyStackException();
        }

        return elem[top];
    }

}

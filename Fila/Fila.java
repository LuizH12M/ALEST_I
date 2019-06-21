public class Fila {
    private int first;
    private int last;
    private int count;
    private int[] data;

    //criando o método construtor
    public Fila(int size) {
    data = new int[size];
    first = 0;
    last= 0;
    count = 0;



    }

    //adiciona elemento a fila
    public void enqueue (int elemento) {
        if(!isFull()){
            data[last] = elemento;
            count++;
            if(last == data.length-1) {
                last = 0;
            } else {
                last++;
            }
        }else{
            throw new RuntimeException("A fila está cheia");
        }

    }

    //remove elemento da fila e retorna quem foi retirado
    public int dequeue() {
        if (!isEmpty()){
            int e = data[first];
            count --;
            if(first == data.length-1) {
                first = 0;
            } else {
                first++;
            }
            return e;
        }
        else{
            throw new RuntimeException("A fila está vazia");
        }
    }

    //confirma se a fila está vazia
    public boolean isEmpty() {
        if(count == 0)
            return true;
        else
            return false;
    }

    //confirma se a fila está cheia
    public boolean isFull() {
        if (data.length==count)
            return true;
        else
            return false;
    }

    //retorna o número de elementos na fila
    public int size(){
        return count;
    }

    //retorna o elemento que esta na frente da fila
    public int front() {
        return data[first];
    }

    //public

}

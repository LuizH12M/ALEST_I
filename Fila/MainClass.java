public class MainClass {

    public  static void  main (String args[]) {

        //faça aqui os testes para classe Fila
        Fila f = new Fila(3);
        f.enqueue(1);
        System.out.println("elemento adicionado: " + f);
        f.enqueue(2);
        System.out.println("elemento adicionado: " + f[]);
        f.enqueue(3);
        System.out.println("elemento adicionado: " + f[]);
    }
}

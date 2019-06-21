import java.util.Arrays;

public class MainClass {

    public static void main(String args[]) {
//        //implemente a classe para fazer a validação da classe Pilha
//        Pilha p = new Pilha(5);
//        p.push(5);
//        System.out.println(p.top());
//
//        p.push(23);
//        System.out.println(p.top());
//
//        System.out.println("\nElemento removido:");
//        System.out.println(p.pop());
//        System.out.println(p.top());
//
//        p.push(6);
//        p.push(6);
//        p.push(6);
//        p.push(6);
//        p.push(6);
//
//        int[] nums = new int[5];
//        nums[0] = 1;
//        nums[1] = 2;
//        nums[2] = 3;
//        nums[3] = 4;
//        nums[4] = 5;
//
//        Pilha p = new Pilha(5);
//
//        for (int i = 0; i < nums.length; i++) {
//            p.push(nums[i]);
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = p.pop();
//        }
//
//        System.out.println(Arrays.toString(nums));


    }

    public boolean confereFechamento(String palavra)
    {


        int tam = palavra.length();
        if(tam%2 != 0)
        {
            return false;
        }

        Pilha p = new Pilha(tam/2);


    }

}

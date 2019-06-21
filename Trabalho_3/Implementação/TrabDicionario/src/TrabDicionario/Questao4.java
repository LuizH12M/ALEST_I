package TrabDicionario;

public class Questao4
{
    public static void main(String args[])
    {
        int a, b, x, i;
        a = 5;
        b = 3;
        i = 0;

        System.out.println("a no primeiro " + a);
        System.out.println("b no primeiro " + b);
        System.out.println("i no primeiro " + i);

        a = b * i;
        b = a + i;
        i = b - a;

        System.out.println("a no segundo " + a);
        System.out.println("b no segundo " + b);
        System.out.println("i no segundo " + i);

        int metodo1 = metodoQuestao4(a, b);
        System.out.println(metodo1);
    }

    public static int metodoQuestao4 (int num1, int num2)
    {
        System.out.println(num1);
        System.out.println(num2);
        int num3 = num1 * num2;
        System.out.println(num3);
        boolean b = (metodo2(num3, num1, num2));
        System.out.println(b);
        return num3;
    }

    public static boolean metodo2 (int num1, int num2, int num3)
    {
        boolean flag = false;
        if (num1 > (num2 + num3))
            flag = true;
        else
            flag = false;
        return flag;
    }
}

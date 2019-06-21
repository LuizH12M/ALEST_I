package implementação;

public class VoidException extends RuntimeException
{
    public static final String mensagem = "Stack is void!";

    public VoidException()
    {
        super(mensagem);   
    }
}

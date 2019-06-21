package implementação;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Calculadora {
    private Pilha p = new Pilha();
    private String[] line = new String[9];
    
    private String op, exp1, exp2, msg;
    private double resultado,num1,num2;
    private boolean erro, conta3valores;
    
    private String num;
    private int tam;
    
    //Leitura de Arquivo
    private File arquivo;
    private FileReader arquivoEntrada;
    private BufferedReader buffer;
    
    public void Calculadora(int n){
        tam = p.size();
        erro = false;
        conta3valores = false;
        System.out.println(line[n]);
        String[] aux = line[n].split(" ");
        for (int i = 0; i < aux.length; i++){
            if(conta3valores){
                conta3valores=false;
                i = i - 1;
            }else{
                p.push(aux[i]);
            }
            
            if(tam < p.size()){
                tam = p.size() - 1;
            }
            
            if(p.top().equals(")") || p.top().equals("}") || p.top().equals("]")){
                try{
                    exp2 = p.pop();
                    num2 = Double.parseDouble(p.pop());
                    op = p.pop();
                    num1 = Double.parseDouble(p.pop());
                    exp1 = p.pop();
                }catch(NumberFormatException e){
                    erro = true;
                    msg = "Falta de numero";
                }
                
                
                
                if(op.equals("+") || op.equals("/") || op.equals("*") 
                   || op.equals("-") || op.equals("^")){
                    
                }else{
                    erro = true;
                    msg = "Falta de operador";
                }
                if(!exp1.equals("(") && !exp1.equals("{") && !exp1.equals("[")){
                    conta3valores = true;
                }else if(exp1.equals("(")){
                    if(exp2.equals(")")){
                        
                    }else{
                        erro = true;
                        msg = exp2 + " no lugar de ) ";
                    }
                }else if(exp1.equals("[")){
                    if(exp2.equals("]")){
                        
                    }else{
                        erro = true;
                        msg = exp2 + " no lugar de ] ";
                    }
                }else if(exp1.equals("{")){
                    if(exp2.equals("}")){
                        
                    }else{
                        erro = true;
                        msg = exp2 + " no lugar de }";
                    }
                }else{
                    erro = true;
                    msg = "OPS! Voce esta tentanto desempilhar o simbolo errado";
                }
                if(erro){
                    break;
                }
                switch(op){
                    case "+": resultado = num1 + num2;
                        break;
                    case "-": resultado = num1 - num2;
                        break;
                    case "*": resultado = num1 * num2;
                        break;
                    case "/": resultado = num1 / num2;
                        break;
                    case "^": resultado = Math.pow(num1, num2);
                        break;
                }
                if(conta3valores){
                    p.push(exp1);
                    String add = Double.toString(resultado);
                    p.push(add);
                    p.push(exp2);
                }else{
                    String add = Double.toString(resultado);
                    p.push(add);
                }
            }
        }
    }
    
    public void print(){
        if(erro){
            System.out.println("Erro de sintaxe: " + msg);
        }else{    
            System.out.println("Resultado: " + p.top());
            System.out.println("Tamanho maximo da Pilha: "+tam);
        }
    }
    
    public void leArquivo(String s){
        int i = 0;
        String l;
        arquivo = new File(s);
        try
		{
			arquivoEntrada = new FileReader(arquivo);
			buffer = new BufferedReader(arquivoEntrada);
			while((l = buffer.readLine()) != null)
			{
                line[i] = l;
                i++;
			}
			buffer.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
        
    }
    
}

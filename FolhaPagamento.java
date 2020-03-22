package aula2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Natalia
 */
public class FolhaPagamento {
    
    private String nomeFuncionario;
    private float salarioFuncionario;
    
    public FolhaPagamento(String nomeFuncionario,float salarioFuncionario){
        this.nomeFuncionario=nomeFuncionario;
        this.salarioFuncionario=salarioFuncionario;
    }
    
    public float calculaINSS(float salario){
        float inss;
            
        if(salario <= 1045){
            inss = 0.75f;
        } 
        else if(salario > 1045 && salario <= 2089.60){
            inss = 0.09f;
        }
        else if(salario > 2089.60 && salario <= 3134.40){
            inss = 0.12f;
        }
        else{
            inss = 0.14f;
        }

        salario = (salario * inss);
        return (long)Math.round(salario);
    }
    
    public float calculaIR(float salario){
        float irrf;
        if(salario > 1903.98){
            irrf = 0.11f;
        }
        else{
            irrf = 0;
        }
        salario = (salario * irrf);
        return Math.round(salario);
    }
    
    public float calculaSalarioLiquido(float salario){
        return salario = salario - (calculaINSS(salario) + calculaIR(salario));
    }
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        System.out.println("Informe o nome do funcionário: ");
        String funcionario = in.next();
        
        System.out.println("Informe o salário do funcionário: ");
        float salario = in.nextFloat();
        String salarioString = Float.toString(salario);
        
        Map<String,String> funcionarios = new HashMap<String,String>();
        funcionarios.put(salarioString,funcionario);
        
        FolhaPagamento folha= new FolhaPagamento(funcionario,salario);
        System.out.println("Valor bruto do salário: R$" + folha.salarioFuncionario);
        System.out.println("Valor do desconto do IR: R$" + folha.calculaIR(folha.salarioFuncionario));
        System.out.println("Valor do desconto do INSS: R$" + folha.calculaINSS(folha.salarioFuncionario));
        System.out.println("Valor líquido do salário: R$" + folha.calculaSalarioLiquido(folha.salarioFuncionario));
    }
    
}

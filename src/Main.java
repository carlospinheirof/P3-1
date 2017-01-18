import java.util.Scanner;
public class Main {
	public static void main(String args[]) {
		Funcionario[] funcionarios = new Funcionario[50];
	    System.out.println("Olá, atenção, digite seu comando, podendo ser de 1 a 10, poderá ter no maximo 50 funcionários.");
	    System.out.println("1 - add um funcionario.");
	    System.out.println("2 - Remover um empregado.");
	    System.out.println("3 - Lancar um Cartao de Ponto.");
	    System.out.println("4 - Lancar um Resultado Venda.");
	    System.out.println("5 - Lancar uma taxa de servico.");
	    System.out.println("6 - Alterar detalhes de um empregado.");
	    System.out.println("7 - Rodar a folha de pagamento para hoje.");
	    System.out.println("8 - Undo/redo.");
	    System.out.println("9 - Agenda de Pagamento.");
	    System.out.println("10 - Criacao de Novas Agendas de Pagamento.");
	   int comando, NumeroDeFuncionarios = 0;
	   Scanner ler = new Scanner(System.in);
	    while(true){
	    	comando = ler.nextInt();
	    	if(comando < 1 || comando > 10){
	    		System.out.println("você digitou um comando inválido, tente novamente.");
	    	}
	    	else{
	    		if(comando == 1){
	    			System.out.println("você escolheu adicionar um funcionário");
	    			System.out.println("digite o nome do novo empregado");
	    			funcionarios[NumeroDeFuncionarios] = new Funcionario();
	    			
	    			funcionarios[NumeroDeFuncionarios].nome = ler.nextLine();
	    			
	    			NumeroDeFuncionarios++;
	    		}
	    	}
	    }
	}
}

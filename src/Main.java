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
	   String piu;
	   int i;
	   for(i=0; i<50; i++)
	   {
		   funcionarios[i] = new Funcionario();
		   funcionarios[i].EsseLocaleVago = 0;
		   funcionarios[i].numero = i;
		   
	   }
	    while(true){
	    	comando = ler.nextInt();
	    	piu = ler.nextLine();
	    	if(comando < 1 || comando > 10){
	    		System.out.println("você digitou um comando inválido, tente novamente.");
	    	}
	    	else{
	    		if(comando == 1){																//aqui começa a primeira etapa
	    			if(NumeroDeFuncionarios < 50){
	    			System.out.println("você escolheu adicionar um funcionário\n");
	    			System.out.println("\tdigite o nome do novo empregado");
	    				for(i = 0; funcionarios[i].EsseLocaleVago == 1; i++){}
	    			funcionarios[i].nome = ler.nextLine(); //adicionando o nome ao funcionario.	
	    			funcionarios[i].EsseLocaleVago = 1;
	    			System.out.println("\tdigite o tipo do funcionario, pelo que ele é pago.");
	    			System.out.println(" 1 - por hora\n 2 - salário\n 3 - por comissão");
	    			funcionarios[i].tipo = ler.nextInt(); //recebendo o seu tipo.
	    				if(funcionarios[i].tipo == 1){ //quanto ganha por determinada coisa.
	    					System.out.println("então, quanto ele ganha por hora ?");
	    					funcionarios[i].PorHora = ler.nextInt();
	    					piu = ler.nextLine();
	    					System.out.printf("%d\n", funcionarios[i].PorHora);
	    				}
	    				else if(funcionarios[i].tipo == 2){
	    					System.out.println("então, quanto ele ganha de salário ?");
	    					funcionarios[i].salario = ler.nextInt();
	    					piu = ler.nextLine();
	    					System.out.printf("%d\n", funcionarios[i].salario);
	    				}
	    				else{
	    					System.out.println("então, quanto ele ganha de comissão ?");
	    					funcionarios[i].comissao = ler.nextInt();
	    					piu = ler.nextLine();
	    					System.out.printf("%d\n", funcionarios[i].comissao);
	    				}
	    			System.out.println("\tqual o enderaço do novo funcionário?");
	    			funcionarios[i].endereco = ler.nextLine();
	    			System.out.printf("pronto!, o novo funcionario foi adicionado\nseu ID é : %d\n", funcionarios[i].numero);	
	    			System.out.printf("%s\n", funcionarios[i].nome);
	    			System.out.printf("%d\n", funcionarios[i].tipo);
	    			System.out.printf("%s\n", funcionarios[i].endereco);
	    			NumeroDeFuncionarios++;
	    			}
	    			else{
	    				System.out.println("você ja alcançou o total de funcionarios permitidos.");
	    			}
	    		}
	    	}
	    }
	}
}

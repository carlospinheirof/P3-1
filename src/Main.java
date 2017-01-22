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
	   int i, j, o;
	   float p;
	   int DiaAtualDoMes;
	   int DiaAtualDaSemana;
	   int exclusivoparaloop;
	   System.out.println("atenção, o estágiario não soube fazer o funcionamento da data direito, então ela só mudará quando você rodar a folha, logo só faça isso quando o ultimo funcionário bater o ponto do dia.");
	   System.out.println("digite o dia do més, entre 1 e 30");
	   i = ler.nextInt();
	   if(i < 1 || i > 30){
		   while(i < 1 || i > 30){
			   System.out.println("dia inválido, digite novamente");
			   i = ler.nextInt();
		   }
		   DiaAtualDoMes = i;
	   }
	   else{
		   DiaAtualDoMes = i;
	   }
	   
	   System.out.println("digite o dia da semana, entre 1 e 5, sendo 1 - segunda e 7 - sexta");
	   i = ler.nextInt();
	   if(i < 1 || i > 5){
		   while(i < 1 || i > 5){
			   System.out.println("dia inválido, digite novamente");
			   i = ler.nextInt();
		   }
		   DiaAtualDaSemana = i;
	   }
	   else{
		   DiaAtualDaSemana = i;
	   }
	   
	   for(i=0; i<50; i++)
	   {
		   funcionarios[i] = new Funcionario();
		   funcionarios[i].EsseLocaleVago = 0;
		   funcionarios[i].numero = i;
		   funcionarios[i].HorasTotais = 0;
		   funcionarios[i].HorasExtras = 0;
		   funcionarios[i].QuantoVendeu = 0;
		   funcionarios[i].TaxadeServico = 0;
		   funcionarios[i].FoiMotificado = 0;
	   }
	    while(true){
	    	System.out.println("digite seu comando");
	    	comando = ler.nextInt();
	    	piu = ler.nextLine();
	    	if(comando < 1 || comando > 10){
	    		System.out.println("você digitou um comando inválido, tente novamente.");
	    	}
	    	else{
	    		if(comando == 1){																//aqui começa a primeira etapa
	    			for(exclusivoparaloop = 0; exclusivoparaloop < 50; exclusivoparaloop++){
	    				funcionarios[exclusivoparaloop].FoiMotificado = 0;
	    			}
	    			/* espaço para a replicação */
	    			if(NumeroDeFuncionarios < 50){
	    			System.out.println("você escolheu adicionar um funcionário\n");
	    			System.out.println("digite o nome do novo empregado");
	    				for(i = 0; funcionarios[i].EsseLocaleVago == 1; i++){}
	    			funcionarios[i].nome = ler.nextLine(); //adicionando o nome ao funcionario.	
	    			funcionarios[i].EsseLocaleVago = 1;
	    			System.out.println("digite o tipo do funcionario, pelo que ele é pago.");
	    			System.out.println(" 1 - por hora\n 2 - salário\n 3 - por comissão");
	    			funcionarios[i].tipo = ler.nextInt(); //recebendo o seu tipo.
	    				if(funcionarios[i].tipo == 1){ //quanto ganha por determinada coisa.
	    					System.out.println("então, quanto ele ganha por hora ?");
	    					funcionarios[i].PorHora = ler.nextFloat();
	    					funcionarios[i].DiaDaSemana = 5;
	    					piu = ler.nextLine();
	    					//System.out.printf("%d\n", funcionarios[i].PorHora);
	    				}
	    				else if(funcionarios[i].tipo == 2){
	    					System.out.println("então, quanto ele ganha de salário ?");
	    					funcionarios[i].salario = ler.nextFloat();
	    					funcionarios[i].DiaDoMes = 30;
	    					piu = ler.nextLine();
	    					//System.out.printf("%d\n", funcionarios[i].salario);
	    				}
	    				else{
	    					System.out.println("então, quanto ele ganha de salário ?");
	    					funcionarios[i].salario = (ler.nextFloat())/2;
	    					System.out.println("então, quanto ele ganha de comissão ?");
	    					funcionarios[i].comissao = ler.nextFloat();
	    					funcionarios[i].DiaDaSemana = 5;
	    					funcionarios[i].ContadordeSemana = 0;
	    					piu = ler.nextLine();
	    					//System.out.printf("%d\n", funcionarios[i].comissao);
	    				}
	    			System.out.println("qual o enderaço do novo funcionário?");
	    			funcionarios[i].endereco = ler.nextLine();
	    			System.out.println("Como ele gostaria de receber?");
	    			System.out.println("1 - cheque pelos correios\n2 - cheque em mãos\n3 - depósito bancario");
	    			funcionarios[i].ComoRecebe = ler.nextInt();
	    			System.out.printf("pronto!, o novo funcionario foi adicionado\nseu ID é : %d\n", funcionarios[i].numero);	
	    		
	    			NumeroDeFuncionarios++;
	    			funcionarios[i].FoiMotificado = 1;
	    			}
	    			else{
	    				System.out.println("você ja alcançou o total de funcionarios permitidos.");
	    			}
	    		}
	    		else if(comando == 2){									//segunda opção
	    			for(exclusivoparaloop = 0; exclusivoparaloop < 50; exclusivoparaloop++){
	    				funcionarios[exclusivoparaloop].FoiMotificado = 0;
	    			}
	    			/* espaço para a replicação */
	    			System.out.println("você escolheu remover um funcionário\n");
	    			System.out.println("digite o ID do funcionario\n");
	    				i = ler.nextInt();
	    				piu = ler.nextLine();
	    			funcionarios[i].EsseLocaleVago = 0;
	    			System.out.println("removido com sucesso\n");
	    			NumeroDeFuncionarios--;
	    			funcionarios[i].FoiMotificado = 1;
	    		}
	    		else if(comando == 3){									// terceira opção
	    			for(exclusivoparaloop = 0; exclusivoparaloop < 50; exclusivoparaloop++){
	    				funcionarios[exclusivoparaloop].FoiMotificado = 0;
	    			}
	    			/* espaço para a replicação */
	    			System.out.println("você escolheu Lançar um Cartão de Ponto\n");
	    			System.out.println("Digite o ID do funcionário\n");
	    			i = ler.nextInt();
	    			System.out.println("Digite as horas trabalhadas\n");
	    			j = ler.nextInt();
	    			if(j <= 8){
	    				funcionarios[i].HorasTotais += j;
	    				
	    			}
	    			else{
	    				funcionarios[i].HorasTotais += 8;
	    				//System.out.printf("%d\n", funcionarios[i].HorasTotais);
	    				funcionarios[i].HorasExtras += j - 8;
	    				//System.out.printf("%d\n", funcionarios[i].HorasExtras);
	    			}
	    			System.out.println("ponto lançado com sucesso\n");
	    			funcionarios[i].FoiMotificado = 1;
	    		}
	    		else if(comando == 4){								// quarta opção 
	    			for(exclusivoparaloop = 0; exclusivoparaloop < 50; exclusivoparaloop++){
	    				funcionarios[exclusivoparaloop].FoiMotificado = 0;
	    			}
	    			/* espaço para a replicação */
	    			System.out.println("você escolheu Lançar uma venda\n");
	    			System.out.println("Informe o ID do funcionário que realizou a venda\n");
	    			i = ler.nextInt();
	    			System.out.println("Valor da venda\n");
	    			p = ler.nextFloat();
	    			funcionarios[i].QuantoVendeu += p;
	    			System.out.println("Venda adicionada corretamente\n");
	    			funcionarios[i].FoiMotificado = 1;
	    		}
	    		else if(comando == 5){							// quinta opção
	    			for(exclusivoparaloop = 0; exclusivoparaloop < 50; exclusivoparaloop++){
	    				funcionarios[exclusivoparaloop].FoiMotificado = 0;
	    			}
	    			/* espaço para a replicação */
	    			System.out.println("você escolheu lançar uma taxa de serviço");
	    			System.out.println("Digite o ID(do sindicato) referente ao funcionário");
	    			j = ler.nextInt();
	    			for(i = 0; funcionarios[i].IdDoSindicato == j; i++){}
	    			System.out.println("digite o valor da taxa");
	    			p = ler.nextFloat();
	    			funcionarios[i].TaxadeServico += p;
	    			System.out.println("Taxa de serviço adicionada com sucesso");
	    			funcionarios[i].FoiMotificado = 1;
	    		}
	    		else if(comando == 6){							// sexta opção
	    			for(exclusivoparaloop = 0; exclusivoparaloop < 50; exclusivoparaloop++){
	    				funcionarios[exclusivoparaloop].FoiMotificado = 0;
	    			}
	    			/* espaço para a replicação */
	    			System.out.println("Você escolheu alterar os dados do funcionário");
	    			System.out.println("Digite o ID do funcionário");
	    			i = ler.nextInt();
	    			piu = ler.nextLine();
	    			System.out.println("muito bem, agora para começar");
	    			System.out.println("Digite o nome do funcionário");
	    			funcionarios[i].nome = ler.nextLine();
	    			//System.out.printf("%s\n", funcionarios[i].nome);
	    			System.out.println("Digite o endereço");
	    			funcionarios[i].endereco = ler.nextLine();
	    			//System.out.printf("%s\n", funcionarios[i].endereco);
	    			System.out.println("Digite seu tipo");
	    			System.out.println(" 1 - por hora\n 2 - salário\n 3 - por comissão");
	    			funcionarios[i].tipo = ler.nextInt();
	    			System.out.println("Digite a forma de pagamento");
	    			System.out.println("1 - cheque pelos correios\n2 - cheque em mãos\n3 - depósito bancario");
	    			funcionarios[i].ComoRecebe = ler.nextInt();
	    			System.out.println("Pertence ao sindicato ? 1- sim 2-não");
	    			funcionarios[i].PertenceSindicato = ler.nextInt();
	    			if(funcionarios[i].PertenceSindicato == 1){
	    				System.out.println("identificação do sindicato");
	    				funcionarios[i].IdDoSindicato = ler.nextInt();
	    				System.out.println("taxa sindical");
	    				funcionarios[i].TaxaSindical = ler.nextFloat();
	    			}
	    			System.out.println("Dados do funcionário atualizados com sucesso");
	    			funcionarios[i].FoiMotificado = 1;
	    		}
	    		else if(comando == 7){                            // setima opção
	    			for(exclusivoparaloop = 0; exclusivoparaloop < 50; exclusivoparaloop++){
	    				funcionarios[exclusivoparaloop].FoiMotificado = 0;
	    			}
	    			for(i = 0; i < 50; i++)
	    			{
	    				if(funcionarios[i].tipo == 1){
	    					if(funcionarios[i].DiaDaSemana == DiaAtualDaSemana){
	    						System.out.printf("o %s trabalhou irá receber hoje\n", funcionarios[i].nome);
	    						System.out.printf("Receberá %.2f pelas horas trabalhadas\n", (funcionarios[i].HorasTotais * funcionarios[i].PorHora));
	    						System.out.printf("Receberá %.2f pelas horas extras\n", (funcionarios[i].HorasExtras * (funcionarios[i].PorHora * 1.5)));
	    						if(funcionarios[i].PertenceSindicato == 1){
	    							System.out.printf("Sua taxa do sindicato é %.2f\n", funcionarios[i].TaxaSindical);
	    							System.out.printf("Seus custos de serviços foram %.2f\n", funcionarios[i].TaxadeServico);
	    						}
	    						if(funcionarios[i].ComoRecebe == 1){
	    							System.out.println("receberá por cheque pelos correios.");
	    						}
	    						else if(funcionarios[i].ComoRecebe == 2){
	    							System.out.println("receberá por cheque em mãos");
	    						}
	    						else{
	    							System.out.println("receberá por déposito bancário");
	    						}
	    						System.out.printf("total a receber %.2f\n", 
	    						((funcionarios[i].HorasTotais * funcionarios[i].PorHora)+(funcionarios[i].HorasExtras * (funcionarios[i].PorHora * 1.5)) - (funcionarios[i].TaxaSindical+funcionarios[i].TaxadeServico)));
	    						/* espaço para a replicação */
	    						funcionarios[i].HorasTotais = 0;
	    						funcionarios[i].HorasExtras = 0;
	    						funcionarios[i].TaxadeServico = 0;
	    						funcionarios[i].FoiMotificado = 1;
	    					}
	    				}
	    				else if(funcionarios[i].tipo == 2){
	    					if(funcionarios[i].DiaDoMes == DiaAtualDoMes){
	    						System.out.printf("o %s trabalhou irá receber hoje\n", funcionarios[i].nome);
	    						System.out.printf("Ele recebe %.2f\n", funcionarios[i].salario);
	    						if(funcionarios[i].PertenceSindicato == 1){
	    							System.out.printf("Sua taxa do sindicato é %.2f\n", funcionarios[i].TaxaSindical);
	    							System.out.printf("Seus custos de serviços foram %.2f\n", funcionarios[i].TaxadeServico);
	    						}
	    						if(funcionarios[i].ComoRecebe == 1){
	    							System.out.println("receberá por cheque pelos correios.");
	    						}
	    						else if(funcionarios[i].ComoRecebe == 2){
	    							System.out.println("receberá por cheque em mãos");
	    						}
	    						else{
	    							System.out.println("receberá por déposito bancário");
	    						}
	    						System.out.printf("total a receber %.2f\n", (funcionarios[i].salario - (funcionarios[i].TaxaSindical+funcionarios[i].TaxadeServico)));
	    						/* espaço para a replicação */
	    						funcionarios[i].TaxadeServico = 0;
	    						funcionarios[i].FoiMotificado = 1;
	    					}
	    					else if(DiaAtualDaSemana == 5){
	    						j = DiaAtualDoMes + 2;
	    						o = DiaAtualDoMes + 1;
	    						if(j > 30){
	    							j -= 30;
	    						}
	    						if(o > 30){
	    							o -= 30;
	    						}
	    						if((j == funcionarios[i].DiaDoMes) || (o == funcionarios[i].DiaDoMes)){
	    							System.out.printf("o %s trabalhou irá receber hoje\n", funcionarios[i].nome);
		    						System.out.printf("Ele recebe %.2f\n", funcionarios[i].salario);
		    						if(funcionarios[i].PertenceSindicato == 1){
		    							System.out.printf("Sua taxa do sindicato é %.2f\n", funcionarios[i].TaxaSindical);
		    							System.out.printf("Seus custos de serviços foram %.2f\n", funcionarios[i].TaxadeServico);
		    						}
		    						if(funcionarios[i].ComoRecebe == 1){
		    							System.out.println("receberá por cheque pelos correios.");
		    						}
		    						else if(funcionarios[i].ComoRecebe == 2){
		    							System.out.println("receberá por cheque em mãos");
		    						}
		    						else{
		    							System.out.println("receberá por déposito bancário");
		    						}

		    						System.out.printf("total a receber %.2f\n", (funcionarios[i].salario - (funcionarios[i].TaxaSindical+funcionarios[i].TaxadeServico)));
		    						/* espaço para a replicação */
		    						funcionarios[i].TaxadeServico = 0;
		    						funcionarios[i].FoiMotificado = 1;
	    						}
	    					}
	    				}
	    				else if(funcionarios[i].tipo == 3){
	    					if(funcionarios[i].ContadordeSemana == 1){
	    						/* espaço para a replicação */
	    						funcionarios[i].ContadordeSemana = 0;
	    					}
	    					else{
	    						System.out.printf("o %s trabalhou irá receber hoje\n", funcionarios[i].nome);
	    						System.out.printf("Ele recebe %.2f a cada 15 dias\n", funcionarios[i].salario);
	    						System.out.printf("Ele receberá de comissão %.2f\n", (funcionarios[i].comissao * funcionarios[i].QuantoVendeu));
	    						if(funcionarios[i].PertenceSindicato == 1){
	    							System.out.printf("Sua taxa do sindicato é %.2f\n", funcionarios[i].TaxaSindical);
	    							System.out.printf("Seus custos de serviços foram %.2f\n", funcionarios[i].TaxadeServico);
	    						}
	    						if(funcionarios[i].ComoRecebe == 1){
	    							System.out.println("receberá por cheque pelos correios.");
	    						}
	    						else if(funcionarios[i].ComoRecebe == 2){
	    							System.out.println("receberá por cheque em mãos");
	    						}
	    						else{
	    							System.out.println("receberá por déposito bancário");
	    						}
	    						System.out.printf("total a receber %.2f\n", 
	    								(funcionarios[i].salario + (funcionarios[i].comissao * funcionarios[i].QuantoVendeu) - (funcionarios[i].TaxaSindical+funcionarios[i].TaxadeServico)));
	    						/* espaço para a replicação */
	    						funcionarios[i].QuantoVendeu = 0;
	    						funcionarios[i].TaxadeServico = 0;
	    						funcionarios[i].FoiMotificado = 1;
	    						funcionarios[i].ContadordeSemana = 1;
	    					}
	    				}
	    			}
	    			if(DiaAtualDaSemana == 5){ //pulando sabado e domingo.
	    				DiaAtualDaSemana = 1;
	    				DiaAtualDoMes +=2;
	    				if(DiaAtualDoMes > 30){
	    					DiaAtualDoMes -= 30;
	    				}
	    			}
	    			else{
	    				DiaAtualDaSemana += 1;
	    				DiaAtualDoMes +=1;
	    				if(DiaAtualDoMes > 30){
	    					DiaAtualDoMes -= 30;
	    				}
	    			}
	    		}
	    	}
	    }
	}
}

import java.util.Scanner;
public class Main {
	public static void main(String args[]) {
		Funcionario[] funcionarios = new Funcionario[50];
	    System.out.println("Ol�, aten��o, digite seu comando, podendo ser de 1 a 10, poder� ter no maximo 50 funcion�rios.");
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
	   System.out.println("aten��o, o est�giario n�o soube fazer o funcionamento da data direito, ent�o ela s� mudar� quando voc� rodar a folha, logo s� fa�a isso quando o ultimo funcion�rio bater o ponto do dia.");
	   System.out.println("digite o dia do m�s, entre 1 e 30");
	   i = ler.nextInt();
	   if(i < 1 || i > 30){
		   while(i < 1 || i > 30){
			   System.out.println("dia inv�lido, digite novamente");
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
			   System.out.println("dia inv�lido, digite novamente");
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
	    		System.out.println("voc� digitou um comando inv�lido, tente novamente.");
	    	}
	    	else{
	    		if(comando == 1){																//aqui come�a a primeira etapa
	    			for(exclusivoparaloop = 0; exclusivoparaloop < 50; exclusivoparaloop++){
	    				funcionarios[exclusivoparaloop].FoiMotificado = 0;
	    			}
	    			/* espa�o para a replica��o */
	    			if(NumeroDeFuncionarios < 50){
	    			System.out.println("voc� escolheu adicionar um funcion�rio\n");
	    			System.out.println("digite o nome do novo empregado");
	    				for(i = 0; funcionarios[i].EsseLocaleVago == 1; i++){}
	    			funcionarios[i].nome = ler.nextLine(); //adicionando o nome ao funcionario.	
	    			funcionarios[i].EsseLocaleVago = 1;
	    			System.out.println("digite o tipo do funcionario, pelo que ele � pago.");
	    			System.out.println(" 1 - por hora\n 2 - sal�rio\n 3 - por comiss�o");
	    			funcionarios[i].tipo = ler.nextInt(); //recebendo o seu tipo.
	    				if(funcionarios[i].tipo == 1){ //quanto ganha por determinada coisa.
	    					System.out.println("ent�o, quanto ele ganha por hora ?");
	    					funcionarios[i].PorHora = ler.nextFloat();
	    					funcionarios[i].DiaDaSemana = 5;
	    					piu = ler.nextLine();
	    					//System.out.printf("%d\n", funcionarios[i].PorHora);
	    				}
	    				else if(funcionarios[i].tipo == 2){
	    					System.out.println("ent�o, quanto ele ganha de sal�rio ?");
	    					funcionarios[i].salario = ler.nextFloat();
	    					funcionarios[i].DiaDoMes = 30;
	    					piu = ler.nextLine();
	    					//System.out.printf("%d\n", funcionarios[i].salario);
	    				}
	    				else{
	    					System.out.println("ent�o, quanto ele ganha de sal�rio ?");
	    					funcionarios[i].salario = (ler.nextFloat())/2;
	    					System.out.println("ent�o, quanto ele ganha de comiss�o ?");
	    					funcionarios[i].comissao = ler.nextFloat();
	    					funcionarios[i].DiaDaSemana = 5;
	    					funcionarios[i].ContadordeSemana = 0;
	    					piu = ler.nextLine();
	    					//System.out.printf("%d\n", funcionarios[i].comissao);
	    				}
	    			System.out.println("qual o endera�o do novo funcion�rio?");
	    			funcionarios[i].endereco = ler.nextLine();
	    			System.out.println("Como ele gostaria de receber?");
	    			System.out.println("1 - cheque pelos correios\n2 - cheque em m�os\n3 - dep�sito bancario");
	    			funcionarios[i].ComoRecebe = ler.nextInt();
	    			System.out.printf("pronto!, o novo funcionario foi adicionado\nseu ID � : %d\n", funcionarios[i].numero);	
	    		
	    			NumeroDeFuncionarios++;
	    			funcionarios[i].FoiMotificado = 1;
	    			}
	    			else{
	    				System.out.println("voc� ja alcan�ou o total de funcionarios permitidos.");
	    			}
	    		}
	    		else if(comando == 2){									//segunda op��o
	    			for(exclusivoparaloop = 0; exclusivoparaloop < 50; exclusivoparaloop++){
	    				funcionarios[exclusivoparaloop].FoiMotificado = 0;
	    			}
	    			/* espa�o para a replica��o */
	    			System.out.println("voc� escolheu remover um funcion�rio\n");
	    			System.out.println("digite o ID do funcionario\n");
	    				i = ler.nextInt();
	    				piu = ler.nextLine();
	    			funcionarios[i].EsseLocaleVago = 0;
	    			System.out.println("removido com sucesso\n");
	    			NumeroDeFuncionarios--;
	    			funcionarios[i].FoiMotificado = 1;
	    		}
	    		else if(comando == 3){									// terceira op��o
	    			for(exclusivoparaloop = 0; exclusivoparaloop < 50; exclusivoparaloop++){
	    				funcionarios[exclusivoparaloop].FoiMotificado = 0;
	    			}
	    			/* espa�o para a replica��o */
	    			System.out.println("voc� escolheu Lan�ar um Cart�o de Ponto\n");
	    			System.out.println("Digite o ID do funcion�rio\n");
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
	    			System.out.println("ponto lan�ado com sucesso\n");
	    			funcionarios[i].FoiMotificado = 1;
	    		}
	    		else if(comando == 4){								// quarta op��o 
	    			for(exclusivoparaloop = 0; exclusivoparaloop < 50; exclusivoparaloop++){
	    				funcionarios[exclusivoparaloop].FoiMotificado = 0;
	    			}
	    			/* espa�o para a replica��o */
	    			System.out.println("voc� escolheu Lan�ar uma venda\n");
	    			System.out.println("Informe o ID do funcion�rio que realizou a venda\n");
	    			i = ler.nextInt();
	    			System.out.println("Valor da venda\n");
	    			p = ler.nextFloat();
	    			funcionarios[i].QuantoVendeu += p;
	    			System.out.println("Venda adicionada corretamente\n");
	    			funcionarios[i].FoiMotificado = 1;
	    		}
	    		else if(comando == 5){							// quinta op��o
	    			for(exclusivoparaloop = 0; exclusivoparaloop < 50; exclusivoparaloop++){
	    				funcionarios[exclusivoparaloop].FoiMotificado = 0;
	    			}
	    			/* espa�o para a replica��o */
	    			System.out.println("voc� escolheu lan�ar uma taxa de servi�o");
	    			System.out.println("Digite o ID(do sindicato) referente ao funcion�rio");
	    			j = ler.nextInt();
	    			for(i = 0; funcionarios[i].IdDoSindicato == j; i++){}
	    			System.out.println("digite o valor da taxa");
	    			p = ler.nextFloat();
	    			funcionarios[i].TaxadeServico += p;
	    			System.out.println("Taxa de servi�o adicionada com sucesso");
	    			funcionarios[i].FoiMotificado = 1;
	    		}
	    		else if(comando == 6){							// sexta op��o
	    			for(exclusivoparaloop = 0; exclusivoparaloop < 50; exclusivoparaloop++){
	    				funcionarios[exclusivoparaloop].FoiMotificado = 0;
	    			}
	    			/* espa�o para a replica��o */
	    			System.out.println("Voc� escolheu alterar os dados do funcion�rio");
	    			System.out.println("Digite o ID do funcion�rio");
	    			i = ler.nextInt();
	    			piu = ler.nextLine();
	    			System.out.println("muito bem, agora para come�ar");
	    			System.out.println("Digite o nome do funcion�rio");
	    			funcionarios[i].nome = ler.nextLine();
	    			//System.out.printf("%s\n", funcionarios[i].nome);
	    			System.out.println("Digite o endere�o");
	    			funcionarios[i].endereco = ler.nextLine();
	    			//System.out.printf("%s\n", funcionarios[i].endereco);
	    			System.out.println("Digite seu tipo");
	    			System.out.println(" 1 - por hora\n 2 - sal�rio\n 3 - por comiss�o");
	    			funcionarios[i].tipo = ler.nextInt();
	    			System.out.println("Digite a forma de pagamento");
	    			System.out.println("1 - cheque pelos correios\n2 - cheque em m�os\n3 - dep�sito bancario");
	    			funcionarios[i].ComoRecebe = ler.nextInt();
	    			System.out.println("Pertence ao sindicato ? 1- sim 2-n�o");
	    			funcionarios[i].PertenceSindicato = ler.nextInt();
	    			if(funcionarios[i].PertenceSindicato == 1){
	    				System.out.println("identifica��o do sindicato");
	    				funcionarios[i].IdDoSindicato = ler.nextInt();
	    				System.out.println("taxa sindical");
	    				funcionarios[i].TaxaSindical = ler.nextFloat();
	    			}
	    			System.out.println("Dados do funcion�rio atualizados com sucesso");
	    			funcionarios[i].FoiMotificado = 1;
	    		}
	    		else if(comando == 7){                            // setima op��o
	    			for(exclusivoparaloop = 0; exclusivoparaloop < 50; exclusivoparaloop++){
	    				funcionarios[exclusivoparaloop].FoiMotificado = 0;
	    			}
	    			for(i = 0; i < 50; i++)
	    			{
	    				if(funcionarios[i].tipo == 1){
	    					if(funcionarios[i].DiaDaSemana == DiaAtualDaSemana){
	    						System.out.printf("o %s trabalhou ir� receber hoje\n", funcionarios[i].nome);
	    						System.out.printf("Receber� %.2f pelas horas trabalhadas\n", (funcionarios[i].HorasTotais * funcionarios[i].PorHora));
	    						System.out.printf("Receber� %.2f pelas horas extras\n", (funcionarios[i].HorasExtras * (funcionarios[i].PorHora * 1.5)));
	    						if(funcionarios[i].PertenceSindicato == 1){
	    							System.out.printf("Sua taxa do sindicato � %.2f\n", funcionarios[i].TaxaSindical);
	    							System.out.printf("Seus custos de servi�os foram %.2f\n", funcionarios[i].TaxadeServico);
	    						}
	    						if(funcionarios[i].ComoRecebe == 1){
	    							System.out.println("receber� por cheque pelos correios.");
	    						}
	    						else if(funcionarios[i].ComoRecebe == 2){
	    							System.out.println("receber� por cheque em m�os");
	    						}
	    						else{
	    							System.out.println("receber� por d�posito banc�rio");
	    						}
	    						System.out.printf("total a receber %.2f\n", 
	    						((funcionarios[i].HorasTotais * funcionarios[i].PorHora)+(funcionarios[i].HorasExtras * (funcionarios[i].PorHora * 1.5)) - (funcionarios[i].TaxaSindical+funcionarios[i].TaxadeServico)));
	    						/* espa�o para a replica��o */
	    						funcionarios[i].HorasTotais = 0;
	    						funcionarios[i].HorasExtras = 0;
	    						funcionarios[i].TaxadeServico = 0;
	    						funcionarios[i].FoiMotificado = 1;
	    					}
	    				}
	    				else if(funcionarios[i].tipo == 2){
	    					if(funcionarios[i].DiaDoMes == DiaAtualDoMes){
	    						System.out.printf("o %s trabalhou ir� receber hoje\n", funcionarios[i].nome);
	    						System.out.printf("Ele recebe %.2f\n", funcionarios[i].salario);
	    						if(funcionarios[i].PertenceSindicato == 1){
	    							System.out.printf("Sua taxa do sindicato � %.2f\n", funcionarios[i].TaxaSindical);
	    							System.out.printf("Seus custos de servi�os foram %.2f\n", funcionarios[i].TaxadeServico);
	    						}
	    						if(funcionarios[i].ComoRecebe == 1){
	    							System.out.println("receber� por cheque pelos correios.");
	    						}
	    						else if(funcionarios[i].ComoRecebe == 2){
	    							System.out.println("receber� por cheque em m�os");
	    						}
	    						else{
	    							System.out.println("receber� por d�posito banc�rio");
	    						}
	    						System.out.printf("total a receber %.2f\n", (funcionarios[i].salario - (funcionarios[i].TaxaSindical+funcionarios[i].TaxadeServico)));
	    						/* espa�o para a replica��o */
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
	    							System.out.printf("o %s trabalhou ir� receber hoje\n", funcionarios[i].nome);
		    						System.out.printf("Ele recebe %.2f\n", funcionarios[i].salario);
		    						if(funcionarios[i].PertenceSindicato == 1){
		    							System.out.printf("Sua taxa do sindicato � %.2f\n", funcionarios[i].TaxaSindical);
		    							System.out.printf("Seus custos de servi�os foram %.2f\n", funcionarios[i].TaxadeServico);
		    						}
		    						if(funcionarios[i].ComoRecebe == 1){
		    							System.out.println("receber� por cheque pelos correios.");
		    						}
		    						else if(funcionarios[i].ComoRecebe == 2){
		    							System.out.println("receber� por cheque em m�os");
		    						}
		    						else{
		    							System.out.println("receber� por d�posito banc�rio");
		    						}

		    						System.out.printf("total a receber %.2f\n", (funcionarios[i].salario - (funcionarios[i].TaxaSindical+funcionarios[i].TaxadeServico)));
		    						/* espa�o para a replica��o */
		    						funcionarios[i].TaxadeServico = 0;
		    						funcionarios[i].FoiMotificado = 1;
	    						}
	    					}
	    				}
	    				else if(funcionarios[i].tipo == 3){
	    					if(funcionarios[i].ContadordeSemana == 1){
	    						/* espa�o para a replica��o */
	    						funcionarios[i].ContadordeSemana = 0;
	    					}
	    					else{
	    						System.out.printf("o %s trabalhou ir� receber hoje\n", funcionarios[i].nome);
	    						System.out.printf("Ele recebe %.2f a cada 15 dias\n", funcionarios[i].salario);
	    						System.out.printf("Ele receber� de comiss�o %.2f\n", (funcionarios[i].comissao * funcionarios[i].QuantoVendeu));
	    						if(funcionarios[i].PertenceSindicato == 1){
	    							System.out.printf("Sua taxa do sindicato � %.2f\n", funcionarios[i].TaxaSindical);
	    							System.out.printf("Seus custos de servi�os foram %.2f\n", funcionarios[i].TaxadeServico);
	    						}
	    						if(funcionarios[i].ComoRecebe == 1){
	    							System.out.println("receber� por cheque pelos correios.");
	    						}
	    						else if(funcionarios[i].ComoRecebe == 2){
	    							System.out.println("receber� por cheque em m�os");
	    						}
	    						else{
	    							System.out.println("receber� por d�posito banc�rio");
	    						}
	    						System.out.printf("total a receber %.2f\n", 
	    								(funcionarios[i].salario + (funcionarios[i].comissao * funcionarios[i].QuantoVendeu) - (funcionarios[i].TaxaSindical+funcionarios[i].TaxadeServico)));
	    						/* espa�o para a replica��o */
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

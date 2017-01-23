import java.util.Scanner;
public class Main {
	public static void main(String args[]) {
		Funcionario[] funcionarios = new Funcionario[50];
		Funcionario[] auxiliares = new Funcionario[50];
		Funcionario auxiliador = new Funcionario();
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
	   String informacao;
	   int[] AgendasMensais = new int[31];
	   AgendasMensais[30] = 1;
	   int[] AgendasSemanais = new int[6];
	   AgendasSemanais[5] = 1;
	   int[] AgendasBisemanais = new int[6];
	   AgendasBisemanais[5] = 1;
	   int i, j, o;
	   float p;
	   int DiaAtualDoMes;
	   int DiaAtualDaSemana;
	   int exclusivoparaloop;
	   int anteriordonumerodefuncionarios = 0, ajudaoNumero;
	   int comandoAnterior = 9;
	   int relogio = 0;
	   System.out.println("aten��o, o estagi�rio n�o soube como conectar o programa ao rel�gio interno do computador, logo o dia ir� passar depois de 5 comandos v�lidos");
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
	   
	   System.out.println("digite o dia da semana, entre 1 e 5, sendo 1 - segunda e 5 - sexta");
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
		   auxiliares[i] = new Funcionario();
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
	    			if(NumeroDeFuncionarios < 50){
	    			System.out.println("voc� escolheu adicionar um funcion�rio");
	    			System.out.println("digite o nome do novo empregado");
	    				for(i = 0; funcionarios[i].EsseLocaleVago == 1; i++){}
	    				/* espa�o para a replica��o */
	    				anteriordonumerodefuncionarios = NumeroDeFuncionarios;
	    				auxiliares[i].EsseLocaleVago = funcionarios[i].EsseLocaleVago;
	    				/* espa�o para a replica��o */
	    			funcionarios[i].nome = ler.nextLine(); //adicionando o nome ao funcionario.	
	    			auxiliares[i].nome = funcionarios[i].nome;
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
	    					funcionarios[i].comissao = (ler.nextFloat())/100;
	    					//System.out.printf("%.2f", funcionarios[i].comissao);
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
	    			System.out.println("voc� escolheu remover um funcion�rio\n");
	    			System.out.println("digite o ID do funcionario\n");
	    				i = ler.nextInt();
	    				piu = ler.nextLine();
	    				/* espa�o para a replica��o */
		    			anteriordonumerodefuncionarios = NumeroDeFuncionarios;
		    			auxiliares[i].EsseLocaleVago = funcionarios[i].EsseLocaleVago;
		    			/* espa�o para a replica��o */
	    			funcionarios[i].EsseLocaleVago = 0;
	    			System.out.println("removido com sucesso\n");
	    			NumeroDeFuncionarios--;
	    			funcionarios[i].FoiMotificado = 1;
	    		}
	    		else if(comando == 3){									// terceira op��o
	    			for(exclusivoparaloop = 0; exclusivoparaloop < 50; exclusivoparaloop++){
	    				funcionarios[exclusivoparaloop].FoiMotificado = 0;
	    			}
	    			
	    			System.out.println("voc� escolheu Lan�ar um Cart�o de Ponto\n");
	    			System.out.println("Digite o ID do funcion�rio\n");
	    			i = ler.nextInt();
	    			/* espa�o para a replica��o */
	    			auxiliares[i].HorasTotais = funcionarios[i].HorasTotais;
	    			auxiliares[i].HorasExtras = funcionarios[i].HorasExtras;
	    			/* espa�o para a replica��o */
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
	    			System.out.println("voc� escolheu Lan�ar uma venda\n");
	    			System.out.println("Informe o ID do funcion�rio que realizou a venda\n");
	    			i = ler.nextInt();
	    			/* espa�o para a replica��o */
	    			auxiliares[i].QuantoVendeu = funcionarios[i].QuantoVendeu;
	    			/* espa�o para a replica��o */
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
	    			System.out.println("voc� escolheu lan�ar uma taxa de servi�o");
	    			System.out.println("Digite o ID(do sindicato) referente ao funcion�rio");
	    			j = ler.nextInt();
	    			for(i = 0; funcionarios[i].IdDoSindicato == j; i++){}
	    			/* espa�o para a replica��o */
	    			auxiliares[i].TaxadeServico = funcionarios[i].TaxadeServico;
	    			
	    			/* espa�o para a replica��o */
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
	    			auxiliares[i].nome = funcionarios[i].nome;
	    			funcionarios[i].nome = ler.nextLine();
	    			//System.out.printf("%s\n", funcionarios[i].nome);
	    			System.out.println("Digite o endere�o");
	    			auxiliares[i].endereco = funcionarios[i].endereco;
	    			funcionarios[i].endereco = ler.nextLine();
	    			//System.out.printf("%s\n", funcionarios[i].endereco);
	    			System.out.println("Digite seu tipo");
	    			System.out.println(" 1 - por hora\n 2 - sal�rio\n 3 - por comiss�o");
	    			auxiliares[i].tipo = funcionarios[i].tipo;
	    			funcionarios[i].tipo = ler.nextInt();
	    			System.out.println("Digite a forma de pagamento");
	    			System.out.println("1 - cheque pelos correios\n2 - cheque em m�os\n3 - dep�sito bancario");
	    			auxiliares[i].ComoRecebe = funcionarios[i].ComoRecebe;
	    			funcionarios[i].ComoRecebe = ler.nextInt();
	    			System.out.println("Pertence ao sindicato ? 1- sim 2-n�o");
	    			auxiliares[i].PertenceSindicato = funcionarios[i].PertenceSindicato;
	    			funcionarios[i].PertenceSindicato = ler.nextInt();
	    			if(funcionarios[i].PertenceSindicato == 1){
	    				System.out.println("identifica��o do sindicato");
	    				auxiliares[i].IdDoSindicato = funcionarios[i].IdDoSindicato;
	    				funcionarios[i].IdDoSindicato = ler.nextInt();
	    				System.out.println("taxa sindical");
	    				auxiliares[i].TaxaSindical = funcionarios[i].TaxaSindical;
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
	    				if(funcionarios[i].tipo == 1 && funcionarios[i].JaRecebeuHoje == 0){
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
	    						auxiliares[i].HorasTotais = funcionarios[i].HorasTotais;
	    						funcionarios[i].HorasTotais = 0; 
	    						auxiliares[i].HorasExtras = funcionarios[i].HorasExtras;
	    						funcionarios[i].HorasExtras = 0; 
	    						auxiliares[i].TaxadeServico = funcionarios[i].TaxadeServico;
	    						funcionarios[i].TaxadeServico = 0;
	    						auxiliares[i].JaRecebeuHoje = funcionarios[i].JaRecebeuHoje;
	    						funcionarios[i].JaRecebeuHoje = 1;
	    						funcionarios[i].FoiMotificado = 1;
	    					}
	    				}
	    				else if(funcionarios[i].tipo == 2 && funcionarios[i].JaRecebeuHoje == 0){
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
	    						auxiliares[i].TaxadeServico = funcionarios[i].TaxadeServico;
	    						funcionarios[i].TaxadeServico = 0;
	    						auxiliares[i].JaRecebeuHoje = funcionarios[i].JaRecebeuHoje;
	    						funcionarios[i].JaRecebeuHoje = 1;
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
		    						auxiliares[i].TaxadeServico = funcionarios[i].TaxadeServico;
		    						funcionarios[i].TaxadeServico = 0;
		    						auxiliares[i].JaRecebeuHoje = funcionarios[i].JaRecebeuHoje;
		    						funcionarios[i].JaRecebeuHoje = 1;
		    						funcionarios[i].FoiMotificado = 1;
	    						}
	    					}
	    				}
	    				else if(funcionarios[i].tipo == 3 && funcionarios[i].JaRecebeuHoje == 0){
	    					if(funcionarios[i].ContadordeSemana == 1){
	    						/* espa�o para a replica��o */
	    						auxiliares[i].ContadordeSemana = funcionarios[i].ContadordeSemana;
	    						funcionarios[i].ContadordeSemana = 0;
	    						funcionarios[i].JaRecebeuHoje = 1;
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
	    						auxiliares[i].QuantoVendeu = funcionarios[i].QuantoVendeu;
	    						funcionarios[i].QuantoVendeu = 0;
	    						auxiliares[i].TaxadeServico = funcionarios[i].TaxadeServico;
	    						funcionarios[i].TaxadeServico = 0;
	    						auxiliares[i].JaRecebeuHoje  = funcionarios[i].JaRecebeuHoje;
	    						funcionarios[i].JaRecebeuHoje = 1;
	    						funcionarios[i].FoiMotificado = 1;
	    						auxiliares[i].ContadordeSemana = funcionarios[i].ContadordeSemana;
	    						funcionarios[i].ContadordeSemana = 1;
	    					}
	    				}
	    			}
	    		}
	    		else if(comando == 8){			// op��o 8.
	    			for(i = 0; i <50; i++){
		    			if((comandoAnterior == 1) && funcionarios[i].FoiMotificado == 1){
		    				auxiliador.EsseLocaleVago = funcionarios[i].EsseLocaleVago;	    				
		    				funcionarios[i].EsseLocaleVago = auxiliares[i].EsseLocaleVago;	
		    				auxiliares[i].EsseLocaleVago = auxiliador.EsseLocaleVago;	
		    				ajudaoNumero = NumeroDeFuncionarios;
		    				NumeroDeFuncionarios = anteriordonumerodefuncionarios;
		    				anteriordonumerodefuncionarios = ajudaoNumero;
		    			}
		    			else if(comandoAnterior == 2 && funcionarios[i].FoiMotificado == 1){
		    				auxiliador.EsseLocaleVago = funcionarios[i].EsseLocaleVago;
		    				funcionarios[i].EsseLocaleVago = auxiliares[i].EsseLocaleVago;
		    				auxiliares[i].EsseLocaleVago = auxiliador.EsseLocaleVago;
		    				ajudaoNumero = NumeroDeFuncionarios;
		    				NumeroDeFuncionarios = anteriordonumerodefuncionarios;
		    				anteriordonumerodefuncionarios = ajudaoNumero;
		    			}
		    			else if(comandoAnterior == 3  && funcionarios[i].FoiMotificado == 1){
		    				auxiliador.HorasExtras = funcionarios[i].HorasExtras;
		    				auxiliador.HorasTotais = funcionarios[i].HorasTotais;
		    				funcionarios[i].HorasExtras = auxiliares[i].HorasExtras;
		    				funcionarios[i].HorasTotais = auxiliares[i].HorasTotais;
		    				auxiliares[i].HorasExtras = auxiliador.HorasExtras;
		    				auxiliares[i].HorasTotais = auxiliador.HorasTotais;
		    			}
		    			else if(comandoAnterior == 4  && funcionarios[i].FoiMotificado == 1){
		    				auxiliador.QuantoVendeu = funcionarios[i].QuantoVendeu;
		    				funcionarios[i].QuantoVendeu = auxiliares[i].QuantoVendeu;
		    				auxiliares[i].QuantoVendeu = auxiliador.QuantoVendeu;
		    			}
		    			else if(comandoAnterior == 5  && funcionarios[i].FoiMotificado == 1){
		    				auxiliador.TaxadeServico = funcionarios[i].TaxadeServico;
		    				funcionarios[i].TaxadeServico = auxiliares[i].TaxadeServico;
		    				auxiliares[i].TaxadeServico = auxiliador.TaxadeServico;
		    			}
		    			else if(comandoAnterior == 6  && funcionarios[i].FoiMotificado == 1){
		    				auxiliador.nome = funcionarios[i].nome;
		    				auxiliador.endereco = funcionarios[i].endereco;
		    				auxiliador.tipo = funcionarios[i].tipo;
		    				auxiliador.ComoRecebe = funcionarios[i].ComoRecebe;
		    				auxiliador.PertenceSindicato = funcionarios[i].PertenceSindicato;
		    				funcionarios[i].nome = auxiliares[i].nome;
		    				funcionarios[i].endereco = auxiliares[i].endereco;
		    				funcionarios[i].tipo = auxiliares[i].tipo;
		    				funcionarios[i].ComoRecebe = auxiliares[i].ComoRecebe;
		    				funcionarios[i].PertenceSindicato = auxiliares[i].PertenceSindicato;
		    				auxiliares[i].nome = auxiliador.nome;
		    				auxiliares[i].endereco = auxiliador.endereco;
		    				auxiliares[i].tipo = auxiliador.tipo;
		    				auxiliares[i].ComoRecebe = auxiliador.ComoRecebe;
		    				auxiliares[i].PertenceSindicato = auxiliador.PertenceSindicato; 
		    			}
		    			else if(comandoAnterior == 7  && funcionarios[i].FoiMotificado == 1){
		    				auxiliador.HorasTotais = funcionarios[i].HorasTotais;
		    				auxiliador.HorasExtras = funcionarios[i].HorasExtras;
		    				auxiliador.TaxadeServico = funcionarios[i].TaxadeServico;
		    				auxiliador.JaRecebeuHoje = funcionarios[i].JaRecebeuHoje;
		    				auxiliador.ContadordeSemana = funcionarios[i].ContadordeSemana;
		    				auxiliador.QuantoVendeu = funcionarios[i].QuantoVendeu; 
		    				funcionarios[i].HorasTotais = auxiliares[i].HorasTotais;
		    				funcionarios[i].HorasExtras = auxiliares[i].HorasExtras;
		    				funcionarios[i].TaxadeServico = auxiliares[i].TaxadeServico;
		    				funcionarios[i].JaRecebeuHoje = auxiliares[i].JaRecebeuHoje;
		    				funcionarios[i].ContadordeSemana = auxiliares[i].ContadordeSemana;
		    				funcionarios[i].QuantoVendeu = auxiliares[i].QuantoVendeu;
		    				auxiliares[i].HorasTotais = auxiliador.HorasTotais;
		    				auxiliares[i].HorasExtras = auxiliador.HorasExtras;
		    				auxiliares[i].TaxadeServico = auxiliador.TaxadeServico;
		    				auxiliares[i].JaRecebeuHoje = auxiliador.JaRecebeuHoje;
		    				auxiliares[i].ContadordeSemana = auxiliador.ContadordeSemana;
		    				auxiliares[i].QuantoVendeu = auxiliador.QuantoVendeu;
		    			}
	    			}
	    			System.out.println("Comando anterior cancelado com sucesso.");
	    		}
	    		else if(comando == 9){			//op��o 9.
	    			System.out.println("Voc� escolheu selecionar uma nova agenda de pagamentos");
	    			System.out.println("Digite o Id do funcionario");
	    			i = ler.nextInt();
	    			if(funcionarios[i].tipo == 1){
	    				System.out.println("Escolha o dia da semana que deseja receber.\nSendo 1 - segunda a 5 - sexta.");
	    				j = ler.nextInt();
	    				if(AgendasSemanais[j] == 1){
	    					funcionarios[i].DiaDaSemana = j;
	    					System.out.println("Foi atualizado com sucesso.");
	    				}
	    				else{
	    					System.out.println("Desculpe, mas esse dia n�o est� disponivel.");
	    				}
	    			}
	    			else if(funcionarios[i].tipo == 2){
	    				System.out.println("Escolha o dia do m�s que voc� deseja receber, simplesmente digite o numero de 1 a 30");
	    				j = ler.nextInt();
	    				if(AgendasMensais[j] == 1){
	    					funcionarios[i].DiaDoMes = j;
	    					System.out.println("Foi atualizado com sucesso.");
	    				}
	    				else{
	    					System.out.println("Desculpe, mas esse dia n�o est� disponivel.");
	    				}
	    			}
	    			else{
	    				System.out.println("Escolha o dia da semana que deseja receber.\nSendo 1 - segunda a 5 - sexta.");
	    				j = ler.nextInt();
	    				if(AgendasBisemanais[j] == 1){
	    					funcionarios[i].DiaDaSemana = j;
	    					System.out.println("Foi atualizado com sucesso.");
	    				}
	    				else{
	    					System.out.println("Desculpe, mas esse dia n�o est� disponivel.");
	    				}
	    			}
	    		}
	    		else{  							// op��o 10.
	    			System.out.println("Voc� escolheu criar uma nova agenda de pagamentos\ndeve ser digitado o comando do tipo: mensal x, semana 1 segunda, semana 2 segunda.");
	    			informacao = ler.next();
	    			if(informacao.equals("mensal")){
	    				 i = ler.nextInt();
	    				 AgendasMensais[i] = 1;
	    			}
	    			else{
	    				j = ler.nextInt();
	    				
	    				if(j == 1){
	    					informacao = ler.next();
	    					if(informacao.equals("segunda")){
	    						AgendasSemanais[1] = 1;
	    					}
	    					else if(informacao.equals("terca")){
	    						AgendasSemanais[2] = 1;
	    					}
	    					else if(informacao.equals("quarta")){
	    						AgendasSemanais[3] = 1;
	    					}
	    					else if(informacao.equals("quinta")){
	    						AgendasSemanais[4] = 1;
	    					}
	    					else{
	    						AgendasSemanais[5] = 1;
	    					}
	    				}
	    				else{
	    					informacao = ler.next();
	    					if(informacao.equals("segunda")){
	    						AgendasBisemanais[1] = 1;
	    					}
	    					else if(informacao.equals("terca")){
	    						AgendasBisemanais[2] = 1;
	    					}
	    					else if(informacao.equals("quarta")){
	    						AgendasBisemanais[3] = 1;
	    					}
	    					else if(informacao.equals("quinta")){
	    						AgendasBisemanais[4] = 1;
	    					}
	    					else{
	    						AgendasBisemanais[5] = 1;
	    					}
	    				}
	    			}
	    			//System.out.printf("%d", AgendasSemanais[1]);
	    		}
	    		if(comando != 8){
	    			comandoAnterior = comando;
	    		}
	    		relogio += 1; 
	    		if(relogio == 5){
	    			if(DiaAtualDaSemana == 5){ //pulando sabado e domingo.
	    				DiaAtualDaSemana = 1;
	    				DiaAtualDoMes +=3;
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
	    			for(exclusivoparaloop = 0; exclusivoparaloop < 50; exclusivoparaloop++){
	    				funcionarios[exclusivoparaloop].JaRecebeuHoje = 0;
	    			}
	    			relogio = 0;
	    			System.out.printf("Dia foi atualizado, hoje � %d\n", DiaAtualDoMes);
	    		}
	    	}
	    }
	}
}

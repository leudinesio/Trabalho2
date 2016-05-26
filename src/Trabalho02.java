import java.util.Locale;
import java.util.Scanner;

public class Trabalho02 {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		Locale.setDefault(new Locale("en", "US"));
		
		

		int N, tipo[], min[], i, mb;
		String nome[], telefone[];
		double Vassinatura[][], Vconta[], soma, somam, mediam;

		System.out.print("Quantos clientes deseja cadastrar? ");
		N = sc.nextInt();

		nome = new String[N];
		telefone = new String[N];
		tipo = new int[N];
		min = new int[N];

		for (i = 0; i < N; i++) {
			System.out.print("Digite o nome do " + (i + 1) + "º cliente: ");
			sc.nextLine();
			nome[i] = sc.nextLine();
			System.out.print("Digite o telefone do " + (i + 1) + "º cliente: ");
			telefone[i] = sc.next();
			System.out.print("Digite o tipo de assinatura do " + (i + 1) + "º cliente: ");
			tipo[i] = sc.nextInt();
			System.out.print("Digite os minutos utilizados pelo " + (i + 1) + "º cliente: ");
			min[i] = sc.nextInt();
		}
    		Vassinatura = new double[3][2];

		for (i = 0; i < 3; i++) {
			System.out.print("Digite o valor da assinatura do tipo " + (i+1) + ": ");
			Vassinatura[i][0] = sc.nextDouble();
			System.out.print("Digite o valor do minuto excedente para o tipo " + (i+1) + ": ");
			Vassinatura[i][1] = sc.nextDouble();
		}
		
		Vconta = new double[N];
		
		for (i = 0; i < N; i++) {
			if (min[i] > 90) {
				Vconta[i] = Vassinatura[tipo[i]][0] + ((min[i] - 90) * Vassinatura[tipo[i]][1]);
			}
			else {
				Vconta[i] = Vconta[tipo[i]];
			}
		}
		System.out.println("Dados das contas: \n");
		for (i=0;i<N;i++) {
			System.out.print(nome[i]+" \t");
			System.out.print(telefone[i]+"  \t ");
			System.out.print(tipo[i]+"   \t");
			System.out.print(min[i]+" \t  ");
			System.out.print(Vconta[i]+"  \t ");
			System.out.println();
		}
		
		soma=0;
		for (i=0;i<N;i++) {
			soma = soma + Vconta[i];
		}
		System.out.printf("\nReceita total: %.2f\n" , soma);
		
		mb=0;
		for (i=0;i<N;i++) {
			if (Vconta[i] < Vconta[mb]) {
				mb = i;
			}
		}
		System.out.print("\nNome e telefone da conta mais barata: " + nome[mb] + " " + telefone[mb] + "\n");
		
		somam=0;
		int quant = 0;
		for (i=0;i<N;i++) {
			if (tipo[i] == 1){
				somam = somam + min[i];
				quant = quant + 1;
			}
		}
		mediam = (somam / quant);
		System.out.print("\nMédia de minutos dos clientes tipo 1: " + mediam + "\n");
		
		System.out.print("\nNome e telefone de quem não consumiu minutos exedecentes: \n");
		for (i=0;i<N;i++) {
			if (min[i] <= 90) {
				System.out.println(nome[i]+"  "+telefone[i]);
			}
		}
		
		int quantm = 0;
		for (i=0;i<N;i++) {
			if (min[i] > 120) {
				quantm = quantm + 1;
			}
		}
		System.out.print("\nQuantidade de clientes que consumiu acima de 120 minutos: " + quantm + "\n");
		
		int quant2 = 0;
		
		for (i=0;i<N;i++) {
			if (tipo[i] == 2) {
				quant2 = quant2 + 1;
			}
		}
		double porc = 0;
		porc = (double) quant2 / N * 100;
		System.out.printf("\nPorcentagem de clientes que possuem conta do tipo 2: %.2f%%" , porc);
		
		sc.close();
	}

}



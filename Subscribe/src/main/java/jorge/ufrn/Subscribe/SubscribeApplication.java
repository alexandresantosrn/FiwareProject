package jorge.ufrn.Subscribe;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SubscribeApplication {

	private static String style;

	public static void main(String[] args) {
		SpringApplication.run(SubscribeApplication.class, args);

		int option = 100;

		try (Scanner in = new Scanner(System.in)) {

			while (option != 0) {

				System.out.println("--------------------------------------------------------------");
				System.out.println("--------------------------------------------------------------");
				System.out.println("Caro cliente, informe a opção de traje preferido para aluguel:");
				System.out.println("1 - Roupas esportivas.");
				System.out.println("2 - Roupas tradicionais.");
				System.out.println("3 - Roupas para festas.");
				System.out.println("0 - Sair.");
				System.out.print("Opção desejada: ");
				option = in.nextInt();

				switch (option) {

				case 1:
					style = "Esportivo";
				case 2:
					style = "Tradicional";
				case 3:
					style = "Festa";
				default:
					if (option != 0)
						System.out.println("Opção inválida. Selecione uma das opções disponíveis!");
				}
			}
		}

		System.out.println(" \n" + "Até logo pessoal!!");
	}

}

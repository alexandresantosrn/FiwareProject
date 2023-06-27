package jorge.ufrn.Subscribe;

import java.io.IOException;
import java.util.Scanner;

import org.apache.http.client.ClientProtocolException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jorge.ufrn.Subscribe.Utils.DataUtils;

@SpringBootApplication
public class SubscribeApplication {

	private static String style;

	public static void main(String[] args) throws ClientProtocolException, IOException {
		SpringApplication.run(SubscribeApplication.class, args);

		int option = 100;

		try (Scanner in = new Scanner(System.in)) {

			while (option != 0 && option != 1 && option != 2 && option != 3 && option != 4) {

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

				case 0:
					System.out.println(" \n" + "Até logo pessoal!!");
					break;
				case 1:
					style = "Esportivo";
					connect(style);
					break;
				case 2:
					style = "Tradicional";
					connect(style);
					break;
				case 3:
					style = "Festa";
					connect(style);
					break;
				default:
					if (option != 0)
						System.out.println("Opção inválida. Selecione uma das opções disponíveis!");
				}
			}
		}

	}

	private static void connect(String style) throws ClientProtocolException, IOException {

		String uriCloth = "http://127.0.0.1:1026/v2/entities?type=Cloth&q=category==" + style + ";avaliable==true";

		String jsonResponse = DataUtils.returnData(uriCloth);

		if (jsonResponse.equals("[]")) {
			System.out.println("Não há roupas disponíveis para a categoria de trajes desejada.");
			System.out.println(
					"Caso algum traje do tipo selecionado: " + style + " esteja disponível, este será listado abaixo.");
		} else {
			System.out.println(
					"Caso algum traje do tipo selecionado: " + style + " esteja disponível, este será listado abaixo.");
			String cloth = DataUtils.formatCloth(jsonResponse);
			System.out.println(cloth);
		}

	}
}

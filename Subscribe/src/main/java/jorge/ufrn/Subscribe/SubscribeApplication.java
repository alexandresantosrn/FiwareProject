package jorge.ufrn.Subscribe;

import java.io.IOException;
import java.util.Scanner;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jorge.ufrn.Subscribe.Utils.DataUtils;

@SpringBootApplication
public class SubscribeApplication {

	private static String style;

	public static void main(String[] args) throws ParseException, IOException {
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

	private static void connect(String style) throws ParseException, IOException {

		HttpClient httpClient = HttpClients.createDefault();
		String uriCloth = "http://127.0.0.1:1026/v2/entities?type=Cloth&q=category==" + style + ";avaliable==true";
		HttpGet httpGet = new HttpGet(uriCloth);

		HttpResponse response = httpClient.execute(httpGet);
		HttpEntity entity = response.getEntity();
		String jsonResponse = EntityUtils.toString(entity);

		if (jsonResponse.equals("[]")) {
			System.out.println("Não há roupas disponíveis para a categoria de trajes desejada.");
		}
		else {
			String cloth = DataUtils.formatCloth(jsonResponse);
			System.out.println(jsonResponse);
		}
	}
}

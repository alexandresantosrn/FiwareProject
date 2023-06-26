package jorge.ufrn.Subscribe.Utils;

public class DataUtils {

	public static String formatCloth(String jsonResponse) {

		String traje = "";
		String word = jsonResponse.substring(184);

		for (int i = 0; i < word.length(); i++) {
			char caractere = word.charAt(i);
			if (caractere != '"') {
				traje += caractere;
			} else {
				break;
			}
		}

		String msg = "O traje: " + traje + " encontra-se disponível para aluguel na Loja:";

		return msg;
	}
}

package jorge.ufrn.Subscribe.Utils;

public class DataUtils {

	public static String formatCloth(String jsonResponse) {
		
		String word = "";		
		String traje = jsonResponse.substring(181);
		
		for (int i = 0; i < traje.length(); i++) {
		    char caractere = traje.charAt(i);
		    if (caractere != '"') {
		    	word += caractere;	
		    }
		}
		
		String msg = "O traje: " + word + " encontra-se disponível para aluguel na Loja:";
		
		return msg;		
	}
}

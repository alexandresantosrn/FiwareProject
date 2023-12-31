package jorge.ufrn.Subscribe.Utils;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class DataUtils {

	static String store1 = "";
	static String store2 = "";
	static String store3 = "";

	public static String returnData(String uri) throws ClientProtocolException, IOException {
		String jsonResponse = "";

		HttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(uri);
		HttpResponse response = httpClient.execute(httpGet);
		HttpEntity entity = response.getEntity();
		jsonResponse = EntityUtils.toString(entity);

		return jsonResponse;
	}

	public static String formatCloth(String jsonResponse) throws ClientProtocolException, IOException {

		String traje = "";
		String store = getStore(jsonResponse);
		String word = jsonResponse.substring(184);

		for (int i = 0; i < word.length(); i++) {
			char caractere = word.charAt(i);
			if (caractere != '"') {
				traje += caractere;
			} else {
				break;
			}
		}

		String msg = "O traje: " + traje + " encontra-se disponível para aluguel na Loja: " + store + ".";

		return msg;
	}

	public static void formatStore(String jsonResponse2) {

		String word1 = jsonResponse2.substring(0, 206);
		String word2 = jsonResponse2.substring(207, 414);
		String word3 = jsonResponse2.substring(415);

		store1 = word1.substring(179, 190);
		store2 = word2.substring(179, 190);
		store3 = word3.substring(178, 186);
	}

	public static String getStore(String jsonResponse) {

		if (jsonResponse.contains("S1")) {
			return store1;
		}

		else if (jsonResponse.contains("S2")) {
			return store2;
		}

		else {
			return store3;
		}

	}

}

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

		String msg = "O traje: " + traje + " encontra-se disponível para aluguel na Loja: " + store +".";

		return msg;
	}

	private static String getStore(String jsonResponse) {

		String store = "";
		if (jsonResponse.contains("S1")) {
			store = "Natal Rigor";
		}

		else if (jsonResponse.contains("S2")) {
			store = "S2";
		}

		else if (jsonResponse.contains("S3")) {
			store = "S3";
		}

		return store;
	}

}

package jorge.ufrn.Subscribe.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

import jorge.ufrn.Subscribe.Utils.DataUtils;

@RestController
@RequestMapping("/subscribe")
public class SubscribeController {

	@PostMapping
	public void exibirSubscricao(@RequestBody JsonNode body) {
		
		String store = body.findValue("store").findValue("value").textValue();
		
		store = DataUtils.getStore(store);
		
		String msg = " \n O traje: " + body.findValue("description").findValue("value")
				+ " encontra-se disponível para aluguel na Loja: " + store + ".";

		System.out.println(msg);
	}

}

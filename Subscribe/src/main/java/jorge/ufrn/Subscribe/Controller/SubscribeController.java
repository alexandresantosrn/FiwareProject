package jorge.ufrn.Subscribe.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

@RestController
@RequestMapping("/subscribe")
public class SubscribeController {

	@PostMapping
	public void exibirSubscricao(@RequestBody JsonNode body) {

		String msg = "O traje: " + body.findValue("description").findValue("value")
				+ " encontra-se disponível para aluguel na Loja: " + body.findValue("store").findValue("value") + ".";

		System.out.println(msg);
	}

}

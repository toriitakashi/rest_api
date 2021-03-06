package jp.co.toyota.rest_api.controller;

import static org.springframework.test.web.client.response.MockRestResponseCreators.withBadRequest;

import java.util.concurrent.atomic.AtomicLong;
import javax.validation.Valid;
import jp.co.toyota.rest_api.domain.model.request.GreetingRequest;
import jp.co.toyota.rest_api.domain.service.Calculator;
import jp.co.toyota.rest_api.domain.service.entity.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@RestController
public class GreetingController {

	private final AtomicLong counter = new AtomicLong();

	@Autowired
	Calculator calculator;

	@GetMapping("/greeting")
	public ResponseEntity greeting(@Valid @ModelAttribute GreetingRequest request) {
		return new ResponseEntity(counter.incrementAndGet(), String.format("Hello, %s!", request.getName()),
				calculator.calc(10, 5));
	}

}

package jp.co.toyota.rest_api.controller;

import static org.springframework.test.web.client.response.MockRestResponseCreators.withBadRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import jp.co.toyota.rest_api.domain.model.request.GreetingRequest;
import jp.co.toyota.rest_api.domain.service.Calculator;
import jp.co.toyota.rest_api.domain.service.entity.ResponseEntity;
import jp.co.toyota.rest_api.validator.ByteSize;
import lombok.NonNull;
import lombok.val;

@RestController
public class GreetingController {

	private final AtomicLong counter = new AtomicLong();

	@Autowired
	Calculator calculator;

	@GetMapping("/greeting")
	public ResponseEntity greeting(@Valid @ModelAttribute GreetingRequest request) {
		return new ResponseEntity(counter.incrementAndGet(),
				String.format("Hello, %s!", request.getName()),
				calculator.calc(10, 5));
	}

}

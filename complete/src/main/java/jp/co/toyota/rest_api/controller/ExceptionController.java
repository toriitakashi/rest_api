package jp.co.toyota.rest_api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * 例外ハンドルクラス.
 * 
 * @author DN
 *
 */
@ControllerAdvice
public class ExceptionController {

	/**
	 * リクエストのJSONのパース失敗の例外ハンドラ.
	 *
	 * @param e 例外
	 * @return エラーメッセージ
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ IllegalArgumentException.class, BindException.class })
	@ResponseBody
	public Map<String, Object> exceptionHandle(Exception e) {
		Map<String, Object> errorMap = new HashMap<String, Object>();
		errorMap.put("message", "不正なパラメータです");
		return errorMap;
	}

}

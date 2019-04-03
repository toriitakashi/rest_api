package jp.co.toyota.rest_api.validator;

import java.io.UnsupportedEncodingException;
import javax.validation.ConstraintValidatorContext;

import java.io.UnsupportedEncodingException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import lombok.val;

/**
 * ByteSizeValidator.
 *
 * @author DN
 *
 */
public class ByteSizeValidator implements ConstraintValidator<ByteSize, String> {

	/** 文字エンコーディング. */
	private String encoding;

	/** 許容する最大バイト数. */
	private int min;

	/** 許容する最大バイト数. */
	private int max;

	@Override
	public void initialize(ByteSize byteSize) {
		encoding = byteSize.encoding();
		max = byteSize.max();
		min = byteSize.min();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) {
			return true;
		}
		return isByteSizeValid(value);
	}

	/**
	 * 引数で指定した文字列のバイトサイズを検証.
	 *
	 * @param value 検証する文字列
	 * @return trueの場合、指定した許容サイズ以下
	 */
	private boolean isByteSizeValid(String value) {
		try {
			val len = value.getBytes(encoding).length;
			return len <= max && min < len;
		} catch (UnsupportedEncodingException e) {
			return false;
		}
	}
}

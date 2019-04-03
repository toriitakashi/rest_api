package jp.co.toyota.rest_api.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.lang.model.element.Element;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RUNTIME)
public @interface ByteSize {

	String message() default "";

	String encoding() default "MS932";

	public int min = 1;

	public int max = 10;

	int max() default max;

	int min() default min;

	Class< ? >[] groups() default {};

	Class< ? extends Payload>[] payload() default {};

}

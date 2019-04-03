package jp.co.toyota.rest_api.domain.model.request;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import jp.co.toyota.rest_api.validator.ByteSize;
import lombok.Data;

/**
 * 退会リクエストオブジェクト.
 *
 * @author DN
 *
 */
@Data
@NoArgsConstructor
public class GreetingRequest {

	@Size(min = 1, max = 5)
	@NonNull
	private String name;

}

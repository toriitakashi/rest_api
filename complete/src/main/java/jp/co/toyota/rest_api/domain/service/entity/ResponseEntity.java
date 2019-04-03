package jp.co.toyota.rest_api.domain.service.entity;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.Setter;

@Data
@AllArgsConstructor
@Validated
public class ResponseEntity {
	
    private final long id;
    
    private final String name;
    
    private final int age;

}

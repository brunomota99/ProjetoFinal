package com.brq.ecommerce.exceptioins;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class FieldMessageList extends StandardError {
	
	
	
	public FieldMessageList(Date data, int status, String error, String message, String path) {
		super(data, status, error, message, path);
	}


	private List<FieldMessage> erros = new ArrayList<>();
	
	
	public void addError(String fieldName, String message) {
		erros.add(new FieldMessage(fieldName, message));
	}
	
	

}

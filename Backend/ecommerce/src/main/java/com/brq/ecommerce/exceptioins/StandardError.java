package com.brq.ecommerce.exceptioins;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandardError {
	
	private Date data;
//	private Long data;
	private int status;
	private String error;
	private String message;
	private String path;
}

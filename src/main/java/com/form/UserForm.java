package com.form;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import lombok.Data;


@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserForm {

	private int userId;
	
	private int name;
	
	private int sex;
	
	private int version;
	
}

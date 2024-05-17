package com.aditya.CRUD.UserMgmtSys.ExceptionHandling;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.hibernate.mapping.List;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.aditya.CRUD.UserMgmtSys.UserdefinedExceptions.UserNotFoundException;

@Component
@RestControllerAdvice
public class ValidationsWithExceptionHandling {


	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handleUser1Exception(MethodArgumentNotValidException manve){
		
		Map<String,String> map = new HashMap<String, String>();
	
		manve.getBindingResult().getFieldErrors().forEach(error->{ map.put(error.getField(), error.getDefaultMessage());});
		
		
		return map;
		
	}
	
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(UserNotFoundException.class)
	public Map<String, String> handleUser2Exception(UserNotFoundException usfe){
		
		Map<String,String> maperror = new HashMap<>();
		
		String errormessage = usfe.getMessage();
		maperror.put("User Input Field Error", errormessage);
		
		return maperror;
		
	}
}

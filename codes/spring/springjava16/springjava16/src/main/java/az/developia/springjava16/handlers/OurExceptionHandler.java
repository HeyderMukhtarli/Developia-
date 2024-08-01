package az.developia.springjava16.handlers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import az.developia.springjava16.ErrorResponse;
import az.developia.springjava16.MyFE;
import az.developia.springjava16.OurException;

@RestControllerAdvice
public class OurExceptionHandler {

	@ExceptionHandler
	public ErrorResponse handleException(OurException exc) {
		ErrorResponse resp = new ErrorResponse();
		resp.setMessage(exc.getMessage());
		BindingResult br = exc.getBr();
		List<FieldError> fieldErrors = br.getFieldErrors();
		List<MyFE> errors = new ArrayList<MyFE>();
		for (FieldError e : fieldErrors) {
			MyFE er = new MyFE();
			er.setField(e.getField());
			er.setMessage(e.getDefaultMessage());
			errors.add(er);
		}
		resp.setFieldErrors(errors);
		return resp;
	}

}

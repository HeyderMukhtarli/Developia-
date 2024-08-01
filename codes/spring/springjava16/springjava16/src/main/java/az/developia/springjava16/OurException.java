package az.developia.springjava16;

import org.springframework.validation.BindingResult;

import lombok.Data;

@Data
public class OurException extends RuntimeException {
	private String internalMessage;
	private BindingResult br;

	public OurException(String message, String internalMessage, BindingResult br) {
		super(message);
		this.internalMessage = internalMessage;
		this.br = br;
	}
}

package az.developia.springjava16.exceptionHandler;

import lombok.Data;
import org.springframework.validation.BindingResult;
@Data
public class OurException extends RuntimeException{
    private String internalMessage;
    private BindingResult br;
    public OurException(String internalMessage,BindingResult br,String message){
        super(message);
        this.internalMessage=internalMessage;
        this.br=br;

    }
    public OurException(String message){
        super(message);

    }
}

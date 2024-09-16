package az.developia.springjava16.exceptionHandler;


import az.developia.springjava16.dto.ErrorResponse;
import az.developia.springjava16.dto.GeneralResponse;
import az.developia.springjava16.dto.MyFieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler  {

    @ExceptionHandler()
    public GeneralResponse handleValidationExceptions(OurException ex) {
        ErrorResponse resp = new ErrorResponse();

        resp.setInternalMessage(ex.getInternalMessage());

        List<MyFieldError> myFieldError = Collections.emptyList();
        if (ex.getBr() != null) {
            myFieldError = ex.getBr().getFieldErrors().stream()
                    .map(x -> new MyFieldError(x.getDefaultMessage(), x.getField()))
                    .collect(Collectors.toList());
        }
        resp.setFieldErrors(myFieldError);

        GeneralResponse gr = new GeneralResponse(resp);
        gr.setMessage(ex.getMessage());
        return gr;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public GeneralResponse handleValidationExceptions(MethodArgumentNotValidException ex) {
        ErrorResponse resp = new ErrorResponse();
        List<MyFieldError> myFieldError = Collections.emptyList();
        myFieldError = ex.getFieldErrors().stream()
                    .map(x -> new MyFieldError(x.getDefaultMessage(), x.getField()))
                    .collect(Collectors.toList());
        resp.setFieldErrors(myFieldError);
        GeneralResponse gr = new GeneralResponse(resp);
        gr.setMessage("Validation error");
        return gr;
    }

}

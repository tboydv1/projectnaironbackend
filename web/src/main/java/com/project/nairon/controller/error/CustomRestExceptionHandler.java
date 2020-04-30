package com.project.nairon.controller.error;
/*
 *@author tobi
 * created on 29/04/2020
 *
 */

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;


@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {



    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid
            ( MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status,
            WebRequest request ) {

        List<String> errors = new ArrayList<String>();

        ex.getBindingResult().getFieldErrors().stream().forEach( fieldError -> {

            errors.add(fieldError.getField() + ": " +fieldError.getDefaultMessage());
        });

        ex.getBindingResult().getGlobalErrors().stream().forEach( fieldError -> {

            errors.add(fieldError.getObjectName() + ": " +fieldError.getDefaultMessage());
        });

        ApiError apiError =
                new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);


        return super.handleExceptionInternal(ex, apiError, headers, apiError.getStatus(), request);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter
            (MissingServletRequestParameterException ex, HttpHeaders headers,
             HttpStatus status, WebRequest request) {


        String error = ex.getParameterName()+ "parameter is Missing";

        ApiError apiError =
                new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);

        return new ResponseEntity<Object>(
                apiError, new HttpHeaders(), apiError.getStatus());
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<Object> handleConstrainViolation(ConstraintViolationException ex, WebRequest request){

        List<String> errors = new ArrayList<>();

        ex.getConstraintViolations().stream().forEach( constraintViolation -> {
            errors.add(constraintViolation.getRootBeanClass().getName() + " " +
                    constraintViolation.getPropertyPath() + " : " +  constraintViolation.getMessage());
        });

        ApiError apiError =
                new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);

        return new ResponseEntity<Object>(
                apiError, new HttpHeaders(), apiError.getStatus()
                );
    }

    @ExceptionHandler({DataIntegrityViolationException.class})
    public ResponseEntity<Object> handleDataIntegrityViolation(DataIntegrityViolationException ex, WebRequest request){

        String error = ex.getRootCause().getClass().getName();

        ApiError apiError =
                new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);

        return new ResponseEntity<Object>(
                apiError, new HttpHeaders(), apiError.getStatus()
        );
    }



    @ExceptionHandler({ MethodArgumentTypeMismatchException.class })
    public ResponseEntity<Object> handleMethodArgumentTypeMismatch(
            MethodArgumentTypeMismatchException ex, WebRequest request) {
        String error =
                ex.getName() + " should be of type " + ex.getRequiredType().getName();

        ApiError apiError =
                new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
        return new ResponseEntity<Object>(
                apiError, new HttpHeaders(), apiError.getStatus());
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
            HttpRequestMethodNotSupportedException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {


        StringBuilder builder = new StringBuilder();
            builder.append(ex.getMethod());
            builder.append(
                    "method is not supported for this request. Supported methods are    "
            );

            ex.getSupportedHttpMethods().forEach(httpMethod -> builder.append(headers + " "));

        ApiError apiError = new ApiError(HttpStatus.METHOD_NOT_ALLOWED,
                ex.getLocalizedMessage(), builder.toString());

        return new ResponseEntity<Object>(
                apiError, new HttpHeaders(), apiError.getStatus());
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleAll(Exception ex,  WebRequest request){
        ex.printStackTrace();
        ApiError apiError =
                new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), "error occured");

        return new ResponseEntity<Object>(
                apiError, new HttpHeaders(), apiError.getStatus());
    }
}

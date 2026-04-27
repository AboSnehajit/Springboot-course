package com.codingshuttleweek2.spingbootwebtutorial.springbootwebtutorial.advices;


import com.codingshuttleweek2.spingbootwebtutorial.springbootwebtutorial.exception.ResourceNotFoundException;
import jakarta.validation.constraints.NotNull;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private ResponseEntity<ApiResponse<?>> buildErrorResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(new ApiResponse<>(apiError), apiError.getStatus());
    }


    //when search by id is not found
        @ExceptionHandler(ResourceNotFoundException.class)
        public ResponseEntity<ApiResponse<?>> handleResourceNotFound(ResourceNotFoundException exception){
//            return  new ResponseEntity<>("Resource not found ", HttpStatus.NOT_FOUND);
              ApiError apiError = ApiError.builder()
                      .status(HttpStatus.NOT_FOUND)
                      .message(exception.getMessage())
                      .build();
//              return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
               return buildErrorResponseEntity(apiError);
        }




    //provided value to the field is not valid
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleMethodArgumentNotValidException(@NotNull MethodArgumentNotValidException exception) {
            List<String>errors = exception.getBindingResult()
                          .getAllErrors()
                          .stream()
                          .map(error -> error.getDefaultMessage())
                          .collect(Collectors.toList());


            ApiError apiError = ApiError.builder()
                    .status(HttpStatus.BAD_REQUEST)
                    .message("Input Validation Failed")
                    .subErrors(errors)
                    .build();
//            return  new ResponseEntity<>(apiError , HttpStatus.BAD_REQUEST);
              return buildErrorResponseEntity(apiError);
        }


        //Json is not correct, syntax , type mismatch, missing noargs consttructor
         @ExceptionHandler(HttpMessageNotReadableException.class)
         public ResponseEntity<ApiResponse<?>>handleHttpMessageNotReadableException(@NotNull HttpMessageNotReadableException exception){

        //get the message
             Throwable rootCause = exception.getRootCause();
            ApiError apiError =ApiError.builder()
                    .status(HttpStatus.BAD_REQUEST)
                    .message(rootCause.getMessage())
                    .build ();

            return buildErrorResponseEntity(apiError);
         }

        // Illegal fields in patch or other request
         @ExceptionHandler(IllegalArgumentException.class)
         public ResponseEntity<ApiResponse<?>> handleIllegalArgumentException(IllegalArgumentException exception)
         {
             ApiError apiError = ApiError.builder()
                                 .status(HttpStatus.BAD_REQUEST)
                     .message(exception.getMessage())
                     .build();
             return buildErrorResponseEntity(apiError);
         }


         @ExceptionHandler(DataIntegrityViolationException.class)
         public ResponseEntity<ApiResponse<?>>handleDataIntegrityViolation( DataIntegrityViolationException exception)
         {
             ApiError apiError = ApiError.builder()
                     .status(HttpStatus.BAD_REQUEST)
                     .message("Database constraint violation")
                     .build();

             return buildErrorResponseEntity(apiError);
         }

        //wil now handle the validations
        @ExceptionHandler(Exception.class)
        public ResponseEntity<ApiResponse<?>> handleException(Exception exception){
            ApiError apiError = ApiError.builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message(exception.getMessage())
                    .build();
//            return  new ResponseEntity<>(apiError , HttpStatus.INTERNAL_SERVER_ERROR);
            return buildErrorResponseEntity(apiError);

        }


    }


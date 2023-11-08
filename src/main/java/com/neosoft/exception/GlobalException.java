package com.neosoft.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalException {
        @ExceptionHandler(value = {paymentFailedException.class})
        public ResponseEntity<Object> handleCustomer(paymentFailedException paymentFailedException) {
//        System.out.println("inside the handleCustomer() method");
//        UserException userexception = new UserException(userexceptionclass.getMessage(),
//                userexceptionclass.getCause(), HttpStatus.NOT_FOUND); // constructor calling
//        System.out.println("after calling constructor of CustomerException");
            return new ResponseEntity<Object>((Object) paymentFailedException.getMessage(), HttpStatus.NOT_FOUND);
        }

}

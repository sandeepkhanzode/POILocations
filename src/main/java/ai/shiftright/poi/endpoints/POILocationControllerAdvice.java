package ai.shiftright.poi.endpoints;

import java.sql.SQLException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import ai.shiftright.poi.services.impl.POIApplicationException;

/**
 * @author Sandeep Ramesh Khanzode
 *
 */
@ControllerAdvice
public class POILocationControllerAdvice extends ResponseEntityExceptionHandler {
		 
	    @ExceptionHandler(value  = { MethodArgumentTypeMismatchException.class, SQLException.class, POIApplicationException.class })
	    protected ResponseEntity<Object> handleConflict(final RuntimeException exception, WebRequest request) {
	        String bodyOfResponse = "Please check the input arguments and try again!";
	        return handleExceptionInternal(exception, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	    }
}

package br.com.zup.config;

import javax.servlet.http.HttpServlet;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.zup.dto.ErrorInfo;
import br.com.zup.exceptions.BusinessException;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(BusinessException.class)
	@ResponseBody
	public ResponseEntity<ErrorInfo> handleBusinessException(HttpServlet req, Throwable ex) {
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setStatus(String.valueOf(HttpStatus.BAD_REQUEST.value()));
		errorInfo.setTimestamp(String.valueOf(System.currentTimeMillis()));
		errorInfo.setMessage(ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorInfo);
	}

}

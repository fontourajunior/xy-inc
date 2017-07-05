package br.com.zup.config;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

	//	@ExceptionHandler(BusinessException.class)
	//	@ResponseBody
	//	public ResponseEntity<ErrorInfo> handleBusinessException(HttpServlet req, Throwable ex) {
	//		ErrorInfo errorInfo = new ErrorInfo();
	//		errorInfo.setStatus(String.valueOf(HttpStatus.BAD_REQUEST.value()));
	//		errorInfo.setTimestamp(String.valueOf(System.currentTimeMillis()));
	//		errorInfo.setMessage(ex.getMessage());
	//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorInfo);
	//	}

}

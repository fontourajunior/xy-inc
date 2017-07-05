package br.com.zup.exceptions;

import org.springframework.stereotype.Service;

@Service
public class BusinessException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public BusinessException() {
		super(null, null, true, false);
	}

	public BusinessException(boolean withStackTrace) {
		super(null, null, true, withStackTrace);
	}

	public BusinessException(String message) {
		super(message, null, true, false);
	}

	public BusinessException(String message, boolean withStackTrace) {
		super(message, null, true, withStackTrace);
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause, true, false);
	}

	public BusinessException(String message, Throwable cause, boolean withStackTrace) {
		super(message, cause, true, withStackTrace);
	}

	public BusinessException(Throwable cause) {
		super(null, cause, true, false);
	}

	public BusinessException(Throwable cause, boolean withStackTrace) {
		super(null, cause, true, withStackTrace);
	}

	public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean withStackTrace) {
		super(message, cause, enableSuppression, withStackTrace);
	}

}

package web.mvc.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;
import web.mvc.dto.ResponseDTO;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionAdvice {

	@ExceptionHandler({MyErrorException.class})
	public ResponseEntity<?> error(MyErrorException e) {
		log.info("[ERROR] " + e.getMessage());
		
		ResponseDTO dto = ResponseDTO.builder()
				.status(e.getErrorCode().getStatus())
				.msg(e.getErrorCode().getMsg())
				.build();
		
		return ResponseEntity.status(dto.getStatus()).body(dto);
	}
}

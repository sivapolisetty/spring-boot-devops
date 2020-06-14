package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {
	
	Logger logger = LoggerFactory.getLogger(TodoController.class);
	
	 
	@RequestMapping("/hello")
	public ResponseEntity<String> getHello() {
		logger.info("get hello rest service called");
		return new ResponseEntity<String>("Hello service", HttpStatus.OK);
	}
	


}

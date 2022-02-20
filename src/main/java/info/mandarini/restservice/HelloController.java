package info.mandarini.restservice;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import info.mandarini.restservice.persistence.domain.User;
import info.mandarini.restservice.persistence.repositories.UserRepository;


@RestController
public class HelloController {
	
	@Autowired
	UserRepository repository;
	
	@GetMapping("/")
	public String index() throws Exception {
		StringBuilder html = new StringBuilder();
		 ClassLoader classLoader = getClass().getClassLoader();
		URI res = classLoader.getResource("insert.html").toURI();
		try (Stream<String> lines = Files.lines(Paths.get(res), StandardCharsets.UTF_8)) {
			  lines.forEach(x -> html.append(x+"\n"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		return html.toString();
	}
	
	@PostMapping("/insert")
	User insertUser(@RequestBody User user) {
	    return repository.save(user);
	  }
	
	
	@GetMapping("/list")
	Iterable<User> listUsers() {
	    return repository.findAll();
	  }
	


}

package in.ineuron.restcontroller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.User;
import in.ineuron.repository.IUserRepository;

@RestController
public class UserController {
	private IUserRepository userRepository;

	public UserController(IUserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@PostMapping(value = "/add", consumes = "application/json")
	public User add(@RequestBody User user) {
		userRepository.save(user);
		return userRepository.findById(user.getId());
	}

	@GetMapping("/update/{id}/{name}")
	public User update(@PathVariable("id") final String id, @PathVariable("name") final String name) {
		userRepository.update(new User(id, name, 1000L));
		return userRepository.findById(id);
	}

	@GetMapping("/delete/{id}")
	public Map<String, User> delete(@PathVariable("id") final String id) {
		userRepository.delete(id);
		return all();
	}

	@GetMapping("/all")
	public Map<String, User> all() {
		Map<String, User> findAll = userRepository.findAll();
		if (findAll.isEmpty()) {
			// get data from db
			// store data to redis cache
		}
		return findAll;
	}

}

package in.ineuron.repository;

import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import in.ineuron.model.User;

@Repository
public class UserRepositoryImpl implements IUserRepository {
	
	private HashOperations<String, String, User> hashOperations;
	
	public UserRepositoryImpl(RedisTemplate<String, User> redisTemplate) {
		hashOperations = redisTemplate.opsForHash();
		
	}
	

	@Override
	public void save(User user) {
		hashOperations.put("USER", user.getId(), user);
	}

	@Override
	public Map<String, User> findAll() {
		// TODO Auto-generated method stub
		return hashOperations.entries("USER");
	}

	@Override
	public User findById(String id) {
		User user = (User) hashOperations.get("USER", id);
		if (user == null) {
			// load from database
		}
		return user;
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

}

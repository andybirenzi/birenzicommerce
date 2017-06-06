package birenzi.commerce.springboot.service;

import birenzi.commerce.springboot.pojo.User;

public interface UserService {
	public User findByEmail(String email);

	public User findByUserName(String userName);

	public void saveUser(User user);

}

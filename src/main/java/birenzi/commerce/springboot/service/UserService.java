package birenzi.commerce.springboot.service;

import birenzi.commerce.springboot.pojo.User;

public interface UserService {
	public User findUserByEmail(String email);

	public User findUserByUserName(String userName);

	public void saveUser(User user);

}

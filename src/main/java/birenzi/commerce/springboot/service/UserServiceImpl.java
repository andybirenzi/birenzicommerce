package birenzi.commerce.springboot.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.BootstrapWith;

import birenzi.commerce.springboot.pojo.Role;
import birenzi.commerce.springboot.pojo.User;
import birenzi.commerce.springboot.repository.RoleRepository;
import birenzi.commerce.springboot.repository.UserRepository;
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepo;
//	@Autowired
//	RoleRepository roleRepo;
//	@Autowired
//	BCryptPasswordEncoder encoder;

	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepo.findByEmail(email);
	}

	@Override
	public User findUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return userRepo.findByUserName(userName);
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
//		user.setPassword(encoder.encode(user.getPassword()));
		user.setActive(1);
//		Role userRole = roleRepo.findByRole("ADMIN");
//		user.setRoles(new HashSet<>(Arrays.asList(userRole)));
		userRepo.save(user);
	}

}

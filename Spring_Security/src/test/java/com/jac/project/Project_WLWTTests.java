package com.jac.project;

import com.jac.project.model.Role;
import com.jac.project.model.User;
import com.jac.project.repository.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class Project_WLWTTests {

	@Autowired
	UserDao userDao;
	@Test
	void contextLoads() {
		User user1 = new User();
		user1.setAccountNonExpired(true);
		user1.setAccountNonLocked(true);
		user1.setCredentialsNonExpired(true);
		user1.setEnabled(true);
		user1.setPword("123");
		user1.setEmail("zeen");

		List<Role> roles1 = new ArrayList<>();
		Role r1 = new Role("ROLE_user");
		r1.setRole("ROLE_admin");
		roles1.add(r1);

		user1.setRoles(roles1);
		userDao.save(user1);

		// user2
		User user2 = new User();
		user2.setAccountNonExpired(true);
		user2.setAccountNonLocked(true);
		user2.setCredentialsNonExpired(true);
		user2.setEnabled(true);
		user2.setPword("123");
		user2.setEmail("wu");

		List<Role> roles2 = new ArrayList<>();
		Role r2 = new Role("ROLE_user");
		r2.setRole("ROLE_user");
		roles2.add(r2);

		user2.setRoles(roles2);
		userDao.save(user2);
	}

}

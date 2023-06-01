package U2W1D4THEORYJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import U2W1D4THEORYJPA.dao.UsersService;
import U2W1D4THEORYJPA.entities.User;

@Component
public class UserRunner implements CommandLineRunner {
	@Autowired
	UsersService usersService;

	@Override
	public void run(String... args) throws Exception {
		User aldo = new User();
		aldo.setEmail("aldo.baglio@agg.com");
		aldo.setName("aldo");
		aldo.setSurname("baglio");

		// usersService.create(aldo);

		usersService.find().forEach(user -> System.out.println(user));

		try {
			usersService.findById(4);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}

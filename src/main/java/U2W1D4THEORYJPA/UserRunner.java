package U2W1D4THEORYJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import U2W1D4THEORYJPA.dao.UsersService;
import U2W1D4THEORYJPA.entities.User;
import U2W1D4THEORYJPA.exception.ItemNotFoundException;

@Component
public class UserRunner implements CommandLineRunner {
	@Autowired
	UsersService usersService;

	@Override
	public void run(String... args) throws Exception {
		User aldo = new User();
		aldo.setEmail("giacomo@poretti.it");
		aldo.setName("Giacomo");
		aldo.setSurname("Poretti");

//		usersService.create(aldo);

		System.out.println("*********************** FIND ALL ***********************");
		usersService.find().forEach(user -> System.out.println(user));

		System.out.println("*********************** FIND BY ID ***********************");
		try {
			System.out.println(usersService.findById(2));

		} catch (ItemNotFoundException e) {
			System.out.println(e);
		}

		System.out.println("*********************** FIND BY ID AND UPDATE ***********************");
		try {
			usersService.findByIdAndUpdate(2, aldo);
			System.out.println(usersService.findById(2));

		} catch (ItemNotFoundException e) {
			System.out.println(e);
		}

		System.out.println("*********************** FIND BY ID AND DELETE ***********************");
		try {
			usersService.findByIdAndDelete(3);
			System.out.println(usersService.findById(3));

		} catch (ItemNotFoundException e) {
			System.out.println(e);
		}

		System.out.println("*********************** COUNT ***********************");
		System.out.println(usersService.count());

	}

}

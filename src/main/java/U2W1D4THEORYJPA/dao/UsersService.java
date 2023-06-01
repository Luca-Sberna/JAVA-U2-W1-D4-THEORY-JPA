package U2W1D4THEORYJPA.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import U2W1D4THEORYJPA.entities.User;
import U2W1D4THEORYJPA.exception.ItemNotFoundException;

@Service
public class UsersService {
	@Autowired
	private UsersRepository usersRepo;

	public void create(User u) {
//logica custom addizionale
		usersRepo.save(u);
	}

	public List<User> find() {
		return usersRepo.findAll();
	}

	public User findByNameIgnoreCase(String name) throws ItemNotFoundException {
		return usersRepo.findByNameIgnoreCase(name).orElseThrow(() -> new ItemNotFoundException(name));
	}

	public User findById(int id) {
		// Optional<User> found = usersRepo.findById(id);

//		if (found.isPresent()) {
//			return found.get();
//		} else {
//			throw new ItemNotFoundException(id);
//		}

		return usersRepo.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
		// stessa maniera piu coincisa ^
	}

	public void findByIdAndUpdate(int id, User u) throws ItemNotFoundException {
		User found = this.findById(id);
		found.setId(u.getId());
		found.setName(u.getName());
		found.setSurname(u.getSurname());
		found.setEmail(u.getEmail());

	}

	public void findByIdAndDelete(int id) {
		User found = this.findById(id);
		usersRepo.delete(found);
	}

	public long count() {
		return usersRepo.count();
	}
}

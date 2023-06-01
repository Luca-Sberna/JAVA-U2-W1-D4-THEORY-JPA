package U2W1D4THEORYJPA.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import U2W1D4THEORYJPA.entities.User;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer> { // gia cosi è implementato il crud
//	List<User> findByNameIgnoreCase(String name);

	Optional<User> findByNameIgnoreCase(String name);
	// corrisponde ad un select from user where name= :name

	List<User> findByNameAndSurname(String name, String surname);
}

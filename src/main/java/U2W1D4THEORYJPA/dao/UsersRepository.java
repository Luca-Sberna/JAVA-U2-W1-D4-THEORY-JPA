package U2W1D4THEORYJPA.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import U2W1D4THEORYJPA.entities.User;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer> { // gia cosi è implementato il crud

}

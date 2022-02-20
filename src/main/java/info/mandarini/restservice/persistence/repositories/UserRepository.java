package info.mandarini.restservice.persistence.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import info.mandarini.restservice.persistence.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

	List<User> findByLastName(String lastName);

	User findById(long id);
}

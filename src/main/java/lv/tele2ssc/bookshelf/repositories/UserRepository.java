package lv.tele2ssc.bookshelf.repositories;

import java.util.List;
import lv.tele2ssc.bookshelf.model.Book;
import lv.tele2ssc.bookshelf.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository works directly with a table.
 * It has common operation (like selection by id, saving, 
 * counting etc.) defined in CrudRepository already
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    User findByEmail(String email);
    List<User> findAll();
}

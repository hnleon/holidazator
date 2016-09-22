package ua.pp.leon.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Andrii Zalevskyi <azalevskyi@gmail.com>
 */
@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    public User findByUsername(String username);
}

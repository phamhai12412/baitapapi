package ra.session5_spring_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.session5_spring_jpa.model.Author;


@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
}
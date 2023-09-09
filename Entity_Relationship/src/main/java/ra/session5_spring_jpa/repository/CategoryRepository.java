package ra.session5_spring_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.session5_spring_jpa.model.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {
}

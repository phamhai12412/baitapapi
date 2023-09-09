package ra.session5_spring_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.session5_spring_jpa.model.Zipcode;


public interface ZipcodeRepository extends JpaRepository<Zipcode, Long> {
}

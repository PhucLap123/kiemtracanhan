package luphuclap.demo.repository;

import luphuclap.demo.entity.PhongBan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface phongbanRepository extends JpaRepository<PhongBan,String> {
}
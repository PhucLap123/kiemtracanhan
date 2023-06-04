package luphuclap.demo.repository;

import luphuclap.demo.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface nhanvienRepository extends JpaRepository<NhanVien,String> {
}

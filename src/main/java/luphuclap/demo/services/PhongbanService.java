package luphuclap.demo.services;

import luphuclap.demo.entity.PhongBan;
import luphuclap.demo.repository.phongbanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhongbanService {
    @Autowired
    private phongbanRepository phongBanRepository;

    public List<PhongBan> getAllPhongBan(){
        return phongBanRepository.findAll();
    }

    public void addPhongBan(PhongBan newCategory){
        phongBanRepository.save(newCategory);
    }
    public PhongBan savePhongBan(PhongBan category) { return phongBanRepository.save(category);}
    public void updateCategory(PhongBan category){
        phongBanRepository.save(category);
    }
    /*public void deleteCategory(String id) {phongBanRepository.deleteById(id);}*/
}

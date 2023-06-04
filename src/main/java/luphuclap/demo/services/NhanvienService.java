package luphuclap.demo.services;


import luphuclap.demo.entity.NhanVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import luphuclap.demo.repository.nhanvienRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NhanvienService {
    @Autowired
    private nhanvienRepository nhanVienRepository;
    public List<NhanVien> getAllNhanVien(){
        return nhanVienRepository.findAll();
    }
    public NhanVien getNhanVienById(String id){
        Optional<NhanVien> optionalBook = nhanVienRepository.findById(id);
        return optionalBook.orElse(null);
    }
    public void add(NhanVien newNhanVien){
        nhanVienRepository.save(newNhanVien);
    }
    public void updateBook(NhanVien newbook){
        nhanVienRepository.save(newbook);
    }
    public void deleteBook(String id){
        nhanVienRepository.deleteById(id);
    }
}

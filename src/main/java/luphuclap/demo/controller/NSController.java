package luphuclap.demo.controller;

import luphuclap.demo.entity.NhanVien;
import luphuclap.demo.services.NhanvienService;
import luphuclap.demo.services.PhongbanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/nhanvien")
public class NSController {
    @Autowired
    private NhanvienService nhanVienService;
    @Autowired
    private PhongbanService phongBanService;
    @GetMapping
    public String listBooks(Model model){
        List<NhanVien> nhanViens = nhanVienService.getAllNhanVien();
        model.addAttribute("listNhanVien", nhanViens);
        model.addAttribute("title", "List Nhan Vien");
        return "nhanvien/list";
    }

    @GetMapping("/add")
    public String addBookForm(Model model){
        model.addAttribute("nhanvien", new NhanVien());
        model.addAttribute("listPhongBan", phongBanService.getAllPhongBan());
        return "nhanvien/add";
    }
    @PostMapping("/add")
    public String addBook( @ModelAttribute("nhanvien") NhanVien nhanVien, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("listPhongBan", phongBanService.getAllPhongBan());
            return "nhanvien/add";
        }
        nhanVienService.add(nhanVien);
        return "redirect:/nhanvien";
    }

    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable("id") String id, Model model){
        NhanVien editNhanVien = nhanVienService.getNhanVienById(id);
        if(editNhanVien != null){
            model.addAttribute("nhanvien", editNhanVien);
            model.addAttribute("listPhongBan", phongBanService.getAllPhongBan());
            return "nhanvien/edit";
        }else {
            return "not-found";
        }
    }
    @PostMapping("/edit")
    public String editBook( @ModelAttribute("nhanvien")NhanVien updateNhanVien, BindingResult bindingResult, Model model ){
        if (bindingResult.hasErrors()){
            model.addAttribute("listPhongBan", phongBanService.getAllPhongBan());
            return "nhanvien/edit";
        }
        nhanVienService.updateBook(updateNhanVien);
        return "redirect:/nhanvien";
    }
    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") String id){
        nhanVienService.deleteBook(id);
        return "redirect:/nhanvien";
    }
}

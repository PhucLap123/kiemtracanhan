package luphuclap.demo.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;


@Data
@Entity

@Table(name="nhanvien")
public class NhanVien {

    @Id
    @Column(name = "ma_nv")
    private String ma_nv;

    @Column(name = "ten_nv")
    @NotNull
    private String ten_nv;

    @Column(name = "phai")
    private String phai;

    @Column(name = "noi_sinh")
    private String noi_sinh;
    @ManyToOne
    @JoinColumn(name = "ma_phong")
    private PhongBan phongBan;
    @Column(name = "luong")
    private int luong;


}

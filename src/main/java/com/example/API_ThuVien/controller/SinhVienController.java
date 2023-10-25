package com.example.API_ThuVien.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.API_ThuVien.model.SinhVien;
import com.example.API_ThuVien.repository.SinhVienRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sv")
public class SinhVienController {

    @Autowired
    private SinhVienRepository sinhVienRepository;

    // Tạo một sinh viên mới
    @PostMapping("")
    public SinhVien createSinhVien(@RequestBody SinhVien sinhVien) {
        return sinhVienRepository.save(sinhVien);
    }

    // Lấy tất cả sinh viên
    @GetMapping("")
    public List<SinhVien> getAllSinhVien() {
        return sinhVienRepository.findAll();
    }

    // Lấy sinh viên bằng ID
    @GetMapping("/{id}")
    public Optional<SinhVien> getSinhVienById(@PathVariable Integer id) {
        return sinhVienRepository.findById(id);
    }

    // Xóa sinh viên bằng ID
    @DeleteMapping("/{id}")
    public void deleteSinhVien(@PathVariable Integer id) {
        sinhVienRepository.deleteById(id);
    }

    // Cập nhật thông tin sinh viên
    @PutMapping("/{id}")
    public SinhVien updateSinhVien(@PathVariable Integer id, @RequestBody SinhVien sinhVien) {
        if (sinhVienRepository.existsById(id)) {
            sinhVien.setId_sv(id);
            return sinhVienRepository.save(sinhVien);
        } else {
            // Xử lý khi sinh viên không tồn tại
            throw new RuntimeException("Sinh viên không tồn tại với ID " + id);
        }
    }
}

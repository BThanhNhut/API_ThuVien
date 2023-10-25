package com.example.API_ThuVien.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.API_ThuVien.model.Loai;
import com.example.API_ThuVien.repository.LoaiRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/loai")
public class LoaiController {

    @Autowired
    private LoaiRepository loaiRepository;

    // Tạo một loại mới
    @PostMapping("")
    public Loai createLoai(@RequestBody Loai loai) {
        return loaiRepository.save(loai);
    }

    // Lấy tất cả các loại
    @GetMapping("")
    public List<Loai> getAllLoai() {
        return loaiRepository.findAll();
    }

    // Lấy loại bằng ID
    @GetMapping("/{id}")
    public Optional<Loai> getLoaiById(@PathVariable Integer id) {
        return loaiRepository.findById(id);
    }

    // Xóa loại bằng ID
    @DeleteMapping("/{id}")
    public void deleteLoai(@PathVariable Integer id) {
        loaiRepository.deleteById(id);
    }

    // Cập nhật thông tin loại
    @PutMapping("/{id}")
    public Loai updateLoai(@PathVariable Integer id, @RequestBody Loai loai) {
        if (loaiRepository.existsById(id)) {
            loai.setId_loai(id);
            return loaiRepository.save(loai);
        } else {
            // Xử lý khi loại không tồn tại
            throw new RuntimeException("Loại không tồn tại với ID " + id);
        }
    }
}

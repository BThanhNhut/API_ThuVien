package com.example.API_ThuVien.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.API_ThuVien.model.Yeuthich;
import com.example.API_ThuVien.repository.YeuThichRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/yeuthich")
public class YeuThichController {

    @Autowired
    private YeuThichRepository yeuthichRepository;

    // Tạo một đối tượng yêu thích mới
    @PostMapping("")
    public Yeuthich createYeuthich(@RequestBody Yeuthich yeuthich) {
        return yeuthichRepository.save(yeuthich);
    }

    // Lấy tất cả các đối tượng yêu thích
    @GetMapping("")
    public List<Yeuthich> getAllYeuthich() {
        return yeuthichRepository.findAll();
    }

    // Lấy đối tượng yêu thích bằng ID
    @GetMapping("/{id}")
    public Optional<Yeuthich> getYeuthichById(@PathVariable Integer id) {
        return yeuthichRepository.findById(id);
    }

    // Xóa đối tượng yêu thích bằng ID
    @DeleteMapping("/{id}")
    public void deleteYeuthich(@PathVariable Integer id) {
        yeuthichRepository.deleteById(id);
    }

    // Cập nhật thông tin đối tượng yêu thích
    @PutMapping("/{id}")
    public Yeuthich updateYeuthich(@PathVariable Integer id, @RequestBody Yeuthich yeuthich) {
        if (yeuthichRepository.existsById(id)) {
            yeuthich.setId_yeuthich(id);
            return yeuthichRepository.save(yeuthich);
        } else {
            // Xử lý khi đối tượng yêu thích không tồn tại
            throw new RuntimeException("Đối tượng yêu thích không tồn tại với ID " + id);
        }
    }
}

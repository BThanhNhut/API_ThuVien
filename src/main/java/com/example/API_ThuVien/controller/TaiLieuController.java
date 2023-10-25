package com.example.API_ThuVien.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.API_ThuVien.model.Tailieu;
import com.example.API_ThuVien.repository.TaiLieuRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tailieu")
public class TaiLieuController {

    @Autowired
    private TaiLieuRepository tailieuRepository;

    // Tạo một tài liệu mới
    @PostMapping("")
    public Tailieu createTailieu(@RequestBody Tailieu tailieu) {
        return tailieuRepository.save(tailieu);
    }

    // Lấy tất cả các tài liệu
    @GetMapping("")
    public List<Tailieu> getAllTailieu() {
        return tailieuRepository.findAll();
    }

    // Lấy tài liệu bằng ID
    @GetMapping("/{id}")
    public Optional<Tailieu> getTailieuById(@PathVariable Integer id) {
        return tailieuRepository.findById(id);
    }

    // Xóa tài liệu bằng ID
    @DeleteMapping("/{id}")
    public void deleteTailieu(@PathVariable Integer id) {
        tailieuRepository.deleteById(id);
    }

    // Cập nhật thông tin tài liệu
    @PutMapping("/{id}")
    public Tailieu updateTailieu(@PathVariable Integer id, @RequestBody Tailieu tailieu) {
        if (tailieuRepository.existsById(id)) {
            tailieu.setId_tailieu(id);
            return tailieuRepository.save(tailieu);
        } else {
            // Xử lý khi tài liệu không tồn tại
            throw new RuntimeException("Tài liệu không tồn tại với ID " + id);
        }
    }
}

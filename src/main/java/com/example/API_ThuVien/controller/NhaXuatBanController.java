package com.example.API_ThuVien.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.API_ThuVien.model.Nhaxuatban;
import com.example.API_ThuVien.repository.NhaXuatBanRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/nhaxuatban")
public class NhaXuatBanController {

    @Autowired
    private NhaXuatBanRepository nhaxuatbanRepository;

    // Tạo một nhà xuất bản mới
    @PostMapping("")
    public Nhaxuatban createNhaxuatban(@RequestBody Nhaxuatban nhaxuatban) {
        return nhaxuatbanRepository.save(nhaxuatban);
    }

    // Lấy tất cả các nhà xuất bản
    @GetMapping("")
    public List<Nhaxuatban> getAllNhaxuatban() {
        return nhaxuatbanRepository.findAll();
    }

    // Lấy nhà xuất bản bằng ID
    @GetMapping("/{id}")
    public Optional<Nhaxuatban> getNhaxuatbanById(@PathVariable Integer id) {
        return nhaxuatbanRepository.findById(id);
    }

    // Xóa nhà xuất bản bằng ID
    @DeleteMapping("/{id}")
    public void deleteNhaxuatban(@PathVariable Integer id) {
        nhaxuatbanRepository.deleteById(id);
    }

    // Cập nhật thông tin nhà xuất bản
    @PutMapping("/{id}")
    public Nhaxuatban updateNhaxuatban(@PathVariable Integer id, @RequestBody Nhaxuatban nhaxuatban) {
        if (nhaxuatbanRepository.existsById(id)) {
            nhaxuatban.setId_nxb(id);
            return nhaxuatbanRepository.save(nhaxuatban);
        } else {
            // Xử lý khi nhà xuất bản không tồn tại
            throw new RuntimeException("Nhà xuất bản không tồn tại với ID " + id);
        }
    }
}

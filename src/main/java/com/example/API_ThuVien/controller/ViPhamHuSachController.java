package com.example.API_ThuVien.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.API_ThuVien.model.Viphamhusach;
import com.example.API_ThuVien.repository.ViPhamHuSachRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/viphamhusach")
public class ViPhamHuSachController {

    @Autowired
    private ViPhamHuSachRepository viphamhusachRepository;

    // Tạo một vi phạm hư sách mới
    @PostMapping("")
    public Viphamhusach createViphamhusach(@RequestBody Viphamhusach viphamhusach) {
        return viphamhusachRepository.save(viphamhusach);
    }

    // Lấy tất cả các vi phạm hư sách
    @GetMapping("")
    public List<Viphamhusach> getAllViphamhusach() {
        return viphamhusachRepository.findAll();
    }

    // Lấy vi phạm hư sách bằng ID
    @GetMapping("/{id}")
    public Optional<Viphamhusach> getViphamhusachById(@PathVariable Integer id) {
        return viphamhusachRepository.findById(id);
    }

    // Xóa vi phạm hư sách bằng ID
    @DeleteMapping("/{id}")
    public void deleteViphamhusach(@PathVariable Integer id) {
        viphamhusachRepository.deleteById(id);
    }

    // Cập nhật thông tin vi phạm hư sách
    @PutMapping("/{id}")
    public Viphamhusach updateViphamhusach(@PathVariable Integer id, @RequestBody Viphamhusach viphamhusach) {
        if (viphamhusachRepository.existsById(id)) {
            viphamhusach.setId_vipham(id);
            return viphamhusachRepository.save(viphamhusach);
        } else {
            // Xử lý khi vi phạm hư sách không tồn tại
            throw new RuntimeException("Vi phạm hư sách không tồn tại với ID " + id);
        }
    }
}

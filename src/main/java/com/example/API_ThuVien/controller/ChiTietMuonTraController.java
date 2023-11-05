package com.example.API_ThuVien.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.API_ThuVien.model.Chitietmuontra;
import com.example.API_ThuVien.model.ChitietmuontraDTO;
import com.example.API_ThuVien.repository.ChiTietMuonTraRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/chitietmuontra")
public class ChiTietMuonTraController {

    @Autowired
    private ChiTietMuonTraRepository chitietmuontraRepository;

    // Tạo một chi tiết mượn trả mới
    @PostMapping("")
    public Chitietmuontra createChitietmuontra(@RequestBody Chitietmuontra chitietmuontra) {
        return chitietmuontraRepository.save(chitietmuontra);
    }

    // Lấy tất cả các chi tiết mượn trả
    @GetMapping("")
    public List<Chitietmuontra> getAllChitietmuontra() {
        return chitietmuontraRepository.findAll();
    }

    // Lấy chi tiết mượn trả bằng ID
    @GetMapping("/{id}")
    public Optional<Chitietmuontra> getChitietmuontraById(@PathVariable Integer id) {
        return chitietmuontraRepository.findById(id);
    }

    // Xóa chi tiết mượn trả bằng ID
    @DeleteMapping("/{id}")
    public void deleteChitietmuontra(@PathVariable Integer id) {
        chitietmuontraRepository.deleteById(id);
    }

    // Cập nhật thông tin chi tiết mượn trả
    @PutMapping("/{id}")
    public Chitietmuontra updateChitietmuontra(@PathVariable Integer id, @RequestBody Chitietmuontra chitietmuontra) {
        if (chitietmuontraRepository.existsById(id)) {
            chitietmuontra.setId_ctmuon(id);
            return chitietmuontraRepository.save(chitietmuontra);
        } else {
            // Xử lý khi chi tiết mượn trả không tồn tại
            throw new RuntimeException("Chi tiết mượn trả không tồn tại với ID " + id);
        }
    }
    //
    @GetMapping("/info")
    public List<ChitietmuontraDTO> loadChiTietMuonTra ()
    {
    	return chitietmuontraRepository.getChitietmuontraInfo();
    }
    @GetMapping("/info/{id}")
    public List<ChitietmuontraDTO> loadChiTietMuonTra(@PathVariable int id) {
        return chitietmuontraRepository.getChitietmuontraInfoByMuonId(id);
    }
}

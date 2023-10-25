package com.example.API_ThuVien.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.API_ThuVien.model.Muontra;
import com.example.API_ThuVien.model.Tailieu;
import com.example.API_ThuVien.model.Viphamhusach;
import com.example.API_ThuVien.repository.MuonTraRepository;
import com.example.API_ThuVien.repository.ViPhamHuSachRepository;

@RestController
@RequestMapping("/viphamhusach")
public class ViPhamHuSachController {

    @Autowired
    private ViPhamHuSachRepository viphamhusachRepository;
    @Autowired
    private MuonTraRepository muontraRepository; 
    // Tạo một vi phạm hư sách mới
    @PostMapping("")
    public Viphamhusach createViphamhusach(@RequestBody Viphamhusach viphamhusach) {
        return viphamhusachRepository.save(viphamhusach);
    }

    // Lấy tất cả vi phạm hư sách
    @GetMapping("")
    public List<Viphamhusach> getAllViphamhusach() {
        return viphamhusachRepository.findAll();
    }

    // Xóa vi phạm hư sách bằng cả hai khóa chính
    @DeleteMapping("/{idTailieu}/{idMuon}")
    public void deleteViphamhusach(@PathVariable Integer idTailieu, @PathVariable Integer idMuon) {
        viphamhusachRepository.deleteByTailieuAndMuon(idTailieu, idMuon);
    }

    // Cập nhật thông tin vi phạm hư sách (nếu cần)
    @PutMapping("/{idTailieu}/{idMuon}")
    public Viphamhusach updateViphamhusach(@PathVariable Integer idTailieu, @PathVariable Integer idMuon, @RequestBody Viphamhusach viphamhusach) {
        // Code cập nhật thông tin vi phạm hư sách (nếu cần)
        // ...
        return viphamhusach;
    }
}

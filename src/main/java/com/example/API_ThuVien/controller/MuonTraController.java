package com.example.API_ThuVien.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.API_ThuVien.model.Muontra;
import com.example.API_ThuVien.model.MuontraDTO;
import com.example.API_ThuVien.repository.MuonTraRepository;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/muontra")
public class MuonTraController {

    @Autowired
    private MuonTraRepository muontraRepository;

    // Tạo một phiếu mượn mới
    @PostMapping("")
    public Muontra createMuontra(@RequestBody Muontra muontra) {
        return muontraRepository.save(muontra);
    }

    // Lấy tất cả các phiếu mượn
    @GetMapping("")
    public List<Muontra> getAllMuontra() {
        return muontraRepository.findAll();
    }

    // Lấy phiếu mượn bằng ID
    @GetMapping("/{id}")
    public Optional<Muontra> getMuontraById(@PathVariable Integer id) {
        return muontraRepository.findById(id);
    }

    // Xóa phiếu mượn bằng ID
    @DeleteMapping("/{id}")
    public void deleteMuontra(@PathVariable Integer id) {
        muontraRepository.deleteById(id);
    }

    // Cập nhật thông tin phiếu mượn
    @PutMapping("/{id}")
    public Muontra updateMuontra(@PathVariable Integer id, @RequestBody Muontra muontra) {
        if (muontraRepository.existsById(id)) {
            muontra.setId_muon(id);
            return muontraRepository.save(muontra);
        } else {
            // Xử lý khi phiếu mượn không tồn tại
            throw new RuntimeException("Phiếu mượn không tồn tại với ID " + id);
        }
    }
    //
    @GetMapping("/info")
    public List<MuontraDTO> getMuontraInfo() {
        return muontraRepository.getMuontraInfo();
    }
    
    @GetMapping("/info2")
    public List<MuontraDTO> getMuontraInfo2() {
        return muontraRepository.getMuontraInfo2();
    }
    
    @GetMapping("/dg")
    public List<Object[]> getMuontraIa() {
        return muontraRepository.getMuontraAndDocgia();
    }
    @PutMapping("/{id}/tinhtrangmuon")
    public Muontra updateTintrangmuon(@PathVariable Integer id, @RequestParam("tinhtrangmuon") int tinhtrangmuon) {
        Optional<Muontra> optionalMuontra = muontraRepository.findById(id);

        if (optionalMuontra.isPresent()) {
            Muontra muontra = optionalMuontra.get();
            muontra.setTinhtrangmuon(tinhtrangmuon);
            return muontraRepository.save(muontra);
        } else {
            throw new RuntimeException("Phiếu mượn không tồn tại với ID " + id);
        }
    }
}

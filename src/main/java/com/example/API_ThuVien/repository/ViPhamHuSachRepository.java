package com.example.API_ThuVien.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.API_ThuVien.model.Viphamhusach;

import jakarta.persistence.Id;
import jakarta.transaction.Transactional;

public interface ViPhamHuSachRepository extends JpaRepository<Viphamhusach, Integer> {
    // Xóa dữ liệu bằng cả hai khóa chính
    @Modifying
    @Transactional
    @Query("DELETE FROM Viphamhusach v WHERE v.id_tailieu = :idTailieu AND v.id_muon = :idMuon")
    void deleteByTailieuAndMuon(int idTailieu, int idMuon);
}
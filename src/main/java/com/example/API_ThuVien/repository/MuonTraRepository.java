package com.example.API_ThuVien.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.API_ThuVien.model.Muontra;
import com.example.API_ThuVien.model.MuontraDTO;


public interface MuonTraRepository extends JpaRepository<Muontra, Integer>{
	@Query("SELECT m, d FROM Muontra m JOIN Docgia d ON m.id_dg = d.id_dg")
    List<Object[]> getMuontraAndDocgia();
    
    @Query("SELECT new com.example.API_ThuVien.model.MuontraDTO(m.id_muon, m.id_dg, m.id_nv, m.ngaymuon, m.tinhtrangmuon, n.ten_nv, d.email) " +
            "FROM Muontra m " +
            "JOIN Nhanvien n ON m.id_nv = n.id_nv " +
            "JOIN Docgia d ON m.id_dg = d.id_dg " +
            "WHERE m.tinhtrangmuon = 0")
    List<MuontraDTO> getMuontraInfo();
    @Query("SELECT new com.example.API_ThuVien.model.MuontraDTO(m.id_muon, m.id_dg, m.id_nv, m.ngaymuon, m.tinhtrangmuon, n.ten_nv, d.email) " +
            "FROM Muontra m " +
            "JOIN Nhanvien n ON m.id_nv = n.id_nv " +
            "JOIN Docgia d ON m.id_dg = d.id_dg " +
            "WHERE m.tinhtrangmuon = 0")
    List<MuontraDTO> getMuontraInfo2();
    
	
    
}


package com.example.API_ThuVien.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.API_ThuVien.model.Chitietmuontra;
import com.example.API_ThuVien.model.ChitietmuontraDTO;


public interface ChiTietMuonTraRepository extends JpaRepository<Chitietmuontra, Integer>{
	@Query("SELECT NEW com.example.API_ThuVien.model.ChitietmuontraDTO(c.id_ctmuon, c.id_muon, c.id_tailieu, c.ngaytra, c.tinhtrangtra, t.hinh, t.tentailieu) " +
	           "FROM Chitietmuontra c " +
	           "JOIN Tailieu t ON c.id_tailieu = t.id_tailieu")
	List<ChitietmuontraDTO> getChitietmuontraInfo();
	@Query("SELECT NEW com.example.API_ThuVien.model.ChitietmuontraDTO(c.id_ctmuon, c.id_muon, c.id_tailieu, c.ngaytra, c.tinhtrangtra, t.hinh, t.tentailieu) " +
		       "FROM Chitietmuontra c " +
		       "JOIN Tailieu t ON c.id_tailieu = t.id_tailieu " +
		       "WHERE c.id_muon = :id_muon")
	List<ChitietmuontraDTO> getChitietmuontraInfoByMuonId(@Param("id_muon") int id_muon);
}


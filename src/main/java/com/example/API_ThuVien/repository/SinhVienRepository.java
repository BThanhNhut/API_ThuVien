package com.example.API_ThuVien.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.API_ThuVien.model.SinhVien;


public interface SinhVienRepository extends JpaRepository<SinhVien, Integer>{
}

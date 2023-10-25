package com.example.API_ThuVien.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.API_ThuVien.model.SinhVien;
import com.example.API_ThuVien.model.Tailieu;

public interface TaiLieuRepository extends JpaRepository<Tailieu, Integer>{

}

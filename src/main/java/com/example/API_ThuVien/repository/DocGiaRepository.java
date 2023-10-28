package com.example.API_ThuVien.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.API_ThuVien.model.Docgia;

public interface DocGiaRepository extends JpaRepository<Docgia, Integer>{
}

package com.example.API_ThuVien.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.API_ThuVien.model.Viphamhusach;

import jakarta.persistence.Id;
import jakarta.transaction.Transactional;

public interface ViPhamHuSachRepository extends JpaRepository<Viphamhusach, Integer> {
}
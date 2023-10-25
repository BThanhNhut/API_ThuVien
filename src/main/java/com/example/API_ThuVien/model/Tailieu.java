package com.example.API_ThuVien.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "tailieu")
public class Tailieu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_tailieu;
	private int id_nxb;
	private int id_loai;
	private String tentailieu;
	private Integer soluong;
	private int namsanxuat;
	private String tacgia;
	private String hinh;
	private String mota;
}

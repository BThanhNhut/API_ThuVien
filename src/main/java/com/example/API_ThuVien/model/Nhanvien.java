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
@Table(name = "nhanvien")
public class Nhanvien {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_nv;
	private String ten_nv;
	private int gioitinh;
	private Date ngaysinh;
	private int tinhtrang;
	private String hinh;
	private String diachi;
}

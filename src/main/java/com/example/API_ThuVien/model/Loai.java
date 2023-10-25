package com.example.API_ThuVien.model;

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
@Table(name = "loai")
public class Loai {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_loai;
	private String tenloai;
	private String icon;
	
	
}

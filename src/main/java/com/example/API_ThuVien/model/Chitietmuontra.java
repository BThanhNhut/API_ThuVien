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
@Table(name = "chitietmuontra")
public class Chitietmuontra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_ctmuon;
	private int id_muon;
	private int id_tailieu;
	private Date ngaytra;
	private int tinhtrangtra;
}

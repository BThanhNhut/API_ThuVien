package com.example.API_ThuVien.model;

import jakarta.persistence.Entity;
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
@Table(name = "viphamhusach")
public class Viphamhusach {
	@Id
	private Integer id_tailieu;
	private Integer id_muon;
	private String mota;
}

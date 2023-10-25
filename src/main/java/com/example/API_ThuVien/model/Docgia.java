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
@Table(name = "docgia")
public class Docgia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_dg;
	private int id_sv;
	private String email;
	private int password;
}

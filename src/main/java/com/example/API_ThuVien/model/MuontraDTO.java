package com.example.API_ThuVien.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MuontraDTO {
	private int id_muon;
    private int id_dg;
    private int id_nv;
    private Date ngaymuon;
    private int tintrangmuon;
    private String ten_nv;
    private String email;   
}

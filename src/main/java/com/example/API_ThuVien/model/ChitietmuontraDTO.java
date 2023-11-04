package com.example.API_ThuVien.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChitietmuontraDTO {
	private Integer id_ctmuon;
	private int id_muon;
    private int id_tailieu;
    private Date ngaytra;
    private int tinhtrangtra;
    private String hinh;
    private String tentailieu;
}

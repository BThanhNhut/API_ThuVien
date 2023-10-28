package com.example.API_ThuVien.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.API_ThuVien.model.Docgia;
import com.example.API_ThuVien.repository.DocGiaRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/docgia")
public class DocgiaController {

	@Autowired
	private DocGiaRepository docgiaRepository;

	// Tạo một độc giả mới
	@PostMapping("")
	public Docgia createDocgia(@RequestBody Docgia docgia) {
		return docgiaRepository.save(docgia);
	}

	// Lấy tất cả độc giả
	@GetMapping("")
	public List<Docgia> getAllDocgia() {
		return docgiaRepository.findAll();
	}

	// Lấy độc giả bằng ID
	@GetMapping("/{id}")
	public Optional<Docgia> getDocgiaById(@PathVariable Integer id) {
		return docgiaRepository.findById(id);
	}

	// Xóa độc giả bằng ID
	@DeleteMapping("/{id}")
	public void deleteDocgia(@PathVariable Integer id) {
		docgiaRepository.deleteById(id);
	}

	// Cập nhật thông tin độc giả
	@PutMapping("/{id}")
	public Docgia updateDocgia(@PathVariable Integer id, @RequestBody Docgia docgia) {
		if (docgiaRepository.existsById(id)) {
			docgia.setId_dg(id);
			return docgiaRepository.save(docgia);
		} else {
			// Xử lý khi độc giả không tồn tại
			throw new RuntimeException("Độc giả không tồn tại với ID " + id);
		}
	}

	//
	@GetMapping("/{username}/{password}")
    public Optional<Docgia> checkUserName (@PathVariable String username,@PathVariable String password){
		List<Docgia> docgialist = docgiaRepository.findAll();
		for(Docgia dg : docgialist)
		{
			if(dg.getEmail().trim().equals(username.trim()) && dg.getPassword().trim().equals(password.trim())) {
				Optional<Docgia> optionalDocgia =  Optional.of(dg);
				return optionalDocgia;
			}
		}
		return Optional.empty();
    }
}

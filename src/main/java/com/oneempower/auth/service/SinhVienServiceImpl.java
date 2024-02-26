package com.oneempower.auth.service;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.oneempower.auth.model.SinhVien;
import com.oneempower.auth.repository.SinhVienRepo;


@Service
public class SinhVienServiceImpl implements SinhVienService {
	 private final Path root = Paths.get("./uploads");

	@Autowired
	private SinhVienRepo sinhVienRepo;

	@Autowired
	public SinhVienServiceImpl(SinhVienRepo sinhVienRepo) {
		this.sinhVienRepo = sinhVienRepo;
	}



	@Override
	public SinhVien insert(SinhVien sinhVien) {
		return sinhVienRepo.save(sinhVien);
	}

	@Override
	public boolean delete(long id) {
		Optional<SinhVien> sinhVien = sinhVienRepo.findById(id);
		if (sinhVien.isPresent()) {
			sinhVienRepo.deleteById(id);
			return true;
		}
		return false;
	}



	@Override
	public SinhVien update(SinhVien sinhVien) {
		SinhVien editSinhVien = sinhVienRepo.findById(sinhVien.getId()).orElse(null);
		sinhVien.setName(sinhVien.getName());
		sinhVien.setEmail(sinhVien.getEmail());
		sinhVien.setAddress(sinhVien.getAddress());
		return sinhVienRepo.save(sinhVien);
	}

	@Override
	public SinhVien findById(long id) {
		return sinhVienRepo.findById(id).orElse(null);
	}

	@Override
	public Page<SinhVien> searchSinhVien(Optional<String> keyword,Pageable pageable) {
		// TODO Auto-generated method stub
		return sinhVienRepo.FindAllByNameorEmailorAddress(keyword,pageable);
	}


	@Override
	public Page<SinhVien> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return sinhVienRepo.findAll(pageable);
	}



}

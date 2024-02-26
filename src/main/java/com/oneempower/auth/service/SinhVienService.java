package com.oneempower.auth.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.oneempower.auth.model.SinhVien;

@Service
public interface SinhVienService {


	SinhVien insert(SinhVien sinhVien);

	boolean delete(long id);

	SinhVien update(SinhVien sinhVien);

	SinhVien findById(long id);

	Page<SinhVien> searchSinhVien(Optional<String> keyword, Pageable pageable);

	Page<SinhVien> findAll(Pageable pageable);




}
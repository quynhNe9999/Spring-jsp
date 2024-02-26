package com.oneempower.auth.repository;



import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.oneempower.auth.model.SinhVien;

@Repository
public interface SinhVienRepo extends JpaRepository<SinhVien, Long>, CrudRepository<SinhVien, Long>, PagingAndSortingRepository<SinhVien, Long> {
//	@Query(value = "Select name, email, address from User u WHERE CONCAT('',u.id,'',u.name,'',u.address) like ?1", nativeQuery = true)
	@Query("SELECT e FROM SinhVien e WHERE e.name LIKE %:keyword% OR e.email LIKE %:keyword% OR e.address LIKE %:keyword%")
	Page<SinhVien> FindAllByNameorEmailorAddress(Optional<String> keyword, Pageable pageable);

}
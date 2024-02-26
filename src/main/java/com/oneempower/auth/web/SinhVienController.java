package com.oneempower.auth.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.oneempower.auth.model.SinhVien;
import com.oneempower.auth.repository.SinhVienRepo;
import com.oneempower.auth.service.SinhVienService;

@Controller
//@RequestMapping(value = "/student")
public class SinhVienController {

	@Autowired
	private SinhVienService sinhVienService;

	private final SinhVienRepo sinhVienRepo;

	SinhVienController(SinhVienRepo sinhVienRepo) {
		this.sinhVienRepo = sinhVienRepo;
	}

	// hiển thị bảng user
// 	@GetMapping("/view")
// 	public ModelAndView listUsers(@RequestParam("keyword") Optional<String> keyword, SinhVien sinhVien,
// 				@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size,
// 			Model model) throws IOException {

	// System.out.println("Hello list usser");
// 		// phan_trang
//// 		Pageable pageable = PageRequest.of(page, size);
//// 		Page<SinhVien> listUsers;
//// 		// = userService.getAllUser(page,size);
//// 		// tìm kiếm
//// 		if (keyword.isPresent()) {
//// 			listUsers = sinhVienService.searchSinhVien(keyword, pageable);
////
//// 			// listUsers = userService.findAllByFirstNameContaining(firstName.get(),
//// 			// pageable);
//// 		} else {
//// 			listUsers = sinhVienService.findAll(pageable);
//// 		}
//
//// 		ModelAndView modelAndView = new ModelAndView("view");
//// 		modelAndView.addObject("data", listUsers);
//// 		return modelAndView;
// 		return null;
// 	} 
//hien thị sv
	@GetMapping("/view")
	public ModelAndView home(@RequestParam(name = "keyword") Optional<String> keyword,
			@RequestParam(defaultValue = "0") int page,  @RequestParam(defaultValue = "5") int size, Model model
			) throws IOException {
		Pageable pageable = PageRequest.of(page, size);
		Page<SinhVien> listUsers;
		// = userService.getAllUser(page,size);
		// tìm kiếm
		if (keyword.isPresent()) {
			listUsers = sinhVienService.searchSinhVien(keyword, pageable);

			// listUsers = userService.findAllByFirstNameContaining(firstName.get(),
			// pageable);
		} else {
			listUsers = sinhVienService.findAll(pageable);
		}
		Map<String, Object> modelMap = new HashMap<>();
		modelMap.put("data", listUsers);
		return new ModelAndView("view", modelMap);
	}

	// them sv
	@GetMapping("/addSinhVien")
	public String viewAddSinhVien() {
		return "addSinhVien";
	}

	@PostMapping("/insertSinhVien")
	public String insertSinhVien(@ModelAttribute("insertSinhVien") SinhVien sinhVien) {

		sinhVienService.insert(sinhVien);
		return "redirect:/view";
	}

	// update sv
	@PostMapping("/editSinhVien/updateSinhVien")
	public String updateSinhVien(@ModelAttribute("sinhVien") SinhVien sinhVien) {

		sinhVienService.update(sinhVien);
		return "redirect:/view";
	}

	@GetMapping("/editSinhVien/{id}")
	public String viewUpdateSinhVien(@PathVariable("id") Long id, SinhVien sinhVien, Model model) {

		model.addAttribute("sinhVien", sinhVienService.findById(id));
		return "updateSinhVien";

	}

	// xoa sv
	@GetMapping("/deleteSinhVien/{id}")
	public String deleteSinhVien(@PathVariable("id") Long id) {
		sinhVienService.delete(id);
		return "redirect:/view";
	}

}

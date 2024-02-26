package com.oneempower.auth.web;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.io.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.oneempower.auth.model.ImageInfo;
import com.oneempower.auth.service.FileStorageService;
@Controller
public class ImageController {
	 @Autowired
	  private FileStorageService storageService;


	  @GetMapping("/images/new")
	  public String newImage(Model model) {
	    return "upload_form";
	  }

	  @PostMapping("/images/upload")
	  public String uploadImage(Model model, @RequestParam("file") MultipartFile file) {
	    String message = "";

	    try {
	      storageService.save(file);

	      message = "Uploaded the image successfully: " + file.getOriginalFilename();
	      model.addAttribute("message", message);
	    } catch (Exception e) {
	      message = "Could not upload the image: " + file.getOriginalFilename() + ". Error: " + e.getMessage();
	      model.addAttribute("message", message);
	    }

	    return "upload_form";
	  }
	


	  @GetMapping("/index")
	  public String homepage() {
	    return "redirect:/images";
	  }

	  @GetMapping("/images")
	  public String getListImages(Model model) {
	    List<ImageInfo> imageInfos = storageService.loadAll().map(path -> {
	      String filename = path.getFileName().toString();
	      String url = MvcUriComponentsBuilder
	          .fromMethodName(ImageController.class, "getImage", path.getFileName().toString()).build().toString();

	      return new ImageInfo(filename, url);
	    }).collect(Collectors.toList());

	    model.addAttribute("images", imageInfos);

	    return "images";
	  }

	  @GetMapping("/images/{filename:.+}")
	  public ResponseEntity<Resource> getImage(@PathVariable String filename) {
	    Resource file = storageService.load(filename);

	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
	  }

	 
	}



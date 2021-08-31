package com.m14.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m14.domain.Picture;
import com.m14.service.PicturesService;

@RestController
@RequestMapping("/shops/{ID}")
public class PicturesController {
	
	@Autowired
	PicturesService pictureService;
	
	
	@PostMapping("/pictures")
	
	public Picture addPicture(@Valid @RequestBody Picture picture, @PathVariable("ID") int id) {
			return pictureService.add(picture,id);
	}
	
	
	@GetMapping("/pictures")
	public Set<Picture> getAllPictures(@PathVariable("ID") int id){
		return pictureService.getAll(id);
	}
	
	
	@GetMapping("/picture/{idPicture}")
	public Picture getOnePicuture(@PathVariable("idPicture") int idPicture) {
		return pictureService.getById(idPicture);
	}
	
	
	@DeleteMapping("/pictures")
	
	public String deleteAll(@PathVariable("ID") int idShop) {
		pictureService.deleteAllPictures(idShop);		
		return "Tots els quadres han estat eliminats";
		}
	
	
	@DeleteMapping("/pictures/{idPicture}")
	
	public String deleteOnePicutre(@PathVariable("idPicture") int idPicture) {
		pictureService.deleteById(idPicture);	
		return "El quadre amb id: " + idPicture + " s'ha eliminat correctament.";
	}
	
	
	@PutMapping("/pictures/{idPicture}")
	
	public Picture updateEmployee(@Valid @RequestBody Picture picture, @PathVariable("idPicture") int idPicture) {
		return pictureService.updatePicture(idPicture,picture);
	}

}

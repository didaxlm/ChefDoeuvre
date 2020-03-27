package fr.didier.giveapp.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.didier.giveapp.app.model.Photo;
import fr.didier.giveapp.app.repository.PhotoRepository;

@RequestMapping("/photos")
@RestController
public class PhotoController 
{
	@Autowired
	private PhotoRepository photoDepot;
	
	@GetMapping
	public List<Photo> afficherLiensPhotos() 
	{
		return photoDepot.findAll();
	}
}

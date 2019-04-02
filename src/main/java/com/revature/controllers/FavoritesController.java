package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.exceptions.UserNotFoundException;
import com.revature.model.Favorites;
import com.revature.service.FavoritesService;
import com.revature.service.UserService;

@CrossOrigin
@Controller
public class FavoritesController {
	
	@Autowired
	FavoritesService fService;
	
	@GetMapping("/favorites")
	@ResponseBody
	public List<Favorites> getFavoritesBytUserId(@RequestParam(value="id",required=false)Integer id){
		if(id!=null) {
			
			System.out.println("----------------->in /fService");
			//Favorites c = fService.getFavoritesByUserId(id);
//			if(c == null) {
//				throw new UserNotFoundException();
//			} else {
//				ArrayList<Favorites> favs = new ArrayList<Favorites>();
//				favs.add(c);
				return  fService.getFavoritesByUserId(id);
			}
		
		return null;
	}
	
//	@RequestMapping(method=RequestMethod.POST, value="/update/")
//	@ResponseBody
	
	
	
	

	

	
	@PostMapping("/fav/new")
	@ResponseBody
	public Favorites returnNewUserPage( @RequestBody Favorites favs) {
		System.out.println("checking for favorites... " + favs);
		 System.out.println("in /new " + favs);
			 
		return  fService.create(favs);
	}
	
	

	
	@PostMapping("/fav/delete")
	@ResponseBody
	public boolean deleteFavorites( @RequestBody Favorites favs) {
		
		
		System.out.println(favs);
		
		 System.out.println("in /delete");
	 
 
		 
		 
		return fService.deleteFavorites(favs);
		
	}
	

}

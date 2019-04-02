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
import com.revature.model.WishList;
import com.revature.service.UserService;
import com.revature.service.WishListService;

@CrossOrigin
@Controller
public class WishListController {
	
	@Autowired
	WishListService wService;
	
	@GetMapping("/wish")
	@ResponseBody
	public List<WishList> getwishBytUserId(@RequestParam(value="id",required=false)Integer id){
		if(id!=null) {
			
			System.out.println("----------------->in /fService");
			//Favorites c = fService.getFavoritesByUserId(id);
//			if(c == null) {
//				throw new UserNotFoundException();
//			} else {
//				ArrayList<Favorites> favs = new ArrayList<Favorites>();
//				favs.add(c);
				return  wService.getWishListsByUserId(id);
			}
		
		return null;
	}
	
//	@RequestMapping(method=RequestMethod.POST, value="/update/")
//	@ResponseBody
	
	
	
	

	

	
	@PostMapping("/fav/new")
	@ResponseBody
	public WishList returnNewUserPage( @RequestBody WishList wish) {
		System.out.println("checking for WishList... " + wish);
		 System.out.println("in /new " + wish);
			 
		return  wService.create(wish);
	}
	
	

	
	@PostMapping("/wish/delete")
	@ResponseBody
	public boolean deleteWishList( @RequestBody WishList wish) {
		
		
		System.out.println(wish);
		
		 System.out.println("in /delete");
	 
 
		 
		 
		return wService.deleteWishList(wish);
		
	}
	

}

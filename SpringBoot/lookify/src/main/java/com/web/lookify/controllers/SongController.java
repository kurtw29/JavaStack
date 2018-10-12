package com.web.lookify.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.lookify.Services.SongService;
import com.web.lookify.models.Song;

@Controller
public class SongController {
	//setup for using SongService methods
	private final SongService songService;
	
	//setup SongService in constructor
	public SongController(SongService songService) {
		this.songService = songService;
	}
	@RequestMapping("")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		model.addAttribute("songs",songService.allSongs());
		return "dashboard.jsp";
	}
	
	@RequestMapping("/songs/new")
	public String add(@ModelAttribute("song") Song song) {
		return "addNew.jsp";
	}
	
	//POST add a song
	@RequestMapping(value="/song/add", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if(result.hasErrors()) {
			return "addNew.jsp";
		}else {
			songService.newSong(song);
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping("songs/{id}")
	public String detail(Model model, @PathVariable("id") Long id) {
		model.addAttribute("song", songService.findSong(id));
		return "detail.jsp";
	}
	
	@RequestMapping("search/{artist}") //{song.artist}
	public String searchArtistSong(Model model, @PathVariable("artist") String artist) {
		model.addAttribute("songs", songService.findByArtistContaining(artist));
		model.addAttribute("searchedWord", artist);
		return "search.jsp";
	}
	
	@RequestMapping("search/topTen")
	public String topTen(Model model) {
		model.addAttribute("songs", songService.findTopTen());
		return "topTen.jsp";
	}

	@RequestMapping("search/")
	public String searching(@RequestParam(value="artist", required=false) String searchedWord) {
		if(searchedWord == null | searchedWord == "") {
			return "redirect:/dashboard";
		}else {
		return "redirect:/search/"+searchedWord;
		}
	}
	
	@RequestMapping(value="song/{id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id) {
		songService.deleteSong(id);
		return "redirect:/dashboard";
	}
	
}

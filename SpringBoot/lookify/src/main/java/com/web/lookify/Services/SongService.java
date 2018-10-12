package com.web.lookify.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.web.lookify.models.Song;
import com.web.lookify.repositories.SongRepository;

@Service
public class SongService {
	private final SongRepository songRepo;
	public SongService(SongRepository songRepo) {
		this.songRepo = songRepo;
	}
	//retrieve all songs
	public List<Song> allSongs(){
		return (List<Song>) songRepo.findAll();
	}
	//retrieve a song by id
	public Song findSong(Long id) {
		Optional<Song> optionalSong = songRepo.findById(id);
		if(optionalSong.isPresent()) {
			return optionalSong.get();
		}else
		return null;
	}
	//Delete a song
	public void deleteSong(Long id) {
		songRepo.deleteById(id);
	}
	//Add a new song
	public void newSong(Song song) {
		songRepo.save(song);
	}
	//Find song by artist containing
	public List<Song> findByArtistContaining(String search){
		return songRepo.findByArtistContaining(search);
	}
	
	//Find the top ten rating songs
	public List<Song> findTopTen(){
		return songRepo.findTopTen();
	}
	
}

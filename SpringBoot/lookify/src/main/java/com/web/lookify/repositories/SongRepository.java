package com.web.lookify.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.web.lookify.models.Song;

public interface SongRepository extends CrudRepository<Song, Long>{
	List<Song> findByArtistContaining(String search);
	
	@Query(value="SELECT * FROM songs ORDER BY rating DESC LIMIT 10;", nativeQuery = true)
	List<Song> findTopTen();
}

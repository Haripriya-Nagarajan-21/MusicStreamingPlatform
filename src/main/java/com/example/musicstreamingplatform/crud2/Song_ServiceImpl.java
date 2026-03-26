package com.example.musicstreamingplatform.crud2;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class Song_ServiceImpl implements Song_Service {
@Autowired
private Song_Repository songRepository;
@Autowired
private RestTemplate restTemplate;
@Value("${weather.api.key}")
private String apiKey;private final String WEATHER_API_URL =
"https://api.openweathermap.org/data/2.5/weather?q={city}&appid={apiKey}";
@Override
public String createSong(Song_Dto songDto) {
Song_Entity song = new Song_Entity();
song.setTitle(songDto.getTitle());
song.setArtist(songDto.getArtist());
song.setAlbumId(songDto.getAlbumId());
song.setGenre(songDto.getGenre());
song.setDuration(songDto.getDuration());
songRepository.save(song);

return "Song Created Successfully";}
@Override
public Song_Dto getSong(Long id) {
Optional<Song_Entity> songOptional =
songRepository.findById(id);
return songOptional.map(this::mapToDto) .orElseThrow(() -> new
RuntimeException("Song not found"));}
@Override
public String deleteSong(Long id) {
if (songRepository.existsById(id)) {
songRepository.deleteById(id); 
return "Song Deleted Successfully";
}
return "Song Not Found"; }
@Override
public String updateSong(Long id, Song_Dto songDto) {
Optional<Song_Entity> songOptional =
songRepository.findById(id);
if (songOptional.isPresent()) {
Song_Entity song = songOptional.get();
song.setTitle(songDto.getTitle());
song.setArtist(songDto.getArtist());
song.setAlbumId(songDto.getAlbumId());
song.setGenre(songDto.getGenre());
song.setDuration(songDto.getDuration());
songRepository.save(song);
return "Song Updated Successfully"; 
}
return "Song Not Found"; 
}

@Transactional
@Override
public String updateSongGenre(Long id, String genre) {
int updatedRows = songRepository.updateSongGenre(id, genre);
return updatedRows > 0 ? "Genre Updated Successfully" : "Song Not Found";}
@Override
public List<Song_Dto> getSongsByArtist(String artist) {
List<Song_Entity> songs = songRepository.findSongsByArtist(artist);
return
songs.stream().map(this::mapToDto).collect(Collectors.toList());}
@Override
public List<Song_Dto> getSongsStartingWith(String prefix) {
List<Song_Entity> songs =
songRepository.findByTitleStartingWith(prefix);
return
songs.stream().map(this::mapToDto).collect(Collectors.toList());}
@Override
public List<Song_Dto> getSongsEndingWith(String suffix) {
List<Song_Entity> songs =
songRepository.findByTitleEndingWith(suffix);
return
songs.stream().map(this::mapToDto).collect(Collectors.toList());}
@Override
public List<Song_Dto> getSongsContaining(String substring) {
List<Song_Entity> songs =
songRepository.findByTitleContaining(substring);
return
songs.stream().map(this::mapToDto).collect(Collectors.toList());}

@Override
public List<Song_Dto> getSongsNotContaining(String substring) {
List<Song_Entity> songs =
songRepository.findByTitleNotContaining(substring);
return songs.stream().map(this::mapToDto).collect(Collectors.toList());
}
@Override
public String getWeather(String city) {
return restTemplate.getForObject(WEATHER_API_URL, String.class,
city,apiKey);}
private Song_Dto mapToDto(Song_Entity song) {
Song_Dto dto = new Song_Dto();
dto.setSongId(song.getSongId());
dto.setTitle(song.getTitle());
dto.setArtist(song.getArtist());
dto.setAlbumId(song.getAlbumId());
dto.setGenre(song.getGenre());
dto.setDuration(song.getDuration()); return dto;
}
}
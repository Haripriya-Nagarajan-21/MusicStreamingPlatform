package com.example.musicstreamingplatform.crud1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UController {

@Autowired
private UService uService;
@PostMapping("/create")
public String createUser(@RequestBody UDto userDto)
{
    return uService.createUser(userDto);
}
@GetMapping("/get/{id}")
public UDto getUser(@PathVariable Long id) {
    return uService.getUser(id); 
}
@DeleteMapping("/delete/{id}")
public String deleteUser(@PathVariable Long id) {
	return uService.deleteUser(id);
}
@PutMapping("/update/{id}")
public String updateUser(@PathVariable Long id, @RequestBody UDto userDto) {
return uService.updateUser(id, userDto);
}
@GetMapping("/pagination")
public List<UEntity> getUsersWithPagination(@RequestParam int
page, @RequestParam int size, @RequestParam String sortBy) {
    return uService.getUsersWithPagination(page, size, sortBy);
}
@GetMapping("/filter/or")
public List<UEntity> filterUsersByNameOrSubscription(@RequestParam int page, @RequestParam int size, @RequestParam String name,@RequestParam String subscriptionType) {
   return uService.filterUsersByNameOrSubscription(page, size,name, subscriptionType);
}
@GetMapping("/filter/and")
public List<UEntity> filterUsersByNameAndEmail(@RequestParam int page, @RequestParam int size, @RequestParam String name, @RequestParam String email) {
  return uService.filterUsersByNameAndEmail(page, size, name,email);
}
}
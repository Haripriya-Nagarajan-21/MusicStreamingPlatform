package com.example.musicstreamingplatform.crud1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.musicstreamingplatform.utils.EmailService;

import java.util.List;
import java.util.Optional;
@Service
public class UServiceImpl implements UService {

@Autowired
private URepository uRepository;
@Autowired
private EmailService emailService;
@Override
public String createUser(UDto userDto) {
             UEntity user = new UEntity();
             user.setName(userDto.getName());
             user.setEmail(userDto.getEmail());
             user.setPassword(userDto.getPassword());
             user.setSubscriptionType(userDto.getSubscriptionType());
             user.setDateOfBirth(userDto.getDateOfBirth());
              uRepository.save(user);
             emailService.sendEmail(user.getEmail(),
		"Welcome to Music Streaming Platform", "Thank you for signing up!");
return "User Created Successfully";
}
@Override
public UDto getUser(Long id) {
          Optional<UEntity> userOptional = uRepository.findById(id);
            if (userOptional.isPresent()) {
            UEntity user = userOptional.get();
UDto userDto = new UDto();
userDto.setId(user.getId());
userDto.setName(user.getName());
userDto.setEmail(user.getEmail());
userDto.setPassword(user.getPassword());
userDto.setSubscriptionType(user.getSubscriptionType());
userDto.setDateOfBirth(user.getDateOfBirth());
return userDto;
}
throw new RuntimeException("User not found");
}
@Override
public String deleteUser(Long id) {
if (uRepository.existsById(id)) {
uRepository.deleteById(id);
return "User Deleted Successfully";
}
return "User Not Found";

}
@Override
public String updateUser(Long id, UDto userDto) {
Optional<UEntity> userOptional = uRepository.findById(id);
if (userOptional.isPresent()) {
UEntity user = userOptional.get();
user.setName(userDto.getName());
user.setEmail(userDto.getEmail());
user.setPassword(userDto.getPassword());
user.setSubscriptionType(userDto.getSubscriptionType());
user.setDateOfBirth(userDto.getDateOfBirth());
uRepository.save(user);
return "User Updated Successfully";
}
return "User Not Found";}
@Override
public List<UEntity> getUsersWithPagination(int page, int size,
String sortBy) {
Pageable pageable = PageRequest.of(page, size,
Sort.by(sortBy).descending());
return uRepository.findAll(pageable).getContent();
}
@Override
public List<UEntity> filterUsersByNameOrSubscription(int page, int
size, String name, String subscriptionType) {
Pageable pageable = PageRequest.of(page, size);
return uRepository.findAllByNameOrSubscriptionType(pageable,
name, subscriptionType);
}
@Override
public List<UEntity> filterUsersByNameAndEmail(int page, int size,
String name, String email) {
Pageable pageable = PageRequest.of(page, size);
return uRepository.findAllByNameAndEmail(pageable, name,
email);
}
@Override
public void sendEmail(String to, String subject, String text) {
String emailTemplate = "<html>" +

"<body style='font-family: Arial, sans-serif; text-align: center;'>"+

"<h2>" + subject + "</h2>" +
"<p>You have successfully logged into your Music Streaming account.</p>" +"<p>Enjoy your music!</p>" +"</body></html>";
emailService.sendEmail(to, subject, emailTemplate);
}
}
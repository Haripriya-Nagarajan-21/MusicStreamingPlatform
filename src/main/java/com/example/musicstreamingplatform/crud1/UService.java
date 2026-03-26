package com.example.musicstreamingplatform.crud1;
import java.util.List;
public interface UService {
String createUser(UDto userDto);
UDto getUser(Long id);
String deleteUser(Long id);
String updateUser(Long id, UDto userDto);
List<UEntity> getUsersWithPagination(int page, int size, String
sortBy);List<UEntity> filterUsersByNameOrSubscription(int page, int
size, String name, String subscriptionType);
List<UEntity> filterUsersByNameAndEmail(int page, int size, String
name, String email);
void sendEmail(String to, String subject, String text);
}
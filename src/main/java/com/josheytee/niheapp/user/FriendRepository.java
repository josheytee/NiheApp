package com.josheytee.niheapp.user;

import com.josheytee.niheapp.app.AppRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FriendRepository extends AppRepository<Friend, Long> {

  @Query("select f.friend.id from Friend f where f.user = ?1")
  public List<Long> getAllIdsFromUser(User user);
  

}
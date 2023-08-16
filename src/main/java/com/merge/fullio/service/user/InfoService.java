package com.merge.fullio.service.user;

import com.merge.fullio.DTO.user.UserDTO;
import com.merge.fullio.model.user.User;
import com.merge.fullio.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InfoService {
    private final UserRepository userRepository;

    public UserDTO getUserInfo(User user){
        User user1 =userRepository.findByUsername(user.getUsername());
        return new UserDTO(user1.getId(), user1.getUserNumber(), user1.getUsername(), user1.getNickName(), user1.getEmail(), user1.getPhoneNumber());
    }
}

package com.merge.fullio.DTO.user;

import com.merge.fullio.model.user.Role;
import com.merge.fullio.model.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private long id;

    private String username;

    private String name;

    private String nickName;

    private String email;

    private String phoneNumber;

    public static UserDTO of(User user){
        return new UserDTO(user.getId(), user.getUsername(), user.getName(), user.getNickName(), user.getEmail(), user.getPhoneNumber());
    }
}

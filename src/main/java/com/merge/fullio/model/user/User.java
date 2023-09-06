package com.merge.fullio.model.user;

import com.merge.fullio.model.TimeEntity;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data // getter, setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class User extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column
    private String name;

    @Column
    private String nickName;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Role role;


    public User (String username, String password, String name, String email, Role role) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public int getPeriod() {
        if (username == null) return 0;
        if (username.length() != 8) return 0;
        return Integer.parseInt(username.substring(3, 5));
    }

}

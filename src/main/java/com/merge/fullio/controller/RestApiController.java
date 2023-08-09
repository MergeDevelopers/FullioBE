package com.merge.fullio.controller;

import com.merge.fullio.model.user.Role;
import com.merge.fullio.model.user.User;
import com.merge.fullio.repository.UserRepository;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RestApiController {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("join")
    public String join(@RequestBody User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRole(Role.ROLE_USER);
        userRepository.save(user);
        return "회원가입완료";
    }

    @GetMapping("/api/v1/user")
    public Map<String, Object> user() {
        Map<String, Object> userInfo = new HashMap<>();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        userInfo.put("username", auth.getName());
        String role = auth.getAuthorities().stream()
            .findFirst()
            .map(r -> r.getAuthority())
            .orElse("");
        userInfo.put("roles", role);

        return userInfo;
    }

    // manager, admin 권한만 접근 가능
    @GetMapping("/api/v1/manager")
    public String manager() {
        return "manager";
    }

    // admin 권한만 접근 가능
    @GetMapping("/api/v1/admin")
    public String admin() {
        return "admin";
    }
}

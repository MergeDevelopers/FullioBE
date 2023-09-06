package com.merge.fullio.config.jpa;

import com.merge.fullio.config.auth.PrincipalDetails;
import com.merge.fullio.model.user.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration
@EnableJpaAuditing
public class JpaConfig {

    @Bean
    public AuditorAware<User> auditorProvider() {

        // 익명 클래스를 이용
        return new AuditorAware<User>() {
            @Override
            public Optional<User> getCurrentAuditor() {
                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                if (authentication == null) return Optional.empty();
                if (!(authentication.getPrincipal() instanceof PrincipalDetails principalDetails)) return Optional.empty();
                return Optional.of(principalDetails.getUser());
            }
        };
    }

}

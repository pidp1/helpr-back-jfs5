package org.soulcodeacademy.helpr.config;

import org.springframework.security.config.annotation.web.builders.WebSecurity;

public interface SecurityConfigIgnore {
    void configure(WebSecurity web) throws Exception;
}

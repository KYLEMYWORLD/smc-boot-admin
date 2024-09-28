package com.kyle.security.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author kyle
 * @date 2024/3/23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorityDto implements GrantedAuthority {
    private String authority;

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
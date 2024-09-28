package com.kyle.security.service;

import com.kyle.security.domain.dto.UserInfoDto;
import jakarta.annotation.Nullable;

import java.util.Optional;

/**
 * @author kyle
 * @date 2024/4/2
 */
public interface UserLoginService {

    /**
     * 根据用户名获取商户识别码
     *
     * @param username 用户名
     * @return 商户识别码
     */
    Optional<String> getSysCodeByUsername(String username);

    /**
     * 根据用户名获取用户信息,管理端登录
     *
     * @param username 用户名
     * @return 用户信息
     */
    UserInfoDto findByUsername(String username);

    /**
     * 根据用户名获取用户信息，商户端登录
     *
     * @param username 用户名
     * @param sysCode  商户识别码
     * @return 用户信息
     */
    UserInfoDto findByUsername(String username, @Nullable String sysCode);
}
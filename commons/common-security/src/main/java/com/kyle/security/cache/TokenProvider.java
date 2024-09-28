package com.kyle.security.cache;

import com.kyle.security.domain.dto.UserInfoDto;

/**
 * @author kyle
 * @date 2024/3/23
 */
public interface TokenProvider {
    /**
     * 创建token
     *
     * @param dto 登录信息
     * @return token
     */
    String createAccessToken(UserInfoDto dto);

    /**
     * 刷新token
     *
     * @param accessToken token
     * @return token
     */
    boolean checkRenewal(String accessToken);

    /**
     * 删除token
     *
     * @param accessToken token
     * @return 是否成功
     */
    boolean removeToken(String accessToken);

    /**
     * 获取token的值
     *
     * @param accessToken token
     * @return 值
     */
    String getValue(String accessToken);
}
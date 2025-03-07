package com.kyle.basic.controller;

import com.kyle.base.R;
import com.kyle.base.utils.PasswordUtil;
import com.kyle.base.utils.StrUtil;
import com.kyle.basic.domain.dto.BasUserDto;
import com.kyle.basic.domain.dto.BasUserRestPasswordDto;
import com.kyle.basic.domain.dto.BasUserSaveDto;
import com.kyle.basic.domain.query.BasUserQuery;
import com.kyle.basic.service.BasUserService;
import com.kyle.common.api.JsfPage;
import com.kyle.security.utils.SecurityUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kyle
 * @date 2024/4/30
 */
@RestController
@RequestMapping("/bas/user")
@Tag(name = "履约端：用户管理")
@RequiredArgsConstructor
public class BasUserController {
    private final BasUserService service;

    /**
     * 账号是否存在
     *
     * @param username 用户名
     * @param id       需要排除的id
     * @return .
     */
    @GetMapping("/existsByUsername")
    @Operation(summary = "账号是否存在")
    @Parameters({
            @io.swagger.v3.oas.annotations.Parameter(name = "username", description = "用户名", required = true),
            @io.swagger.v3.oas.annotations.Parameter(name = "id", description = "需要排除的id", required = false)
    })
    public R<Boolean> existsByUsername(String username, @RequestParam(required = false) String id) {
        String sysCode = SecurityUtil.getSysCode();
        Boolean res = service.existsUsername(username, sysCode, id);
        return R.OK(res);
    }

    @GetMapping
    @Operation(summary = "分页查询")
    @PreAuthorize("hasAnyAuthority('bas:user:query')")
    public R<JsfPage<BasUserDto>> page(BasUserQuery query) {
        String sysCode = SecurityUtil.getSysCode();
        query.setSysCode(sysCode);
        JsfPage<BasUserDto> res = service.page(query);
        return R.OK(res);
    }

    @PostMapping
    @Operation(summary = "保存")
    @PreAuthorize("hasAnyAuthority('bas:user:save')")
    public R<String> save(@Valid @RequestBody BasUserSaveDto dto) {
        if (StrUtil.isBlank(dto.getPassword())) {
            return R.NG("密码不能为空");
        }
        String sysCode = SecurityUtil.getSysCode();
        dto.setSysCode(sysCode);
        dto.setPassword(PasswordUtil.encoder(dto.getPassword()));
        service.save(dto);
        return R.OK();
    }

    @PutMapping
    @Operation(summary = "更新")
    @PreAuthorize("hasAnyAuthority('bas:user:update')")
    public R<String> update(@Valid @RequestBody BasUserSaveDto dto) {
        String id = dto.getId();
        if (id == null) {
            return R.NG("id不能为空");
        }
        dto.setSysCode(SecurityUtil.getSysCode());
        dto.setPassword(null);
        service.updateById(dto);
        return R.OK();
    }

    /**
     * 重置密码
     *
     * @param dto .
     * @return .
     */
    @PutMapping("/restPassword")
    @Operation(summary = "重置密码")
    @PreAuthorize("hasAnyAuthority('bas:user:restPassword')")
    public R<String> restPassword(@Valid @RequestBody BasUserRestPasswordDto dto) {
        String username = SecurityUtil.getUsername();
        dto.setOperator(username);
        dto.setPassword(PasswordUtil.encoder(dto.getPassword()));
        service.restPassword(dto);
        return R.OK();
    }


    /**
     * 删除
     *
     * @param id .
     * @return .
     */
    @DeleteMapping
    @Operation(summary = "删除")
    @PreAuthorize("hasAnyAuthority('bas:user:delete')")
    public R<String> delete(@RequestParam String id) {
        service.removeById(id);
        return R.OK();
    }
}

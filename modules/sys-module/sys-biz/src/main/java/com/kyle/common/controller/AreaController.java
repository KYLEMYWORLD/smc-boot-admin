package com.kyle.common.controller;

import com.kyle.base.R;
import com.kyle.sys.domain.dto.AreaDto;
import com.kyle.sys.domain.query.AreaQuery;
import com.kyle.sys.service.SysAreaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 地区
 *
 * @author kyle
 * @date 2024/5/10
 */
@RestController
@RequestMapping("/common/area")
@RequiredArgsConstructor
@Tag(name = "公共接口：地区")
public class AreaController {
    private final SysAreaService areaService;


    /**
     * 查询
     *
     * @param parentId .
     * @return .
     */
    @GetMapping
    @Operation(summary = "查询", description = "如果parentId为空,则查询的第一级,且只查询已启用的地区信息")
    public R<List<AreaDto>> find(@RequestParam(required = false) String parentId) {
        AreaQuery areaQuery = new AreaQuery();
        areaQuery.setParentId(parentId);
        areaQuery.setEnabled(true);
        List<AreaDto> list = areaService.list(areaQuery);
        return R.OK(list);
    }
}

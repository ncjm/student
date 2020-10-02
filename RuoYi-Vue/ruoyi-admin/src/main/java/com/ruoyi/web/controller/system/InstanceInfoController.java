package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.system.service.IInstanceInfoService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.InstanceInfo;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 审批单实例Controller
 * 
 * @author ruoyi
 * @date 2020-09-07
 */
@RestController
@RequestMapping("/system/info")
public class InstanceInfoController extends BaseController
{
    @Autowired
    private IInstanceInfoService instanceInfoService;

    /**
     * 查询审批单实例列表
     */
    @PreAuthorize("@ss.hasPermi('system:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(InstanceInfo instanceInfo)
    {
        startPage();
        List<InstanceInfo> list = instanceInfoService.selectInstanceInfoList(instanceInfo);
        return getDataTable(list);
    }

    /**
     * 导出审批单实例列表
     */
    @PreAuthorize("@ss.hasPermi('system:info:export')")
    @Log(title = "审批单实例", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(InstanceInfo instanceInfo)
    {
        List<InstanceInfo> list = instanceInfoService.selectInstanceInfoList(instanceInfo);
        ExcelUtil<InstanceInfo> util = new ExcelUtil<InstanceInfo>(InstanceInfo.class);
        return util.exportExcel(list, "info");
    }

    /**
     * 获取审批单实例详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:info:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(instanceInfoService.selectInstanceInfoById(id));
    }

    /**
     * 新增审批单实例
     */
    @PreAuthorize("@ss.hasPermi('system:info:add')")
    @Log(title = "审批单实例", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody InstanceInfo instanceInfo)
    {
        return toAjax(instanceInfoService.insertInstanceInfo(instanceInfo));
    }

    /**
     * 修改审批单实例
     */
    @PreAuthorize("@ss.hasPermi('system:info:edit')")
    @Log(title = "审批单实例", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody InstanceInfo instanceInfo)
    {
        return toAjax(instanceInfoService.updateInstanceInfo(instanceInfo));
    }

    /**
     * 删除审批单实例
     */
    @PreAuthorize("@ss.hasPermi('system:info:remove')")
    @Log(title = "审批单实例", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(instanceInfoService.deleteInstanceInfoByIds(ids));
    }
}

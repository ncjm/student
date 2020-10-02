package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.InstanceInfo;

/**
 * 审批单实例Mapper接口
 * 
 * @author ruoyi
 * @date 2020-09-07
 */
public interface InstanceInfoMapper 
{
    /**
     * 查询审批单实例
     * 
     * @param id 审批单实例ID
     * @return 审批单实例
     */
    public InstanceInfo selectInstanceInfoById(String id);

    /**
     * 查询审批单实例列表
     * 
     * @param instanceInfo 审批单实例
     * @return 审批单实例集合
     */
    public List<InstanceInfo> selectInstanceInfoList(InstanceInfo instanceInfo);

    /**
     * 新增审批单实例
     * 
     * @param instanceInfo 审批单实例
     * @return 结果
     */
    public int insertInstanceInfo(InstanceInfo instanceInfo);

    /**
     * 修改审批单实例
     * 
     * @param instanceInfo 审批单实例
     * @return 结果
     */
    public int updateInstanceInfo(InstanceInfo instanceInfo);

    /**
     * 删除审批单实例
     * 
     * @param id 审批单实例ID
     * @return 结果
     */
    public int deleteInstanceInfoById(String id);

    /**
     * 批量删除审批单实例
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteInstanceInfoByIds(String[] ids);
}

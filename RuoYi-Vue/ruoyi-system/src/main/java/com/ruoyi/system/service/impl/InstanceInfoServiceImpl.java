package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.InstanceInfoMapper;
import com.ruoyi.system.domain.InstanceInfo;
import com.ruoyi.system.service.IInstanceInfoService;

/**
 * 审批单实例Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-07
 */
@Service
public class InstanceInfoServiceImpl implements IInstanceInfoService 
{
    @Autowired
    private InstanceInfoMapper instanceInfoMapper;

    /**
     * 查询审批单实例
     * 
     * @param id 审批单实例ID
     * @return 审批单实例
     */
    @Override
    public InstanceInfo selectInstanceInfoById(String id)
    {
        return instanceInfoMapper.selectInstanceInfoById(id);
    }

    /**
     * 查询审批单实例列表
     * 
     * @param instanceInfo 审批单实例
     * @return 审批单实例
     */
    @Override
    public List<InstanceInfo> selectInstanceInfoList(InstanceInfo instanceInfo)
    {
        return instanceInfoMapper.selectInstanceInfoList(instanceInfo);
    }

    /**
     * 新增审批单实例
     * 
     * @param instanceInfo 审批单实例
     * @return 结果
     */
    @Override
    public int insertInstanceInfo(InstanceInfo instanceInfo)
    {
        return instanceInfoMapper.insertInstanceInfo(instanceInfo);
    }

    /**
     * 修改审批单实例
     * 
     * @param instanceInfo 审批单实例
     * @return 结果
     */
    @Override
    public int updateInstanceInfo(InstanceInfo instanceInfo)
    {
        return instanceInfoMapper.updateInstanceInfo(instanceInfo);
    }

    /**
     * 批量删除审批单实例
     * 
     * @param ids 需要删除的审批单实例ID
     * @return 结果
     */
    @Override
    public int deleteInstanceInfoByIds(String[] ids)
    {
        return instanceInfoMapper.deleteInstanceInfoByIds(ids);
    }

    /**
     * 删除审批单实例信息
     * 
     * @param id 审批单实例ID
     * @return 结果
     */
    @Override
    public int deleteInstanceInfoById(String id)
    {
        return instanceInfoMapper.deleteInstanceInfoById(id);
    }
}

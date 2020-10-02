package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 审批单实例对象 instance_info
 *
 * @author ruoyi
 * @date 2020-09-07
 */
public class InstanceInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String id;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 企业id */
    @Excel(name = "企业id")
    private String corpId;

    /** 发起人id */
    @Excel(name = "发起人id")
    private String originatorUserId;

    /** 发起人部门id */
    @Excel(name = "发起人部门id")
    private String originatorDeptId;

    /** 0第一级，1第二级，2第三极（发送的时候去修改） */
    @Excel(name = "0第一级，1第二级，2第三极")
    private Long stateType;

    /** 审批状态，分为

     0,NEW（新创建）

     1,RUNNING（运行中）

     2,TERMINATED（被终止,不同意）

     3,COMPLETED（完成,同意） */
    @Excel(name = "审批状态，分为0,NEW")
            private Long status;

            /** 当前处理人 */
            @Excel(name = "当前处理人")
            private String tasksUser;

            /** 审批日期 */
            @Excel(name = "审批日期")
            private String patrolDate;

            /** 审批巡查单位 */
            @Excel(name = "审批巡查单位")
            private String patrolDept;

            /** 巡查人 */
            @Excel(name = "巡查人")
            private String patrolUser;

            /** 审批巡查路段 */
            @Excel(name = "审批巡查路段")
            private String patrolRoad;

            /** 审批问题简述 */
            @Excel(name = "审批问题简述")
            private String description;

            /** 审批填写说明 */
            @Excel(name = "审批填写说明")
            private String txsm;

            /** 审批备注 */
            @Excel(name = "审批备注")
            private String remake;

            /** 创建时间 */
            @JsonFormat(pattern = "yyyy-MM-dd")
            @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /** 审批图片地址 */
    @Excel(name = "审批图片地址")
    private String imgUrl;

    /** 发起人名称 */
    @Excel(name = "发起人名称")
    private String originatorUser;

    /** 发起人部门 */
    @Excel(name = "发起人部门")
    private String originatorDept;

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }
    public void setCorpId(String corpId)
    {
        this.corpId = corpId;
    }

    public String getCorpId()
    {
        return corpId;
    }
    public void setOriginatorUserId(String originatorUserId)
    {
        this.originatorUserId = originatorUserId;
    }

    public String getOriginatorUserId()
    {
        return originatorUserId;
    }
    public void setOriginatorDeptId(String originatorDeptId)
    {
        this.originatorDeptId = originatorDeptId;
    }

    public String getOriginatorDeptId()
    {
        return originatorDeptId;
    }
    public void setStateType(Long stateType)
    {
        this.stateType = stateType;
    }

    public Long getStateType()
    {
        return stateType;
    }
    public void setStatus(Long status)
    {
        this.status = status;
    }

    public Long getStatus()
    {
        return status;
    }
    public void setTasksUser(String tasksUser)
    {
        this.tasksUser = tasksUser;
    }

    public String getTasksUser()
    {
        return tasksUser;
    }
    public void setPatrolDate(String patrolDate)
    {
        this.patrolDate = patrolDate;
    }

    public String getPatrolDate()
    {
        return patrolDate;
    }
    public void setPatrolDept(String patrolDept)
    {
        this.patrolDept = patrolDept;
    }

    public String getPatrolDept()
    {
        return patrolDept;
    }
    public void setPatrolUser(String patrolUser)
    {
        this.patrolUser = patrolUser;
    }

    public String getPatrolUser()
    {
        return patrolUser;
    }
    public void setPatrolRoad(String patrolRoad)
    {
        this.patrolRoad = patrolRoad;
    }

    public String getPatrolRoad()
    {
        return patrolRoad;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }
    public void setTxsm(String txsm)
    {
        this.txsm = txsm;
    }

    public String getTxsm()
    {
        return txsm;
    }
    public void setRemake(String remake)
    {
        this.remake = remake;
    }

    public String getRemake()
    {
        return remake;
    }
    public void setCreateDate(Date createDate)
    {
        this.createDate = createDate;
    }

    public Date getCreateDate()
    {
        return createDate;
    }
    public void setImgUrl(String imgUrl)
    {
        this.imgUrl = imgUrl;
    }

    public String getImgUrl()
    {
        return imgUrl;
    }
    public void setOriginatorUser(String originatorUser)
    {
        this.originatorUser = originatorUser;
    }

    public String getOriginatorUser()
    {
        return originatorUser;
    }
    public void setOriginatorDept(String originatorDept)
    {
        this.originatorDept = originatorDept;
    }

    public String getOriginatorDept()
    {
        return originatorDept;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("title", getTitle())
                .append("corpId", getCorpId())
                .append("originatorUserId", getOriginatorUserId())
                .append("originatorDeptId", getOriginatorDeptId())
                .append("stateType", getStateType())
                .append("status", getStatus())
                .append("tasksUser", getTasksUser())
                .append("patrolDate", getPatrolDate())
                .append("patrolDept", getPatrolDept())
                .append("patrolUser", getPatrolUser())
                .append("patrolRoad", getPatrolRoad())
                .append("description", getDescription())
                .append("txsm", getTxsm())
                .append("remake", getRemake())
                .append("createDate", getCreateDate())
                .append("imgUrl", getImgUrl())
                .append("originatorUser", getOriginatorUser())
                .append("originatorDept", getOriginatorDept())
                .toString();
    }
}

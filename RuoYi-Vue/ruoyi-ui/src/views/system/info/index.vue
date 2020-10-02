<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="标题" prop="title">
        <el-input
          v-model="queryParams.title"
          placeholder="请输入标题"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="企业id" prop="corpId">
        <el-input
          v-model="queryParams.corpId"
          placeholder="请输入企业id"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="发起人id" prop="originatorUserId">
        <el-input
          v-model="queryParams.originatorUserId"
          placeholder="请输入发起人id"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="发起人部门id" prop="originatorDeptId">
        <el-input
          v-model="queryParams.originatorDeptId"
          placeholder="请输入发起人部门id"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="0第一级，1第二级，2第三极" prop="stateType">
        <el-select v-model="queryParams.stateType" placeholder="请选择0第一级，1第二级，2第三极" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="审批状态，分为

0,NEW" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择审批状态，分为

0,NEW" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="当前处理人" prop="tasksUser">
        <el-input
          v-model="queryParams.tasksUser"
          placeholder="请输入当前处理人"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="审批日期" prop="patrolDate">
        <el-input
          v-model="queryParams.patrolDate"
          placeholder="请输入审批日期"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="审批巡查单位" prop="patrolDept">
        <el-input
          v-model="queryParams.patrolDept"
          placeholder="请输入审批巡查单位"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="巡查人" prop="patrolUser">
        <el-input
          v-model="queryParams.patrolUser"
          placeholder="请输入巡查人"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="审批巡查路段" prop="patrolRoad">
        <el-input
          v-model="queryParams.patrolRoad"
          placeholder="请输入审批巡查路段"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="审批填写说明" prop="txsm">
        <el-input
          v-model="queryParams.txsm"
          placeholder="请输入审批填写说明"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="审批备注" prop="remake">
        <el-input
          v-model="queryParams.remake"
          placeholder="请输入审批备注"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="创建时间" prop="createDate">
        <el-date-picker clearable size="small" style="width: 200px"
          v-model="queryParams.createDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择创建时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="审批图片地址" prop="imgUrl">
        <el-input
          v-model="queryParams.imgUrl"
          placeholder="请输入审批图片地址"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="发起人名称" prop="originatorUser">
        <el-input
          v-model="queryParams.originatorUser"
          placeholder="请输入发起人名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="发起人部门" prop="originatorDept">
        <el-input
          v-model="queryParams.originatorDept"
          placeholder="请输入发起人部门"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="cyan" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:info:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:info:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:info:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:info:export']"
        >导出</el-button>
      </el-col>
	  <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="infoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="标题" align="center" prop="title" />
      <el-table-column label="企业id" align="center" prop="corpId" />
      <el-table-column label="发起人id" align="center" prop="originatorUserId" />
      <el-table-column label="发起人部门id" align="center" prop="originatorDeptId" />
      <el-table-column label="0第一级，1第二级，2第三极" align="center" prop="stateType" />
      <el-table-column label="审批状态，分为

0,NEW" align="center" prop="status" />
      <el-table-column label="当前处理人" align="center" prop="tasksUser" />
      <el-table-column label="审批日期" align="center" prop="patrolDate" />
      <el-table-column label="审批巡查单位" align="center" prop="patrolDept" />
      <el-table-column label="巡查人" align="center" prop="patrolUser" />
      <el-table-column label="审批巡查路段" align="center" prop="patrolRoad" />
      <el-table-column label="审批问题简述" align="center" prop="description" />
      <el-table-column label="审批填写说明" align="center" prop="txsm" />
      <el-table-column label="审批备注" align="center" prop="remake" />
      <el-table-column label="创建时间" align="center" prop="createDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="审批图片地址" align="center" prop="imgUrl" />
      <el-table-column label="发起人名称" align="center" prop="originatorUser" />
      <el-table-column label="发起人部门" align="center" prop="originatorDept" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:info:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:info:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改审批单实例对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="发起人部门" prop="id">
          <el-input v-model="form.id" placeholder="请输入发起人部门" />
        </el-form-item>
        <el-form-item label="标题" prop="title">
          <el-input v-model="form.title" placeholder="请输入标题" />
        </el-form-item>
        <el-form-item label="企业id" prop="corpId">
          <el-input v-model="form.corpId" placeholder="请输入企业id" />
        </el-form-item>
        <el-form-item label="发起人id" prop="originatorUserId">
          <el-input v-model="form.originatorUserId" placeholder="请输入发起人id" />
        </el-form-item>
        <el-form-item label="发起人部门id" prop="originatorDeptId">
          <el-input v-model="form.originatorDeptId" placeholder="请输入发起人部门id" />
        </el-form-item>
        <el-form-item label="0第一级，1第二级，2第三极">
          <el-select v-model="form.stateType" placeholder="请选择0第一级，1第二级，2第三极">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="审批状态，分为

0,NEW">
          <el-radio-group v-model="form.status">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="当前处理人" prop="tasksUser">
          <el-input v-model="form.tasksUser" placeholder="请输入当前处理人" />
        </el-form-item>
        <el-form-item label="审批日期" prop="patrolDate">
          <el-input v-model="form.patrolDate" placeholder="请输入审批日期" />
        </el-form-item>
        <el-form-item label="审批巡查单位" prop="patrolDept">
          <el-input v-model="form.patrolDept" placeholder="请输入审批巡查单位" />
        </el-form-item>
        <el-form-item label="巡查人" prop="patrolUser">
          <el-input v-model="form.patrolUser" placeholder="请输入巡查人" />
        </el-form-item>
        <el-form-item label="审批巡查路段" prop="patrolRoad">
          <el-input v-model="form.patrolRoad" placeholder="请输入审批巡查路段" />
        </el-form-item>
        <el-form-item label="审批问题简述" prop="description">
          <el-input v-model="form.description" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="审批填写说明" prop="txsm">
          <el-input v-model="form.txsm" placeholder="请输入审批填写说明" />
        </el-form-item>
        <el-form-item label="审批备注" prop="remake">
          <el-input v-model="form.remake" placeholder="请输入审批备注" />
        </el-form-item>
        <el-form-item label="创建时间" prop="createDate">
          <el-date-picker clearable size="small" style="width: 200px"
            v-model="form.createDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择创建时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="审批图片地址" prop="imgUrl">
          <el-input v-model="form.imgUrl" placeholder="请输入审批图片地址" />
        </el-form-item>
        <el-form-item label="发起人名称" prop="originatorUser">
          <el-input v-model="form.originatorUser" placeholder="请输入发起人名称" />
        </el-form-item>
        <el-form-item label="发起人部门" prop="originatorDept">
          <el-input v-model="form.originatorDept" placeholder="请输入发起人部门" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listInfo, getInfo, delInfo, addInfo, updateInfo, exportInfo } from "@/api/system/info";

export default {
  name: "Info",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 审批单实例表格数据
      infoList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        title: null,
        corpId: null,
        originatorUserId: null,
        originatorDeptId: null,
        stateType: null,
        status: null,
        tasksUser: null,
        patrolDate: null,
        patrolDept: null,
        patrolUser: null,
        patrolRoad: null,
        description: null,
        txsm: null,
        remake: null,
        createDate: null,
        imgUrl: null,
        originatorUser: null,
        originatorDept: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询审批单实例列表 */
    getList() {
      this.loading = true;
      listInfo(this.queryParams).then(response => {
        this.infoList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        title: null,
        corpId: null,
        originatorUserId: null,
        originatorDeptId: null,
        stateType: null,
        status: 0,
        tasksUser: null,
        patrolDate: null,
        patrolDept: null,
        patrolUser: null,
        patrolRoad: null,
        description: null,
        txsm: null,
        remake: null,
        createDate: null,
        imgUrl: null,
        originatorUser: null,
        originatorDept: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加审批单实例";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getInfo(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改审批单实例";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateInfo(this.form).then(response => {
              if (response.code === 200) {
                this.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              }
            });
          } else {
            addInfo(this.form).then(response => {
              if (response.code === 200) {
                this.msgSuccess("新增成功");
                this.open = false;
                this.getList();
              }
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$confirm('是否确认删除审批单实例编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delInfo(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(function() {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有审批单实例数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportInfo(queryParams);
        }).then(response => {
          this.download(response.msg);
        }).catch(function() {});
    }
  }
};
</script>

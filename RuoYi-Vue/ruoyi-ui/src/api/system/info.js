import request from '@/utils/request'

// 查询审批单实例列表
export function listInfo(query) {
  return request({
    url: '/system/info/list',
    method: 'get',
    params: query
  })
}

// 查询审批单实例详细
export function getInfo(id) {
  return request({
    url: '/system/info/' + id,
    method: 'get'
  })
}

// 新增审批单实例
export function addInfo(data) {
  return request({
    url: '/system/info',
    method: 'post',
    data: data
  })
}

// 修改审批单实例
export function updateInfo(data) {
  return request({
    url: '/system/info',
    method: 'put',
    data: data
  })
}

// 删除审批单实例
export function delInfo(id) {
  return request({
    url: '/system/info/' + id,
    method: 'delete'
  })
}

// 导出审批单实例
export function exportInfo(query) {
  return request({
    url: '/system/info/export',
    method: 'get',
    params: query
  })
}
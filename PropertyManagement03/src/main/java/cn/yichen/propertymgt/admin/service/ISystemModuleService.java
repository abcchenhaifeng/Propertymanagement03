package cn.yichen.propertymgt.admin.service;

import java.util.List;

import cn.yichen.propertymgt.admin.model.SystemModule;

/**
 * 
 * @date: 2019年8月9日 下午9:19:25
 * @author: YiChen(李冠永)
 * @Description: 系统模块业务层接口
 *
 */
public interface ISystemModuleService {

	// 添加
	public void add(SystemModule systemModule) throws Exception;

	// 修改
	public void modify(SystemModule systemModule) throws Exception;

	// 删除
	public void delete(int no) throws Exception;

	// 按条件获取列表
	public List<SystemModule> getListByAll(SystemModule systemModule) throws Exception;

	// 按条件获取列表(分页)
	public List<SystemModule> getListByAllWithPage(SystemModule systemModule, int page, int rows) throws Exception;

	// 按no获取
	public SystemModule getModuleByNo(int no) throws Exception;

	// 获取个数
	public int getCountByAll(SystemModule systemModule) throws Exception;
}

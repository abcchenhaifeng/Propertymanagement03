package cn.yichen.propertymgt.admin.service;

import java.util.List;

import cn.yichen.propertymgt.admin.model.SystemFunction;

/**
 * 
 * @date: 2019年8月9日 下午7:03:50
 * @author: YiChen(李冠永)
 * @Description: 系统功能业务层接口
 *
 */
public interface ISystemFunctionService {
		
		// 添加
		public void add(SystemFunction systemFunction) throws Exception;

		// 修改
		public void modify(SystemFunction systemFunction) throws Exception;
		
		// 修改模块
		public void modifyModule(int no, int mno) throws Exception;
		
		// 删除
		public void delete(int no) throws Exception;

		// 按条件获取列表
		public List<SystemFunction> getListByCriteria(SystemFunction systemFunction) throws Exception;
		
		// 按条件获取列表(分页)
		public List<SystemFunction> getListByCriteriaWithPage(SystemFunction systemFunction, int page, int rows) throws Exception;
		public List<SystemFunction> getListByCriteriaAndUseridWithPage(SystemFunction systemFunction, String userid, int page, int rows) throws Exception;
		
		// 按no获取
		public SystemFunction getFunctionByNo(int no) throws Exception;
		
		// 获取个数
		public int getCountByCriteria(SystemFunction systemFunction) throws Exception;

		public int getCountByCriteriaAndUserid(SystemFunction systemFunction, String userid) throws Exception;
}

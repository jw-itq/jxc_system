package com.mf.service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import com.mf.entity.Goods;

/**
 * 材料Service接口
 * @author Administrator
 *
 */
public interface GoodsService {

	/**
	 * 查询某个类别下的所有材料
	 * @param typeId
	 * @return
	 */
	public List<Goods> findByTypeId(int typeId);

	/**
	 * 根据条件分页查询材料信息
	 * @param goods
	 * @param page
	 * @param pageSize
	 * @param direction
	 * @param properties
	 * @return
	 */
	public List<Goods> list(Goods goods,Integer page,Integer pageSize,Direction direction,String...properties);

	/**
	 * 获取总记录数
	 * @param goods
	 * @return
	 */
	public Long getCount(Goods goods);

	/**
	 * 根据材料编码或材料名称条件分页查询没有库存的材料信息
	 * @param codeOrName
	 * @param page
	 * @param pageSize
	 * @param direction
	 * @param properties
	 * @return
	 */
	public List<Goods> listNoInventoryQuantityByCodeOrName(String codeOrName,Integer page,Integer pageSize,Direction direction,String...properties);

	/**
	 * 根据材料编码或材料名称条件分页查询没有库存的材料信息的总记录数
	 * @param codeOrName
	 * @return
	 */
	public Long getCountNoInventoryQuantityByCodeOrName(String codeOrName);

	/**
	 * 根据材料编码或材料名称条件分页查询有库存的材料信息
	 * @param codeOrName
	 * @param page
	 * @param pageSize
	 * @param direction
	 * @param properties
	 * @return
	 */
	public List<Goods> listHasInventoryQuantityByCodeOrName(String codeOrName,Integer page,Integer pageSize,Direction direction,String...properties);

	/**
	 * 根据材料编码或材料名称条件分页查询有库存的材料信息的总记录数
	 * @param codeOrName
	 * @return
	 */
	public Long getCountHasInventoryQuantityByCodeOrName(String codeOrName);

	/**
	 * 获取最大的材料编码
	 * @return
	 */
	public String getMaxGoodsCode();

	/**
	 * 根据id删除材料
	 * @param id
	 */
	public void delete(Integer id);

	/**
	 * 根据id查询实体
	 * @param id
	 * @return
	 */
	public Goods findById(Integer id);

	/**
	 * 添加或者修改材料信息
	 * @param goods
	 */
	public void save(Goods goods);

	/**
	 * 查询库存报警材料，实际库存小于库存下限的材料
	 * @return
	 */
	public List<Goods> listAlarm();
}

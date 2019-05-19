package com.mf.service;

import java.util.List;


import com.mf.entity.GoodsUnit;

/**
 * 材料单位Service接口
 * @author Administrator
 *
 */
public interface GoodsUnitService {

	/**
	 * 查询所有材料单位信息
	 * @return
	 */
	public List<GoodsUnit> listAll();

	/**
	 * 添加或者修改材料单位信息
	 * @param user
	 */
	public void save(GoodsUnit goodsUnit);

	/**
	 * 根据id删除材料单位
	 * @param id
	 */
	public void delete(Integer id);

	/**
	 * 根据id查询实体
	 * @param id
	 * @return
	 */
	public GoodsUnit findById(Integer id);
}

package com.mf.service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import com.mf.entity.DamageList;
import com.mf.entity.DamageListGoods;

/**
 * 材料报损单Service接口
 * @author Administrator
 *
 */
public interface DamageListService {

	/**
	 * 根据id查询实体
	 * @param id
	 * @return
	 */
	public DamageList findById(Integer id);

	/**
	 * 获取当天最大材料报损单号
	 * @return
	 */
	public String getTodayMaxDamageNumber();

	/**
	 * 添加材料报损单 以及所有材料报损单材料  以及 修改材料成本价 库存数量 上次进价
	 * @param damageList
	 * @param damageListGoodsList
	 */
	public void save(DamageList damageList,List<DamageListGoods> damageListGoodsList);

	/**
	 * 根据条件查询材料报损单信息
	 * @param damageList
	 * @param direction
	 * @param properties
	 * @return
	 */
	public List<DamageList> list(DamageList damageList,Direction direction,String...properties);

}

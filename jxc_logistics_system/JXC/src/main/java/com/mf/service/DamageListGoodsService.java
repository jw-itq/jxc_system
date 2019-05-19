package com.mf.service;

import java.util.List;

import com.mf.entity.DamageListGoods;

/**
 * 材料报损单材料Service接口
 * @author Administrator
 *
 */
public interface DamageListGoodsService {

	/**
	 * 根据材料报损单id查询所有材料报损单材料
	 * @param damageListId
	 * @return
	 */
	public List<DamageListGoods> listByDamageListId(Integer damageListId);

}

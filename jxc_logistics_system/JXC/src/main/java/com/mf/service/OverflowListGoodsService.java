package com.mf.service;

import java.util.List;

import com.mf.entity.OverflowListGoods;

/**
 * 材料报溢单材料Service接口
 * @author Administrator
 *
 */
public interface OverflowListGoodsService {

	/**
	 * 根据材料报溢单id查询所有材料报溢单材料
	 * @param overflowListId
	 * @return
	 */
	public List<OverflowListGoods> listByOverflowListId(Integer overflowListId);

}

package com.mf.service;

import java.util.List;

import com.mf.entity.ReturnListGoods;

/**
 * 退货单材料Service接口
 * @author Administrator
 *
 */
public interface ReturnListGoodsService {

	/**
	 * 根据退货单id查询所有退货单材料
	 * @param returnListId
	 * @return
	 */
	public List<ReturnListGoods> listByReturnListId(Integer returnListId);

	/**
	 * 根据条件查询退货单材料
	 * @param returnListGoods
	 * @return
	 */
	public List<ReturnListGoods> list(ReturnListGoods returnListGoods);
}

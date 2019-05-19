package com.mf.service;

import java.util.List;

import com.mf.entity.SaleListGoods;

/**
 * 销售单材料Service接口
 * @author Administrator
 *
 */
public interface SaleListGoodsService {

	/**
	 * 根据销售单id查询所有销售单材料
	 * @param saleListId
	 * @return
	 */
	public List<SaleListGoods> listBySaleListId(Integer saleListId);

	/**
	 * 统计某个材料的销售总数
	 * @param goodsId
	 * @return
	 */
	public Integer getTotalByGoodsId(Integer goodsId);

	/**
	 * 根据条件查询销售单材料
	 * @param saleListGoods
	 * @return
	 */
	public List<SaleListGoods> list(SaleListGoods saleListGoods);

}

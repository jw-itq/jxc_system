package com.mf.service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import com.mf.entity.OverflowList;
import com.mf.entity.OverflowListGoods;

/**
 * 材料报溢单Service接口
 * @author Administrator
 *
 */
public interface OverflowListService {

	/**
	 * 根据id查询实体
	 * @param id
	 * @return
	 */
	public OverflowList findById(Integer id);

	/**
	 * 获取当天最大材料报溢单号
	 * @return
	 */
	public String getTodayMaxOverflowNumber();

	/**
	 * 添加材料报溢单 以及所有材料报溢单材料  以及 修改材料成本价 库存数量 上次进价
	 * @param overflowList
	 * @param overflowListGoodsList
	 */
	public void save(OverflowList overflowList,List<OverflowListGoods> overflowListGoodsList);

	/**
	 * 根据条件查询材料报溢单信息
	 * @param overflowList
	 * @param direction
	 * @param properties
	 * @return
	 */
	public List<OverflowList> list(OverflowList overflowList,Direction direction,String...properties);

}

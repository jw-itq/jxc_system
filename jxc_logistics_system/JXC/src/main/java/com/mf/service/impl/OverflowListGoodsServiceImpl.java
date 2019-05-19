package com.mf.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mf.entity.OverflowListGoods;
import com.mf.repository.OverflowListGoodsRepository;
import com.mf.service.OverflowListGoodsService;

/**
 * 材料报溢单材料Service实现类
 * @author Administrator
 *
 */
@Service("overflowListGoodsService")
public class OverflowListGoodsServiceImpl implements OverflowListGoodsService{

	@Resource
	private OverflowListGoodsRepository overflowListGoodsRepository;

	@Override
	public List<OverflowListGoods> listByOverflowListId(Integer overflowListId) {
		return overflowListGoodsRepository.listByOverflowListId(overflowListId);
	}



}

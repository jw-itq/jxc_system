package com.mf.service.impl;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.mf.entity.Goods;
import com.mf.entity.OverflowList;
import com.mf.entity.OverflowListGoods;
import com.mf.repository.GoodsRepository;
import com.mf.repository.GoodsTypeRepository;
import com.mf.repository.OverflowListGoodsRepository;
import com.mf.repository.OverflowListRepository;
import com.mf.service.OverflowListService;

/**
 * 材料报溢单Service实现类
 * @author Administrator
 *
 */
@Service("overflowListService")
public class OverflowListServiceImpl implements OverflowListService{

	@Resource
	private OverflowListRepository overflowListRepository;

	@Resource
	private GoodsTypeRepository goodsTypeRepository;

	@Resource
	private GoodsRepository goodsRepository;

	@Resource
	private OverflowListGoodsRepository overflowListGoodsRepository;

	@Override
	public String getTodayMaxOverflowNumber() {
		return overflowListRepository.getTodayMaxOverflowNumber();
	}

	@Transactional
	public void save(OverflowList overflowList, List<OverflowListGoods> overflowListGoodsList) {
		for(OverflowListGoods overflowListGoods:overflowListGoodsList){
			overflowListGoods.setType(goodsTypeRepository.findOne(overflowListGoods.getTypeId())); // 设置类别
			overflowListGoods.setOverflowList(overflowList); // 设置材料报溢单
			overflowListGoodsRepository.save(overflowListGoods);
			// 修改材料库存
			Goods goods=goodsRepository.findOne(overflowListGoods.getGoodsId());

			goods.setInventoryQuantity(goods.getInventoryQuantity()+overflowListGoods.getNum());
			goods.setState(2);
			goodsRepository.save(goods);
		}
		overflowListRepository.save(overflowList); // 保存材料报溢单
	}

	@Override
	public List<OverflowList> list(final OverflowList overflowList, Direction direction, String... properties) {
		return overflowListRepository.findAll(new Specification<OverflowList>() {

			@Override
			public Predicate toPredicate(Root<OverflowList> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate=cb.conjunction();
				if(overflowList!=null){
					if(overflowList.getbOverflowDate()!=null){
						predicate.getExpressions().add(cb.greaterThanOrEqualTo(root.<Date>get("overflowDate"), overflowList.getbOverflowDate()));
					}
					if(overflowList.geteOverflowDate()!=null){
						predicate.getExpressions().add(cb.lessThanOrEqualTo(root.<Date>get("overflowDate"), overflowList.geteOverflowDate()));
					}
				}
				return predicate;
			}
		},new Sort(direction, properties));
	}

	@Override
	public OverflowList findById(Integer id) {
		return overflowListRepository.findOne(id);
	}




}

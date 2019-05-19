package com.mf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.mf.entity.DamageListGoods;

/**
 * 材料报损单材料Repository接口
 * @author Administrator
 *
 */
public interface DamageListGoodsRepository extends JpaRepository<DamageListGoods, Integer>,JpaSpecificationExecutor<DamageListGoods>{

	/**
	 * 根据材料报损单id查询所有材料报损单材料
	 * @param damageListId
	 * @return
	 */
	@Query(value="SELECT * FROM t_damage_list_goods WHERE damage_list_id=?1",nativeQuery=true)
	public List<DamageListGoods> listByDamageListId(Integer damageListId);

	/**
	 * 根据材料报损单id删除所有材料报损单材料
	 * @param damageListId
	 * @return
	 */
	@Query(value="delete FROM t_damage_list_goods WHERE damage_list_id=?1",nativeQuery=true)
	@Modifying
	public void deleteByDamageListId(Integer damageListId);
}

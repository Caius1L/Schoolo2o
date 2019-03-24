package o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import o2o.entity.Shop;

public interface ShopDao {
	// 新增店铺
	int insertShop(Shop shop);

	// 更新店铺
	int updateShop(Shop shop);

	// 通过Id查询店铺信息
	Shop queryByShopId(long shopId);

	// 分页查询店铺
	/**
	 * 分页查询店铺，模糊查询
	 * 
	 * @param shopCondition
	 * @param rowIndex      从第几行开始取数据
	 * @param pageSize      返回的行数
	 * @return
	 */
    List<Shop> queryShopList(@Param("shopCondition") Shop shopCondition, @Param("rowIndex") int rowIndex,
			@Param("pageSize") int pageSize);
    
    int queryShopCount(@Param("shopCondition") Shop shopCondition);
}

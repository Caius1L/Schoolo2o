package o2o.service;


import o2o.dto.ImageHolder;
import o2o.dto.ShopExecution;
import o2o.entity.Shop;
import o2o.exceptions.ShopOperationException;

public interface ShopService {
    /**
      * 根据shopCondition分页返回相应的列表数据
     * @param shopCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
	ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize);

	ShopExecution addShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException;

	// 通过店铺ID获取店铺信息
	Shop getByShopId(long shopId);

	// 更新店铺信息
	ShopExecution modifyShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException;
}

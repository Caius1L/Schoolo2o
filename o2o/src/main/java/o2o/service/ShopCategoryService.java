package o2o.service;

import java.util.List;

import o2o.entity.ShopCategory;


public interface ShopCategoryService {
	public static final String SCLISTKEY = "shopCategoryList";
	List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition);
}

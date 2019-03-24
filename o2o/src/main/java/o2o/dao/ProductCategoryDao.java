package o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import o2o.entity.ProductCategory;

/**
 * 通过shopid来查询店铺商品类别
 * 
 * @author Administrator
 *
 */

public interface ProductCategoryDao {
	List<ProductCategory> queryproductCategoryList(long shopId);

	
	/**
	 * 批量新增实体类别
	 * @param productCategoryList
	 * @return
	 */
	int batchInsertProductCategory(List<ProductCategory> productCategoryList);
	
	int deleteProductCategory(@Param("productCategoryId")long productCategoryId,@Param("shopId")long shopId);
}

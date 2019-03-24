package o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import o2o.entity.Product;

public interface ProductDao {

	/**
	 * 通过条件模糊查询商品列表
	 * @param productCondition
	 * @param rowIndex
	 * @param pageSize
	 * @return
	 */
	List<Product> queryProductList(@Param("productCondition")Product productCondition,@Param("rowIndex") int rowIndex,
	@Param("pageSize") int pageSize);
	
	/**
	 * 
	 * 
	 * @param productCondition
	 * @return
	 */
	int queryProductCount(@Param("productCondition") Product productCondition);
	
	/**
	 * 通过id查询商品
	 * @param productId
	 * @return
	 */
	Product queryProductByProductId(long productId);
	
	/**
	 * 插入商品
	 * @param product
	 * @return
	 */
	int insertProduct(Product product);
	
	/**
	 * 更新商品
	 * @param product
	 * @return
	 */
	int updateProduct(Product product);

	/**
	 * 清空
	 * 
	 * @param productCategoryId
	 * @return
	 */
	int updateProductCategoryToNull(long productCategoryId);

	/**
	 * 删除商品
	 * 
	 * @param productId
	 * @return
	 */
	int deleteProduct(@Param("productId") long productId, @Param("shopId") long shopId);

	
}

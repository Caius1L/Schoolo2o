package o2o.dao;

import java.util.List;

import o2o.entity.ProductImg;

public interface ProductImgDao {

	List <ProductImg> queryProductImgList(long productId);
	/**
	 * 批量添加商品图片
	 * @param productImgList
	 * @return
	 */
	int batchInsertProductImg(List<ProductImg> productImgList);
	/**
	 * 删除商品图片
	 * @param productId
	 * @return
	 */
	int deleteProductImgByProductId(long productId);
	
	
}

package o2o.service;

import java.util.List;

import o2o.dto.ProductCategoryExecution;
import o2o.entity.ProductCategory;
import o2o.exceptions.ProductCategoryOperationException;

public interface ProductCategoryService {
/**
 * 查询指定店铺下所有商品类别信息
 * @param shopId
 * @return
 */

 List<ProductCategory> getProductCategoryList(long shopId) ;

ProductCategoryExecution batchAddProductCategory(List<ProductCategory>productCategoryList)
		throws ProductCategoryOperationException;

ProductCategoryExecution deleteProductCategory(long productCategoryId,long shopId)
		throws ProductCategoryOperationException;
}

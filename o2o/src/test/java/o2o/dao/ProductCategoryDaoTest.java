package o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import o2o.entity.ProductCategory;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductCategoryDaoTest extends BaseTest {
	@Autowired
	private ProductCategoryDao productCategoryDao;

	@Test
	@Ignore
	public void testQueryByShopId() throws Exception {
		long shopId = 2;
		List<ProductCategory> productCategoryList = productCategoryDao.queryproductCategoryList(shopId);
		System.out.println(productCategoryList.size());
	}
    @Test
    @Ignore
    public void testBatchInsertProductCategory() {
    	ProductCategory productCategory = new ProductCategory();
		productCategory.setProductCategoryName("test3");
		productCategory.setPriority(1);
		productCategory.setCreateTime(new Date());
		productCategory.setShopId(2L);
		ProductCategory productCategory2 = new ProductCategory();
		productCategory2.setProductCategoryName("test4");
		productCategory2.setPriority(2);
		productCategory2.setCreateTime(new Date());
		productCategory2.setShopId(2L);
		List<ProductCategory> productCategoryList = new ArrayList<ProductCategory>();
		productCategoryList.add(productCategory);
		productCategoryList.add(productCategory2);
		int effectedNum = productCategoryDao.batchInsertProductCategory(productCategoryList);
		assertEquals(2, effectedNum);
    }
    @Test
    public void testDeleteProductCategory()throws Exception{
    	long shopId=2;
    	List<ProductCategory> productCategoryList = productCategoryDao.queryproductCategoryList(shopId);
    	for(ProductCategory pc:productCategoryList) {
    		if(("test3").equals(pc.getProductCategoryName())||("test4").equals(pc.getProductCategoryName())){
    			int effectedNum=productCategoryDao.deleteProductCategory(pc.getProductCategoryId(), shopId);
    			assertEquals(1,effectedNum);
    		}
    	}
    }
}

package o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import o2o.entity.ShopCategory;



public class ShopCategoryDaoTest extends BaseTest{
	  @Autowired
	   private ShopCategoryDao shopCategoryDao;
	   @Test
	   public void testshopCategoryDao() {
		   List<ShopCategory> shopCategoryList=shopCategoryDao.queryShopCategory(new ShopCategory());
		   assertEquals(0,shopCategoryList.size());
	   }
}

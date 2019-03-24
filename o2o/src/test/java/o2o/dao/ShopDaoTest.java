package o2o.dao;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import o2o.entity.Area;
import o2o.entity.PersonInfo;
import o2o.entity.Shop;
import o2o.entity.ShopCategory;

public class ShopDaoTest extends BaseTest {
    @Autowired
    private ShopDao shopDao;
    @Test
	public void testQueryShopList() {
		Shop shopCondition=new Shop();
		PersonInfo owner=new PersonInfo();
		owner.setUserId(1L);
		shopCondition.setOwner(owner);
		int count=shopDao.queryShopCount(shopCondition);
		List<Shop> shopList=shopDao.queryShopList(shopCondition,0,6);
		System.out.println(count);
	}
    @Test
    @Ignore
    public void testQueryByShopId() {
             long shopId=2;
             Shop shop=shopDao.queryByShopId(shopId);
             System.out.println(shop.getArea().getAreaName());
    }
}

package o2o.service;

import static org.junit.Assert.assertEquals;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import o2o.dao.BaseTest;
import o2o.dao.ShopDao;
import o2o.dto.ImageHolder;
import o2o.dto.ShopExecution;
import o2o.entity.Area;
import o2o.entity.PersonInfo;
import o2o.entity.Shop;
import o2o.entity.ShopCategory;
import o2o.enums.ShopStateEnum;
import o2o.exceptions.ShopOperationException;


public class ShopServiceTest extends BaseTest {
	@Autowired
	private ShopService shopService;

	
	@Test
	public void testGetShopList() {
		Shop shopCondition=new Shop();
		PersonInfo personInfo=new PersonInfo();
		personInfo.setUserId(8L);
		shopCondition.setOwner(personInfo);
		ShopExecution se=shopService.getShopList(shopCondition, 1, 3);
		System.out.println("??"+se.getShopList());
		System.out.println("??"+se.getShopList().size());
		System.out.println(se.getCount());
	}
	
	@Test
	@Ignore
	public void testModifyShop() throws FileNotFoundException,ShopOperationException {
		Shop shop = new Shop();
        shop.setShopId(2L);
        shop.setShopName("修改后的店铺名");
		File shopImg=new File("D:/image/lmy.jpg");
		InputStream is=new FileInputStream(shopImg);
		ImageHolder imageholder=new ImageHolder("lmy.jpg",is);
		ShopExecution shopExecution=shopService.modifyShop(shop, imageholder);
		System.out.println( shopExecution.getShop().getShopImg());
	}
}

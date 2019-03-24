package o2o.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import o2o.dao.BaseTest;
import o2o.dto.ImageHolder;
import o2o.dto.ProductExecution;
import o2o.entity.Product;
import o2o.entity.ProductCategory;
import o2o.entity.Shop;
import o2o.enums.ProductStateEnum;
import o2o.exceptions.ShopOperationException;

public class ProductServiceTest extends BaseTest{
  @Autowired
  private ProductService productService;
  @Test
  @Ignore
  public void testAddProduct() throws ShopOperationException, FileNotFoundException {
		// 创建shopid为1且productcategory为1的商品实例并给其成员变量赋值
		Product product = new Product();
		Shop shop = new Shop();
		shop.setShopId(2L);
		ProductCategory pc = new ProductCategory();
		pc.setProductCategoryId(1L);
		product.setShop(shop);
		product.setProductCategory(pc);
		product.setProductName("测试商品8");
		product.setProductDesc("测试商品8");
		product.setPriority(20);
		product.setCreateTime(new Date());
		product.setEnableStatus(ProductStateEnum.SUCCESS.getState());
		// 创建缩略图文件流
		File thumbnailFile = new File("D:/image/lmy.jpg");
		InputStream is = new FileInputStream(thumbnailFile);
		ImageHolder thumbnail = new ImageHolder(thumbnailFile.getName(), is);
		// 创建商品详情图文件流
		File productImg1 = new File("D:/image/lmy.jpg");
		InputStream is1 = new FileInputStream(productImg1);
		File productImg2 = new File("D:/image/lzt.jpg");
		InputStream is2 = new FileInputStream(productImg2);
		List<ImageHolder> productImgList = new ArrayList<ImageHolder>();
		productImgList.add(new ImageHolder(productImg1.getName(), is1));
		productImgList.add(new ImageHolder(productImg2.getName(), is2));
		// 将商品成功加入
		ProductExecution pe = productService.addProduct(product, thumbnail, productImgList);
		assertEquals(ProductStateEnum.SUCCESS.getState(), pe.getState());
	}
  @Test
	public void testModifyProduct() throws ShopOperationException, FileNotFoundException {
		// 创建shopid为1的商品实例并且给他赋值
		Product product = new Product();
		Shop shop = new Shop();
		shop.setShopId(2L);
		ProductCategory pc = new ProductCategory();
		pc.setProductCategoryId(2L);
		product.setProductId(1L);
		product.setShop(shop);
		product.setProductCategory(pc);
		product.setProductName("正式测试商品");
		product.setProductDesc("正式测试商品");
		// 创建缩略文件流
		File thumbnailFile = new File("D:/image/1.jpg");
		InputStream is = new FileInputStream(thumbnailFile);
		ImageHolder thumbnail = new ImageHolder(thumbnailFile.getName(), is);
		//创建两个详情图文件流并加入进列表
		File productImg1 = new File("D:/image/4.jpg");
		InputStream is1 = new FileInputStream(productImg1);
		File productImg2 = new File("D:/image/2.jpg");
		InputStream is2 = new FileInputStream(productImg2);
		List<ImageHolder> productImgList = new ArrayList<ImageHolder>();
		productImgList.add(new ImageHolder(productImg1.getName(), is1));
		productImgList.add(new ImageHolder(productImg2.getName(), is2));
		//更新
		ProductExecution pe = productService.modifyProduct(product, thumbnail, productImgList);
		assertEquals(ProductStateEnum.SUCCESS.getState(), pe.getState());
	}

}

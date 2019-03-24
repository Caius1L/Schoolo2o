package o2o.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import o2o.dao.ShopDao;
import o2o.dto.ShopExecution;
import o2o.entity.Shop;
import o2o.enums.ShopStateEnum;
import o2o.exceptions.ShopOperationException;
import o2o.dto.ImageHolder;
import o2o.service.ShopService;
import o2o.util.ImageUtil;
import o2o.util.PageCalculator;
import o2o.util.PathUtil;

@Service
public class ShopServiceImpl implements ShopService {
	@Autowired
	private ShopDao shopDao;
	
	
	@Override
	@Transactional
	public ShopExecution addShop(Shop shop, ImageHolder thumbnail)throws ShopOperationException {
		// 空值判断
		if (shop == null) {
			return new ShopExecution(ShopStateEnum.NULL_SHOP);
		}
		try {
			// 给店铺赋值初始值
			shop.setEnableStatus(0);
			shop.setCreateTime(new Date());
			shop.setLastEditTime(new Date());
			int effectNum = shopDao.insertShop(shop);
			// 给店铺添加信息
			if (effectNum <= 0) {
				throw new ShopOperationException("创建店铺失败");
			} else {
				if (thumbnail.getImage() != null) {
					// 存储图片
					try {
						addshopImg(shop, thumbnail);
					} catch (Exception e) {
						throw new ShopOperationException("addshopImgInputStream error:" + e.getMessage());
					}
					// 更新店铺的图片地址
					effectNum = shopDao.updateShop(shop);
					if (effectNum <= 0) {
						throw new ShopOperationException("更新图片地址失败:");
					}
				}
			}
		} catch (Exception e) {
			throw new ShopOperationException("addShop:" + e.getMessage());
		}
		return new ShopExecution(ShopStateEnum.CHECK, shop);
	}

	private void addshopImg(Shop shop, ImageHolder thumbnail) {
		// 获取SHOP图片的相对值路径
		String dest = PathUtil.getShopImagePath(shop.getShopId());
		String shopImgAddr = ImageUtil.generateThumbnail(thumbnail,dest);
		shop.setShopImg(shopImgAddr);
	}
	@Override
	public Shop getByShopId(long shopId) {
		return shopDao.queryByShopId(shopId);
	}
	@Override
	public ShopExecution modifyShop(Shop shop,ImageHolder thumbnail)throws ShopOperationException{
		//判断是否需要处理图片
		if(shop==null||shop.getShopId()==null) {
			return new ShopExecution(ShopStateEnum.NULL_SHOP);
		}else {
			try {
			if(thumbnail.getImage() !=null &&thumbnail.getImageName() !=null &&!"".equals(thumbnail.getImageName() )) {
				Shop tempShop=shopDao.queryByShopId(shop.getShopId());
				if(tempShop.getShopImg()!=null) {
					ImageUtil.deleteFileOrPath(tempShop.getShopImg());
				}
				addshopImg(shop,thumbnail);
			}
		//更新店铺信息
		shop.setLastEditTime(new Date());
		int effectedNum=shopDao.updateShop(shop);
		if(effectedNum<=0) {
			return new ShopExecution(ShopStateEnum.INNER_ERROR);
		}else {
			shop=shopDao.queryByShopId(shop.getShopId());
			return new ShopExecution(ShopStateEnum.SUCCESS,shop);
		}
	}catch(Exception e) {
		throw new ShopOperationException("error"+e.getMessage());
	}
}}

	@Override
	public ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize) {
		int rowIndex=PageCalculator.calculateRowIndex(pageIndex, pageSize);
		List<Shop> shopList=shopDao.queryShopList(shopCondition, rowIndex, pageSize);
		int count=shopDao.queryShopCount(shopCondition);
		ShopExecution se=new ShopExecution();
		if(shopList!=null) {
			se.setShopList(shopList);
			se.setCount(count);
		}else {
			se.setState(ShopStateEnum.INNER_ERROR.getState());
		}
		return se;
	}
	}

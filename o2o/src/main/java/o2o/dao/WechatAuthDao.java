package o2o.dao;

import o2o.entity.WeChatAuth;

public interface WechatAuthDao {
	/**
	 * 通过openId查询对应本平台的微信帐号
	 * 
	 * @param openId
	 * @return
	 */
	WeChatAuth queryWechatInfoByOpenId(String openId);

	/**
	 * 添加对应本平台的微信帐号
	 * 
	 * @param wechatAuth
	 * @return
	 */
	int insertWechatAuth(WeChatAuth wechatAuth);

}

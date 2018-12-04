package online.forgame.wechat_pay.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.yml")
public class WeChatConfig {

    /**
     * 微信公众平台id
     */
    @Value("${wxpay.appid}")
    private String appId;

    /**
     * 微信公众平台appsecret
     */
    @Value("${wxpay.appsecret}")
    private String appSecret;

    /**
     * 微信开放平台id
     */
    @Value("${wxopen.appid}")
    private String openAppId;

    /**
     * 微信开放平台appsecret
     */
    @Value("${wxopen.appsecret}")
    private String openAappSecret;

    /**
     * 微信开放平台回调函数
     */
    @Value("${wxopen.redirect_url}")
    private String openRedirectUrl;

    /**
     * 二维码链接
     */
    public final static String OPEN_QRCODE_URL = "https://open.weixin.qq.com/connect/qrconnect?" +
            "appid=%s&redirect_uri=%s&response_type=code&scope=snsapi_login&state=%s#wechat_redirect";

    /**
     * 获取token地址
     */
    public final static String OPEN_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";

    /**
     * 获取UserInfo地址
     */
    public final static String USER_INFO_URL = "https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=zh_CN";

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getOpenAppId() {
        return openAppId;
    }

    public void setOpenAppId(String openAppId) {
        this.openAppId = openAppId;
    }

    public String getOpenAappSecret() {
        return openAappSecret;
    }

    public void setOpenAappSecret(String openAappSecret) {
        this.openAappSecret = openAappSecret;
    }

    public String getOpenRedirectUrl() {
        return openRedirectUrl;
    }

    public void setOpenRedirectUrl(String openRedirectUrl) {
        this.openRedirectUrl = openRedirectUrl;
    }
}

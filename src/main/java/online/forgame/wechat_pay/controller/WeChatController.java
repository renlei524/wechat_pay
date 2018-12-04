package online.forgame.wechat_pay.controller;

import online.forgame.wechat_pay.config.WeChatConfig;
import online.forgame.wechat_pay.domain.User;
import online.forgame.wechat_pay.service.UserService;
import online.forgame.wechat_pay.domain.JsonData;
import online.forgame.wechat_pay.utils.JwtUtils;
import online.forgame.wechat_pay.utils.RequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
@RequestMapping("/api/v1/wechat")
public class WeChatController {
    @Autowired
    private WeChatConfig weChatConfig;

    @Autowired
    private UserService userService;

    /**
     * 返回二维码链接
     *
     * @param accessPage accessPage
     * @return JsonData
     */
    @GetMapping("/login_url")
    @ResponseBody
    public JsonData loginUrl(@RequestParam(value = "access_page") String accessPage) throws UnsupportedEncodingException {
        String callbackUrl = URLEncoder.encode(weChatConfig.getOpenRedirectUrl(), "GBK");
        String qrcodeUrl = String.format(WeChatConfig.OPEN_QRCODE_URL, weChatConfig.getOpenAppId(), callbackUrl, accessPage);
        return JsonData.buildSuccess(qrcodeUrl);
    }

    /**
     * 扫码回调地址
     *
     * @param code  code
     * @param state state
     */
    @GetMapping("/user/callback")
    public void weChatUserCallback(@RequestParam(value = "code") String code, String state) throws IOException {
        User user = userService.saveWeChatUser(code);
        if (user != null) {
            String token = JwtUtils.geneJsonWebToken(user);
            RequestUtils.getResponse().sendRedirect(state + "?token=" + token);
        }
    }

}

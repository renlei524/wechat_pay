package online.forgame.wechat_pay.service;

import online.forgame.wechat_pay.domain.User;

public interface UserService {
    User saveWeChatUser(String code);
}

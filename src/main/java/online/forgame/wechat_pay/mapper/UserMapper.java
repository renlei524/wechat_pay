package online.forgame.wechat_pay.mapper;

import online.forgame.wechat_pay.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User findByOpenId(String openId);

    int save(User user);
}

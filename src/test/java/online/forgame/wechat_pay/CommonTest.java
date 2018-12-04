package online.forgame.wechat_pay;

import online.forgame.wechat_pay.utils.CommonUtils;
import org.junit.Test;

public class CommonTest {

    @Test
    public void test() {
        System.out.println(CommonUtils.generateNonceStr());
    }
}

package online.forgame.wechat_pay.mapper;

import online.forgame.wechat_pay.domain.VideoOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
    int delete(@Param("id") int id, @Param("user_id") int userId);

    VideoOrder findById(int id);

    VideoOrder findByOutTradeNo(String outTradeNo);

    int insert(VideoOrder order);

    List<VideoOrder> findMyOrderList(int userId);

    /**
     * 根据订单流水号更新
     */
    int updateVideoOderByOutTradeNo(VideoOrder videoOrder);

}

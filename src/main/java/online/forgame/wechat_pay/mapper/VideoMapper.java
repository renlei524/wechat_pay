package online.forgame.wechat_pay.mapper;

import online.forgame.wechat_pay.domain.Video;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoMapper {

    List<Video> findAll();

    Video findById(Integer id);

    int update(Video video);

    int delete(Integer id);

    int save(Video video);
}

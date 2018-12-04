package online.forgame.wechat_pay.service;

import online.forgame.wechat_pay.domain.Video;

import java.util.List;

public interface VideoService {
    List<Video> findAll();

    Video findById(Integer id);

    int update(Video video);

    int delete(Integer id);

    int save(Video video);
}

package online.forgame.wechat_pay.controller.admin;

import online.forgame.wechat_pay.domain.Video;
import online.forgame.wechat_pay.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/video")
public class VideoAdminController {

    @Autowired
    private VideoService videoService;

    @PutMapping("update_by_id")
    public Object update(@RequestBody Video video) {
        return videoService.update(video);
    }

    @DeleteMapping("del_by_id")
    public Object delById(@RequestParam(value = "video_id") int videoId) {
        return videoService.delete(videoId);
    }

    @PostMapping("save")
    public Object save(@RequestBody Video video) {
        return videoService.save(video);
    }
}

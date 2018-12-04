package online.forgame.wechat_pay.interceptor;

import com.google.gson.Gson;
import io.jsonwebtoken.Claims;
import online.forgame.wechat_pay.domain.JsonData;
import online.forgame.wechat_pay.utils.JwtUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginInterceptor implements HandlerInterceptor {
    private static final Gson gson = new Gson();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        String token = request.getHeader("token");
        if (token == null) {
            token = request.getParameter("token");
        }

        if (token != null) {
            Claims claims = JwtUtils.checkJWT(token);
            if (claims != null) {
                Integer userId = (Integer) claims.get("id");
                String name = (String) claims.get("name");
                request.setAttribute("user_id", userId);
                request.setAttribute("name", name);
                return true;
            }
        }

        sendJsonMessage(response, JsonData.buildError("请登录"));
        return false;
    }


    /**
     * 响应数据给前端
     */
    private static void sendJsonMessage(HttpServletResponse response, Object obj) throws IOException {
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print(gson.toJson(obj));
        writer.close();
        response.flushBuffer();

    }
}

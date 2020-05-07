package com.ykt.ind_ykt.core.security;

import com.alibaba.fastjson.JSON;
//import com.xyz.dao.model.SysUser;
import com.ykt.ind_ykt.core.Constants;
import com.ykt.ind_ykt.core.ResultBean;
import com.ykt.ind_ykt.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Objects;
/**
 * @Autor guoyh
 * @Date 20120-02-08 0011
 * @Usage
 */

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisUtil redisUtil;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String uri = request.getRequestURI();
//        String token = request.getHeader("Authorization");
//        if (StringUtils.isEmpty(token)) {
//            return error(response,HttpStatus.BAD_REQUEST, "请求信息不完整");
//        }
//        String account = JwtUtil.getClaim(token,Constants.ACCOUNT);
//        SysUser user = (SysUser) redisUtil.get(Constants.LOGIN_USER+account);
//        if (user == null) {
//            return error(response,HttpStatus.UNAUTHORIZED, "所请求用户不存在");
//        }
//        String key = Constants.TOKEN_KEY + account;
//        if (JwtUtil.verify(token) && redisUtil.hasKey(key)) {
//            String currentTimeMillisRedis = (String) redisUtil.get(key);
//            if (JwtUtil.getClaim(token, Constants.CURRENT_TIME_MILLIS).equals(currentTimeMillisRedis)) {
//                redisUtil.expired(key,Constants.TOKEN_EXPIRE_TIME);
//                redisUtil.expired(Constants.LOGIN_USER +account,Constants.TOKEN_EXPIRE_TIME);
//            }
//        }else {
//            return error(response,HttpStatus.UNAUTHORIZED, "Token 过期或不正确");
//        }
//        Integer roleId = user.getRole_id();
//        if (roleId == 1) {
//            return true;
//        }
//
//        String deptAuths = (String) redisUtil.hget(Constants.DEPT_AUTH,uri);
//        String roleAuths = (String) redisUtil.hget(Constants.ROLE_AUTH,uri);
//        if (Objects.isNull(deptAuths) || Objects.isNull(roleAuths)) {
//            return error(response,HttpStatus.FORBIDDEN, "非法路径");
//        }
//
//        Integer deptId = user.getDept_id();
//        String[] depts = deptAuths.split(",");
//        String[] roles = roleAuths.split(",");
//        boolean flag = Arrays.stream(depts).anyMatch(str->str.equals(deptId.toString())) && Arrays.stream(roles).anyMatch(str->str.equals(roleId.toString()));
//        if (flag) {
            return true;
//        }else {
//            return error(response,HttpStatus.UNAUTHORIZED, "无访问权限");
//        }
    }
    private boolean error(HttpServletResponse resp, HttpStatus code, String msg) throws IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=UTF-8");
        ResultBean result = new ResultBean(msg);
        result.setCode(code.value());
        PrintWriter pw = resp.getWriter();
        pw.write(JSON.toJSONString(result));
        pw.flush();
        pw.close();
        return false;
    }
}

package com.verification.service;

import com.verification.util.LoginToken;
import jakarta.annotation.Resource;
import org.readcom.entity.view.ResultMessage;
import org.readcom.exception.AuthrizeException;
import org.readcom.util.RedisUtils;
import org.readcom.util.Uuid;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @program: box-system
 * @description: 登录状态服务类
 * @author: zhangxiaoyu
 * @create: 2025-04-21 17:19
 **/
@Service
public class LoginStatus {

    @Resource
    private RedisUtils<LoginToken> redisUtils;

    @Resource
    private ResultMessage resultMessage;

    public ResultMessage generateLoginToken(){
        Uuid.init(1);
        long id = Uuid.nextId();
        LoginToken loginToken = new LoginToken(id, 0);
        redisUtils.set("loginToken:" + id,loginToken,3,TimeUnit.MINUTES);
        return resultMessage.success("生成二维码id", id);
    }

    public ResultMessage<Integer> checkLoginStatus(Long id) {
        LoginToken loginToken = redisUtils.get("loginToken:" + id);
        return resultMessage.success(null, loginToken.getStatus());
    }

    public ResultMessage authorize(Long id) {
        if (id == null) throw new AuthrizeException("授权异常，id为空");
        LoginToken loginToken = redisUtils.get("loginToken:" + id);
        if (loginToken == null) throw new AuthrizeException("授权异常，错误id");
        loginToken.setStatus(2);
        redisUtils.set("loginToken:"+id,loginToken,2, TimeUnit.MINUTES);
        return resultMessage.success("授权成功!", null);
    }

}

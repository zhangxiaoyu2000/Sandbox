package org.readcom.exception;

/**
 * @program: box-system
 * @description: 授权自定义异常
 * @author: zhangxiaoyu
 * @create: 2025-04-21 18:25
 **/
public class AuthrizeException extends RuntimeException{

    public AuthrizeException() {
        super();
    }

    public AuthrizeException(String message) {
        super(message);
    }
}

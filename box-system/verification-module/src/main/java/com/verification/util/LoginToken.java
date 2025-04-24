package com.verification.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @program: box-system
 * @description: 唯一的二维码id类
 * @author: zhangxiaoyu
 * @create: 2025-04-21 17:09
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginToken {
    private  Long id;

    private Integer status;   // 0为待扫码，1为扫码成功，-1为扫码失败，2为授权成功，-2为授权失败
}

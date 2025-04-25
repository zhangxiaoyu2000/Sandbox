package org.readcom.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author baomidou
 * @since 2025-04-25
 */
@Getter
@Setter
@ToString
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String nickname;

    private String name;

    private String pwd;

    private String email;

    private String phone;

    private Byte gender;

    private LocalDate birthday;

    private String avatar;

    private String idCard;

    private String authProvider;

    private Integer roleId;

    private Byte status;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private LocalDateTime lastLoginTime;

    private String loginIp;
}

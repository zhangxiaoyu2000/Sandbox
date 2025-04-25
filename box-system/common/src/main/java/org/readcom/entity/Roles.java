package org.readcom.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
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
@Table(name = "roles")
public class Roles implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "role_id", type = IdType.AUTO)
    private Integer roleId;

    private String roleName;

    private String description;

    private LocalDateTime createTime;
}

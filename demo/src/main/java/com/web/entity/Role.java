package com.web.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Set;

@Data
@TableName("role") //对应表名
public class Role {
    private String id;
    private String roleName;
    /**
     *
     *角色对应的权限集合
     *
     */
    private Set<Permissions> permissions;
}

package com.web.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user_role")
public class UserRole {

    private Integer UserId;
    private Integer RoleId;
}

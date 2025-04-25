## 用户表

```sql
CREATE TABLE user (
	id INT AUTO_INCREMENT PRIMARY KEY,
	nickname VARCHAR(50) UNIQUE NOT NULL,
	name VARCHAR(50) UNIQUE NOT NULL,
	pwd VARCHAR(255) NOT NULL,
	email VARCHAR(100) UNIQUE,
	phone VARCHAR(20) UNIQUE,
	gender TINYINT DEFAULT 0,   -- 0未知，1男性,2女性
	birthday DATE,           -- 出生日期
	avatar VARCHAR(255),     -- 头像地址
	id_card VARCHAR(18) UNIQUE, -- 身份证
	auth_provider VARCHAR(20) DEFAULT '本地',  -- 登录来源 （本地，微信，QQ等） 
	role_id INT DEFAULT 1 NOT NULL,   -- 默认角色名称为1，为普通用户
	status TINYINT DEFAULT 1,    -- 用户状态 （1-启动，0-禁用）
	create_time DATETIME,          -- 账户创建时间
	update_time DATETIME,          -- 账户更新时间
	last_login_time DATETIME,            -- 上次登录时间
	login_ip VARCHAR(45),         -- 最近登录ip
	FOREIGN KEY (role_id) REFERENCES roles(role_id),
	CONSTRAINT uq_email UNIQUE (email)  
);
```

## 角色表

```sql
CREATE TABLE roles (
    role_id INT AUTO_INCREMENT PRIMARY KEY, -- 自动递增 + 主键
    role_name VARCHAR(50) NOT NULL UNIQUE,  -- 角色名称唯一，如 admin、editor
    description VARCHAR(255),
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP
);

```


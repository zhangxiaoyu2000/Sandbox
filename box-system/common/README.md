## 模块内容

这个模块主要实现了公共代码

- 公共实体类

  @Entity注解和@Table注解需要添加JPA依赖

  ```xml
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-data-jpa</artifactId>
      <version>3.4.3</version>
  </dependency>
  ```

- 公共的工具类

- 上传功能       （本地存储和云端存储或远端文件服务器）

  > 上传文件存储的方式可能有很多种，由于存储的过程中有一些公共的部分，比如解析出上传文件的后缀，生成对应文件的名称（随机的名称），并且后续的结果对象的封装都可以是一致的，所以这里我们其实是可以采用，策略模式+模版模式的设计模式

- 自定义异常处理

- 自定义注解

- AOP日志记录

- 返回值对象

  需要存储返回状态码status, 消息对象 T data

- 分页对象
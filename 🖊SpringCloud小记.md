# 🖊SpringCloud小记

![image-20240910220747258](C:\Users\Alex\AppData\Roaming\Typora\typora-user-images\image-20240910220747258.png)

### 微服务架构编码Base工程模块构建

**父工程pom文件**

```xml
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0"

xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"

xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">

<modelVersion>4.0.0</modelVersion>



<groupId>org.atguigu.cloud</groupId>

<artifactId>SpringCloud</artifactId>

<version>1.0-SNAPSHOT</version>

<packaging>pom</packaging>



<properties>

<maven.compiler.source>17</maven.compiler.source>

<maven.compiler.target>17</maven.compiler.target>

<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>

<hutool.version>5.8.22</hutool.version>

<lombok.version>1.18.26</lombok.version>

<druid.version>1.1.20</druid.version>

<mybatis.springboot.version>3.0.2</mybatis.springboot.version>

<mysql.version>8.0.11</mysql.version>

<swagger3.version>2.2.0</swagger3.version>

<mapper.version>4.2.3</mapper.version>

<fastjson2.version>2.0.40</fastjson2.version>

<persistence-api.version>1.0.2</persistence-api.version>

<spring.boot.test.version>3.1.5</spring.boot.test.version>

<spring.boot.version>3.2.0</spring.boot.version>

<spring.cloud.version>2023.0.0</spring.cloud.version>

<spring.cloud.alibaba.version>2022.0.0.0-RC2</spring.cloud.alibaba.version>

</properties>



<dependencyManagement>

<dependencies>

<!--springboot 3.2.0-->

<dependency>

<groupId>org.springframework.boot</groupId>

<artifactId>spring-boot-starter-parent</artifactId>

<version>${spring.boot.version}</version>

</dependency>

<!--springcloud 2023.0.0-->

<dependency>

<groupId>org.springframework.cloud</groupId>

<artifactId>spring-cloud-dependencies</artifactId>

<version>${spring.cloud.version}</version>

<type>pom</type>

<scope>import</scope>

</dependency>

<!--springcloud alibaba 2022.0.0.0-RC2-->

<dependency>

<groupId>com.alibaba.cloud</groupId>

<artifactId>spring-cloud-alibaba-dependencies</artifactId>

<version>${spring.cloud.alibaba.version}</version>

<type>pom</type>

<scope>import</scope>

</dependency>





<!--springboot 集成mybatis-->

<dependency>

<groupId>org.mybatis.spring.boot</groupId>

<artifactId>mybatis-spring-boot-starter</artifactId>

<version>${mybatis.springboot.version}</version>

</dependency>

<!--mysql数据驱动 8.0.11-->

<dependency>

<groupId>mysql</groupId>

<artifactId>mysql-connector-java</artifactId>

<version>${mysql.version}</version>

</dependency>

<!--springboot 集成druid 数据库连接池-->

<dependency>

<groupId>com.alibaba</groupId>

<artifactId>druid-spring-boot-starter</artifactId>

<version>${druid.version}</version>

</dependency>

<!--通用Mapper4之tk.mybatis-->

<dependency>

<groupId>tk.mybatis</groupId>

<artifactId>mapper</artifactId>

<version>${mapper.version}</version>

</dependency>

<!--数据持久化persistence-api-->

<dependency>

<groupId>javax.persistence</groupId>

<artifactId>persistence-api</artifactId>

<version>${persistence-api.version}</version>

</dependency>



<!--fastjson2-->

<dependency>

<groupId>com.alibaba</groupId>

<artifactId>fastjson2</artifactId>

<version>${fastjson2.version}</version>

</dependency>

<!--swagger-->

<dependency>

<groupId>org.springdoc</groupId>

<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>

<version>${swagger3.version}</version>

</dependency>

<!--hutool-->

<dependency>

<groupId>cn.hutool</groupId>

<artifactId>hutool-all</artifactId>

<version>${hutool.version}</version>

</dependency>

<!--lombok-->

<dependency>

<groupId>org.projectlombok</groupId>

<artifactId>lombok</artifactId>

<version>${lombok.version}</version>

</dependency>

<!--springboot 测试-->

<dependency>

<groupId>org.springframework.boot</groupId>

<artifactId>spring-boot-starter-test</artifactId>

<version>${spring.boot.test.version}</version>

</dependency>

</dependencies>

</dependencyManagement>
</project>
```

💻备注：

> dependencyManagement 在 Maven 项目中的 pom.xml 文件里起到以下作用：
> 1.统一管理依赖版本：通过在父项目或聚合项目中定义 dependencyManagement，可以集中管理所有子模块或项目的依赖版本，避免各个模块中重复定义相同的依赖版本号。
> 2.简化子模块配置：子模块只需要声明依赖而不需要指定版本号，版本号会从 dependencyManagement 中继承，简化了子模块的 pom.xml 文件。如果子模块需要单独配置直接声明版本号即可。
> 3.便于升级依赖版本：当需要更新某个依赖的版本时，只需在 dependencyManagement 中修改，所有使用该依赖的子模块都会自动应用新的版本号。

### Mapper4之一键生成



### 微服务工程化编写步骤

**微服务小口诀**

- 建moudle
- 改pom
- 写yml
- 主启动
- 业务类



创建moudle

![image-20240911110859916](https://raw.githubusercontent.com/Alexffg234/CloudImage/master/img/image-20240911110859916.png)

修改pom文件

```XML
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.atguigu.cloud</groupId>
        <artifactId>SpringCloud</artifactId>
        <version>1.0-SNAPSHOT</version>
    </parent>

    <groupId>org.example</groupId>
    <artifactId>cloud-provider-payment8001</artifactId>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <!--springBoot通用依赖模块-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
            <version>2.7.5</version>
        </dependency>
        <!--监控模块-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
            <version>2.7.5</version>
        </dependency>
        <!--数据库连接池-->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid-spring-boot-starter</artifactId>
        </dependency>
        <!--swagger-->
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
        </dependency>
        <!--mybatis-->
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
        </dependency>
        <!--数据库连接驱动-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>
        <!--jpa-->
        <dependency>
            <groupId>javax.persistence</groupId>
            <artifactId>persistence-api</artifactId>
        </dependency>
        <!--mybatis-generator-->
        <dependency>
            <groupId>tk.mybatis</groupId>
            <artifactId>mapper</artifactId>
        </dependency>
        <!--hutool工具类 -->
        <dependency>
            <groupId>cn.hutool</groupId>
            <artifactId>hutool-all</artifactId>
        </dependency>
        <!--fastjson2-->
        <dependency>
            <groupId>com.alibaba.fastjson2</groupId>
            <artifactId>fastjson2</artifactId>
            <version>2.0.26</version>
        </dependency>
        <!--lombok-->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
        </dependency>
        <!--单元测试-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
        </dependency>

    </dependencies>
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

</project>
```

```xml
<!--jpa-->
    <dependency>
        <groupId>javax.persistence</groupId>
        <artifactId>persistence-api</artifactId>
    </dependency>
这个依赖用于支持java持久化API，实现对象关系映射(ORM),简化数据库操作
那么什么是ORM框架？
https://www.cnblogs.com/xiaotian0422/p/16496908.html

```

![img](https://raw.githubusercontent.com/Alexffg234/CloudImage/master/img/2550000-20220720102530912-199990477.png)






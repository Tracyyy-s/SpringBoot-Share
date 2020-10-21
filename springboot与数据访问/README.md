# SpringBoot配置数据库



## JDBC

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>
```



在application.yml文件中配置本地数据库相关信息

```yaml
spring:
	datasource:
		username: root
		password: 
		url: jdbc:数据库类型://地址:3306/数据库名?serverTimezone=UTC
		driver-class-name: com.mysql.jdbc.Driver
	schema:
	 - classpath:文件名.sql
```



效果：

​	默认是用org.apache.tomcat.jdbc.pool.DataSource作为数据源；

​	数据源的相关配置都在DataSourceProperties里面；





## MyBatis

```xml
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>1.3.1</version>
</dependency>
```



在application.yml文件中配置本地数据库相关信息

```yaml
spring:
	datasource:
		username: root
		password: 
		url: jdbc:数据库类型://地址:3306/数据库名?serverTimezone=UTC
		driver-class-name: com.mysql.jdbc.Driver
	schema:
	 - classpath:文件名.sql
	 
```



### 注解版

```java
//指定这是一个操作数据库的mapper
@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    public Department getDeptById(Integer id);

    @Delete("delete from department where id=#{id}")
    public int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into department(departmentName) values(#{departmentName})")
    public int insertDept(Department department);

    @Update("update department set departmentName=#{departmentName} where id=#{id}")
    public int updateDept(Department department);
}
```



### 配置版

```yaml
mybatis:
	config-location: classpath:全局配置文件的位置.xml
	mapper-locations: classpath:mapper映射文件的位置
```





## JPA

在application.yml文件中配置本地数据库相关信息

```yaml
spring:
	datasource:
		username: root
		password: 
		url: jdbc:数据库类型://地址:3306/数据库名?serverTimezone=UTC
		driver-class-name: com.mysql.jdbc.Driver
	jpa:
		hibernate:
			ddl-auto: update
			show-sql: true
```



1. 编写一个实体类（bean）和数据表进行映射，并配置好映射关系

```java
//使用JPA注解配置映射关系
@Entity //告诉JPA这是一个实体类（和数据表映射的类）
@Table(name = "tbl_user") //@Table指定和哪个数据表对应;省略默认表名user；
public class User {

    @Id //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增主键
    private Integer id;

    @Column(name = "last_name",length = 50) //和数据表对应的列
    private String lastName;
    @Column //省略默认列名就是属性名
    private String email;
}
```



2.编写一个接口来操作实体类对应的数据表（Repository）

```java
//继承JpaRepository来完成对数据库的操作
public interface UserRepository extends JpaRepository<User, Integer> {
}
```


### SSM整合案例

---

环境：

- IDEA
- MySQL 5.7.19
- Tomcat 9
- Maven 3.6

数据库环境：

```sql
create database ssm; 
use ssm;
create table account( 
    id int primary key auto_increment,
    name varchar(20), 
    money double );
```

此项目是对Spring、Springmvc、Mybatis的整合。笔记来自黑马程序员：

 [ssm整合【大纲笔记】.pdf](笔记\ssm整合[大纲笔记].pdf) 

 [ssm整合【随堂笔记】.pdf](笔记\ssm整合[随堂笔记].pdf) 
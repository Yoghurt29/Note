---
layout: post
title: Mybatis N+1,及关于association映射返回list的思考
excerpt: "association映射中使用select语句将会出现n+1问题，且其返回的结果被组织为list<map>,无论返回多少条数据"
categories: [about Trulon]
comments: true
image:
  feature: #https://images.unsplash.com/photo-1440635592348-167b1b30296f?crop=entropy&dpr=2&fit=crop&fm=jpg&h=475&ixjsv=2.1.0&ixlib=rb-0.3.5&q=50&w=1250
  credit: thomas shellberg
  creditlink: https://unsplash.com/photos/Ki0dpxd3LGc
---



## 解决
	可采用多表查询，如下例getCars2。在使用懒加载的时候使用association n+1问题不是那么严重。
	而多数ajax访问数据将会获取所有数据转换成JSON响应，将会导致100%n+1，懒加载几乎无用。因此懒加载和jsp等模板渲染方式更搭配。
	http://blog.csdn.net/isea533/article/details/20868189
<mapper namespace="org.apache.ibatis.submitted.associationtest.Mapper">  
  
    <resultMap type="org.apache.ibatis.submitted.associationtest.Car" id="carResult">  
        <id column="carid" property="id"/>  
        <result column="cartype" property="type"/>  
        <association property="engine" resultMap="engineResult"/>  
        <association property="brakes" resultMap="brakesResult"/>  
    </resultMap>  
    <resultMap type="org.apache.ibatis.submitted.associationtest.Engine" id="engineResult">  
        <result column="enginetype" property="type"/>  
        <result column="enginecylinders" property="cylinders"/>  
    </resultMap>  
    <resultMap type="org.apache.ibatis.submitted.associationtest.Brakes" id="brakesResult">  
        <result column="brakesType" property="type"/>  
    </resultMap>  
  
    <select id="getCars" resultMap="carResult">  
    select * from cars  
  </select>  
  
    <select id="getCarsNonUnique" resultMap="carResult">  
    select 1 as carid, cartype, enginetype, enginecylinders, brakestype from cars  
  </select>  
  
    <select id="getCars2" resultMap="carResult">  
    select 1 as carid, cartype, enginetype, enginecylinders, brakestype from cars where carid in (1,2)  
  </select>  
  
</mapper> 



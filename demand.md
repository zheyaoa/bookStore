#  网上书店需求分析

>  本项目用　servlet + html/css + ajax　书写

###  接口文档

* 书籍信息浏览

  > 接口路径　/bookScan

  数据格式｛

  ​			type:id

  ​		｝

  返回数据格式bookList:[

  ​	{

  ​		bookId:1,

  ​		title:

  ​		content:

  ​		image:

  ​	}

  ]

* 用户登入　

  > 接口路径　/login

  数据格式｛

  ​	user:

  ​	password:

  ｝

  返回格式　｛

  ​	login:true/false

  }



###  数据库设计

*  用户表数据库设计

  | 属性列   | 属性   |  
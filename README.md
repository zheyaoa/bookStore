# Java web 期中测试

> 2018Java web期中测试

### 前端页面项目 ###

> /web-end 目录

#### 环境依赖

​	node v8.12.0

#### 部署步骤 ####

​	1.npm install  //安装项目所需的node 依赖

​	2.npm run serve //运行项目，在localhost端口进行访问

​	3.npm run build //打包项目生成项目文件

#### 项目结构

> node_modules    //安装的依赖包
>
> src
>
> > assets	//放置一些静态资源，例如图片图标，字体等
> >
> > components  //一些公共组件
> >
> > router  //vue-router相关配置 
> >
> > store    //vuex 相关配置
> >
> > pages   //vue-router下的页面
>
> public  公共页面模板
>
> .gitignore
>
> babel.config.js
>
> package.json
>
> package.lock.json
>
> README.md
>
> vue.config.js

### 后端页面项目

>  .idea //idea相关项目配置
>
> src
>
> > beans 逻辑层
> >
> > servlets 控制层
> >
> > dao 数据层
>
> web
>
> > WEN-INF
> >
> > > web.xml 
> >
> > dist  //相关文件

### 接口文档

* api/getListByBookType

  > 根据书籍类型 返回书籍列表

  * 请求数据:web => server

    ```data:{
    data:{
        "typeId":id
    }
    ```

  * 返回数据

    ``` 
    data:[
        {
          "bookId":1,
          "price":20,
          "name":name,
          "desc":desc
          "imgUrl":url
        },
        {
        	"bookId":id,
          	"title":title,
          	"content":content，
            "imgUrl":url
        }
    ]
    ```

* api/register  

  > 注册账号

  * web => server

  ``` 
  data:{
      "userId":6130116240,
      "password":123456
  }
  ```

  * server => web

  > 返回状态  status:0|1  0表示不成功，1表示成功

  ```
  data:{
      "status":1
  }
  ```

* api/login

  > 账号登陆

  * web => server

  ```
  data:{
  	"userId":6130116240,
      "password":123456
  }
  ```

  * server => web

  > 返回状态 status:0|1 0表示成功,1表示失败

  ```
  data:{
      "status":1,
      cookie:{}
  }
  ```

* api/shoppingCart

  > 获取购物车

  * web => server 

  ```  
  Cookies
  ```

  * server => web

  ``` 
  data:{
      [
          {
              "cId":1,
              "num":2,
              "cName":"name",
              "image":"url"
          },
          {
              "cId":1,
              "num":2,
              "cName":"name",
              "image":"url"
          }
      ]
  }
  ```

* api/myOrders

  > 获取我的订单

  * web => server 

  ```
  Cookies
  ```

  * server => web

  ```
  data:[
  	{
      	"cId":1,
      	"price":20.00,
      	"cName":"name",
      	"iamge":"url"
  	},
  	{
      	"cId":1,
      	"price":20.00,
      	"cName":"name",
      	"iamge":"url"
  	}
  ]
  ```




### 数据库构建

数据库名称 ：

* User 表

>

<table>
    <tr>
        <th>属性列</th>
        <th>数据类型</th>
        <th>约束条件</th>
        <th>desc</th>
    </tr>
    <tr>
        <th>uId</th>
        <th>Integer</th>
        <th>主键</th>
        <th>用户id</th>
    </tr>
    <tr>
        <th>username</th>
        <th>Integer</th>
        <th>不可空/不可重复</th>
        <th>用户名</th>
    </tr>
    <tr>
        <th>password</th>
        <th>String</th>
        <th>不可空</th>
        <th>密码</th>
    </tr>
    <tr>
    	<th>address</th>
        <th>String</th>
        <th>可空</th>
        <th>地址</th>
    </tr>
</table>	



* commodity 表

>

<table>
    <tr>
        <th>属性列</th>
        <th>数据类型</th>
        <th>约束条件</th>
        <th>desc</th>
    </tr>
    <tr>
        <th>cId</th>
        <th>Integer</th>
        <th>主键</th>
        <th>商品id</th>
    </tr>
    <tr>
        <th>typeId</th>
        <th>Integer</th>
        <th>外键</th>
        <th>商品类型</th>
    </tr>
    <tr>
        <th>cName</th>
        <th>Integer</th>
        <th>不可空/不可重复</th>
        <th>商品名称</th>
    </tr>
    <tr>
        <th>price</th>
        <th>Float</th>
        <th>不可空</th>
        <th>商品价格</th>
    </tr>
    <tr>
    	<th>desc</th>
        <th>String</th>
        <th>可空</th>
        <th>商品描述</th>
    </tr>
    <tr>
    	<th>image</th>
        <th>图片链接</th>
        <th>不可空</th>
        <th>图片地址</th>
    </tr>
</table>



* commodityType

> 书籍类型 表

<table>
    <tr>
        <th>属性列</th>
        <th>数据类型</th>
        <th>约束条件</th>
        <th>desc</th>
    </tr>
    <tr>
        <th>typeId</th>
        <th>Integer</th>
        <th>主键</th>
        <th>类型id</th>
    </tr>
    <tr>
        <th>typeName</th>
        <th>String</th>
        <th>不可空</th>
        <th>书籍类型</th>
    </tr>
</table>	

* orders

> 订单 表格

<table>
    <tr>
        <th>属性列</th>
        <th>数据类型</th>
        <th>约束条件</th>
        <th>desc</th>
    </tr>
    <tr>
        <th>oId</th>
        <th>Integer</th>
        <th>主键</th>
        <th>订单id</th>
    </tr>
    <tr>
        <th>uId</th>
        <th>Integer</th>
        <th>外键</th>
        <th>用户id</th>
    </tr>
    <tr>
        <th>cId</th>
        <th>Integer</th>
        <th>外键</th>
        <th>商品id</th>
    </tr>
    <tr>
        <th>num</th>
        <th>Integer</th>
        <th>不可空</th>
        <th>购买数量</th>
    </tr>
        <tr>
        <th>status</th>
        <th>Integer</th>
        <th>不可空</th>
        <th>订单是否完成 0未完成/1完成</th>
    </tr>
    <tr>
    	<th>price</th>
        <th>Float</th>
        <th>不可空</th>
        <th>价格(合计)</th>
    </tr>
</table>

* shoppingCart

> 购物车 table

<table>
    <tr>
        <th>属性列</th>
        <th>数据类型</th>
        <th>约束条件</th>
        <th>desc</th>
    </tr>
    <tr>
        <th>uId</th>
        <th>Integer</th>
        <th>外键</th>
        <th>用户id</th>
    </tr>
    <tr>
        <th>cId</th>
        <th>Integer</th>
        <th>外键</th>
        <th>商品id</th>
    </tr>
    <tr>
        <th>num</th>
        <th>Integer</th>
        <th>不可空</th>
        <th>购买数量</th>
    </tr>
    <tr>
    	<th>price</th>
        <th>Float</th>
        <th>不可空</th>
        <th>价格(合计)</th>
    </tr>
</table>

### 数据库api文档

* dao/commodityType

  * getTypeList   ： ***获取所有书籍类型***

* dao/commodity

  * getBookListByTypeId : ***根据书籍Id获取书籍列表***
  * addBook  ***添加书籍***

* dao/Orders

  * getOrderListByUid  ***根据用户id获取订单列表***
  * getOrderListByStatus  ***根据status获取订单列表***

  * completeOrder  ***完成订单***

* 
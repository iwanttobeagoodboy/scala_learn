[TOC]

### 学习教程

* [官方网站](https://docs.scala-lang.org/)

* [标准库api](www.scala-lang.org/api/)

* [社区](https://www.scala-lang.org/community/)

* [Visual Scala Reference](https://superruzafa.github.io/visual-scala-reference/)

* [Scala Center](https://scala.epfl.ch/) 在EPFL建立了一个新的非营利中心。

* [在线练习](https://www.scala-exercises.org/)

* [Scala School!](http://twitter.github.com/scala_school/): Twitter 的 Scala 教程

* [A Tour of Scala](http://docs.scala-lang.org/tutorials/tour/tour-of-scala.html): 教程介绍了Scala的主要概念

* [Scala Overview on StackOverflow](http://stackoverflow.com/tags/scala/info): 有用的问题列表，按主题排序

* [allaboutscala 为初学者提供的详细教程](https://allaboutscala.com/)

  

### 视频

* [尚硅谷韩顺平]()

* [Coursera 教程](https://www.coursera.org/)

  > 1. 可能有 DNS 污染可能需要修改 host
  > 2. 课程免费，但是网页没有免费注册，可以在手机端注册课程

  * [Functional Programming Principles in Scala](https://www.coursera.org/learn/progfun1),
  * [Functional Program Design in Scala](https://www.coursera.org/learn/progfun2),
  * [Parallel programming](https://www.coursera.org/learn/parprog1),
  * [Big Data Analysis with Scala and Spark](https://www.coursera.org/learn/scala-spark-big-data),
  * [Functional Programming in Scala Capstone](https://www.coursera.org/learn/scala-capstone),

* [Youtube 频道](https://www.youtube.com/user/DrMarkCLewis/featured)

  * [Introduction to Programming and Problem Solving Using Scala](https://www.youtube.com/playlist?list=PLLMXbkbDbVt9MIJ9DV4ps-_trOzWtphYO)
  * [Object-Orientation, Abstraction, and Data Structures Using Scala](https://www.youtube.com/playlist?list=PLLMXbkbDbVt8JLumqKj-3BlHmEXPIfR42) 

### 书

> 鸠摩搜索
>
> 虫部落

* ***Structure and Interpretation of Computer Programs***. *Harold Abelson and Gerald J. Sussman. 2nd edition. MIT Press 1996.* - [[**Full text available online**](http://mitpress.mit.edu/sicp/)].	// 不是 Scala 的书， 讲函数式编程用的 LISP
* ***Programming in Scala***. Martin Odersky, Lex Spoon and Bill Venners. 3rd edition. Artima 2016. http://www.artima.com/shop/programming_in_scala_3ed
* ***Programming in Scala***. *Martin Odersky, Lex Spoon and Bill Venners. 2nd edition. Artima 2010.* - [[**Full text of 1st edition available online**](http://www.artima.com/pins1ed/)].Artima has graciously provided a 25% discount on the 2nd edition of *Programming in Scala* to all participants of this course. To receive the discount, simply visit http://www.artima.com/shop/programming_in_scala_2ed and during checkout, please use the coupon code: COURSERA-ODERSKY to have the discount applied.
* ***Scala for the Impatient***. *Cay Horstmann. Addison-Wesley 2012.* - [[**First part available for download**](http://typesafe.com/resources/scala-for-the-impatient).]
* ***Scala in Depth***. *Joshua D. Suereth. Manning 2012.* - [[**Available for purchase**](http://www.manning.com/suereth/)].
* ***Programming Scala***. *Dean Wampler and Alex Payne. O’Reilly 2009.* [[**Available for purchase**](http://shop.oreilly.com/product/9780596155964.do)].

### 技术栈

* [技术栈列表](https://github.com/lauris/awesome-scala) 由社区驱动的有用的Scala库，框架和软件列表。

#### 可能需要的技术栈

> 通过指定的规则，进行仿真的计算，数据分析 得出硬件的参数导入 excel

* 可能需要
  * 计算
  * 数据分析
  * 并发
  * 日志和导出excel

### 遇到的环境配置问题

* 环境
  * [Oraclejdk](https://www.oracle.com/java/technologies/javase-downloads.html)  Java 运行环境 +  Java 类库
    * 设置环境变量
  * [sbt](https://www.scala-sbt.org/download.html) 项目构建工具
    * 第一次很构建需要下载东西
      * 设置仓库提速（没用过）
  * [Scala](https://www.scala-lang.org/download/)
    * 设置环境变量
  * intellij IDEA 集成开发环境
    * 需要配置 Scala 插件
    * 指定 jdk、sdk、sbt
    * 源码跳转
* [Scala 与 JDK 兼容问题](https://docs.scala-lang.org/overviews/jdk-compatibility/overview.html)
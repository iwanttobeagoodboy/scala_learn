我们使用**sbt进行构建，测试，运行和提交作业**。本教程说明了我们在课堂上将使用的所有sbt命令。“ [工具设置”](https://www.coursera.org/learn/progfun1/supplement/BNOBK/tools-setup)页面介绍了如何安装sbt。

以下页面介绍：

1. 基本的sbt任务对任何Scala开发人员都有用。有关SBT或它们的命令的更多详细信息，强烈建议您查看[SBT参考手册](http://www.scala-sbt.org/0.13/docs/Getting-Started.html)或Scala社区制作的本[SBT教程](https://github.com/shekhargulati/52-technologies-in-2016/blob/master/02-sbt/README.md)。
2. 一种通过SBT将您的作业提交给Coursera评分者的方法。

# **基础**

## 基础或项目的根目录

用sbt的术语来说，“基础或项目的根目录”是包含项目的目录。因此，如果您进入任何SBT项目，都会在顶层目录（即基本目录）中看到一个“ build.sbt”声明。

## 源代码

可以将源代码与hello / hw.scala一起放置在项目的基本目录中。但是，大多数人在真正的项目中并不这样做。太混乱了。

默认情况下，SBT 对源文件使用与[Maven](https://maven.apache.org/)相同的目录结构 （所有路径都相对于基本目录）：

```
src/
  main/
    resources/
       <files to include in main jar here>
    scala/
       <main Scala sources>
    java/
       <main Java sources>
  test/
    resources
       <files to include in test jar here>
    scala/
       <test Scala sources>
    java/
       <test Java sources>
Other directories in src/ will be ignored. Additionally, all hidden
directories will be ignored.

```

src /中的其他目录将被忽略。此外，所有隐藏目录都将被忽略。

## SBT构建定义文件

您已经在项目的基本目录中看到了build.sbt。其他sbt文件出现在项目子目录中。

该*项目*文件夹可以包含.scala文件，这些文件与文件名.bst相结合，形成完整的构建定义。有关更多信息，请参见[组织构建](http://www.scala-sbt.org/0.13/docs/Organizing-Build.html)。

```
build.sbt
project/
  Build.scala

```

您可能会在project /中看到.sbt文件，但是它们不等同于项目基本目录中的.sbt文件。[稍后](http://www.scala-sbt.org/0.13/docs/Organizing-Build.html)将进行解释，因为您首先需要一些背景信息。

# **SBT任务**

## 启动sbt

为了启动sbt，请打开一个终端（在Windows中为“命令提示符”），并导航到您正在处理的任务的目录（*build.sbt*文件所在的*位置*）。键入sbt将打开sbt命令提示符。

```shell
# This is the shell of the operating system
$ cd /path/to/parprog-project-directory
$ sbt
# This is the sbt shell
>
```

SBT命令在SBT Shell中执行。不要尝试在Scala REPL中执行它们，因为它们将无法工作。

## 在SBT中运行Scala解释器

Scala解释器与SBT命令行不同。

但是，您可以使用*“ console”*任务**在sbt中**启动**Scala解释器**。解释器（也称为REPL，用于“ read-eval-print循环”）对于试用Scala代码段很有用。当从SBT执行REPL时，还将加载SBT项目中的所有代码，并且您将能够从解释器中访问它。这就是为什么Scala REPL仅在代码中没有编译错误时才能启动的原因。

为了退出解释器并返回sbt，请输入*<Ctrl + D>* 或者`:q`。

```
> console
[info] Starting scala interpreter...
Welcome to Scala version 2.11.5 (Java HotSpot(TM) 64-Bit Server VM, Java 1.7.0_04-ea).
Type in expressions to have them evaluated.
Type :help for more information.

scala> println("Oh, hai!")                                          # This is the Scala REPL, type some Scala code
Oh, hai!

scala> val l = List(1, 2, 3)
l: List[Int] = List(1, 2, 3)

scala> val squares = l.map(x => x * x)
squares: List[Int] = List(1, 4, 9)

scala>                                                              # Type [ctrl-d] to exit the Scala REPL
[success] Total time: 20 s, completed Mar 21, 2013 11:02:31 AM
>                                                                   # We're back to the sbt shell
```

## 编译代码

编译任务将编译位于src / main / scala目录中的分配的源代码。

```
> compile
[info] Compiling 4 Scala sources to /Users/aleksandar/example/target/scala-2.11/classes...
[success] Total time: 1 s, completed Mar 21, 2013 11:04:46 PM
> 
```

如果源代码包含错误，将显示来自编译器的错误消息。

## 测试您的代码

目录src / test / scala包含项目的单元测试。为了在sbt中运行这些测试，可以使用test命令。

```
> test
[info] ListsSuite:
[info] - one plus one is two
[info] - sum of a few numbers *** FAILED ***
[info]   3 did not equal 2 (ListsSuite.scala:23)
[info] - max of a few numbers
[error] Failed: : Total 3, Failed 1, Errors 0, Passed 2, Skipped 0
[error] Failed tests:
[error]   example.ListsSuite
[error] {file:/Users/luc/example/}assignment/test:test: Tests unsuccessful
[error] Total time: 5 s, completed Aug 10, 2012 10:19:53 PM
> 
```

## 运行你的代码

如果您的项目有一个具有main方法的对象（或扩展trait App的对象），则可以通过键入run轻松地在sbt中运行代码。如果sbt找到多个主要方法，它将询问您要执行哪个方法。

```
> run
Multiple main classes detected, select one to run:

 [1] example.Lists
 [2] example.M2

Enter number: 1

[info] Running example.Lists 
main method!
[success] Total time: 33 s, completed Aug 10, 2012 10:25:06 PM
>
```

# **将您的解决方案提交给Coursera**

sbt任务提交允许您提交分配的解决方案。它将您的源代码打包到一个.jar文件中，并将其上传到Coursera服务器。请注意，只有在没有编译错误的情况下，才能提交代码。

**警告**：继续之前：

- 确保在项目的根文件夹（*build.sbt*文件所在的*位置*）中运行sbt 。
- 确保控制台行是*`>`*而不是*`scala>`*。否则，您将位于Scala控制台内，而不是sbt shell。

提交任务有两个参数：您的Coursera电子邮件地址和提交令牌。**注意**：提交令牌**不是您的登录密码**。相反，它是Coursera为每次作业生成的特殊密码。在“ [分配”](https://www.coursera.org/learn/progfun1/home/assignments)页面上可用。

```
> submit e-mail@university.org suBmISsioNPasSwoRd
[info] Packaging /Users/luc/example/target/scala-2.11/parprog-example_2.11-1.0.0-sources.jar ...
[info] Done packaging.
[info] Compiling 1 Scala source to /Users/luc/example/target/scala-2.11/classes...
[info] Connecting to coursera. Obtaining challenge...
[info] Computing challenge response...
[info] Submitting solution...
[success] Your code was successfully submitted: Your submission has been accepted and will be graded shortly.
[success] Total time: 6 s, completed Aug 10, 2012 10:35:53 PM
>
```

您还可以通过运行以下命令来提交工作，而无需启动sbt交互式shell：

```
$ sbt "submit e-mail@university.org suBmISsioNPasSwoRd"
```

注意双引号的用法。
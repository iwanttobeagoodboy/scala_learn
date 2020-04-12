**注意**：以下各节包含有关完成本课程所需的所有工具的信息。如果您在浏览过程中遇到问题或希望观看视频，请查看 *入门*  部分中的 *工具设置*  视频。

为了进行编程任务，您需要在计算机上安装以下工具：

- Oracle JDK，Java开发工具包，版本1.8或更高版本。通过在控制台中输入来检查您的版本是否正确：

```shell
java -servion
```

- Scala构建工具（sbt），Scala 1.x版或更高版本的构建工具。
- IntelliJ IDEA，用于Eclipse的Scala IDE，Scala Metals或您选择的其他IDE。

请仔细按照本页上的说明进行操作。

# 安装JDK

## 的Linux

- **Ubuntu，Debian：**要使用apt-get安装JDK，请在终端sudo apt-get install openjdk-11-jdk中执行以下命令
- **Fedora，Oracle，Red Had：**要使用yum安装JDK，请在终端su -c“ yum install java-11-openjdk-devel”中执行以下命令
- **手动安装：**要在Linux系统上手动安装JDK，请执行以下步骤：

1. 从[Oracle网站](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)下载.tar.gz归档文件
2. 将下载的档案解压缩到您选择的目录中

3. 将提取的JDK 的*bin /*目录添加到PATH环境变量中。在编辑器中打开文件*〜/ .bashrc*（如果不存在，请创建它）并添加以下行：

```shell
export PATH = "/PATH/TO/YOUR/jdk11-VERSION/bin:$PATH"
```

如果使用的是其他Shell，则将该行添加到相应的配置文件中（例如，zsh的*〜/ .zshrc*）。



**验证您的设置：**打开一个新终端（以 在手动安装的情况下应用更改后的`~/ .bashrc`）并键入`java -version`。如果您在安装JDK时遇到问题，请在论坛上寻求帮助。

## Mac OS X

Mac OS X要么预装了JDK，要么自动安装。

要验证您的JDK安装，请在/ Applications / Utilities /中打开Terminal应用程序，然后键入java -version。如果尚未安装JDK，系统将询问您是否要下载并安装它。确保安装Java 1.8或更高版本。

## 视窗

- 从[Oracle网站](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)下载Windows的JDK安装程序。
- 运行安装程序。
- 添加`bin`的JDK安装目录到PATH环境变量，如所描述[这里](http://www.java.com/en/download/help/path.xml)。

要验证JDK的安装，请打开命令提示符并键入*`java -version`*。如果遇到任何问题，请转到[Oracle官方文档](https://java.com/en/download/help/windows_manual_download.xml)。

## 安装sbt

[请按照您所用平台的说明进行操作](http://www.scala-sbt.org/release/docs/Setup.html)。

此课程要求SBT版本**> 1.x的**。如果先前已安装sbt 0.12.x，则需要将其卸载并安装更新的版本。sbt 1.x可以用于需要sbt 0.12.x的项目和其他课程，但不能用于其他目的。如有疑问，可以这样检查您当前安装的sbt：在不是编程分配或sbt项目的任意目录中，运行：

```shell
$ sbt about
```

您应该会看到以下内容：

```shell
This is sbt 1.2.8
```

如果找不到sbt命令，则需要安装sbt。在这种情况下，[请转到您所用平台的官方说明](http://www.scala-sbt.org/release/docs/Setup.html)。


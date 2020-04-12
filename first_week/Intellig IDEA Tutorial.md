# IntelliJ IDEA教程

## **1.下载IntelliJ IDEA社区版**

IntelliJ IDEA社区版是IntelliJ IDEA的开源版本，IntelliJ IDEA是Java，Scala和其他基于JVM的编程语言的首选IDE。 [您可以从官方网站下载](https://www.jetbrains.com/idea/download)。

## **2.安装Scala插件**

启动Intellij时，将显示一个欢迎屏幕。创建或打开Scala项目之前的第一步是安装Scala插件。为此，转到欢迎屏幕的右下角，然后选择**Configure → Plugins → Browse JetBrains Plugins**。如果没有出现这样的“欢迎屏幕”，请转到**“Preferences (Settings) → Plugins”**。

![img](https://d3c33hcgiwev3.cloudfront.net/imageAssetProxy.v1/cHUFPz-sEeWxgwoU-Y5WvQ_8674a4d29a5985d4844ac79a13733791_scala_install_plugin-_1_.gif?expiry=1586822400000&hmac=vXs95CeSfBzXCc0f3ejEgENIdyJw_C1XwYpkYOUFF28)

请注意，Scala插件需要重新启动才能完成安装。因此，在执行下一步之前，请**重新启动Intellij**。

有关此步骤的更多信息，请访问[官方文档](https://www.jetbrains.com/help/idea/2016.2/creating-and-running-your-scala-application.html)。

## **3.设置JDK**

在欢迎屏幕上，转到**配置→新项目的结构，**然后添加JDK。将自动检测JDK，否则将找到JDK的存储路径，然后从文件选择器中选择它。更详细的说明在[这里](https://www.jetbrains.com/help/idea/2016.2/configuring-global-project-and-module-sdks.html)。

## **4.创建一个项目**

创建项目的最简单方法是使用“项目向导”。要使用它，请在“欢迎屏幕**”**上单击“ **创建新项目** ”，然后选择“ **Scala”**，最后选择“ **SBT Project”**。

![img](https://d3c33hcgiwev3.cloudfront.net/imageAssetProxy.v1/jhsLsj-sEeW_MxLSMNWlQw_e1dc72d4d8c9cc7fbcedb18c59f81fc6_scala_sbt_0-_1_.png?expiry=1586822400000&hmac=T-uMTo4NYqNqtgZD_gxdGk2c75OEIGALwHAWho4gNk0)

单击下一步以指定项目名称和位置。输入此信息后，IntelliJ IDEA将创建一个包含 *build.sbt*文件的空项目。

**注意**：第一次创建或导入SBT项目时，Intellij可能不会立即显示项目的结构。发生这种情况是因为Intellij决定延迟此任务，直到成功执行sbt并下载了所有必需的依赖项为止。完成后，将创建通常的*src*文件夹及其子文件夹。



## **5.创建一个Scala工作表**

只需从上下文菜单或Scala包（位于*scala`*文件夹下的任何内容）中使用“ **创建新**动作”。

![img](https://d3c33hcgiwev3.cloudfront.net/imageAssetProxy.v1/nRllVj-sEeWxgwoU-Y5WvQ_47b5f2690e9645989b957c4f3bba4f53_scala_empty_project-_1_.png?expiry=1586822400000&hmac=CTxFvBQPL0CSOCG9CqrEbeSnNz7GcHQozFOpTYoN2pw)

要评估工作表，请使用相应的工具栏图标（播放按钮），或按**Alt + Ctrl + W**（在OS X上为Alt + Cmd + W）。如有任何问题，您可以[查看正式文档](https://www.jetbrains.com/help/idea/2016.2/working-with-scala-worksheet.html)，[该文档](https://www.jetbrains.com/help/idea/2016.2/working-with-scala-worksheet.html)彻底解释了如何运行*Scala工作表*。

![img](https://d3c33hcgiwev3.cloudfront.net/imageAssetProxy.v1/uUlHCD-sEeWxgwoU-Y5WvQ_2f7083beb15ffe7c67f8fbd3049e313a_scala_worksheet_2.png?expiry=1586822400000&hmac=fZzNAsSM6zQtxmnDztc4MJ__9O43_z33-is-noO425M)

## **6.创建一个Scala类**

与工作表类似，Scala类是通过上下文菜单操作**Create New创建的**。

![img](https://d3c33hcgiwev3.cloudfront.net/imageAssetProxy.v1/zeiDKT-sEeWNnhLBZy0LHQ_b5db84efdd14d0fa8fda7e0fb7beae04_scala_class_1-_1_.png?expiry=1586822400000&hmac=dLxrJzGV0GC3FIF3HgJUV4YtpjuLEgtl_KuE0VutvwU)

准备就绪后，请按**Ctrl + Shift + F10**或使用编辑器上下文菜单来运行应用程序。

![img](https://d3c33hcgiwev3.cloudfront.net/imageAssetProxy.v1/53vngT-sEeWqOA5s4RkvPQ_f46c9f72467f07b5bc0168f781f8b4bd_scala_run_app_1-_1_.png?expiry=1586822400000&hmac=5j-3DV65e7iq0Uys4QyLCbwOvVgjbYxMwbx1NU0xKWQ)

应用程序完成运行后，您将在“运行工具”窗口中看到其输出。

![img](https://d3c33hcgiwev3.cloudfront.net/imageAssetProxy.v1/DQAX2j-tEeWNnhLBZy0LHQ_aae855dc3495dae85b15fc5ea3002bcd_scala_run_app_2-_2_.png?expiry=1586822400000&hmac=_UaRQMAmSImTcb9QgjIPmhdHQ0RVy1klLwIXxCTrnes)

## **7.打开一个SBT项目**

所有讲义文件（分配）均为SBT项目。如果要使用Intellij破解它们，则需要先导入项目。

要在IntelliJ IDEA中打开SBT项目，请转到“欢迎屏幕”，单击“导入项目”，然后选择要打开的SBT构建文件。然后，IntelliJ IDEA将创建一个新项目并将所选文件导入到其中。

![img](https://d3c33hcgiwev3.cloudfront.net/imageAssetProxy.v1/KQ7c4z-tEeWqOA5s4RkvPQ_ef406c453204212b4147dbb93277cc0e_scala_import_sbt-_1_.gif?expiry=1586822400000&hmac=vh5tvC39eapAiyc4cQz_zn4LMGUTROpxrSkpjkqebRA)

另外，您可以打开SBT项目而无需调用Import Project操作。只需在“欢迎屏幕”上单击“打开项目”，然后选择一个SBT构建文件。

## **8.同步SBT和IntelliJ IDEA项目**

IntelliJ IDEA SBT支持将项目与构建文件同步，因此，当您更改要使用的Scala版本或添加库时，将相应地更新项目。对于下一次，您可以通过在步骤7中取消选中“使用自动导入”选项来避免执行此步骤。

**警告**：此屏幕快照中显示的scala版本为2.10.3，已过时。Scala的版本，我们将使用这门课程是**2.13.x**。另外，请注意，scalatest依赖项的scala版本嵌入在“ scalatest_2.10”中，并且2.11.x没有2.0版本。因此，请替换：

```shell
libraryDependencies += "org.scalatest" % 
	"scalatest_2.10" % "2.0" % "test"
```

通过：

```shell
libraryDependencies += "org.scalatest" %% 
	"scalatest" % "3.0.8" % "test"
```

双百分比符号将迫使SBT使用中定义的当前版本阶*scalaVersion*（其是“2.13.0”或更高）。

![img](https://d3c33hcgiwev3.cloudfront.net/imageAssetProxy.v1/Qsyskz-tEeWM-wqPLzH4ew_af3dea9c209bb18bccf1aae4ffe1bb5b_scala_sync_sbt-_1_.png?expiry=1586822400000&hmac=cW5de0kof1ywTAO_ju_s4zSFrYHiStUbfYPS74pORXw)

## **9.使用终端运行SBT命令**

从IntelliJ IDEA运行SBT命令的最简单方法是通过**Alt + F12**使用终端工具窗口。它执行项目目录中的终端。然后，键入“ sbt”以执行构建工具REPL。如果您有任何问题（例如，您的映射不同），[请查阅官方文档](https://www.jetbrains.com/help/idea/2016.2/terminal.html?search=terminal)。

![img](https://d3c33hcgiwev3.cloudfront.net/imageAssetProxy.v1/U3AD8T-tEeWxgwoU-Y5WvQ_463903025805afc92b81749d9025d811_sbt_commands-_1_.png?expiry=1586822400000&hmac=uKKWd9k4CuEL5H6EMsqJovk2sHStW_8shrn9LlIfB54)

## **10.更多信息和故障排除**

要了解有关IntelliJ IDEA的更多信息，请阅读[IntelliJ IDEA官方文档](https://www.jetbrains.com/help/idea/2016.2/scala.html)。

















 完成
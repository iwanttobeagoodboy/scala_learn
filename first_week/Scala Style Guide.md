在此页面上，您可以找到在查看某些提交时检测到的常见问题的列表。

一些样式问题可以通过自动样式检查器检测到，我们也将其用于评分过程。基于[Scalastyle](http://www.scalastyle.org/)的样式检查器可以通过运行styleCheck任务在sbt中本地执行。

## 常见问题

### ＃1避免强制类型转换和类型测试

永远不要使用isInstanceOf或asInstanceOf-对于分配和任何实际的Scala项目，总会有更好的解决方案。如果您发现自己想使用演员表，请退后一步，思考您要实现的目标。重新阅读作业说明，然后再看一下相应的讲座视频。

### ＃2缩进

确保您的代码正确缩进，使其更具可读性。

这对我们的练习来说似乎微不足道，但并不是很相关，但是请想象一下自己将来成为团队的一员，与其他编码人员一起处理相同的文件：每个人都必须遵守样式规则以确保代码健康，这一点非常重要。

如果您的编辑器没有按照您希望的方式进行缩进，则应了解如何更改其设置。在Scala中，标准是缩进使用2个空格（无制表符）。

### ＃3行长和空格

确保这些行不太长，否则您的代码很难阅读。而不是写很长的行，而是引入一些局部值绑定。统一使用空格可使代码更具可读性。

示例（长行，缺少空格）：

```scala
if(p(this.head))this.tail.filter0(p, accu
	.incl(this.head))else this.tail.filter0(p
	, accu)
```

更好：

```scala
if (p(this.head))
  this.tail.filter0(p, accu.incl(this.head))
else
  this.tail.filter0(p, accu)
```

更好（请参阅下面的＃4和＃6）：

```scala
val newAccu =
  if (p(this.head)) accu.incl(this.head)
  else accu
this.tail.filter0(p, newAccu)
```

### ＃4使用局部值简化复杂的表达式

当以功能样式编写代码时，方法通常实现为功能调用的组合。如果这样的组合表达式变得太大，则代码可能变得难以理解。

在这种情况下，最好将一些参数存储在本地值中，然后再将其传递给函数（请参见上面的＃3）。确保本地值具有有意义的名称（请参见下面的＃5）！

### ＃5为方法和值选择有意义的名称

方法，字段和值的名称应仔细选择，以使源代码易于理解。方法名称应清楚说明该方法的作用。不，temp从来不是一个好名字：-)

一些可改进的示例：

```scala
val temp = sortFuntion0(list.head, tweet)   // what does sortFunction0 do?
def temp(first: TweetSet, second : TweetSet): TweetSet = ...
def un(th: TweetSet,acc: TweetSet): TweetSet = ...
val c = if (p(elem)) accu.incl(elem) else accu
def loop(accu: Trending, current: TweetSet): Trending = ...
def help(ch: Char, L2: List[Char], compteur: Int): (Char, Int) = ...
def help2(L: List[(Char, Int)], L2: List[Char]): List[(Char, Int)] = ...
```

### ＃6常见子表达式

您应该避免不必要地调用计算密集型方法。例如

```scala
this.remove(this.findMin).ascending(t + this.findMin)
```

两次调用this.findMin方法。如果每次调用都很昂贵（例如，必须遍历整个数据结构）并且没有副作用，则可以通过引入局部值绑定来节省一个：

```scala
val min = this.findMin
this.remove(min).ascending(t + min)
```

如果以递归方式调用该函数，则将变得更加重要：在这种情况下，该方法不仅会被多次调用，而且会以指数形式被调用。

### ＃7不要复制粘贴代码！

复制粘贴代码始终是样式不好的警告标志！有很多缺点：

- 代码较长，需要更多时间来理解
- 如果两个部分不相同但非常相似，则很难发现差异（请参见下面的示例）
- 维护两个副本并确保它们保持同步非常容易出错
- 更改代码所需的工作量成倍增加

您应该将公共部分分解为单独的方法，而不是在周围复制代码。示例（有关另一个示例，请参见上面的＃3）：

```scala
val googleTweets: TweetSet = TweetReader.allTweets.filter(tweet =>
  google.exists(word => tweet.text.contains(word)))
val appleTweets: TweetSet = TweetReader.allTweets.filter(tweet =>
  apple.exists(word => tweet.text.contains(word)))
```

最好将此代码编写如下：

```scala
def tweetsMentioning(dictionary: List[String]): TweetSet =
  TweetReader.allTweets.filter(tweet =>
    dictionary.exists(word => tweet.text.contains(word)))

val googleTweets = tweetsMentioning(google)
val appleTweets  = tweetsMentioning(apple)
```

### ＃8 Scala不需要分号

仅在同一行上编写多个语句时才需要Scala中的分号。应避免编写不必要的分号，例如：

```scala
def filter(p: Tweet => Boolean): TweetSet = filter0(p, new Empty);
```

### ＃9不要使用“打印”语句提交代码

在提交代码之前，应清理代码并删除所有print或println语句。在公司工作并创建用于生产的代码后，同样适用：最终代码应不含调试语句。

### ＃10避免使用Return

在Scala中，您通常不需要使用显式返回，因为控制结构（如if是表达式）。例如，在

```scala
def factorial(n: Int): Int = {
  if (n <= 0) return 1
  else return (n * factorial(n-1))
}
```

return语句可以简单地删除。

### ＃11避免使用可变的局部变量

由于这是一门有关函数式编程的课程，因此我们希望您习惯于以纯函数式风格编写代码，而无需使用副作用操作。您通常可以重写使用可变局部变量的代码，以使用带有累加器的辅助函数进行编码。代替：

```scala
def fib(n: Int): Int = {
  var a = 0
  var b = 1
  var i = 0
  while (i < n) {
    val prev_a = a
    a = b
    b = prev_a + b
    i = i + 1
  }
  a
}
```

喜欢：

```scala
def fib(n: Int): Int = {
  def fibIter(i: Int, a: Int, b: Int): Int =
    if (i == n) a else fibIter(i+1, b, a+b)
  fibIter(0, 0, 1)
}
```

### ＃12消除多余的“ If”表达式

代替

```scala
if (cond) true else false
```

你可以简单地写

```scala
cond
```

（对于否定情况类似）。

### 其他样式问题？

请使用style或styleChecktags发布到论坛，我们将在此指南中添加建议。


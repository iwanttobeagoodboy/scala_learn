该备忘单源自#progfun论坛，归功于Laurent Poulain。我们复制并更改或添加了一些内容。当然，还有很多可以改进的地方！如果您想贡献，则有两种选择：

- 单击GitHub上此文件上的“编辑”按钮：[https](https://github.com/lrytz/progfun-wiki/blob/gh-pages/CheatSheet.md) : [//github.com/lrytz/progfun-wiki/blob/gh-pages/CheatSheet.md](https://github.com/lrytz/progfun-wiki/blob/gh-pages/CheatSheet.md)您可以从那里直接提交拉取请求，而无需检出git存储库到您的本地计算机。
- 分叉存储库https://github.com/lrytz/progfun-wiki，并在本地检出。要预览您的更改，您需要[jekyll](https://jekyllrb.com/)。导航到您的结帐并调用jekyll --auto --server，然后打开页面[http：// localhost：4000 / CheatSheet.html](http://localhost:4000/CheatSheet.html)。

## Evaluation Rules(评估规则)

- 按值调用：在调用函数之前评估函数参数
- 按名称调用：首先评估函数，然后根据需要评估参数

```scala
def example = 2      // evaluated when called
val example = 2      // evaluated immediately
lazy val example = 2 // evaluated once when needed

def square(x: Double)    // call by value
def square(x: => Double) // call by name
def myFct(bindings: Int*) = { ... } // bindings is a sequence of int, containing a varying # of arguments
```

## Higher order functions(高阶函数)

这些是将函数作为参数或返回函数的函数。

```scala
// sum() returns a function that takes two integers and returns an integer  
def sum(f: Int => Int): (Int, Int) => Int = {  
  def sumf(a: Int, b: Int): Int = {...}  
  sumf  
} 

// same as above. Its type is (Int => Int) => (Int, Int) => Int  
def sum(f: Int => Int)(a: Int, b: Int): Int = { ... } 

// Called like this
sum((x: Int) => x * x * x)          // Anonymous function, i.e. does not have a name  
sum(x => x * x * x)                 // Same anonymous function with type inferred

def cube(x: Int) = x * x * x  
sum(x => x * x * x)(1, 10) // sum of cubes from 1 to 10
sum(cube)(1, 10)           // same as above      
```

## Currying(咖喱)

将具有多个参数的函数转换为具有单个参数的函数，该函数返回另一个函数。

```scala
def f(a: Int, b: Int): Int // uncurried version (type is (Int, Int) => Int)
def f(a: Int)(b: Int): Int // curried version (type is Int => Int => Int)
```

## Class(类)

```scala
class MyClass(x: Int, y: Int) {           // Defines a new type MyClass with a constructor  
  require(y > 0, "y must be positive")    // precondition, triggering an IllegalArgumentException if not met  
  def this (x: Int) = { ... }             // auxiliary constructor   
  def nb1 = x                             // public method computed every time it is called  
  def nb2 = y  
  private def test(a: Int): Int = { ... } // private method  
  val nb3 = x + y                         // computed only once  
  override def toString =                 // overridden method  
      member1 + ", " + member2 
  }

new MyClass(1, 2) // creates a new object of type
```

这引用了当前对象，如果不满足条件，则assert（<condition>）会发出AssertionError。请参阅scala.Predef以了解需求，假设和断言。

## Operators(操作符)

myObject myMethod 1与调用myObject.myMethod（1）相同

运算符（即函数）名称可以是字母数字，符号（例如x1，*，+？％＆，vector _ ++，counter_ =）

运算符的优先级由其第一个字符确定，并具有以下递增的优先级顺序：

```scala
(all letters)
|
^
&
< >
= !
:
+ -
* / %
(all other special characters)
```

运算符的关联性由其最后一个字符决定：如果以：结尾，则为右关联，否则为左关联。

请注意，赋值运算符的优先级最低。（有关详细信息，请阅读Scala语言规范2.9的6.12.3、6.12.4节）

## Class hierarchies(类的层次结构）

```scala
abstract class TopLevel {     // abstract class  
  def method1(x: Int): Int   // abstract method  
  def method2(x: Int): Int = { ... }  
}

class Level1 extends TopLevel {  
  def method1(x: Int): Int = { ... }  
  override def method2(x: Int): Int = { ...} // TopLevel's method2 needs to be explicitly overridden  
}

object MyObject extends TopLevel { ... } // defines a singleton object. No other instance can be created
```

在Scala中创建可运行的应用程序：

```scala
object Hello {  
  def main(args: Array[String]) = println("Hello world")  
}
```

要么

```scala
object Hello extends App {
  println("Hello World")
}
```

## Class Organization(类的组织)

- 类和对象以包（包myPackage）进行组织。
- 可以通过导入语句来引用它们（导入myPackage.MyClass，导入myPackage._，导入myPackage。{MyClass1，MyClass2}，导入myPackage。{MyClass1 => A}）
- 也可以在代码中使用完全限定的名称（新的myPackage.MyClass1）直接引用它们。
- 软件包scala和java.lang的所有成员，以及对象scala.Predef的所有成员都将自动导入。
- 特性与Java接口相似，不同之处在于它们可以具有非抽象成员：trait Planar {...}类Square用Planar扩展Shape
- 通用对象层次结构：

\- **scala.Any**基类型的所有类型的。具有可以覆盖的**hashCode**和**toString**方法

\- 所有原始类型的**scala.AnyVal**基本类型。（**scala.Double**，**scala.Float**等）

\- 所有引用类型的**scala.AnyRef**基本类型。（别名**java.lang.Object中**，超型的**java.lang.String中**，**scala.List**，任何用户定义的类）

\- **scala.Null**是任何的子类型**scala.AnyRef**（null是类型的唯一实例**空**），并且scala.Nothing是任何其他类型的，没有任何实例的子类型。

## Type Parameters(类型参数)

类似于C ++模板或Java泛型。这些可以应用于类，特征或功能。

```scala
class MyClass[T](arg1: T) { ... }  
new MyClass[Int](1)  
new MyClass(1)   // the type is being inferred, i.e. determined based on the value arguments  
```

可以限制使用的类型，例如

```scala
def myFct[T <: TopLevel](arg: T): T = { ... } // T must derive from TopLevel or be TopLevel
def myFct[T >: Level1](arg: T): T = { ... }   // T must be a supertype of Level1
def myFct[T >: Level1 <: Top Level](arg: T): T = { ... }
```

## Variance(变动)

给定A <：B

if C [A] <：C [B], C is covariat（协变）

if C [A]>：C [B]，C is contravariant（逆变）

Otherwise C is nonvariant（不变）

```scala
class C[+A] { ... } // C is covariant
class C[-A] { ... } // C is contravariant
class C[A]  { ... } // C is nonvariant
```

对于函数来说，if A2 <: A1 and B1 <: B2, then A1 => B1 <: A2 => B2。

函数的参数类型必须是互变量的，而结果类型必须是协变量的，例如

```scala
trait Function1[-T, +U] {
  def apply(x: T): U
} // Variance check is OK because T is contravariant and U is covariant

class Array[+T] {
  def update(x: T)
} // variance checks fails
```

在第[4.4节中](https://www.coursera.org/learn/progfun1/lecture/dnreZ/lecture-4-4-variance-optional)了解有关方差的更多信息。

## Pattern Matching(模式匹配)

模式匹配用于分解数据结构：

```scala
unknownObject match {
  case MyClass(n) => ...
  case MyClass2(a, b) => ...
}
```

这是一些示例模式

```scala
(someList: List[T]) match {
  case Nil => ...          // empty list
  case x :: Nil => ...     // list with only one element
  case List(x) => ...      // same as above
  case x :: xs => ...      // a list with at least one element. x is bound to the head,
                           // xs to the tail. xs could be Nil or some other list.
  case 1 :: 2 :: cs => ... // lists that starts with 1 and then 2
  case (x, y) :: ps => ... // a list where the head element is a pair
  case _ => ...            // default case if none of the above matches
}
```

最后一个示例显示每个模式都由子模式组成：仅匹配具有至少一个元素的列表，其中该元素是一对。x和y还是只能与特定类型匹配的模式。

### Options(选项)

模式匹配也可以用于选项值。某些函数（如Map.get）返回Option [T]类型的值，该值可以是Some [T]类型的值，也可以是值None：

```scala
val myMap = Map("a" -> 42, "b" -> 43)
def getMapValue(s: String): String = {
  myMap get s match {
    case Some(nb) => "Value found: " + nb
    case None => "No value found"
  }
}
getMapValue("a")  // "Value found: 42"
getMapValue("c")  // "No value found"
```

在大多数情况下，当您在选项值上编写模式匹配时，可以使用Option类的组合器方法更简洁地编写相同的表达式。例如，函数getMapValue可以编写如下：

```scala
def getMapValue(s: String): String =
  myMap.get(s).map("Value found: " + _).getOrElse("No value found")
```

### Pattern Matching in Anonymous Functions(匿名函数中的模式匹配)

模式匹配也经常在匿名函数中使用：

```scala
val pairs: List[(Char, Int)] = ('a', 2) :: ('b', 3) :: Nil
val chars: List[Char] = pairs.map(p => p match {
  case (ch, num) => ch
})
```

Instead of p => p match { case ... }, you can simply write {case ...}, so the above example becomes more concise:

```scala
val chars: List[Char] = pairs map {
  case (ch, num) => ch
}
```

## Collections(集合)

Scala定义了几个集合类：

### Base Classes(基类)

- Iterable (collections you can iterate on)
- Seq (ordered sequences)
- Set
- Map (lookup data structure)

### Immutable Collections(不变的收藏)

- 列表（链接列表，提供快速的顺序访问）
- 流（与列表相同，只是尾部仅根据需要进行评估）
- 向量（类似于数组的类型，实现为块树，提供快速的随机访问）
- 范围（等间距整数的有序序列）
- 字符串（Java类型，隐式转换为字符序列，因此您可以将每个字符串都视为Seq [Char]）
- 映射（将键映射到值的集合）
- 集合（没有重复元素的集合）

### 可变集合

- 数组（Scala数组在运行时是本机JVM数组，因此它们非常有效）
- Scala还具有可变的地图和集合；仅在不可变类型存在性能问题时才应使用这些

### 例子

```scala
val fruitList = List("apples", "oranges", "pears")
// Alternative syntax for lists
val fruit = "apples" :: ("oranges" :: ("pears" :: Nil)) // parens optional, :: is right-associative
fruit.head   // "apples"
fruit.tail   // List("oranges", "pears")
val empty = List()
val empty = Nil

val nums = Vector("louis", "frank", "hiromi")
nums(1)                     // element at index 1, returns "frank", complexity O(log(n))
nums.updated(2, "helena")   // new vector with a different string at index 2, complexity O(log(n))

val fruitSet = Set("apple", "banana", "pear", "banana")
fruitSet.size    // returns 3: there are no duplicates, only one banana

val r: Range = 1 until 5 // 1, 2, 3, 4
val s: Range = 1 to 5    // 1, 2, 3, 4, 5
1 to 10 by 3  // 1, 4, 7, 10
6 to 1 by -2  // 6, 4, 2

val s = (1 to 6).toSet
s map (_ + 2) // adds 2 to each element of the set

val s = "Hello World"
s filter (c => c.isUpper) // returns "HW"; strings can be treated as Seq[Char]

// Operations on sequences
val xs = List(...)
xs.length   // number of elements, complexity O(n)
xs.last     // last element (exception if xs is empty), complexity O(n)
xs.init     // all elements of xs but the last (exception if xs is empty), complexity O(n)
xs take n   // first n elements of xs
xs drop n   // the rest of the collection after taking n elements
xs(n)       // the nth element of xs, complexity O(n)
xs ++ ys    // concatenation, complexity O(n)
xs.reverse  // reverse the order, complexity O(n)
xs updated(n, x)  // same list than xs, except at index n where it contains x, complexity O(n)
xs indexOf x      // the index of the first element equal to x (-1 otherwise)
xs contains x     // same as xs indexOf x >= 0
xs filter p       // returns a list of the elements that satisfy the predicate p
xs filterNot p    // filter with negated p 
xs partition p    // same as (xs filter p, xs filterNot p)
xs takeWhile p    // the longest prefix consisting of elements that satisfy p
xs dropWhile p    // the remainder of the list after any leading element satisfying p have been removed
xs span p         // same as (xs takeWhile p, xs dropWhile p)

List(x1, ..., xn) reduceLeft op    // (...(x1 op x2) op x3) op ...) op xn
List(x1, ..., xn).foldLeft(z)(op)  // (...( z op x1) op x2) op ...) op xn
List(x1, ..., xn) reduceRight op   // x1 op (... (x{n-1} op xn) ...)
List(x1, ..., xn).foldRight(z)(op) // x1 op (... (    xn op  z) ...)

xs exists p    // true if there is at least one element for which predicate p is true
xs forall p    // true if p(x) is true for all elements
xs zip ys      // returns a list of pairs which groups elements with same index together
xs unzip       // opposite of zip: returns a pair of two lists
xs.flatMap f   // applies the function to all elements and concatenates the result
xs.sum         // sum of elements of the numeric collection
xs.product     // product of elements of the numeric collection
xs.max         // maximum of collection
xs.min         // minimum of collection
xs.flatten     // flattens a collection of collection into a single-level collection
xs groupBy f   // returns a map which points to a list of elements
xs distinct    // sequence of distinct entries (removes duplicates)

x +: xs  // creates a new collection with leading element x
xs :+ x  // creates a new collection with trailing element x

// Operations on maps
val myMap = Map("I" -> 1, "V" -> 5, "X" -> 10)  // create a map
myMap("I")      // => 1  
myMap("A")      // => java.util.NoSuchElementException  
myMap get "A"   // => None 
myMap get "I"   // => Some(1)
myMap.updated("V", 15)  // returns a new map where "V" maps to 15 (entry is updated)
                        // if the key ("V" here) does not exist, a new entry is added

// Operations on Streams
val xs = Stream(1, 2, 3)
val xs = Stream.cons(1, Stream.cons(2, Stream.cons(3, Stream.empty))) // same as above
(1 to 1000).toStream // => Stream(1, ?)
x #:: xs // Same as Stream.cons(x, xs)
         // In the Stream's cons operator, the second parameter (the tail)
         // is defined as a "call by name" parameter.
         // Note that x::xs always produces a List
```

## Pairs (similar for larger Tuples)

```scala
val pair = ("answer", 42)   // type: (String, Int)
val (label, value) = pair   // label = "answer", value = 42  
pair._1 // "answer"  
pair._2 // 42  
```

## Ordering 

标准库中已经有一个表示顺序的类：scala.math.Ordering [T]，其中包含标准类型的比较函数，例如lt（）和gt（）。具有单一自然顺序的类型应该从特征scala.math.Ordered [T]继承。

```scala
import math.Ordering  

def msort[T](xs: List[T])(implicit ord: Ordering) = { ...}  
msort(fruits)(Ordering.String)  
msort(fruits)   // the compiler figures out the right ordering  
```

## 理解力

理解是用于集合上的map，flatMap和filter操作的语法糖。

通用形式是收益率e

- s是生成器和过滤器的序列
- p <-e是一个发生器
- 如果f是一个过滤器
- 如果有多个生成器（相当于嵌套循环），则最后一个生成器的变化速度比第一个生成器快
- 如果要使用多行而不需要分号，则可以使用{s}代替（s）
- e是结果集合的元素

### 例子1

```scala
// list all combinations of numbers x and y where x is drawn from
// 1 to M and y is drawn from 1 to N
for (x <- 1 to M; y <- 1 to N)
  yield (x,y)
```

相当于

```scala
(1 to M) flatMap (x => (1 to N) map (y => (x, y)))
```

### 翻译规则

for表达式看起来像传统的for循环，但内部工作方式不同

for（x <-e1）yield e2被转换为e1.map（x => e2）s

for（x <-e1 if f）yield e2转换为for（x <-e1.filter（x => f））yield e2

for（x <-e1; y <-e2）yield e3转换为e1.flatMap（x => for（y <-e2）yield e3）

这意味着只要定义map，flatMap和filter，您就可以对自己的类型使用for-compression。

例子2

```scala
for {  
  i <- 1 until n  
  j <- 1 until i  
  if isPrime(i + j)  
} yield (i, j)  
```

相当于

```scala
for (i <- 1 until n; j <- 1 until i if isPrime(i + j))
    yield (i, j)  
```

相当于

```scala
(1 until n).flatMap(i => (1 until i).filter(j => isPrime(i + j)).map(j => (i, j)))
```
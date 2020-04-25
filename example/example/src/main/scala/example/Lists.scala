package example

object Lists {

  /**
   * This method(方法) computes(计算) the sum of all elements in the list xs. There are
   * multiple(多样) techniques(技巧) that can be used for implementing(实现) this method, and
   * you will learn during(在...期间) the class.
   *
   * For this example assignment(任务) you can use the following methods in class
   * `List`:
   *
   *  - `xs.isEmpty: Boolean` returns `true` if the list `xs` is empty
   *  - `xs.head: Int` returns the head element of the list `xs`. If the list
   *    is empty an exception(异常) is thrown
   *  - `xs.tail: List[Int]` returns the tail of the list `xs`, i.e. the the
   *    list `xs` without its `head` element
   *
   *  ''Hint:'' instead of(代替) writing a `for` or `while` loop, think of a recursive
   *  solution. // 用递归代替循环
   *
   * @param xs A list of natural numbers
   * @return The sum of all elements in `xs`
   */
  def sum(xs: List[Int]): Int = {
    var result = 0
    if (xs.isEmpty) result else xs.foreach(each => result += each)
  }

  /**
   * This method returns the largest element in a list of integers. If the
   * list `xs` is empty it throws a `java.util.NoSuchElementException`. 
   *
   * You can use the same methods of the class `List` as mentioned(提及) above.
   *
   * ''Hint:'' Again, think of a recursive(递归) solution instead of using looping
   * constructs. You might need to define(定义) an auxiliary(助动词) method.
   *
   * @param xs A list of natural numbers
   * @return The largest element in `xs`
   * @throws java.util.NoSuchElementException if `xs` is an empty list
   */
  def max(xs: List[Int]): Int = {
    var
  } 
}

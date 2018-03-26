package week2.trees

abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
}

object Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = NonEmpty(x, Empty, Empty)
}

case class NonEmpty(e: Int, left: IntSet, right: IntSet) extends IntSet {
  def contains(x: Int): Boolean =
    if (x<e) left contains x
    else if (x>e) right contains x
    else true

  def incl(x: Int): IntSet =
    if (x<e) NonEmpty(e, left incl x, right)
    else if (x>e) NonEmpty(e, left, right incl x)
    else this
}

/*
* The Laws of IntSet
* 1. Empty contains x = false
* 2. (s incl x) contains x = true
* 3. (s incl x) contains y = s contains y   (if x!=y)
* */
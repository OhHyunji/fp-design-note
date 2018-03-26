package week2.casestudy

object PouringTest extends App{
  val problem = new Pouring(Vector(4, 9))

  val movesSet = problem.moves      //모든 move 경우의 수
  val pathSets = problem.pathSets   //모든 path 경우의 수

  println(problem.pathSets.take(2).toList) //너무 많아서 오래걸리니까 두개만 확인
  println(problem.solutions(6)) //마지막에 6이 남는 경우의 수
}

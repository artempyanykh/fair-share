import scalaz.\/

val f: Int => Int = a => a + 1

f(5)

\/.right.toValidationNel
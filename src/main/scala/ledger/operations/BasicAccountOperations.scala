package ledger.operations

import ledger._

trait BasicAccountOperations[T] {
  def debit(account: T)(amount: Money): T
  def credit(account: T)(amount: Money): T
  def op(side: Side, account: T, amount: Money): T = side match {
    case Debit => debit(account)(amount)
    case Credit => credit(account)(amount)
  }
}

object BasicAccountOperations {
  def apply[T](d: (T, Money) => T, c: (T, Money) => T) = new BasicAccountOperations[T] {
    def debit(account: T)(amount: Money): T = d(account, amount)
    def credit(account: T)(amount: Money): T = c(account, amount)
  }
}

package story

import ledger.Entry
import org.scalatest.{Matchers, FunSpec}

class TransactionTest extends FunSpec with Matchers {

  describe("TransactionTest") {

    it("lend: creates Entry.lend and Entry.borrow with characterIds") {
      val lenderId = CharacterId(123)
      val borrowerId = CharacterId(72)
      val actual = Transaction.lend(lenderId, borrowerId, 15)
      val expected = Transaction(
        lenderId -> Entry.lend(15),
        borrowerId -> Entry.borrow(15)
      )
      actual shouldEqual expected
    }

    it("repay: creates Entry.payback and Entry.receive with characterIds") {
      val lenderId = CharacterId(1)
      val borrowerId = CharacterId(8)
      val actual = Transaction.repay(borrowerId, lenderId, 999)
      val expected = Transaction(
        borrowerId -> Entry.payback(999),
        lenderId -> Entry.receive(999)
      )
      actual shouldEqual expected
    }

    it("split: creates map (id -> Entry.pay)") {
      val id1 = CharacterId(10)
      val id2 = CharacterId(20)
      val id3 = CharacterId(30)
      val actual = Transaction.split(Map(
        id1 -> (1000, 300),
        id2 -> (100, 200),
        id3 -> (900, 1500)
      ))
      val expected = Transaction(
        id1 -> Entry.pay(1000, 300),
        id2 -> Entry.pay(100, 200),
        id3 -> Entry.pay(900, 1500)
      )
      actual shouldEqual expected
    }
  }
}
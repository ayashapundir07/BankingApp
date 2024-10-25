class BankingService(private val account: BankAccount) {

    fun displayWelcome() {
        println("Welcome to ABC Bank!")
        println("Account Holder: ${account.accountHolder}")
        println("Account Number: ${account.accountNumber}")
        println("Account Type: ${account.accountType}")
        println("Balance: Rs. ${account.formatBalance()}")
    }

    fun deposit(amount: Double) {
        account.balance += amount
        account.transactionHistory.add("Deposited Rs. $amount")
        println("Successfully deposited Rs. $amount. Updated Balance: Rs. ${account.formatBalance()}")
    }

    fun withdraw(amount: Double) {
        if (amount > account.balance) {
            println("Insufficient balance! Transaction failed.")
        } else {
            account.balance -= amount
            account.transactionHistory.add("Withdrew Rs. $amount")
            println("Successfully withdrew Rs. $amount. Updated Balance: Rs. ${account.formatBalance()}")
        }
    }

    fun showTransactionHistory() {
        println("\nTransaction History:")
        if (account.transactionHistory.isEmpty()) {
            println("No transactions yet.")
        } else {
            account.transactionHistory.forEach { println(it) }
        }
        println("Final Balance: Rs. ${account.formatBalance()}\n")
    }

    fun showBalance() {
        println("Current Balance: Rs. ${account.formatBalance()}")
    }

    fun abort() {
        println("\nThank you ${account.accountHolder} for banking with us! Have a great day!")
    }

    fun applyMonthlyInterest() {
        if (account.accountType == "Savings") {
            val interestRate = 0.03
            val interest = account.balance * interestRate
            account.balance += interest
            account.transactionHistory.add("Applied Rs. ${"%.2f".format(interest)} as interest")
            println("Interest of Rs. ${"%.2f".format(interest)} added. Updated Balance: Rs. ${account.formatBalance()}")
        }
    }
}

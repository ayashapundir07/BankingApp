import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    println("Welcome to ABC Bank !!\n Enter your name: ")
    val name = scanner.nextLine()

    println("Select Account Type (Savings(S) or Current(C)): ")
    var accountType = scanner.nextLine().replaceFirstChar { it.uppercase() }


    while (accountType != "S" && accountType != "C") {
        println("Invalid account type! Please enter either 'S' or 'C': ")
        accountType = scanner.nextLine().replaceFirstChar { it.uppercase() }
    }

    // bank account and banking service instance
    val account = BankAccount(accountHolder = name, accountType = accountType)
    val bankingService = BankingService(account)

    // welcome message with initial balance
    bankingService.displayWelcome()

    var continueBanking = true

    // Banking menu
    while (continueBanking) {
        println("\n========= BANK MENU =========")
        println("Press D -> Deposit")
        println("Press W -> Withdraw")
        println("Press H -> Transaction History")
        println("Press B -> Balance")
        println("Press I -> Apply Monthly Interest (Savings Account Only)")
        println("Press N -> Abort")
        println("=============================")

        val choice = scanner.nextLine().uppercase()

        when (choice) {
            "D" -> {
                print("Enter the amount to deposit: Rs ")
                val depositAmount = scanner.nextDouble()
                scanner.nextLine()
                if (depositAmount > 0) {
                    bankingService.deposit(depositAmount)
                } else {
                    println("Invalid deposit amount!")
                }
            }
            "W" -> {
                print("Enter the amount to withdraw: Rs ")
                val withdrawAmount = scanner.nextDouble()
                scanner.nextLine()  
                if (withdrawAmount > 0) {
                    bankingService.withdraw(withdrawAmount)
                } else {
                    println("Invalid withdrawal amount!")
                }
            }
            "H" -> {
                bankingService.showTransactionHistory()
            }
            "B" -> {
                bankingService.showBalance()
            }
            "I" -> {
                bankingService.applyMonthlyInterest()
            }
            "N" -> {
                bankingService.abort()
                continueBanking = false
            }
            else -> {
                println("Invalid choice! Please try again.")
            }
        }
    }
}

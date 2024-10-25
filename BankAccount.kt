import java.text.DecimalFormat

data class BankAccount(
    val accountHolder: String,
    var balance: Double = 1000.0,
    val accountNumber: String = generateAccountNumber(),
    var accountType: String,
    val transactionHistory: MutableList<String> = mutableListOf()
) {
    companion object {
        private var lastAccountNumber = 1000
        fun generateAccountNumber(): String {
            return (lastAccountNumber++).toString()
        }
    }

    fun formatBalance(): String {
        val df = DecimalFormat("#,##0.00")
        return df.format(balance)
    }
}

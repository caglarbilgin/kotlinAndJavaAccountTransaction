package com.task.account.dto

import java.math.BigDecimal
import java.time.LocalDateTime

data class AccountDto(
        val id: String?,
        val balance: BigDecimal?,
        val creationDate: LocalDateTime,
        val customer: AccountCustomerDto?, // ? işareti nullable olabilir demek
        val transaction: Set<TransactionDto>?
) {
}

package com.task.account.dto

import java.math.BigDecimal
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

data class CreateAccountRequest(
        @field:NotBlank//("Customer Bos olamaz")//jvm tarafından pc diline bağlı olarak mesaj üretiyor. isterseniz burayı overrite edebiliriz, aşağıda örneği var
        val customerId: String?,
        @field:Min(0)
        val initialCredit: BigDecimal
)

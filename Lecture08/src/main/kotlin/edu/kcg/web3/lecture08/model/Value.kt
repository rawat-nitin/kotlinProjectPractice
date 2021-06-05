package edu.kcg.web3.lecture08.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties


@JsonIgnoreProperties(ignoreUnknown = true)
data class Value(
    var id: Long? = null,
    var quote: String? = null
)
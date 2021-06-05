package edu.kcg.web3.lecture08.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties


@JsonIgnoreProperties(ignoreUnknown = true)
data class Quote(
    var type: String? = null,
    var value: Value? = null
)
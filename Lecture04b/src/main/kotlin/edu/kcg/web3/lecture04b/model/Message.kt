package edu.kcg.web3.lecture04b.model

import edu.kcg.web3.lecture04b.annotation.Open
import javax.enterprise.context.RequestScoped
import javax.inject.Named


@Named("message")
@RequestScoped
@Open
class Message {
    var text: String? = null
}
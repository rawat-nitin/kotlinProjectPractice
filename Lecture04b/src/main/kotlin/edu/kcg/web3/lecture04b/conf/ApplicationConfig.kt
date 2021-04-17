package edu.kcg.web3.lecture04b.conf

import edu.kcg.web3.lecture04b.annotation.Open
import javax.ws.rs.ApplicationPath
import javax.ws.rs.core.Application


@ApplicationPath("mvc")
@Open
class ApplicationConfig : Application() {

//    override fun getClasses(): Set<Class<*>> {
//        val set: MutableSet<Class<*>> = HashSet()
//        set.add(HelloController::class.java)
//        return set
//    }

}
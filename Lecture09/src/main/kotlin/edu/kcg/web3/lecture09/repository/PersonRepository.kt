package edu.kcg.web3.lecture09.repository

import edu.kcg.web3.lecture09.table.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository : JpaRepository<Person, Long?> {

    @Query("SELECT u FROM Person u WHERE u.deleted = false")
    fun findAllValid(): List<Person>

    @Query("SELECT u FROM Person u WHERE u.email LIKE :email")
    fun findByEmail(@Param("email") email: String): Person?

    @Query("UPDATE Person SET deleted = true WHERE id = :id")
    fun markDeleted(@Param("id") id: Long): Person?

}

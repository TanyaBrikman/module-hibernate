package brikman.dev.service

import brikman.dev.entity.Group
import brikman.dev.util.TransactionHelper
import org.springframework.stereotype.Service

@Service
class GroupService(
    private val transactionHelper: TransactionHelper
) {

    fun saveGroup(number: String, gradYear: Long): Group {
        val group = Group(
            number = number,
            graduationYear = gradYear
        )
        transactionHelper.transaction { it.persist(group) }

        return group
    }

    fun findAllWithStudents(): List<Group> {
        return transactionHelper.transaction {
            it.createQuery(
                "select g from Group g left join fetch g.studentList s left join fetch s.profile",
                Group::class.java
            ).list()
        }
    }
}
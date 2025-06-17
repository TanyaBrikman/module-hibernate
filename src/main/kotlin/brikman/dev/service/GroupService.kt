package brikman.dev.service

import brikman.dev.Group
import brikman.dev.Student
import brikman.dev.TransactionHelper
import org.hibernate.SessionFactory
import org.springframework.stereotype.Service

@Service
class GroupService(
    private val sessionFactory: SessionFactory,
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
        sessionFactory.openSession().use { session ->
            val transaction = session.beginTransaction()
            try {
                val result = session.createQuery("select g from Group g left join fetch g.studentList s left join fetch s.profile", Group::class.java).list()
                transaction.commit()
                return result
            } catch (e: Exception) {
                transaction.rollback()
                throw e
            }
        }
    }
}
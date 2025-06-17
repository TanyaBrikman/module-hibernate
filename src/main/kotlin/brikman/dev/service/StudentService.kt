package brikman.dev.service

import brikman.dev.Student
import brikman.dev.TransactionHelper
import org.hibernate.SessionFactory
import org.springframework.stereotype.Service

@Service
class StudentService(
    private val sessionFactory: SessionFactory,
    private val transactionHelper: TransactionHelper
) {

    fun saveStudent(student: Student) {
        transactionHelper.transaction { it.persist(student) }
    }

    fun getStudentById(id: Long): Student {
        return transactionHelper.transaction { it.get(Student::class.java, id) }
    }

    fun deleteStudent(id: Long) {
        transactionHelper.transaction { it.remove(id) }
    }

    fun findAllStudents(student: Student): MutableList<Student>? {
        return transactionHelper.transaction { it.createQuery("SELECT s from Student s", Student::class.java).list() }
    }

    fun updateStudents(student: Student): Student? {
        return transactionHelper.transaction { it.merge(student) }
    }


}
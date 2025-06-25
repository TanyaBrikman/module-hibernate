package brikman.dev.repository

import brikman.dev.entity.Student
import dto.StudentDTO
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository : JpaRepository<Student, Long> {
    fun getStudentsByIdOrIdNull(id: Long): Student
    fun deleteStudentByIdOrIdNull(id: Long)

}
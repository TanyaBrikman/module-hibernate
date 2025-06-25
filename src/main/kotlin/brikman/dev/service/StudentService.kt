package brikman.dev.service

import brikman.dev.entity.Student
import brikman.dev.repository.StudentRepository
import org.springframework.stereotype.Service

@Service
class StudentService(
    private val studentRepository: StudentRepository
) {

    fun createStudent(student: Student): Student = studentRepository.save(student)

    fun getStudentById(id: Long): Student = studentRepository.getStudentsByIdOrIdNull(id)

    fun deleteStudentById(id: Long) = studentRepository.deleteStudentByIdOrIdNull(id)

    fun findAllStudents(): MutableList<Student> = studentRepository.findAll()

    fun updateStudent(id: Long, name: String) {
        val student = studentRepository.getStudentsByIdOrIdNull(id)
        if (student.name != name) {
            student.name = name
        }
    }
}
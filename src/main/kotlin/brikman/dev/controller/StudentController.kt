package brikman.dev.controller

import brikman.dev.entity.Student
import brikman.dev.service.StudentService
import dto.StudentDTO
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

@RequestMapping("api/students")
@RestController
class StudentController(val studentService: StudentService) {

    @GetMapping
    fun findAllStudents(): List<StudentDTO> = studentService.findAllStudents().map { it.toDTO() }

    @GetMapping("/{id}")
    fun getStudentById(@PathVariable id: Long): StudentDTO = studentService.getStudentById(id).toDTO()


    @PostMapping
    @Transactional
    fun createStudent(@RequestBody student: Student): Student = studentService.createStudent(student)

    @DeleteMapping("/{id}")
    @Transactional
    fun deleteStudentById(@PathVariable id: Long) = studentService.deleteStudentById(id)


    @PostMapping("/{id}")
    @Transactional
    fun updateStudent(
        @PathVariable id: Long,
        @RequestParam(required = false) name: String
    ) = studentService.updateStudent(id, name)
}
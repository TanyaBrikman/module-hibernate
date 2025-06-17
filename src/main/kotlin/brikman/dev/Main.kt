package brikman.dev

import brikman.dev.service.GroupService
import brikman.dev.service.ProfileService
import brikman.dev.service.StudentService
import org.hibernate.Session
import org.hibernate.SessionFactory
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import java.time.LocalDateTime

fun main() {
    val context = AnnotationConfigApplicationContext("brikman.dev")
    val sessionFactory = context.getBean(SessionFactory::class.java)
    val studentService: StudentService = context.getBean(StudentService::class.java)
    val profileService: ProfileService = context.getBean(ProfileService::class.java)
    val groupService: GroupService = context.getBean(GroupService::class.java)

    var group1 = groupService.saveGroup("1", 2024L)
    var group2 = groupService.saveGroup("2", 2025L)

    val student1 = Student(name = "Tommy", age = 2, profile = null, group = group1 )
    val student2 = Student(name = "Jerry", age = 6, profile = null, group = group1)

    studentService.saveStudent(student1)
    studentService.saveStudent(student2)

    val profile1 = Profile(
        bio = "Student, 1 group",
        lastSeenTime = LocalDateTime.now(),
        student = student1,
    )
    val profile2 = Profile(
        bio = "Student, 2 group",
        lastSeenTime = LocalDateTime.now(),
        student = student2,
    )

    profileService.saveProfile(profile1)
    profileService.saveProfile(profile2)
    profileService.deleteProfile(profile2)

    groupService.findAllWithStudents()



}
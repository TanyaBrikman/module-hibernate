package brikman.dev.service

import brikman.dev.entity.Course
import brikman.dev.util.TransactionHelper
import org.springframework.stereotype.Service

@Service
class CourseService(
    private val transactionalHelper: TransactionHelper
) {

    fun saveCourse(course: Course) {
        return transactionalHelper.transaction { it.persist(course) }
    }

    fun enrollStudentToCourse(courseId: Long, studentId: Long) {
        return transactionalHelper.transaction { session ->
//           val student = session.get(Student::class.java, studentId)
//           val course = session.get(Course::class.java, courseId)
//           student.courseList.add(course)

            val sql = """
                INSERT INTO student_courses(course_id, student_id)
                 VALUES (:courseId, :studentId)
            """
            session.createNativeMutationQuery(sql)
                .setParameter("courseId", courseId)
                .setParameter("studentId", studentId)
                .executeUpdate()
        }
    }
}
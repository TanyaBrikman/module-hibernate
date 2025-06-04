package brikman.dev

import org.hibernate.Session
import org.hibernate.SessionFactory
import org.springframework.context.annotation.AnnotationConfigApplicationContext

fun main() {
    val context = AnnotationConfigApplicationContext("brikman.dev")

    val sessionFactory: SessionFactory = context.getBean(SessionFactory::class.java)

    val session: Session = sessionFactory.openSession()

    val student1 = Student(name = "Tom", age = 22)
    val student2 = Student(name = "Jerry", age = 20)

    session.beginTransaction()
    session.persist(student1)
    session.persist(student2)
    session.transaction.commit()

    val studentById: Student = session.get(Student::class.java, 2L)

    println("student: $studentById")

    val studentById2: Student = session.createQuery("FROM Student WHERE id = :id", Student::class.java).setParameter("id", 2L).uniqueResult()

    println("student: $studentById2")

    session.beginTransaction()
    val studentForUpdate:Student = session.get(Student::class.java, 1L)
    studentForUpdate.name = "Tommy"
    studentForUpdate.age = 30
    session.transaction.commit()

    session.beginTransaction()
    val studentForDelete: Student = session.createQuery("FROM Student  WHERE age = :age", Student::class.java).setParameter("age", 20).uniqueResult()
    session.remove(studentForDelete)

    session.transaction.commit()



    session.close()
}
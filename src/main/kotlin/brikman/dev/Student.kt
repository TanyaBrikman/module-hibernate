package brikman.dev

import jakarta.persistence.*

@Entity
@Table(name = "students")
class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    @Column
    var name: String,
    var age: Int
) {
    override fun toString(): String {
        return "Student(id=$id, name='$name', age=$age)"
    }
}
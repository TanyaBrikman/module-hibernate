package brikman.dev.util

import org.hibernate.Session
import org.hibernate.SessionFactory
import org.springframework.stereotype.Component

@Component
class TransactionHelper(private val sessionFactory: SessionFactory) {

    fun <R> transaction(block: (Session) -> R): R {
        val session = sessionFactory.openSession()
        session.beginTransaction()
        try {
            val result = block(session)
            session.transaction.commit()
            return result
        } catch (e: Exception) {
            session.transaction.rollback()
            throw e
        } finally {
            session.close()
        }
    }
}
package brikman.dev.service

import brikman.dev.entity.Profile
import brikman.dev.util.TransactionHelper
import org.hibernate.SessionFactory
import org.springframework.stereotype.Service

@Service
class  ProfileService(
    private val sessionFactory: SessionFactory,
    private val transactionHelper: TransactionHelper
) {

    fun saveProfile(profile: Profile) {
        transactionHelper.transaction { it.persist(profile) }
    }

    fun deleteProfile(profile: Profile) {
       transactionHelper.transaction {  }
    }
}

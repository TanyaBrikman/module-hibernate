package brikman.dev

import org.hibernate.SessionFactory
import org.hibernate.cfg.Configuration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration as SpringConfiguration


@SpringConfiguration
class HibernateConfiguration {

    @Bean
    fun sessionFactory(): SessionFactory {

        val config: Configuration = Configuration()

        config
            .addAnnotatedClass(Student::class.java)
            .addPackage("brikman.dev")
            .setProperty("hibernate.connection.driver_class", "org.postgresql.Driver")
            .setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres")
            .setProperty("hibernate.connection.username", "postgres")
            .setProperty("hibernate.connection.password", "postgres")
            .setProperty("hibernate.hbm2ddl.auto", "create")
//            .setProperty("hibernate.show_sql", "true")
//            .setProperty("hibernate.format_sql", "true")
//            .setProperty("hibernate.use_sql_comments", "true")
//            .setProperty("hibernate.type", "trace")


        return config.buildSessionFactory()
    }
}


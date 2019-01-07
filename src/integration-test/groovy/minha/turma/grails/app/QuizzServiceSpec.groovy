package minha.turma.grails.app

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class QuizzServiceSpec extends Specification {

    QuizzService quizzService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Quizz(...).save(flush: true, failOnError: true)
        //new Quizz(...).save(flush: true, failOnError: true)
        //Quizz quizz = new Quizz(...).save(flush: true, failOnError: true)
        //new Quizz(...).save(flush: true, failOnError: true)
        //new Quizz(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //quizz.id
    }

    void "test get"() {
        setupData()

        expect:
        quizzService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Quizz> quizzList = quizzService.list(max: 2, offset: 2)

        then:
        quizzList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        quizzService.count() == 5
    }

    void "test delete"() {
        Long quizzId = setupData()

        expect:
        quizzService.count() == 5

        when:
        quizzService.delete(quizzId)
        sessionFactory.currentSession.flush()

        then:
        quizzService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Quizz quizz = new Quizz()
        quizzService.save(quizz)

        then:
        quizz.id != null
    }
}

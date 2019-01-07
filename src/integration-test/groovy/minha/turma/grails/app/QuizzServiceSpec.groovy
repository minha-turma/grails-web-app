package minha.turma.grails.app

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class QuizServiceSpec extends Specification {

    QuizService quizService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Quiz(...).save(flush: true, failOnError: true)
        //new Quiz(...).save(flush: true, failOnError: true)
        //Quiz quiz = new Quiz(...).save(flush: true, failOnError: true)
        //new Quiz(...).save(flush: true, failOnError: true)
        //new Quiz(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //quiz.id
    }

    void "test get"() {
        setupData()

        expect:
        quizService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Quiz> quizList = quizService.list(max: 2, offset: 2)

        then:
        quizList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        quizService.count() == 5
    }

    void "test delete"() {
        Long quizId = setupData()

        expect:
        quizService.count() == 5

        when:
        quizService.delete(quizId)
        sessionFactory.currentSession.flush()

        then:
        quizService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Quiz quiz = new Quiz()
        quizService.save(quiz)

        then:
        quiz.id != null
    }
}

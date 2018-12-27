package minha.turma.grails.app

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ProfessorServiceSpec extends Specification {

    ProfessorService professorService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Professor(...).save(flush: true, failOnError: true)
        //new Professor(...).save(flush: true, failOnError: true)
        //Professor professor = new Professor(...).save(flush: true, failOnError: true)
        //new Professor(...).save(flush: true, failOnError: true)
        //new Professor(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //professor.id
    }

    void "test get"() {
        setupData()

        expect:
        professorService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Professor> professorList = professorService.list(max: 2, offset: 2)

        then:
        professorList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        professorService.count() == 5
    }

    void "test delete"() {
        Long professorId = setupData()

        expect:
        professorService.count() == 5

        when:
        professorService.delete(professorId)
        sessionFactory.currentSession.flush()

        then:
        professorService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Professor professor = new Professor()
        professorService.save(professor)

        then:
        professor.id != null
    }
}

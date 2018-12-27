package minha.turma.grails.app

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SchoolClassServiceSpec extends Specification {

    SchoolClassService schoolClassService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SchoolClass(...).save(flush: true, failOnError: true)
        //new SchoolClass(...).save(flush: true, failOnError: true)
        //SchoolClass schoolClass = new SchoolClass(...).save(flush: true, failOnError: true)
        //new SchoolClass(...).save(flush: true, failOnError: true)
        //new SchoolClass(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //schoolClass.id
    }

    void "test get"() {
        setupData()

        expect:
        schoolClassService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SchoolClass> schoolClassList = schoolClassService.list(max: 2, offset: 2)

        then:
        schoolClassList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        schoolClassService.count() == 5
    }

    void "test delete"() {
        Long schoolClassId = setupData()

        expect:
        schoolClassService.count() == 5

        when:
        schoolClassService.delete(schoolClassId)
        sessionFactory.currentSession.flush()

        then:
        schoolClassService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SchoolClass schoolClass = new SchoolClass()
        schoolClassService.save(schoolClass)

        then:
        schoolClass.id != null
    }
}

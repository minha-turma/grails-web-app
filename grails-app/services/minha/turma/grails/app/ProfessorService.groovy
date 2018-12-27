package minha.turma.grails.app

import grails.gorm.services.Service

@Service(Professor)
interface ProfessorService {

    Professor get(Serializable id)

    List<Professor> list(Map args)

    Long count()

    void delete(Serializable id)

    Professor save(Professor professor)

}
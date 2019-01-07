package minha.turma.grails.app

import grails.gorm.services.Service

@Service(Professor)
abstract class ProfessorService {

    abstract Professor get(Serializable id);

    abstract List<Professor> list(Map args)

    abstract Long count()

    abstract void delete(Serializable id)

    abstract Professor save(Professor professor)

}
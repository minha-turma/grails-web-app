package minha.turma.grails.app

import grails.gorm.services.Service

@Service(Lecture)
abstract class LectureService {

    abstract Lecture get(Serializable id)

    abstract List<Lecture> list(Map args)

    abstract Long count()

    abstract void delete(Serializable id)

    abstract Lecture save(Lecture lecture)

}
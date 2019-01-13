package minha.turma.grails.app

import grails.util.Holders
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

class Student extends User {

	private static final long serialVersionUID = 1

	enum Feeling {
		Happy('Happy'), Unhappy('Unhappy'), Confused('Confused'), Mad('Mad')

		String name
		Feeling (String name) {
			this.name = name
		}
	}

	Feeling feeling
	SchoolClass schoolClass

	static constraints = {
		feeling (nullable: true)
		schoolClass (nullable: true)
	}

}

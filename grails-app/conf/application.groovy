

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'minha.turma.grails.app.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'minha.turma.grails.app.UserRole'
grails.plugin.springsecurity.authority.className = 'minha.turma.grails.app.Role'

grails.plugin.springsecurity.securityConfigType = 'InterceptUrlMap'
grails.plugin.springsecurity.interceptUrlMap = [
	[pattern: '/error',          	access: ['permitAll']],
	[pattern: '/index',          	access: ['permitAll']],
	[pattern: '/index.gsp',      	access: ['permitAll']],
	[pattern: '/shutdown',       	access: ['permitAll']],
	[pattern: '/assets/**',      	access: ['permitAll']],
	[pattern: '/**/js/**',       	access: ['permitAll']],
	[pattern: '/**/css/**',      	access: ['permitAll']],
	[pattern: '/**/images/**',   	access: ['permitAll']],
	[pattern: '/**/favicon.ico', 	access: ['permitAll']],
	[pattern: '/api/login',  	 	access: ['permitAll']],
	[pattern: '/api/user/**',  		access: ['ROLE_ADMIN']],
	[pattern: '/api/quiz/**',   	access: ['ROLE_ADMIN', 'ROLE_STUDENT']],
	[pattern: '/api/student/**',   	access: ['ROLE_ADMIN']],
	[pattern: '/api/professor/**',  access: ['ROLE_ADMIN']],
	[pattern: '/api/subject/**', 	access: ['ROLE_ADMIN']],
	[pattern: '/api/lecture/**',  	access: ['ROLE_ADMIN']],
	[pattern: '/api/schoolClass/**',access: ['ROLE_ADMIN']],
	[pattern: '/api/presence/**',	access: ['ROLE_ADMIN']],
	[pattern: '/api/message/**',	access: ['ROLE_ADMIN']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/api/**', filters:'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter']
]

grails.plugin.springsecurity.rest.token.validation.useBearerToken = false
grails.plugin.springsecurity.rest.token.validation.headerName = 'Authorization'
//end of rest configuration

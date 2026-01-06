package auth

import grails.gorm.transactions.Transactional

@Transactional
class AuthService {

    boolean isLoggedIn(session) {
        return session?.user != null
    }

    User login(String email, String password) {
        if (!email || !password) return null
        return User.findByEmailAndPassword(email, password)
    }

    User register(String email, String username, String password) {
        if (!email || !username || !password) return null
        def existing = User.findByEmail(email)
        if (existing) return null

        def user = new User(email: email, username: username, password: password)
        user.save(flush: true)
        return user
    }

    void logout(session) {
        session.invalidate()
    }
}

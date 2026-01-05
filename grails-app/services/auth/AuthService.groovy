package auth

class AuthService {

    boolean isLoggedIn(session) {
        return session?.user != null
    }

    def currentUser(session) {
        return session?.user
    }
}

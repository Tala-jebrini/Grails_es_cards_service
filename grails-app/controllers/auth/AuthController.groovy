package auth

class AuthController {

    AuthService authService

    def login() {
        // Show login page
        render(view: "login")
    }

    def doLogin() {
        def user = authService.login(params.email, params.password)
        if (user) {
            session.user = user
            redirect(uri: "/")
        } else {
            flash.error = "Invalid email or password"
            redirect(action: "login")
        }
    }

    def register() {
        render(view: "register")
    }

    def doRegister() {
        def user = authService.register(params.email, params.username, params.password)
        if (user) {
            session.user = user
            redirect(uri: "/")
        } else {
            flash.error = "Registration failed (email may already exist)"
            redirect(action: "register")
        }
    }

//    def logout() {
//        authService.logout(session)
//        redirect(uri: "/")
//    }

    def logout() {
        session.invalidate()
        redirect(uri: "/")
    }

}

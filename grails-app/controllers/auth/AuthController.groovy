package auth

class AuthController {

    def index() {
        // Show login page
    }

    def login() {
        String email = params.email
        String password = params.password

        if (!email || !password) {
            flash.error = "Email and password are required"
            redirect(action: "index")
            return
        }

        // Simple authentication (replace with real logic)
        def user = User.findByEmailAndPassword(email, password)
        if (user) {
            session.user = user
            redirect(uri: "/")
        } else {
            flash.error = "Invalid email or password"
            redirect(action: "index")
        }
    }
}

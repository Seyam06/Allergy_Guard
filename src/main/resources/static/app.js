// Simple validation for login
function validateLogin() {
    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;

    if (email === "" || password === "") {
        alert("Please fill all fields!");
        return false;
    }
    return true;
}

// Simple validation for register
function validateRegister() {
    let name = document.getElementById("name").value;
    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;

    if (name === "" || email === "" || password === "") {
        alert("All fields are required!");
        return false;
    }

    if (password.length < 4) {
        alert("Password must be at least 4 characters!");
        return false;
    }

    return true;
}
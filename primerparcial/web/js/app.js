async function fetchLogin(user) {
    const response = await fetch(
            "http://localhost:8080/primerparcial/api/user/login",
            {
                method: "POST",
                headers: {
                    "Content-Type": "application/x-www-form-urlencoded;charset=UTF-8"
                },
                body: JSON.stringify(user)
            }
    );
    const data = await response.json();
    return data;
}

function login() {
    let username = document.getElementById("txtUsername").value;
    let password = document.getElementById("txtPassword").value;

    username = normalize(username);
    username = sanitize(username);
    password = normalize(password);
    password = sanitize(password);

    let user = {username: username, password: password};

    fetchLogin(user).then(user => {
        alert(JSON.stringify(user));
    });
}

function normalize(txt) {
    for (let i = 0; i < txt.length; i++) {
        txt = txt.replace("á", "a");
        txt = txt.replace("é", "e");
        txt = txt.replace("í", "i");
        txt = txt.replace("ó", "o");
        txt = txt.replace("ú", "u");
        txt = txt.replace("ü", "u");
        txt = txt.replace("ñ", "n");
        txt = txt.replace("Á", "A");
        txt = txt.replace("É", "E");
        txt = txt.replace("Í", "I");
        txt = txt.replace("Ó", "O");
        txt = txt.replace("Ú", "U");
        txt = txt.replace("Ü", "U");
        txt = txt.replace("Ñ", "N");
    }
    return txt;
}

function sanitize(txt) {
    for (let i = 0; i < txt.length; i++) {
        txt = txt.replace("(", "");
        txt = txt.replace(")", "");
        txt = txt.replace(";", "");
        txt = txt.replace("'", "");
        txt = txt.replace("\"", "");
    }
    return txt;
}
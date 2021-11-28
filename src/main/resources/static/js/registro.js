function registrarUsuario(){
    let myData = {
        name: $("#nombre").val(),
        email: $("#email").val(),
        password: $("#password1").val(),
    };

    let confirmarpass = $("#password2").val();
    if (
        myData.email == "" ||
        myData.name == "" ||
        myData.password == "" ||
        confirmarpass == ""
    ) {
        alert("Debe diligenciar todos los campos")
        return
    } else {
        let dataToSend = JSON.stringify(myData);

        if (myData.password == confirmarpass){
            consultarCorreo(dataToSend);
        } else {            
            alert("No coinciden las contraseñas.");             
            return;
        }
    }
}

function consultarCorreo(dataToSend){
    let email = $("#email").val();

    $.ajax({
        url: "http://152.67.45.211:81/api/user/" + email,
        type: "GET",
        dataType: "json",
        success: function (respuesta){
            if (respuesta){                
                alert("Correo ya registrado o incorrecto.")                
                return;
            }else {
                crearUsuario(dataToSend);
            }
        },
        error: function(e){
            alert("error" + e)
        },
    });
}

function crearUsuario(dataToSend){
    $.ajax({
        url: "http://152.67.45.211:81/api/user/new",
        type: "POST",
        data: dataToSend,
        dataType: "json",
        contentType: "application/json",
        complete: function (respuesta){
            alert("Cuenta creada de forma correcta")
            window.location.href = "index.html";
        }
    });
}
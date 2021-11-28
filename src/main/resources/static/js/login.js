function ingresarUsuario() {
    
    let email= $("#email").val();
    let password=$("#password").val();
    
        $.ajax({
            url: "http://152.67.45.211:81/api/user/"+ email+ "/" + password,
            type: "GET",
            dataType: "json",
            success: function(respuesta){
                if(respuesta.id != null){
                    alert(`Bienvenido ${respuesta.name}`);
                } else {
                    alert("No existe un usuario")
                }
            }
        });
    
}
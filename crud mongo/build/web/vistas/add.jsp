<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="col-lg-6">
                <h1>Agregar Estudiante</h1>
                <form action="Controlador">
                    DNI:<br>
                    <input class="form-control" type="text" name="txtId"><br>
                    Nombres: <br>
                    <input class="form-control" type="text" name="txtNom"><br>
                    Fecha: <br>
                    <input class="form-control" type="date" name="txtFec"><br>
                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                    <a href="Controlador?accion=listar">Regresar</a>
                </form>
            </div>

        </div>
    </body>
</html>

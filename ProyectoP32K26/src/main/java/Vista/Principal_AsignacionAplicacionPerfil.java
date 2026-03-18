//realizado por Herson Giron 
package Vista;

// Importación de clases necesarias del proyecto
import Controlador.Asignacion_Aplicacion_Perfil;
import Modelo.Asignacion_Aplicacion_PerfilDAO;
import java.util.List;

//Clase principal 
public class Principal_AsignacionAplicacionPerfil {

    //Método principal donde se ejecuta el programa
    public static void main(String[] args) {

//INSERT
// Se crea un objeto de tipo Asignacion_Aplicacion_Perfil con todos los permisos en "1"
Asignacion_Aplicacion_Perfil asignacion = new Asignacion_Aplicacion_Perfil("1", "1", "1", "1", "1");
// Se establece el código de la aplicación al objeto
asignacion.setAplCódigo(1);
// Se establece el código del perfil al objeto
asignacion.setPerCódigo(1);
// Se imprime en consola el registro que se agregará
System.out.println("Registro agregado: " + asignacion.toString());
// Se crea un objeto DAO que permitirá interactuar con la base de datos
Asignacion_Aplicacion_PerfilDAO asignacionDAO = new Asignacion_Aplicacion_PerfilDAO();
// Se ejecuta el método insert del DAO para guardar el registro en la base de datos
asignacionDAO.insert(asignacion);


//QUERY
// Se consulta en la base de datos el registro que coincide con los datos del objeto asignacion
asignacion = asignacionDAO.query(asignacion);
// Se imprime en consola el registro encontrado en la base de datos
System.out.println("Registro seleccionado: " + asignacion.toString());


//SELECT
// Se crea otro objeto DAO para realizar la consulta de todos los registros
Asignacion_Aplicacion_PerfilDAO asignacionDAOModi = new Asignacion_Aplicacion_PerfilDAO();
// Se ejecuta el método select que devuelve una lista con todos los registros de la tabla
List<Asignacion_Aplicacion_Perfil> asignaciones = asignacionDAOModi.select();
// Se recorre la lista de registros obtenidos
for (Asignacion_Aplicacion_Perfil lista : asignaciones) {
// Se imprime cada registro encontrado en la lista
System.out.println("Lista de registro: " + lista.toString());
}

//DELETE
// Se crea un objeto vacío para indicar qué registro se desea eliminar
Asignacion_Aplicacion_Perfil asignacionEliminar = new Asignacion_Aplicacion_Perfil();
// Se asigna el código de la aplicación del registro que se quiere eliminar
asignacionEliminar.setAplCódigo(2);
// Se asigna el código del perfil del registro que se quiere eliminar
asignacionEliminar.setPerCódigo(1);
// Se consulta el registro en la base de datos antes de eliminarlo
asignacionEliminar = asignacionDAO.query(asignacionEliminar);
// Se ejecuta el método delete del DAO para eliminar el registro encontrado
asignacionDAO.delete(asignacionEliminar);
// Se imprime en consola el registro que fue eliminado
System.out.println("Registro eliminado: " + asignacionEliminar.toString());


//UPDATE
// Se consulta nuevamente el registro para obtener sus datos actuales
asignacion = asignacionDAO.query(asignacion);
// Se modifica el código del perfil del registro
asignacion.setPerCódigo(3);
// Se actualiza el permiso de insertar
asignacion.setAplpInsert("1");
// Se actualiza el permiso de consultar
asignacion.setAplpSelect("1");
// Se actualiza el permiso de actualizar
asignacion.setAplpUpdate("1");
// Se actualiza el permiso de eliminar
asignacion.setAplpDelete("0");
// Se actualiza el permiso de generar reportes
asignacion.setAplpReporte("1");
// Se ejecuta el método update del DAO para guardar los cambios en la base de datos
asignacionDAO.update(asignacion);
// Se imprime en consola el registro actualizado
System.out.println("Registro actualizado: " + asignacion.toString());
    }
}
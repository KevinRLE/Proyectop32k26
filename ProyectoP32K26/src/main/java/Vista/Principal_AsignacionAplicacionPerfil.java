//realizado por Herson Giron 
package Vista;

// Importación de clases necesarias del proyecto
import Controlador.Asignacion_Aplicacion_Perfil; // Clase controlador
import Modelo.Asignacion_Aplicacion_PerfilDAO; // Clase DAO que maneja las operaciones con la base de datos
import java.util.List; // Librería para manejar listas

//Clase principal 
public class Principal_AsignacionAplicacionPerfil {

    //Método principal donde se ejecuta el programa
        public static void main(String[] args) {

        //insert
        // Se crea un objeto de asignación con los valores de aplicación y perfil
        Asignacion_Aplicacion_Perfil asignacion = new Asignacion_Aplicacion_Perfil(1, 1);
        // Se imprime el objeto para verificar sus datos
        System.out.println("Registro agregado: " + asignacion.toString());    
        // Se crea el objeto DAO que permitirá insertar datos en la base de datos
        Asignacion_Aplicacion_PerfilDAO asignacionDAO = new Asignacion_Aplicacion_PerfilDAO();
        // Se ejecuta el método insert para guardar el registro
        asignacionDAO.insert(asignacion);

        // Query
        // Se busca en la base de datos el registro que coincide con el objeto
        asignacion = asignacionDAO.query(asignacion);
        // Se imprime el resultado obtenido
        System.out.println("Registro seleccionado: " + asignacion.toString());

        //Select
        // Se crea un objeto vacío para posibles modificaciones
        Asignacion_Aplicacion_Perfil asignacionModificar = new Asignacion_Aplicacion_Perfil();
        // Se crea un nuevo DAO para ejecutar la consulta
        Asignacion_Aplicacion_PerfilDAO asignacionDAOModi = new Asignacion_Aplicacion_PerfilDAO();
        // Se obtiene una lista de todas las asignaciones almacenadas
        List<Asignacion_Aplicacion_Perfil> asignaciones = asignacionDAOModi.select();
        // Se recorre la lista y se imprimen todos los registros
        for (Asignacion_Aplicacion_Perfil lista : asignaciones) {
        System.out.println("Lista de registro: " + lista.toString());
        }

        //Delete
        // Se crea un objeto con los datos que se desean eliminar
        Asignacion_Aplicacion_Perfil asignacionEliminar = new Asignacion_Aplicacion_Perfil(2, 1);
        // Se consulta primero el registro en la base de datos
        asignacionEliminar = asignacionDAO.query(asignacionEliminar);
        // Se elimina el registro encontrado
        asignacionDAO.delete(asignacionEliminar);
        // Se imprime el objeto eliminado
        System.out.println("Registro eliminado: " + asignacionEliminar.toString());

        //Update
        // Se consulta nuevamente el registro existente
        asignacion = asignacionDAO.query(asignacion);
        // Se modifica el código del perfil
        asignacion.PerCódigo(3);
        // Se actualiza el registro en la base de datos
        asignacionDAO.update(asignacion);
        // Se imprime el objeto actualizado
        System.out.println("Registro actualizado: " + asignacion.toString());
    }
}

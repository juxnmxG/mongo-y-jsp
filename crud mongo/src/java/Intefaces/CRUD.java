
package Intefaces;

import Estudiante.Estudiante;
import java.util.List;


public interface CRUD {
    public List listar();
    public Estudiante list(int id);
    public boolean add(Estudiante per);
    public boolean edit(Estudiante per);
    public boolean eliminar(int id);
}

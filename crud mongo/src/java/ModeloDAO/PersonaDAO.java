
package ModeloDAO;
import Config.Conexion;
import Intefaces.CRUD;
import Estudiante.Estudiante;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.result.DeleteResult;

public class PersonaDAO implements CRUD{
    
    Conexion cn = new Conexion();
    String rs;
    Estudiante p = new Estudiante();
    
    @Override
    public List listar() {
        
        ArrayList<Estudiante> list = new ArrayList<>();
        MongoCollection<Document> collection = cn.database.getCollection("estudiante");
        MongoCursor<Document> cursor = collection.find().iterator();
        
        try {
            while (cursor.hasNext()){
                    Estudiante per = new Estudiante();
                    per.setId(cursor.next().getString("id"));
                    per.setNombre(cursor.next().getString("nombre"));
                    per.setFecha(cursor.next().getString("fecha"));
                    list.add(per);
                    }
            } finally 
        {
            cursor.close();
        }
        return list;
    }

    @Override
    public Estudiante list(int id) {
        
        try {
            
            while(rs == ""){                
                //p.setId(rs.getInt("Id"));
                //p.setDni(rs.getString("DNI"));
                //p.setNom(rs.getString("Nombres"));
                
            }
        } catch (Exception e) {
        }
        return p;
    }

    @Override
    public boolean add(Estudiante per) {
       
       Document doc = new Document();
       MongoCollection<Document> collection = cn.database.getCollection("estudiante");
  
        try {
                doc.append("id", per.getId())
                .append("nombre", per.getNombre())
                .append("fecha", per.getFecha());
                collection.insertOne(doc);
                
        } catch (Exception e) {
            
        }
        
       return false;
    }

    @Override
    public boolean edit(Estudiante per) {
        Document doc = new Document();
        MongoCollection<Document> collection = cn.database.getCollection("estudiante");
        
        try {
            collection.updateOne(eq("id", 10), new Document("$set", new Document("id", per.getId())));
        } catch (Exception e) {
        }
        return false;
    }

    public boolean eliminar(String eliminar) {
        
        Document doc = new Document();
        MongoCollection<Document> collection = cn.database.getCollection("estudiante");
        
        try {
            collection.deleteOne(eq("id", eliminar));
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

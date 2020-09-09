package dao;

import java.util.List;
import com.db4o.query.Query;
import model.Genre;


public class DAO_Genre extends DAO<Genre> {
	
	public Genre read (Object chave) {
		String genreName = (String) chave;
		
		Query q = manager.query();
		q.constrain(Genre.class);
		q.descend("name").constrain(genreName);
		List<Genre> resultados = q.execute();
		
		if (resultados.size()==0) return null;
		
		return resultados.get(0);
	}
	
}

package dao;

import java.util.List;
import com.db4o.query.Query;
import model.Status;

public class DAO_Status extends DAO<Status> {
	
	public Status read (Object chave) {
		String date = (String) chave;
		
		Query q = manager.query();
		q.constrain(Status.class);
		q.descend("date").constrain(date);
		List<Status> resultados = q.execute();
		
		if (resultados.size()==0) return null;
		
		return resultados.get(0);
	}
	
/*	public Status readBy (Object key1, Object key2) {
		String user = (String) key1;
		String game = (String) key2;
		
		Query q = manager.query();
		q.constrain(Status.class);
		q.
	}
*/
}

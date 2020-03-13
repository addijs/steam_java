package dao;

import java.util.List;
import com.db4o.query.Query;
import model.User;

public class DAO_User extends DAO<User>{
	
	public User read (Object chave) {
		String name = (String) chave;
		
		Query q = manager.query();
		q.constrain(User.class);
		q.descend("name").constrain(name);
		List<User> resultados = q.execute();
		
		if (resultados.size()==0) return null;
		
		return resultados.get(0);
	}
}

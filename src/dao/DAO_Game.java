package dao;

import java.util.List;
import com.db4o.query.Query;
import model.Game;

public class DAO_Game extends DAO<Game>{

	public Game read (Object chave) {
		String title = (String) chave;
		
		Query q = manager.query();
		q.constrain(Game.class);
		q.descend("title").constrain(title);
		List<Game> resultados = q.execute();
		
		if (resultados.size()==0) return null;
		
		return resultados.get(0);
	}
}


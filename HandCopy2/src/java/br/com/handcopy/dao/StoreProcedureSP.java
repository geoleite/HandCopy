package br.com.handcopy.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;

public class StoreProcedureSP extends ObjectDAO {
	 public StoreProcedureSP (DAOFactory dao) throws Exception {
		 setDAOFactory(dao);
 		 con = dao.create();
 	 }
	//

}

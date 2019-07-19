package com.nucleus.hp1;

import java.sql.Connection;

public interface CustomerDAO {
	public void readFromFile(String path,String rejection,Connection con);
}

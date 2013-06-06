package br.com.lifefair.connection;

import javax.sql.DataSource;

import br.com.bradseg.bsad.framework.core.jdbc.JdbcDao;

public abstract class AbstractDaoSql extends JdbcDao {

	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}

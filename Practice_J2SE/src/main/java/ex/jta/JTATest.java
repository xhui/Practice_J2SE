package ex.jta;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;
import javax.sql.XAConnection;
import javax.sql.XADataSource;
import javax.transaction.xa.XAException;
import javax.transaction.xa.XAResource;
import javax.transaction.xa.Xid;

public class JTATest
{
	public void test() throws Throwable
	{
		XADataSource xaDS = null;
		XAConnection xaCon;
		XAResource xaRes;
		Xid xid;
		Connection con;
		Statement stmt;
		int ret;
		// xaDS = getDataSource();
		xaCon = xaDS.getXAConnection("jdbc_user", "jdbc_password");
		xaRes = xaCon.getXAResource();
		con = xaCon.getConnection();
		stmt = con.createStatement();
		xid = new MyXid(100, new byte[] { 0x01 }, new byte[] { 0x02 });
		try
		{
			xaRes.start(xid, XAResource.TMNOFLAGS);
			stmt.executeUpdate("insert into test_table values (100)");
			xaRes.end(xid, XAResource.TMSUCCESS);
			ret = xaRes.prepare(xid);
			if (ret == XAResource.XA_OK)
			{
				xaRes.commit(xid, false);
			}
		}
		catch (XAException e)
		{
			e.printStackTrace();
		}
		finally
		{
			stmt.close();
			con.close();
			xaCon.close();
		}
	}

	// public DataSource getDataSource() throws SQLException
	// {
	// SQLServerDataSource xaDS = new
	// com.merant.datadirect.jdbcx.sqlserver.SQLServerDataSource();
	// xaDS.setDataSourceName("SQLServer");
	// xaDS.setServerName("server");
	// xaDS.setPortNumber(1433);
	// xaDS.setSelectMethod("cursor");
	// return xaDS;
	// }
}

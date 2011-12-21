package ex.jmx;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

import com.sun.jdmk.comm.HtmlAdaptorServer;

public class FooAgent {
	public static void main(String[] args) {
		MBeanServer server = MBeanServerFactory.createMBeanServer();

		try {
			ObjectName fooName = new ObjectName(
					"Foo:fileName=fileA,filePath=\"C:/WebDev/temp.txt\"");
			server.registerMBean(new Foo(), fooName);

			ObjectName adapterName = new ObjectName(
					"FooAgent:name=htmladapter,port=8082");

			HtmlAdaptorServer adapter = new HtmlAdaptorServer();
			server.registerMBean(adapter, adapterName);

			System.out.println("Starting... ...");
			adapter.start();
			System.out.println("running... ...");

		} catch (MalformedObjectNameException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (InstanceAlreadyExistsException e) {
			e.printStackTrace();
		} catch (MBeanRegistrationException e) {
			e.printStackTrace();
		} catch (NotCompliantMBeanException e) {
			e.printStackTrace();
		}
	}
}

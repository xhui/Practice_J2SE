package ex.socket;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class MutipleThreadServer
{
	private static final int	port		= 9001;
	private ServerSocket		server		= null;
	private ExecutorService		threadPool	= null;
	private static final int	POOL_SIZE	= 10;

	public MutipleThreadServer() throws IOException
	{
		server = new ServerSocket(port);
		threadPool = Executors.newFixedThreadPool(POOL_SIZE);
	}

	public void service()
	{
		while (true)
		{
			Socket socket = null;
			try
			{
				socket = server.accept();
				threadPool.execute(new Handler(socket));
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	class Handler implements Runnable
	{
		Socket	socket	= null;

		Handler(Socket socket)
		{
			this.socket = socket;
		}

		@Override
		public void run()
		{
			InetAddress remoteAddress = socket.getInetAddress();
			if (null == remoteAddress)
			{
				Logger.getLogger(this.getClass().getName()).warning(
						"Can not get ip address");
				return;
			}
			remoteAddress.getHostAddress();

			// InputStreamReader bis = new BufferedInputStream(
			// socket.getInputStream());
			// BufferedReader br = new BufferedReader(bis);

		}
	}
}

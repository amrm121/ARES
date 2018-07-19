package client.view.operacao;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileClient {
	
	private Socket s;
	private String ramal;
        private String data;
        
	public FileClient(String ramal, String data, String host, int port, File filez) throws InterruptedException {

            try {
                        this.ramal = ramal;
                        this.data = data;
			s = new Socket(host, port);
			sendFile(filez);
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}
	
	private void sendFile(File file) throws IOException {
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                FileInputStream fis = new FileInputStream(file);
                long fs = file.length();
                String fp = ramal+"_"+data;
		dos.writeUTF(fp+":"+fp+".png:+"+fs);
                dos.flush();
                byte[] buffer = new byte[4096];
		
		while (fis.read(buffer) > 0) {
			dos.write(buffer);
		}
		
		fis.close();
		dos.close();                
        }
                
}
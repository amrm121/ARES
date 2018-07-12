package data;
/**
 *
 * @author Alexandre Moreno Ribeiro Magalhaes
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class APIAcess {
    private final String key = "&chave=8101f7a2b048413814170129d65a1f2d";
    private final String prefix1 = "http://10.81.32.50/api/";
    private static APIAcess instance;
   
    /**
     *
     * @return
     */
    public static APIAcess getInstance(){
        if(instance == null)
            instance = new APIAcess();        
        return instance;
    }
    
    public String APIGet(String info){
        String answ = "null";
        try {
            answ = doHttpUrlConnectionAction(prefix1+info+key);
        } catch (Exception ex) {
            Logger.getLogger(DataBaseAcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return answ;
    }
    
    public String login(String ramal){
        String func = "login?ramal="+ramal;
        return APIGet(func).trim();
    }
    
    public boolean campAtiva(){
        String func = "campanhas?";
        String[] campanhas = APIGet(func).split("\n");
        String[] cAtiva = campanhas[2].split(";");
        return !cAtiva[2].equalsIgnoreCase("INATIVA");
    }
    
    
    /*public DataBaseAcess(String ramal, int func)
  {
      
    try
    {
      
      String loginRamal = prefix+"login?ramal="+ramal+key;      
      String alterarClienteCampanha = prefix + "";
      
      String results = doHttpUrlConnectionAction(myUrl);      
      
    }
    catch (Exception e)
    {
      // deal with the exception in your "controller"
    }
  }*/
  

  /**
   * Returns the output from the given URL.
   * 
   * I tried to hide some of the ugliness of the exception-handling
   * in this method, and just return a high level Exception from here.
   * Modify this behavior as desired.
   * 
   * @param desiredUrl
   * @return
   * @throws Exception
   */
  private String doHttpUrlConnectionAction(String desiredUrl)
  throws Exception
  {
    URL url = null;
    BufferedReader reader = null;
    StringBuilder stringBuilder;

    try
    {
      // create the HttpURLConnection
      url = new URL(desiredUrl);
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      
      // just want to do an HTTP GET here
      connection.setRequestMethod("GET");
      
      // uncomment this if you want to write output to this url
      //connection.setDoOutput(true);
      
      // give it 15 seconds to respond
      connection.setReadTimeout(1*1000);
      connection.connect();

      // read the output from the server
      reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      stringBuilder = new StringBuilder();

      String line = null;
      while ((line = reader.readLine()) != null)
      {
        stringBuilder.append(line+"\n");
      }
      return stringBuilder.toString();
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw e;
    }
    finally
    {
      // close the reader; this can throw an exception too, so
      // wrap it in another try/catch block.
      if (reader != null)
      {
        try
        {
          reader.close();
        }
        catch (IOException ioe)
        {
          ioe.printStackTrace();
        }
      }
    }
  } 
}

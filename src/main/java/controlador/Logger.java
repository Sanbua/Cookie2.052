package controlador;

import java.io.*;

public class Logger {
    private File file;
    private InputStreamReader streamReader;
    private BufferedReader br;

    public Logger(){
        file = new File("log\\logSave");
    }

    public String leerLog(){
        try {
            streamReader = new InputStreamReader(new FileInputStream(file));
            br = new BufferedReader(streamReader);
            String line = new String();

            while (br.ready()) {
                line = br.readLine();
            }

            return line;
        } catch (FileNotFoundException e){
            System.out.println(e);
        } catch (IOException e){
            System.out.println(e);
        }
        return "";

    }
}

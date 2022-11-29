package javaproj;
import java.io.*;
public class InputTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        InputStream in=new FileInputStream("c:/temp/user.txt");
        InputStreamReader sr=new InputStreamReader(in,"UTF-8");
        BufferedReader br=new BufferedReader(sr);
        String line=null;
        while((line=br.readLine())!=null)
        	System.out.println(line);
        br.close();
        in.close();
	}

}

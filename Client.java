import java.net.*;
import java.io.*;


public class Client
{
 private Socket socket=null;
 private DataInputStream in=null;
 private DataOutputStream out=null;

 public Client(String ipaddress,int port)
 {
   
   try
   {
       socket=new Socket(ipaddress,port);
       System.out.println("connected;");

       in=new DataInputStream(System.in);

       out=new DataOutputStream(socket.getOutputStream());

   }
   catch(UnknownHostException u)
   {
       System.out.println(u);
   }
   catch(IOException i)
   {
       System.out.println(i);
   }

   String line="";
   while(!line.equals("Over"))
   {
       try
       {
           line=in.readLine();
           out.writeUTF(line);
       }
       catch(IOException i)
       {
           System.out.println(i);
       }
   }
   try
   {
       in.close();
       out.close();
       socket.close();
   }
   catch(IOException i)
   {
       System.out.println(i);
   }
 }
 public static void main(String args[])
 {
     Client client=new Client("127.0.0.1",5000);
 }
}

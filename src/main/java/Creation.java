import redis.clients.jedis.Jedis;

import java.util.Scanner;

public class Creation {
    public static void main(String[] args) {

        System.out.println("MySQL REDIS Connection Testing ~");

        Scanner myObj = new Scanner(System.in);
//        int ascii=10;
//        char c=(char)ascii;
//        int asciiValue=0;

        try {
            Jedis jedis = new Jedis("localhost");

            System.out.println("Connection Successful");
            System.out.println("The server is running " + jedis.ping());
            System.out.println("enter the username");
            String username= myObj.nextLine();

           // TODO for the one who just press enter without giving any key
//            for(int i=0; i<username.length(); i++)
//            {
//                asciiValue = username.charAt(i);
//            }
//            if(asciiValue==ascii){
//                throw new Exception("USERNAME CANNOT BE BLANK");
//            }

            System.out.println("Enter the Database");
            String db_index_sms = myObj.nextLine();
            jedis.select(Integer.parseInt(db_index_sms));

            jedis.set(username, (String.valueOf(username.hashCode()))+9*3);
            System.out.println(jedis.get(username));

        }catch(Exception e) {
            System.out.println(e);
        }
    }

}

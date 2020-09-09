import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class ReadAllKeys {
    public static void main(String[] args){
        System.out.println("MySQL REDIS Connection Testing ~");
        Scanner myObj = new Scanner(System.in);

        try {
            Jedis jedis = new Jedis("localhost");

            System.out.println("Connection Successful");
            System.out.println("The server is running " + jedis.ping());
            System.out.println("Enter the Database");
            String db_index_sms = myObj.nextLine();

            jedis.select(Integer.parseInt(db_index_sms));

            Set<String> names = jedis.keys("*");
            Iterator<String> it = names.iterator();
            while (it.hasNext()) {
                String s = it.next();
                System.out.println("Username is:"+s+"  And Unique Id is : "+jedis.get(s));
            }

        }catch(Exception e) {
            System.out.println(e);
        }
    }

}


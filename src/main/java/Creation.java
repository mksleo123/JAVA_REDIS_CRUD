import redis.clients.jedis.Jedis;

import java.util.Scanner;

public class Creation {
    public static void main(String[] args) {

        System.out.println("MySQL REDIS Connection Testing ~");

        Scanner myObj = new Scanner(System.in);
        try {
            Jedis jedis = new Jedis("localhost");

            System.out.println("Connection Successful");
            System.out.println("The server is running " + jedis.ping());
            System.out.println("enter the username");
            String username= myObj.nextLine();

            System.out.println("Enter the Database");
            String db_index_sms = myObj.nextLine();
            jedis.select(Integer.parseInt(db_index_sms));

            if(!(jedis.exists(username.toLowerCase()))){
                jedis.set(username, (String.valueOf(username.hashCode()))+9*3);
                System.out.println(jedis.get(username));
            }else{
                System.out.println(" USERNAME ALREADY EXIST");
            }
        }catch(Exception e) {
            System.out.println(e);
        }
    }

}

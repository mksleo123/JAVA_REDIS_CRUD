import redis.clients.jedis.Jedis;

import java.util.Scanner;

public class DeleteSection {
    public static void main(String[] args) {

        System.out.println("MySQL REDIS Connection Testing ~");
        Scanner myObj = new Scanner(System.in);

        try {
            Jedis jedis = new Jedis("localhost");

            System.out.println("Connection Successful");
            System.out.println("The server is running " + jedis.ping());

            System.out.println("Enter the Database");
            String db_index_sms = myObj.nextLine();
            jedis.select(Integer.parseInt(db_index_sms));

            System.out.println("ENTER THE USERNAME TO DELETE");
            String username= myObj.nextLine();
            if(jedis.exists(username.toLowerCase())){
                jedis.del(username);
                System.out.println("USERNAME DELETED");
            }else{
                System.out.println("USERNAME DOESN'T EXIST");
            }


        }catch(Exception e) {
            System.out.println(e);
        }
    }

}

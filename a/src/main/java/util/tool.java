<<<<<<< HEAD
package util;

import java.util.UUID;

public class tool {
	 /**
     * 获得一个UUID 
     * @return String UUID 
     */
    public static String getUUID(){
        String uuid = UUID.randomUUID().toString();
        //去掉“-”符号 
        return uuid.replaceAll("-", "");
    }
}
=======
package util;

import java.util.UUID;

public class tool {
	 /**
     * 获得一个UUID 
     * @return String UUID 
     */
    public static String getUUID(){
        String uuid = UUID.randomUUID().toString();
        //去掉“-”符号 
        return uuid.replaceAll("-", "");
    }
}
>>>>>>> c8a361cdb5bd19bc82a4ecda6a545e77ac7ef6ee

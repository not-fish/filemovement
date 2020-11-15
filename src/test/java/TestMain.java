import java.io.*;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

public class TestMain {

    private static int dateNum = 20201114;

    public static void main(String[] args) throws IOException {

        File fileSource = new File("E:/data/animation/78/10000/arm.jpg");
        String address = "E:/data/animation/78/10000/";
        String newAddress = pathModify(address);
        File newFile = new File(newAddress);
        if (!newFile.exists() && !newFile.isDirectory()) {
            newFile.mkdirs();
            System.out.println("创建文件夹:"+newFile.getName());
        } else {
            System.out.println("文件夹已存在"+newFile.getName());
        }

        File fileTarget = new File(newAddress+fileSource.getName());

        copyFile(fileSource,fileTarget);


    }

    private static void copyFile(File fileSource,File fileTarget) throws IOException {
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        FileOutputStream fos = new FileOutputStream(fileTarget);
        try{
            fis = new FileInputStream(fileSource);
            bis = new BufferedInputStream(fis);
            byte[] buffer = new byte[1024];
            int i = bis.read(buffer);
            while(i!=-1){
                fos.write(buffer,0,i);
                i=bis.read(buffer);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            bis.close();
            fis.close();
            fos.close();
        }
    }

    private static String pathModify(String address) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int num = 0;
        for(int i=0;i<address.length();i++){
            if(address.charAt(i)=='/'){
                num++;
                map.put(num,i);
            }
        }
//        String front = address.substring(0,map.get(3));
//        String back = address.substring(map.get(4),address.length());
//        System.out.println(front + " "+back);
        String[] str = address.split("/");
        for(int i=0;i<str.length;i++){
            System.out.println(str[i]);
        }
        String path = str[0]+"/"+str[1]+"/"+dateNum+"/"+str[2]+"/"+str[4]+"/";
        System.out.println(path);
        dateNum++;
        return path;
    }
}

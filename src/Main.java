import java.io.*;

public class Main {
    public static void main(String[] args){
       BufferedReader bufferedReader = null;
        try{
            File file1 = new File("Output_1");
            File file2 = new File("Output_2");
            if(!file1.exists()){
                file1.createNewFile();
            }
            if(!file2.exists()){
                file2.createNewFile();
            }
            bufferedReader = new BufferedReader(new FileReader("MyTXT.txt"));
            String[] words = bufferedReader.readLine().split(" ");
            String s;
            for(int i = 0; i < words.length-1; i++){
                for(int j = i; j >= 0; j--){
                    if(words[j].compareTo(words[j+1]) > 0){
                         s = words[j];
                         words[j] = words[j+1];
                         words[j+1] = s;
                    }
                }
            }
            PrintWriter printWriter = new PrintWriter(file1);
            for(int i = 0; i < words.length; i++){
                printWriter.print(words[i] + "\n");
            }
            printWriter.close();
            PrintWriter printWriter1 = new PrintWriter(file2);
            for(int i = 0; i < words.length-1; i++){
                if(words[i].length() > 0){
                    s = words[i];
                    words[i] = words[i+1];
                    words[i+1] = s;
                }
            }
            for(int i = 0; i < words.length; i++){
                printWriter1.print(words[i] + "\n");
            }
            printWriter1.close();
        }catch (IOException e){
            System.out.println("Error : " + e);
        }
    }
}
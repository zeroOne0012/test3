import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;

public class IOFile {
    public static Heap ReadText(Heap heap){ //텍스트 파일 읽기
        String fname; //파일 이름
        Scanner in = new Scanner(System.in);
        fname = in.nextLine();
        in.close();
        try{
            Scanner file = new Scanner(new File(System.getProperty("user.dir")+"\\" + fname));
            while(file.hasNextInt()){  //heap에 삽입
                heap.insert(file.nextInt());
            }
            file.close();
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
                throw new RuntimeException(e);
            }
            return heap;
    }
    public static void WriteText(Heap heap){
        String fname;
        Scanner in = new Scanner(System.in);
        fname = "aaa.txt";//in.nextLine();
        in.close();
        try{
            FileWriter fw = new FileWriter(fname);
            for(int i = 1; i<=heap.getSize(); i++){
                fw.write(heap.getValue(i) + "\n");
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
}

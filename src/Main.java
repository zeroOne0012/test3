public class Main {
    public static void main(String[] args) throws Exception {
        Heap heap = IOFile.ReadText(new Heap());
        IOFile.WriteText(heap);
    }
}



/*
public class HeapSort {

    static void readText(ArrayList<Integer> arr){
        String fname;
        Scanner in = new Scanner(System.in);
        fname = in.nextLine();
        try{
            in = new Scanner(new File(System.getProperty("user.dir")+"\\" + fname));
            //int i = 1;
            while(in.hasNextInt()){
                //int temp = in.nextInt();
                arr.add(in.nextInt());
                //System.out.println(temp);
                //i++;
            }
            in.close();
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
                throw new RuntimeException(e);
            }
    }
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> arr = new ArrayList<Integer>(); 
        readText(arr);
        for(int i : arr) { //for문을 통한 전체출력
            System.out.println(i);
        }

    }
}
*/
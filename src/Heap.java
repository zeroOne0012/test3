public class Heap{
    int[] heap;
    int size;
    
    public Heap(){
        heap = new int[1]; //초기 크기 0
        size = heap.length-1;
    }
    public Heap(int[] heap){
        this.heap = heap;
        size = heap.length-1; //heap[0]는 사용하지 않음
    }
    
    public int getValue(int i){
        return heap[i];
    }
    public int getSize(){
        return size;
    }    

    private void swap(int a, int b){
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    int getParent(int child){ //부모 인덱스 get
        return child/2;
    }
    int getLeftChild(int parent){
        return parent*2;
    }
    int getRightChild(int parent){
        return parent*2+1;
    }

    private void increaseSize(){ //배열 사이즈 1 증가
        int[] increasedArr = new int[size+2]; //size: legth-1이므로 +2
        for(int i = 1; i < size; i++)
            increasedArr[i] = heap[i];
        heap = increasedArr;
        size++;
        if(size>5)
        viewHeap(size-2);
    }
    
    void insert(int value){
        increaseSize();
        int i = size;
        heap[i] = value;
        while(i!=1 && heap[i]>heap[getParent(i)]){
            swap(i, getParent(i));
            i = getParent(i);
        }
    }
    void viewHeap(){//테스트용
        for(int i = 1; i<=size; i++)
        System.out.println(heap[i]);
    }
    void viewHeap(int value){//테스트용
        System.out.println(heap[value]);
    }
    

    private void shiftDown(int parent){ //heap을 만족하는 위치로 이동
        int largerChild; //자식중 큰 값
        boolean spotFound = false;
        while(parent*2<=size && !spotFound){ //범위 벗어나기 전까지, 제 위치 찾기 전까지
            if(heap[getLeftChild(parent)]<heap[getRightChild(parent)])
                largerChild = getRightChild(parent);
            else
                largerChild = getLeftChild(parent);
            if(heap[parent]<heap[largerChild]){ 
                swap(parent, largerChild);
                parent = largerChild;
            }
            else spotFound = true;
        }
    }

    

    public void makeHeap() { // 배열 -> 힙
        for(int i = size/2; i>=1; i++) //size: 마지막 값 위치
            shiftDown(i);
    }

    public void heapsort() {
        makeHeap();
        int initialSize = size; //heap의 본래 크기 (정렬 과정에서 size를 정렬 안된부분의 size로 임시로 줄임)
        while(size!=1){ 
            swap(1, size); //1번 값을 마지막 값과 swap,
            size--;         //뒤로 옮긴 값들은 제외하고
            shiftDown(1); //힙 성질 회복
        }
        size = initialSize;
    }
}



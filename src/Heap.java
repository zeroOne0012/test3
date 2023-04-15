public class Heap{
    int[] heap;
    int size;
    
    public Heap(){
        heap = new int[1]; //�ʱ� ũ�� 0
        size = heap.length-1;
    }
    public Heap(int[] heap){
        this.heap = heap;
        size = heap.length-1; //heap[0]�� ������� ����
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

    int getParent(int child){ //�θ� �ε��� get
        return child/2;
    }
    int getLeftChild(int parent){
        return parent*2;
    }
    int getRightChild(int parent){
        return parent*2+1;
    }

    private void increaseSize(){ //�迭 ������ 1 ����
        int[] increasedArr = new int[size+2]; //size: legth-1�̹Ƿ� +2
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
    void viewHeap(){//�׽�Ʈ��
        for(int i = 1; i<=size; i++)
        System.out.println(heap[i]);
    }
    void viewHeap(int value){//�׽�Ʈ��
        System.out.println(heap[value]);
    }
    

    private void shiftDown(int parent){ //heap�� �����ϴ� ��ġ�� �̵�
        int largerChild; //�ڽ��� ū ��
        boolean spotFound = false;
        while(parent*2<=size && !spotFound){ //���� ����� ������, �� ��ġ ã�� ������
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

    

    public void makeHeap() { // �迭 -> ��
        for(int i = size/2; i>=1; i++) //size: ������ �� ��ġ
            shiftDown(i);
    }

    public void heapsort() {
        makeHeap();
        int initialSize = size; //heap�� ���� ũ�� (���� �������� size�� ���� �ȵȺκ��� size�� �ӽ÷� ����)
        while(size!=1){ 
            swap(1, size); //1�� ���� ������ ���� swap,
            size--;         //�ڷ� �ű� ������ �����ϰ�
            shiftDown(1); //�� ���� ȸ��
        }
        size = initialSize;
    }
}



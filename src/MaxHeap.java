import java.util.Arrays;

public class MaxHeap implements Heap {
    int size;

    Integer[] data;

    public MaxHeap(int capacity) {
        data = new Integer[capacity];
        size = 0;
    }

    // build a heap based on data
    // to be implemented in O(nlogn)
    public void MaxHeapNLogN(Integer[] data) {
        for(int i =0; i < data.length; i++){
            add(data[i]);
        }
    }

    // build a heap based on data
    // to be implemented in O(n)
    public void MaxHeapN(Integer[] data) {
        this.size = data.length;
        for(int i = 0; i < data.length; i++){
            this.data[i] = data[i];
        }
        int index = data.length-1;
        for(int i = index; i > 0; i--){
            heapifyUp(i);
            if(leftChildIndex(i) < data.length && data[leftChildIndex(i)] > data[i]){
                heapifyUp(leftChildIndex(i));
            }
            if(rightChildIndex(i) < data.length && data[rightChildIndex(i)] > data[i]){
                heapifyUp(rightChildIndex(i));
            }
        }

    }

    private int parentIndex(int index) {
        return (index-1)/2;
    }
    private int leftChildIndex(int index){
        return (index*2) + 1;
    }
    private int rightChildIndex(int index){
        return (index*2) + 2;
    }
    private void swap(int index1, int index2){
        int temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }
    public void heapifyUp(int index){
        if(index != 0 && data[index] > data[parentIndex(index)]){
            swap(index, parentIndex(index));
            heapifyUp(parentIndex(index));
        }
    }
    // add an item to the heap
    public boolean add(Integer item) {
        data[size] = item;
        heapifyUp(size);
        size++;
        return true;
    }

    // return the max item in the heap
    public Integer get() {
        return data[0];
    }

    // remove the root item
    public void heapifyDown(int index){ // work on this
        int smalllestIndex = index;

        if(leftChildIndex(index) < size && data[leftChildIndex(index)] > data[index]){
            smalllestIndex = leftChildIndex(index);
        }
        if(rightChildIndex(index) < size && data[rightChildIndex(index)] > data[leftChildIndex(index)]){
            smalllestIndex = rightChildIndex(index);
        }

        if(smalllestIndex != index){
            swap(smalllestIndex, index);
            heapifyDown(smalllestIndex);
        }
    }
    public Integer pop() { // work on this
        int root = data[0];
        swap(0, size-1);
        data[size-1] = -1; // null value of -1 is used to avoid Null Pointer exception because I set the last element
        // as null before (to signal that the root was removed from heap)
        // assumes that -1 is never inputted into the heap
        size--;
        heapifyDown(0);
        return root;
    }
    public Integer[] bubbleSort(Integer[] data) {
        for(int i = 0; i < data.length-1; i++) {
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }
        }
        return data;
    }

    public boolean isValidHeap(){
        boolean isValidHeap = true;
        for(int i = 0; i < this.data.length; i++){
            if(this.rightChildIndex(i) >= this.data.length || this.leftChildIndex(i) >= this.data.length) {
                break;
            }
            if (this.data[i] < this.data[leftChildIndex(i)] || this.data[i] < this.data[rightChildIndex(i)]) {
                isValidHeap = false;
            }
        }
        return isValidHeap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaxHeap heap = (MaxHeap) o;

        return (this.size == heap.size) && this.isValidHeap() && heap.isValidHeap() &&
                Arrays.equals(bubbleSort(this.data), bubbleSort(heap.data));
    }


    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(7);
        Integer[] array = {2,5,6,8,8,6,7};
        heap.MaxHeapNLogN(array);
        System.out.println(Arrays.toString(heap.data));
        System.out.println(heap.pop());
        System.out.println(Arrays.toString(heap.data));
        System.out.println(heap.isValidHeap());
//        System.out.println(Arrays.toString(heap.data));

        MaxHeap heap2 = new MaxHeap(7);
        heap2.MaxHeapN(array);
        System.out.println(Arrays.toString(heap2.data));
        System.out.println(heap2.isValidHeap());

//        System.out.println(heap.equals(heap2));




    }
}

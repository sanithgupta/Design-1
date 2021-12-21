// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//Hashmap Implementation
//Time complexity: O(1)
//I am unable to run for test cases under 1000 as length of array
//Problems currently facing : without knowing the initial length , how do we know initialize? looking forward to ask the question in next class.


import java.util.Arrays;

class MyHashMap {
    int baseArray[][];
    int counter=0;
    public MyHashMap() {
        baseArray=new int[20][20];
        for(int [] row:baseArray)
            Arrays.fill(row,-1);
        System.out.println("elements after initialization of array ");
        printElements();
    }

    void  printElements(){
        System.out.println("inside print elements ");
        for(int i=0;i<20;i++){
            System.out.println("");
            for (int j=0;j<20;j++){
                System.out.print(baseArray[i][j] + " ");
            }
        }

    }

    private int hashFunction1(int key){
        return key%5;
    }
    private int hashFunction2(int key){
        return key/5;
    }

    public void put(int key, int value) {
        int baseIndex=hashFunction1(key);
        int secondIndex=hashFunction2(key);
        baseArray[secondIndex][baseIndex]=value;

        System.out.println("Successfully added the element");
        printElements();
    }

    public int get(int key) {
        int baseIndex=hashFunction1(key);
        int secondIndex=hashFunction2(key);
        return    baseArray[secondIndex][baseIndex];
    }

    public void remove(int key) {
        int baseIndex=hashFunction1(key);
        int secondIndex=hashFunction2(key);
        baseArray[secondIndex][baseIndex]=-1;
        printElements();
    }

    public static void main(String args[])
    {
        MyHashMap obj = new MyHashMap();
        obj.printElements();
        obj.put(1,20);
        obj.put(2,30);
        System.out.println("element at 1 = "+obj.get(1));
        System.out.println("element at 2 = "+obj.get(2));
        obj.remove(1);
        obj.printElements();

    }
}


//MinStack Implementation
//Time complexity : O(1) FOR GETTING MINIMUM ELEMENT , TOP ELEMENT; O(N) FOR PUSH AND POP
//executed in leetcode
class MinStack {

    int baseArray[];
    int minstackarray[];
    int topIndex;
    int minimumElement;

    public MinStack() {
        minimumElement=Integer.MAX_VALUE;
        topIndex=-1;
baseArray=new int[100001];
Arrays.fill(baseArray,-1);
    }

    public void push(int val) {
if(this.topIndex==-1){
    baseArray[this.topIndex+1]=val;
this.topIndex=this.topIndex+1;
}else{
    this.baseArray[this.topIndex+1]=val;
    this.topIndex=this.topIndex+1;
}
if(val<this.minimumElement){
    this.minimumElement=val;
}
        System.out.println("Push Successfull");
    }

    public void pop() {

 if(this.baseArray[this.topIndex]==this.minimumElement){
     this.resetMinimumElement();
 }

this.baseArray[this.topIndex]=Integer.MAX_VALUE;
this.topIndex=this.topIndex-1;
        System.out.println("Pop Successfull");

    }

    public int top() {
        System.out.println("inside top = "+ this.baseArray[this.topIndex]);
return this.baseArray[this.topIndex];
    }

    public int getMin() {
        System.out.println("inside getmin = "+this.minimumElement);
return this.minimumElement;
    }

    public void resetMinimumElement( ){
        this.minimumElement=Integer.MAX_VALUE;
        System.out.println("inside resetmin element");
        for (int i=0;i<this.topIndex;i++){
            if(this.minimumElement>baseArray[i]){
                System.out.println("inside condition min element");
                this.minimumElement=baseArray[i];
            }
        }
    }
    public static void main(String args[])
    {
        MinStack obj = new MinStack();
        obj.push(1);
        System.out.println("min element = "+ obj.getMin());
        obj.push(2);
        System.out.println("min element = "+ obj.getMin());
        obj.push(0);
        System.out.println("min element = "+ obj.getMin());
        obj.push(-1);
        System.out.println("min element = "+ obj.getMin());
        obj.pop();
        System.out.println("min element = "+ obj.getMin());
        System.out.println("top element = "+obj.top());
        obj.pop();
        System.out.println("min element = "+ obj.getMin());
        System.out.println("top element = " + obj.top());

    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

class Node{
    Object obj = null;
    Node next = null;
    Node(){
        obj = null;
    }

    Node(Object givenObject){
        obj = givenObject; 
    }

    public Node getNext(){
        return next;
    }

    public Object getObj(){
        return obj; 
    }

    public void addNext(Object nexObject){
        next = new Node(nexObject);
    }

    public void assignNext(Node nextNode){
        next = nextNode;
    }

    public void set(Object newObj){
        obj = newObj;
    }
}

public class Lista {
    Node head;
    int size;

    Lista(){
        size = 0;
        head = null;
    }

    public int getSize(){
        return size;
    }

    public Object getHead(){
        if(head == null) return null;
        return head.getObj();
    }

    public Object getLast(){
        return getNode(getSize() - 1).getObj();
    }

    public boolean goodIndex(int index){
        if(index >= getSize()) System.out.println("Index too big");
        return index < getSize();
    }

    public Node getNode(int index){
        if(!goodIndex(index)) return head;
        int n = 0;
        Node checkObj = head;
        while(checkObj.getNext() != null && n != index){
            checkObj = checkObj.getNext();
            n++;
        }
        return checkObj;
    }

    public Object getElement(int index){
        return getNode(index).getObj();
    }

    public void delElement(int index){
        if(!goodIndex(index)) System.out.println("nothing deleted");
        else if(index == 0){
            head = head.getNext();
            size--;
        }
        else{
            getNode(index - 1).assignNext((getNode(index + 1)));
            size--;
        }
    }

    public void delAll(){
        head = null;
        size = 0;
    }

    public void add(Object newObject){
        if(head == null) head = new Node(newObject);
        else getNode(getSize() - 1).addNext(newObject);
        size++;
    }

    @Override
    public String toString(){
        if(head != null){
            String res = "";
            for(int i = 0; i < getSize(); i++) res += (i) + " " + getNode(i).getObj().toString() + "\n";
            return res;
        }
        else return "List empty..";
    }
}

class ListaLiczb extends Lista{
    
    ListaLiczb(){
        super();
    }
    
    @Override
    public void add(Object newObject){
        if(newObject instanceof Liczba) super.add(newObject);
        else System.out.println("Not an instance of Liczba");
    }

    public Liczba getMin(){
        Liczba BestSoFar = getLiczba(0);
        for(int i = 0; i < getSize(); i++){
            Liczba cand = getLiczba(i);
            if(BestSoFar.toDouble() > cand.toDouble()) BestSoFar = cand;
        }
        return BestSoFar;
    } 

    public Liczba getMax(){
        Liczba BestSoFar = getLiczba(0);
        for(int i = 0; i < getSize(); i++){
            Liczba cand = getLiczba(i);
            if(BestSoFar.toDouble() < cand.toDouble()) BestSoFar = cand;
        }
        return BestSoFar;
    } 

    public double[] getTable(){
        double[] res = new double[getSize()];
        for(int i = 0; i < getSize(); i++) res[i] = getLiczba(i).toDouble();
        return res;
    }

    public double getAverage(){
        double avg = 0;
        for(var val: getTable()) avg += val;
        return avg/getSize();
    }

    public Liczba getLiczba(int index){
        return (Liczba)getElement(index);
    }

    public double getVal(int index){
        return getLiczba(index).toDouble();
    }

    public void sort(){
        for(int i = 1; i < getSize(); i++){
            Liczba key = getLiczba(i);            
            int j = i - 1;
            while(j >= 0 && getVal(j) > key.toDouble()){
                getNode(j + 1).set(getElement(j));
                j = j - 1;
            }
            getNode(j + 1).set(key);
        }
    }

}
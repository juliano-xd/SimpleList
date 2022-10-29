import java.util.Arrays;
import java.util.Iterator;

public class SimpleList<T> implements Iterable<T>{
    transient Object[] list;
    private int length;

    public int size(){ return length; }

    @SafeVarargs
    public SimpleList(T... preList){
        this.list   = preList;
        this.length = preList.length;
    }

    public SimpleList(){ this.list = new Object[this.length]; }

    private int increaseSize(){
        return ++this.length;
    }

    private int decreaseSize(){
        return --this.length;
    }

    public void add(T value){
        int size = this.increaseSize();
        Object[] list = Arrays.copyOf(this.list, size);
        list[size-1] = value;
        this.list = list;
    }

    public void remove(int index){
        this.verifyIndex(index);
        Object[] oldList = this.list;
        int newLength = this.decreaseSize();
        Object[] list = new Object[newLength];
        System.arraycopy(oldList, index + 1, oldList, index, newLength - index);
        System.arraycopy(oldList, 0, list, 0, newLength);
        this.list = list;
    }

    void verifyIndex(int index){
        if(index < 0 || index >= length)
            throw new IndexOutOfBoundsException(index);
    }

    @SuppressWarnings("unchecked")
    public T get(int index){
        this.verifyIndex(index);
        return (T) this.list[index];
    }

    public void revertPosition(int fromHere, int toHere) {
        if (fromHere != toHere) {
            T object1 = this.get(fromHere);
            T object2 = this.get(toHere);
            this.list[fromHere] = object2;
            this.list[toHere] = object1;
        }
    }

    public void replaceAll(T thisObj, T toThisObj){
        Object[] list = this.list;
        for (int i = 0; i < list.length; i++)
            if(list[i] == thisObj) list[i] = toThisObj;
    }

    public boolean contains(T value) {
        Object[] list = this.list;
        for (int i = 0; i < list.length; i++) 
            if(list[i] == value) return true;
        return false;
    }

    public boolean every(T value) {
        Object[] list = this.list;
        for (int i = 0; i < list.length; i++)
            if(list[i] != value) return false;
        return true;
    }

    private void clear() { this.list = new Object[this.length = 0];}

    @Override
    public String toString(){
        return Arrays.toString(list);
    }

    @Override
    public Iterator<T> iterator() {
        return new ITR();
    }

    class ITR implements Iterator<T>{
        int pointer;
        ITR(){}

        @Override
        public boolean hasNext() {
            return pointer != SimpleList.this.length;
        }

        @Override
        public T next() {
            return SimpleList.this.get(pointer++);
        }
    }
}
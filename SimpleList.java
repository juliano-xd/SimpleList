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

    private int increaseSize(int q){
        return this.length+=q;
    }

    private int decreaseSize(int q){
        return this.length-=q;
    }

    public void add(T value){
        int one = 1;
        int size = this.increaseSize(one);
        Object[] list = Arrays.copyOf(this.list, size);
        list[size-one] = value;
        this.list = list;
    }

    public void remove(int index){
        int oldSize = this.length;
        int one = 1;
        if(oldSize > one){
            int zero = 0;
            Object[] oldList = this.list;
            Object[] list = new Object[this.decreaseSize(one)];
            for (; zero < oldSize; zero+=one)
                list[zero >= index ? zero - one : zero] = oldList[zero];
            this.list = list;
        }else this.clear();
    }

    @SuppressWarnings("unchecked")
    public T get(int index){
        return (T) this.list[index];
    }

    public void revertPosition(int fromHere, int toHere) {
        final int size = this.length;
        final byte z = 0;
        if (fromHere != toHere && fromHere >= z && toHere >= z && fromHere < size && toHere < size) {
            final Object object1 = this.list[fromHere];
            final Object object2 = this.list[toHere];
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
            return (T) SimpleList.this.get(pointer++);
        }
    }
}
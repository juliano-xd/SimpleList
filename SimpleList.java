import java.util.Arrays;
import java.util.ListIterator;

@SuppressWarnings("unchecked")
public class SimpleList<T> implements Iterable<T>{
    private Object[] list;
    private int length;

    public int size(){ return this.length; }

    @SafeVarargs
    public SimpleList(T... preList){
        this.list   = preList;
        this.length = preList.length;
    }

    public SimpleList(){ this.list = new Object[this.length]; }

    public void add(T value){
        int oldSize = this.size();
        int newSize = oldSize + 1;
        Object[] list;
        System.arraycopy(this.list, 0, list = new Object[newSize], 0, oldSize);
        list[oldSize] = value;
        this.list = list;
        this.length = newSize;
    }

    public void remove(int index){
        this.verifyIndex(index);
        int newSize = this.size() -1;
        Object[] oldList = this.list;
        System.arraycopy(oldList ,index+1 ,oldList ,index ,newSize - index);
        Object[] list;
        System.arraycopy(oldList, 0, list = new Object[newSize], 0, newSize);
        this.list = list;
        this.length = newSize;
    }

    public void removeReferences(T value){
        Object[] list = new Object[this.size()-this.references(value)];
        int pointer = 0;
        for (T object : this)
            if(object != value)
                list[pointer++] = object;
        this.list = list;
        this.length = list.length;
    }

    void verifyIndex(int index){
        if(index < 0 || index >= length)
            throw new IndexOutOfBoundsException(index);
    }

    public T get(int index){
        this.verifyIndex(index);
        return (T) this.list[index];
    }

    public void set(int index,T value){
        this.verifyIndex(index);
        this.list[index] = value;
    }

    public int references(T value){
        int refs = 0;
        for (T o : this) if(o == value) refs++;
        return refs;
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
        for (T object : this) if(object == value) return true;
        return false;
    }

    public boolean every(T value) {
        Object[] list = this.list;
        for (int i = 0; i < list.length; i++)
            if(list[i] != value) return false;
        return true;
    }

    public void clear() { this.list = new Object[this.length = 0]; }
    
    public T[] toArray(){ return (T[]) this.list; }

    @Override
    public String toString(){ return Arrays.toString(list); }

    @Override
    public ListIterator<T> iterator() {
        return new ListIterator<T>() {
            int pointer;
            @Override
            public boolean hasNext() { return this.pointer < SimpleList.this.size(); }

            @Override
            public T next() {return SimpleList.this.get(this.pointer++);}

            @Override
            public boolean hasPrevious() { return this.pointer != 0; }

            @Override
            public T previous() { return SimpleList.this.get(this.pointer--); }

            @Override
            public int nextIndex() { return Math.min(this.pointer+1, SimpleList.this.size()); }

            @Override
            public int previousIndex() { return Math.max(this.pointer-1, 0); }

            @Override
            public void remove() { SimpleList.this.remove(this.pointer); }

            @Override
            public void set(T value) { SimpleList.this.set(this.pointer, value); }

            @Override
            public void add(T value) { SimpleList.this.add(value);}
        };
    }
}
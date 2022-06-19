public class ListTs{
    public Object[] list;
    public int length;

    public ListTs() { this.list = new Object[0]; }

    public void add(Object value) {
        final int one = 1;
        int z = this.length += one;
        Object[] newL = new Object[z];
        for (int i = 0; i != this.list.length; i++) newL[i] = this.list[i];
        newL[z - one] = value;
        this.list = newL;
    }

    public void remove(int index) {
        final int z = 0;
        if (index < z || index > this.length) return;
        final int one = 1;
        if(this.length == one && index == z) {clear(); return;}
        Object[] newL = new Object[this.length -= one];
        for (int i = z; i != this.list.length; i++) newL[i > index ? i - one : i] = this.list[i];
        this.list = newL;
    }

    public void remove(Object object) { remove(getIndexOfObject(object)); }

    public void revertPos(int fromHere, int toHere) {
        final int size = this.length;
        final int z = 0;
        if (fromHere != toHere && fromHere >= z && toHere >= z && fromHere < size && toHere < size) {
            final Object ob0 = this.list[fromHere];
            final Object ob1 = this.list[toHere];
            this.list[fromHere] = ob1;
            this.list[toHere] = ob0;
        }
    }

    public void clear() {this.list = new Object[this.length = 0];}

    public void addAll(ListTs values) { for (Object object : values.list) this.add(object); }

    public void list() {
        final int L = this.list.length;
        for (int c = 0; c < L; c++) {
            final int one = 1;
            for (int i = 0; i < L - one; i++) this.revertPos(i, this.list[i].hashCode() < this.list[i + one].hashCode() ? i : i + one);
        }
    }

    public void list(int form) {
        final int L = this.list.length;
        for (int c = 0; c < L; c++) {
            final int one = 1;
            for (int i = 0; i < L - one; i++) this.revertPos(i, this.list[i].hashCode() < this.list[i + one].hashCode() ? form == 0 ? i : i + one : form == 0 ? i + one : i);
        }
    }
    
    public void fill(int index, Object value) {
        for (int i = index; i < list.length; i++) this.list[i] = value;
    }

    public void replaceAll(Object thisObject, Object toThisObject) {
        for (int i = 0; i < this.length; i++) if(this.list[i] == thisObject) this.list[i] = toThisObject;
    }

    public int getIndexOfObject(Object value) {
        final Object[] iii = this.list;
        final int minusOne = -1;
        int i = iii.length;
        while (i != 0) if (value == iii[i += minusOne]) return i;
        return minusOne;
    }

    public int getLength() { return this.list.length; }

    public Object getInIndex(int index) { return this.list[index]; }
    
    public ListTs find(Object value) {
        ListTs finder = new ListTs();
        for (Object object : this.list) if (object.toString().contains(value.toString())) finder.add(object);
        return finder;
    }

    public ListTs subList(int start, int end) {
        ListTs newL = new ListTs();
        int i = start--;
        while (i++ != end) newL.add(this.list[i]);
        return newL;
    }

    public boolean contains(Object value) {
        for (Object object : this.list) if(object == value) return true;
        return false;
    }

    public boolean every(Object value) {
        for (Object object : this.list) if(object != value) return false;
        return true;
    }

    public String toString() {
        final int L = this.list.length-1;
        String xxx = "";
        for (int i = 0; i != L; i++) xxx+=this.list[i]+", ";
        return '['+xxx+this.list[L]+']';
    }

    public static ListTs toList(Object[] values) {
        ListTs newL = new ListTs();
        for (Object object : values) newL.add(object);
        return newL;
    }
}
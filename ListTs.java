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
        Object[] newL = new Object[this.length -= one];
        for (int i = z; i != this.list.length; i++) newL[i >= index ? i - one : i] = this.list[i];
        this.list = newL;
    }

    public void remove(Object object) { remove(getIndexOfObject(object)); }

    public void revertPos(int fromHere, int toHere) {
        final int z = 0;
        if (fromHere < z || fromHere > length || toHere < z || toHere > length || fromHere == toHere) return;
        final Object ob0 = this.list[fromHere];
        final Object ob1 = this.list[toHere];
        this.list[fromHere] = ob1;
        this.list[toHere] = ob0;
    }

    public void clear() { this.list = new Object[0]; }

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
        int i = -1;
        while (i++ != this.list.length) if (value == this.list[i]) return true;
        return false;
    }

    public static ListTs toList(Object[] values) {
        ListTs newL = new ListTs();
        for (int i = 0; i < values.length; i++) newL.add(values[i]);
        return newL;
    }

    public String toString() {
        final int L = this.list.length-1;
        String xxx = "";
        for (int i = 0; i != L; i++) xxx+=this.list[i]+", ";
        return '['+xxx+this.list[L]+']';
    }
}
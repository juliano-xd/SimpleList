public class ListTS {
    public Object[] list;
    public int length;

    public ListTS() {
        list = new Object[0];
    }

    public void add(Object value) {
        final int one = 1;
        int z = this.length += one;

        Object[] newL = new Object[z];
        for (int i = 0; i < list.length; i++) {
            newL[i] = list[i];
        }
        newL[z - one] = value;
        list = newL;
    }

    public void remove(int index) {
        final int z = 0;
        if (index < z || index > this.length)
            return;
        final int one = 1;
        Object[] newL = new Object[this.length -= one];
        for (int i = z; i < list.length; i++) {
            newL[i > index ? i - one : i] = list[i];
        }
        list = newL;
    }

    public void remove(Object object) {
        remove(getIndexOfObject(object));
    }

    public void revertPos(int fromHere, int toHere) {
        final int z = 0;
        if (fromHere < z || fromHere > length || toHere < z || toHere > length || fromHere == toHere)
            return;
        final Object ob0 = list[fromHere];
        final Object ob1 = list[toHere];
        list[fromHere] = ob1;
        list[toHere] = ob0;
    }

    public void clear() {
        list = new Object[0];
    }

    public void list() {
        for (int c = 0; c < list.length; c++) {
            final int one = 1;
            for (int i = 0; i < list.length - one; i++) {
                this.revertPos(i, list[i].hashCode() < list[i + one].hashCode() ? i : i + one);
            }
        }
    }

    public void list(int form) {
        for (int c = 0; c < list.length; c++) {
            final int one = 1;
            for (int i = 0; i < list.length - one; i++) {
                this.revertPos(i, list[i].hashCode() < list[i + one].hashCode() ? form == 0 ? i : i + one
                        : form == 0 ? i + one : i);
            }
        }
    }

    public int getIndexOfObject(Object value) {
        final Object[] iii = list;
        final int minusOne = -1;
        int i = iii.length;
        while (i != 0) if (value == iii[i += minusOne]) return i;
        return minusOne;
    }

    public int getLength() {
        return list.length;
    }

    public Object getInIndex(int index) {
        return list[index];
    }

    public ListTS find(Object value) { // SLOWER CODE
        ListTS finder = new ListTS();
        for (Object object : list) {
            if (object.toString().contains(value.toString()))
                finder.add(object);
        }
        return finder;
    }

    public ListTS subList(int start, int end) {
        ListTS newL = new ListTS();
        while (start != end) {
            newL.add(list[start]);
            start++;
        }
        return newL;
    }

    public static ListTS toList(Object[] values) {
        ListTS l = new ListTS();
        for (Object object : values) {
            l.add(object);
        }
        return l;
    }

    public boolean contains(Object value) {
        boolean exist = false;
        for (Object object : list) {
            if (object == value)
                exist = true;
            continue;
        }
        return exist;
    }
}

public class ListTS {
    public Object[] lista;

    public int length;

    public ListTS() {
        lista = new Object[0];
    }

    public void add(Object value) {
        final int one = 1;
        int z = this.length += one;

        Object[] nova = new Object[z];
        for (int i = 0; i < lista.length; i++) {
            nova[i] = lista[i];
        }
        nova[z - one] = value;
        lista = nova;
    }

    public void remove(int index) {
        final int z = 0;
        if (index < z || index > this.length)
            return;
        final int one = 1;
        Object[] nova = new Object[this.length -= one];
        for (int i = z; i < lista.length; i++) {
            nova[i > index ? i - one : i] = lista[i];
        }
        lista = nova;
    }

    public void remove(Object object) {
        remove(getIndexOfObject(object));
    }

    public ListTS find(Object value) {
        ListTS finder = new ListTS();
        for (Object object : lista) {
            if (object.toString().contains(value.toString()))
                finder.add(object);
        }
        return finder;
    }

    public int getIndexOfObject(Object value) {
        final Object[] iii = lista;
        int i = iii.length;
        final int minone = -1;
        while (i != 0) {
            if (iii[i += minone] == value)
                return i;
        }
        return minone;
    }

    public void revertPos(int fromHere, int toHere) {
        final int z = 0;
        if (fromHere < z || fromHere > length || toHere < z || toHere > length || fromHere == toHere)
            return;
        final Object ob0 = lista[fromHere];
        final Object ob1 = lista[toHere];
        lista[fromHere] = ob1;
        lista[toHere] = ob0;
    }

    public ListTS subList(int start, int end) {
        ListTS newL = new ListTS();
        while (start != end) {
            newL.add(lista[start]);
            start++;
        }
        return newL;
    }

    public void clear() {
        lista = new Object[0];
    }

    public int getLength() {
        return lista.length;
    }

    public Object getInIndex(int index) {
        return lista[index];
    }

    public void listar() {
        for (int c = 0; c < lista.length; c++) {
            final int one = 1;
            for (int i = 0; i < lista.length - one; i++) {
                this.revertPos(i, lista[i].hashCode() < lista[i + one].hashCode() ? i : i + one);
            }
        }
    }

    public void listar(int form) {
        for (int c = 0; c < lista.length; c++) {
            final int one = 1;
            for (int i = 0; i < lista.length - one; i++) {
                this.revertPos(i, lista[i].hashCode() < lista[i + one].hashCode() ? form == 0 ? i : i + one
                        : form == 0 ? i + one : i);
            }
        }
    }

    public static ListTS toList(Object[] values) {
        ListTS l = new ListTS();
        for (Object object : values) {
            l.add(object);
        }
        return l;
    }
}
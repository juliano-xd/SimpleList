# SimpleList<T>
#### Lista otimizada para uso em aparelhos Android, extremamente simples, leve, e direta ao ponto, com intuito de ser performático

#### Possíveis erros serão corrigidos nas próximas versões

*`Atualização 27/10/2022`*

- *Implementado interface `Iterable`*
- *Corrigido erro ao tentar remover o último índice da lista*
- *Menor código compilado*
  
*`Atualização 29/10/2022`*

- *Método `public void remove(int index)` mais rápido*
- *Novo método `void verifyLimit(int index)` verifica se int `index` está dentro do tamanho da lista, retornando `throw new IndexOutOfBoundsException(index)` caso não esteja*
- *Menor código compilado*

*`Novo 14/11/2022`*

- *Métodos `private int increaseSize()` e `private int decreaseSize()` removidos*
- *Corrigido possivel erro ao adicionar itens a lista*
- *Metodo `public Iterator iterator()` retorna agora `ListIterator<T>`*
- *Novo método `public T[] toArray()` retorna `this.list`*
- *Novo método `public int references(T value)` retorna a quantidade de referencias de `value` na lista*
- *Novo método `public void removeReferences(T value)` remove de forma rapida todos os objetos `value` da lista*
- *Novo método `public void set(int index, T value)` define objeto no indice `index` igual a `value`*
- *Método `private void clear()` agora `public void clear()`*
- *Código limpo*
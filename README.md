# SimpleList<T>
#### Lista otimizada para uso em aparelhos Android, extremamente simples, leve, e direta ao ponto, com intuito de ser performático

#### Possíveis erros serão corrigidos nas próximas versões

*`Atualização 27/10/2022`*

- *Implementado interface `Iterable`*
- *Corrigido erro ao tentar remover o último índice da lista*
- *Menor código compilado*
  
*`Novo 29/10/2022`*

- *Método `public void remove(int index)` mais rápido*
- *Novo método `void verifyLimit(int index)` que verifica se int `index` está dentro do tamanho da lista, retornando `throw new IndexOutOfBoundsException(index)` caso não esteja*
- *Menor código compilado*

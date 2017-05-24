import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


//List (similar to Haskell's []) Monad implementation as an adapter pattern:
class MonadicList implements Monad<MonadicList> {
  //Haskell return method:
  static MonadicList returnMonad(Object element) {
    List<Object> list = Arrays.asList(element);
    return new MonadicList(list);
  }

  //Haskell bind operator (>>=)
  @Override
  public MonadicList bind(ToMonadFunction<MonadicList> f) {
    MonadicList m = new MonadicList();
    for (Object value : list) {
      MonadicList result = f.execute(value);
      m.list.addAll(result.list);
    }
    return m;
  }

  //Plain Java stuff to make it run:
  public MonadicList(List<Object> fromList) {
    list = fromList;
  }
    
  public MonadicList() {
    list = new ArrayList<>();
  }

  @Override
  public String toString() {
    return list.toString();
  }

  private List<Object> list;
}

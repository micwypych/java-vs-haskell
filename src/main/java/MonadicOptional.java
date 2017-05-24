import java.util.Optional;


//Optional (similar to Haskell's Maybe) Monad implementation as an adapter pattern:
class MonadicOptional implements Monad<MonadicOptional> {
  //Haskell return method:
  static MonadicOptional returnMonad(Object element) {
    return new MonadicOptional(Optional.of(element));
  }

  //Haskell bind operator (>>=)
  @Override
  public MonadicOptional bind(ToMonadFunction<MonadicOptional> f) {
    //if Just value returns Just (f value)
    if (this.optional.isPresent()) {
      Object value = this.optional.get();
      return f.execute(value);
    //else if Nothing propagates Nothing
    } else {
      return this;
    }
  }

  //Plain Java stuff to make it run:
  public MonadicOptional(Optional<Object> fromOptional) {
    optional = fromOptional;
  }

  @Override
  public String toString() {
    return optional.toString();
  }

  private Optional<Object> optional;
}

//Haskell type class Monad definition:
interface Monad <M extends Monad<M>> {
  //Haskell Monda's return method (in Java 1) return is reserved keyword and 2) to get rid of 
  //first argument of type this one has to declare this method as static but then 
  //one cannot force to implement it in subclasses so just commented out
  //static <M> M returnMonad(Object element) { return ???; }


  //Haskell Monad's bind operator (>>=) (remember: in Java first argument is implicit this and second is
  //specified as an explicit lambda type)
  M bind(ToMonadFunction<M> f);

  //more functions like (>>), fail 
}

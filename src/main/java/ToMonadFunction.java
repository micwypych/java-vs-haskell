//type of function :: a -> m b
interface ToMonadFunction<Monad> {
  Monad execute(Object element);
}

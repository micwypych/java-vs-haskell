# java-vs-haskell
Hasekell for Java programmers tutorial by code samples

### Recursion

#### Hasekell implementation

```Haskell
showList' :: [Int] -> String 
showList' number 
   | length number == 0 = ""
   | otherwise = show (head number) ++ showList' (tail number)

showList :: [Int] -> String 
showList [] = ""
showList (n:numberButOne) = show n ++ showList numberButOne
```

#### Java implementation

[Recursive definition of showList together with definition of head and tail methods](./src/main/java/recursion/ListUtility.java)

#### Remarks
1. Two implementations with the same behaviour in Haskell are provided. The very first one is more similar to the one provided in Java
1. Apostrophe (') is a valid character in Haskell's literals
1. All the function names should start with non capital letter
1. Type specification of a Haskell function and its implementation is splitted but after type specification one has to provide definition immediately
1. Type specification of a Haskell function may be omitted and then compiler provides inferred one (but it's recommened to provide one oneself)
1. Haskell functions are pure and side effect free
1. The second implementation makes use of pattern matching to decompose input argument into more useful chunks. In the pattern matching expression one can use arbitrary value constructors of the provided value (list has two of them [] empty list constructor and (:) colon that pushes element on front of the list.


### Monad type class

#### Hasekell implementation
```Haskell
class Monad m where
  (>>=) :: m a -> (a -> m b) -> m b
  return :: a -> m a
```
#### Java implementation
[Monad definition](./src/main/java/Monad.java)

#### Remarks
1. Haskell return method is a method not a keyword like in Java
1. Haskell Monad type class requires type m which has kind ```* -> *``` it which corresponds to generic type in Java but:
1. Java implementation is far weaker typed than Haskell one (uses Object instead of generic type T)
1. One cannot specify class level methods in Java interface to force implementation of static method in subclasses
1. Java bind implementation takes first argument of Hasekell type ```m a``` as implicit argument ```this```
1. Java bind implementation takes second argument of Haskell type ```a -> m b``` explicitly as another [interface ToMonadFunction](./src/main/java/ToMonadFunction.java)

### Monad implementation of Maybe

#### Hasekell implementation
```Haskell
data Maybe x = Nothing | Just x

instance Monad Maybe where
  (>>=) :: Maybe a -> (a -> Maybe b) -> Maybe b
  Just x >>= f = Just $ f x
  Nothing >>= _ = Nothing
  
  return :: a -> Maybe a
  return x = Just x
```
#### Java implementation
[Monadic Optional definition](./src/main/java/MonadicOptional.java)

#### Remarks
1. The most similar type to Hasekell Maybe is Java 8 Optional class
1. Java implements return as returnMonad because return is reserved keyword
1. Java doesn't have pattern matching like Haskell therefore its implementation is just if else
1. Java implementation is reckless about copying object just by assignment of references (just didn't want to obfuscate code more)
1. Java simulates Haskell implementation as an Adapter pattern it is more similar I guess. In Haskell one can define instance of already existing types and therefore the only option in Java is to use Adapter in such cases.

### Monad implementation of List

#### Hasekell implementation
```Haskell
data [] a = [] | (:) a [a]
-- [a] is same as ([] a)

instance Monad [] where
  (>>=) :: [] a -> (a -> [] b) -> [] b
  xs >>= f = [y | x <- xs, y <- f x]
  
  return :: a -> [] a
  return x = [x]
```
#### Java implementation
[Monadic List definition](./src/main/java/MonadicList.java)

#### Remarks
1. A similar type to Hasekell list is Java ```List<T>``` interface but one has to remember that Haskell lists can be infinite
1. Haskell notation ```x <- monadic``` is generic way to take out something from inside of the Monad therefore if ```monadic :: [] Int``` then ```x :: Int```. This notation is available in the ```do``` notation but with extension of ```MonadComprehensions``` can be avaible in comprehension syntax as well. [list comprehension](https://wiki.haskell.org/List_comprehension) and [monad comprehension](https://ghc.haskell.org/trac/ghc/wiki/MonadComprehensions)
1. Actually the definition of Haskell bind operator is tautology so don't think about it too much...

### do notation
do notation in Haskell is just syntactic sugar and can be interpreted in means of simple lambdas and Mondad functions [desugar](http://www.haskellforall.com/2014/10/how-to-desugar-haskell-code.html)

#### Java implementation
[explicit bind notation](./src/main/java/Main.java)

### Unit testing

#### Hasekell implementation

#### Java implementation
[Method definition](./src/main/java/unittesting/UtilityFactorial.java)
[Tests in JUnit](./src/test/java/unittesting/UtilityFactorialJUnitTest.java)
[Tests in AssertJ](./src/test/java/unittesting/UtilityFactorialAssertJTest.java)

#### Remarks

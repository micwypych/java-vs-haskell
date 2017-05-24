class Main {
  public static void main(String[] args) {
    //Haskell's:
    // do i <- Nothing
    //    return $ i + 1
    MonadicOptional nothing = new MonadicOptional(Optional.<Object>empty());
    MonadicOptional m = nothing.bind( i -> { return MonadicOptional.returnMonad(((Integer)i)+1); });
    System.out.println(m);

    //Haskell's:
    // do i <- Just 2
    //    return $ i + 1
    MonadicOptional sth = new MonadicOptional(Optional.of(2));
    MonadicOptional m2 = sth.bind( i -> { return MonadicOptional.returnMonad(((Integer)i)+1); });
    System.out.println(m2);

    //Haskell's:
    // do i <- Just 2
    //    return $ show i ++ "s"
    MonadicOptional m3 = sth.bind( i -> { return MonadicOptional.returnMonad(i.toString()+"s"); });
    System.out.println(m3);


    //Haskell's:
    // do i <- []
    //    return $ i + 1
    MonadicList empty = new MonadicList(Collections.emptyList());
    MonadicList m4 = empty.bind( i -> { return MonadicList.returnMonad(((Integer)i)+1); });
    System.out.println(m4);

    //Haskell's:
    // do i <- [2, 6, 7]
    //    return $ i + 1
    MonadicList sth2 = new MonadicList(Arrays.asList(2, 6, 7));
    MonadicList m5 = sth2.bind( i -> { return MonadicList.returnMonad(((Integer)i)+1); });
    System.out.println(m5);

    //Haskell's:
    // do i <- [2, 6, 7]
    //    return $ show i ++ "s"
    MonadicList m6 = sth2.bind( i -> { return MonadicList.returnMonad(i.toString()+"s"); });
    System.out.println(m6);

    //Haskell's:
    // do i <- [2, 6, 7]
    //    [i,i,i]
    MonadicList m7 = sth2.bind( i -> { return new MonadicList(Arrays.asList(i,i,i)); });
    System.out.println(m7);
  }

}

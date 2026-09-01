       +-------------------+
       |      Expr         |
       |  + toString()     |
       +-------------------+
                ^
                |
    +---------------------+
    |   BinaryExpr        |   (abstrakt)
    |  - left: Expr       |
    |  - right: Expr      |
    |  # getSymbol():String|
    |  + toString()       |
    +---------------------+
          ^         ^
          |         |
   +-------------+  +-------------+
   |    Add      |  |    Mul      |
   | getSymbol()->"+" getSymbol()->"*"
   +-------------+  +-------------+

#lang racket
(define recList '((2 10 7 7) (6 8 12 5) (1 4 6 1) (5 4 11 1)))
(define test '(1 2 3 4))
(define test2 '(5 6 7 8))

(define (main mainList) ;the main function for the program
  (if (or (equal? (length mainList) 0) (equal? (length (rest mainList)) 0)) ;test if the first rectangle is empty or the list is empty
      '()
      (if (or
           (doOverlapLeft (first mainList) (first(rest mainList))) ;test if the rectangles are to the left of the other rectangle
           (doOverlapAbove (first mainList) (first(rest mainList))) ;test if the rectangles are above the other
          )
          (main (rest mainList));if the rectangles fail either of the test, it recurses to new rectangles
          (append
           (list (first mainList)) ;appends the fiorst rectangle that overlapped
           (list (first(rest mainList))) ;appends the second rectangle that overlapped
           (main (rest mainList)) ;recurces to test other rectangles
          )
      )
  )
)

(define (doOverlapLeft rect1 rect2) ;function to perform boolean test if either pass the left test
  (if (or
       (equal? (length rect1) 0)
       (equal? (length rect2) 0)
      )
      #t
      (if (or
           (checkLeft (firstX rect1) (secondX rect2)) ;runs the check left function to test x values
           (checkLeft (firstX rect2) (secondX rect1))
          )
          #t
          #f
      )
  )
)

(define (doOverlapAbove rect1 rect2) ;function to perform boolean test if either pass the above test
  (if (or
       (equal? (length rect1) 0)
       (equal? (length rect2) 0)
      )
      #t
      (if (or
           (checkAbove (topY rect1) (bottomY rect2)) ;runs the check above function to test y values
           (checkAbove (topY rect2) (bottomY rect1))
          )
          #t
          #f
      )
  )
)

(define (checkLeft x1 x2) ;the function to test if the the first x value is greater then the second
  (if (> x1 x2)
      #t
      #f
  )
)

(define (checkAbove y1 y2) ;the function to tif the first y value is less than the second
  (if (< y1 y2)
      #t
      #f
  )
)

(define (firstX rect) ;gets the first x value of a rectangle 
  (first rect)
)

(define (secondX rect) ;gets the second x value of the a rectangle
  (first(rest(rest rect)))
)

(define (topY rect) ;gets the first y value of a rectangle
  (first(rest rect))
)

(define (bottomY rect) ;gets the second y value of a rectangle
  (first(rest(rest(rest rect))))
)

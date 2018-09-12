#lang racket
(define l1 '(1 2 3 4 5))
(define l2 '(3 5 6 7 8))
(define l3 '(3 5 7 2 4))
(define l4 '(7 2 0))

(define (compList op list1 list2)
  (if (or (equal? (length list1) 0) (equal? (length list2) 0))
      '()
       (append
        (list (op (car list1) (car list2)))
        (compList op (cdr list1) (cdr list2))
       )
  )
)

(define (getSmallest i j)
  (if (< i j)
      i
      j
  )
)

(define (getLargest i j)
 (if (> i j)
     i
     j
 )
)

(define (isEqual i j)
  (if (equal? i j)
      #t
      #f
  )    
)

(define (foo n)
  (let
      (
       [x 45]
       [y 22]
      )
    (+ n x y)
  )
)

(define (foo2 n)
  (let*
      (
       [x n]
       [y (+ x 5)]
      )
    (+ n x y)
  )
)


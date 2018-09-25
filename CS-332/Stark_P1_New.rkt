#lang racket
(define rectList '((2 10 7 7) (6 8 12 5) (1 4 6 1) (5 4 11 1)))
(define test '(1 2 3 4))

(define (main mainList)
  (if (equal? mainList 0)
      '()
      (checkIntersection (first mainList) (rest mainList))
  )
)

(define (checkIntersection rect1 rectList)
  '()
)

(define (firstX rect)
  (first rect)
)

(define (secondX rect)
  (first(rest(rest rect)))
)

(define (topY rect)
  (first(rest rect))
)
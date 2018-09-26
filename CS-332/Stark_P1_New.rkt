#lang racket
(define recList '((2 10 7 7) (6 8 12 5) (1 4 6 1) (5 4 11 1)))
(define test '(1 2 3 4))

(define (main mainList)
  (if (equal? mainList 0)
      '()
      (checkIntersection (first mainList) (rest mainList))
  )
)

(define (checkIntersection rect1 rectList)
  (if (equal? (length rect1) 0)
      '()
      (if (or (equal? (checkLeft (firstX rect1) (firstX (first rectList))) #f) (equal? (checkLeft (secondX (first rectList)) (secondX rect1)) #f))
          '()
          (if (or (equal? (checkAbove  (topY rect1) (bottomY (first rectList))) #f) (equal? (checkAbove (topY (first rectList)) (bottomY rect1)) #f))
              
          )
      )
  )
)

(define (checkLeft x1 x2)
  (if (> x1 x2)
      #f
      #t
  )
)

(define (checkAbove y1 y2)
  (if (< y1 y2)
      #f
      #t
  )
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

(define (bottomY rect)
  (first(rest(rest(rest rect))))
)
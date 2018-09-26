#lang racket
(define recList '((2 10 7 7) (6 8 12 5) (1 4 6 1) (5 4 11 1)))
(define test '(1 2 3 4))

(define (main mainList)
  (if (equal? (length mainList) 1)
      '()
      (checkIntersection (first mainList) (first(rest mainList)) (rest mainList))
  )
)

(define (checkIntersection rect1 rect2 rectList)
  (if (or (equal? (length rect1) 0) (equal? (length rectList) 0))
      '()
      (if (or
           (equal? (checkLeft (firstX rect1) (secondX rect2)) "true")
           (equal? (checkLeft (firstX rect2) (secondX rect1)) "true")
           )
          (checkIntersection rect1 (first rectList) (rest rectList))
          (if (or
               (equal? (checkAbove (topY rect1) (bottomY (first rectList)) ) "true")
               (equal? (checkAbove (topY (first rectList)) (bottomY rect1) ) "true")
              )
              (checkIntersection rect1 (first rectList) (rest rectList))
              (append
               (list rect1)
               (list rect2)
               ;(main (rest rectList))
              )
          )
      )
  )
)

(define (getRest rectList)
  (rest rectList)
)

(define (checkLeft x1 x2)
  (if (> x1 x2)
      "true"
      "false"
  )
)

(define (checkAbove y1 y2)
  (if (< y1 y2)
      "true"
      "false"
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
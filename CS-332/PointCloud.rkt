#lang racket

(define cloud '( (1 3) (6 4) (2 1) (4 0) (2 0)))


(define (findBounds pointCloud)
  (car
   (cdr
    (car pointCloud)
   )
  )
)

(define (splitList pointList pos)
  (if (equal? pos 1)
      (1)
      (2)
  )
)

(define (getMax pointList)
  (if (> (length pointList) 1)
      (if (> (car pointList) (getMax(cdr pointList)))
       (car pointList)
       (getMax (cdr pointList)))
      (car pointList)
  )
)
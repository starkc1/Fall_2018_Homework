#lang racket
(define l1 '(1 2 3 4 5 2 3 4 5 6 7 8 2 3 4 5))
(define l2 '(34 65 23 13 5 1 3 5 7))

(define (icount l item)
  (
   if (equal? 1 (length l))
      (
       if (equal? item (car l))
          1
          0
      )
      (
       if (equal? item (car l))
          (+ 1 (icount (cdr l) item))
          (+ 0 (icount (cdr l) item))
      )
  )
)

(define (getmax l)
  (
   if (> (length l) 1)
      (
       if (> (car l) (getmax (cdr l)))
          (car l)
          (getmax (cdr l))
      )
      (car l)
  )
)

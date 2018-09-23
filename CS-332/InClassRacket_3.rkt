#lang racket
(define (isFunctionalGood answer)
  (if (equal? "yes" answer)
   "no it is not"
   "correct"
  )
)

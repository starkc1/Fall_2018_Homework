#lang racket
(define testTrueArray '("a" "b"))
(define testFalseArray '("a" "c"))

(define (FSM testString)
  (if (equal? (string-length testString) 0)
      "Not Accepted"
      (if (testCharacters (string->list testString))
       "False"
       "True"
      )
  )
)

(define (testCharacters stringList)
  (if (equal? (length stringList) 0)
      (if (or (string=? (first stringList) "a") (string=? (first stringList) "b"))
          #f
          (testCharacters (rest stringList))
      )
      #t
  )
)


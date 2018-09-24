#lang racket

(define recList '((3 12 9 5) (7 7 12 2) (8 11 12 9) (12 5 16 3)))
(define test '(1 2 3 4))

(define (checkIntersect rec1 rec2)
  (if (or (equal? (length rec1) 0) (equal? (length rec2) 0))
      '()
      (if (or (> (getX (getFirstCoord rec1)) (getX (getSecondCoord (first rec2)))) (> (getX (getSecondCoord (first rec2))) (getX (getSecondCoord rec1))))
          '()
          (if (or (< (getY (getFirstCoord rec1)) (getY (getSecondCoord (first rec2)))) (< (getY (getSecondCoord (first rec2))) (getY (getSecondCoord rec1))))
              '()
              (append
               (list rec1)
               (list rec2)
               (intersectTest (rest rec2))
               )
          )
      )
  )
)

(define (getFirstCoord points)
  (if (equal? (length points) 0)
      "ERROR: No Points In List"
      (append
       (list (first points))
       (list (first (rest points)))
      )
  )
)

(define (getX coord)
  (if (equal? (length coord) 0)
      "ERROR: Coord is Empty"
      (first coord)
  )
)

(define (getSecondCoord points)
  (if (equal? (length points) 0)
      "ERROR: No Points In List"
      (append
       (list (first (rest (rest test))))
       (list (first (rest (rest (rest test)))))
      )
  )
)

(define (getY coord)
  (if (equal? (length coord) 0)
      "ERROR: Coord is Empty"
      (append
       (first (rest coord))
      )
  )
)

(define (intersectTest listMain)
  (if (equal? (length listMain) 0)
      "ERROR: Empty List Entered"
      (checkIntersect (first listMain) (rest listMain))
  )
)
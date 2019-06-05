{:name        "TAI Demo Part 1"

 :description "Part 1 of the TAI Demo"

 :date        "Tuesday June 4, 2019"

 :assumptions {; Axiom 1: Defining Glowering
                Ax1 (forall [x y]
                            (iff (G x y)
                                 (and (Larger x y) (Adj x y))))

                ;; Axiom 2: Adjacency is commutative
                Ax2 (forall [x y] (iff (Adj x y) (Adj y x)))

                ;; Axiom 3: Larger is not commutative
                Ax3 (forall [x y] (iff (Larger x y) (not (Larger y x))))

                ;; Axiom 4: Adjacency
                Ax4 (forall [x y]
                            (iff (Adj x y)
                                 (exits [p q r s]
                                        (and (= (pos x) (coord p q))
                                             (= (pos y) (coord r s)))
                                        (or (and (= p r) (= q (+ 1 s)))
                                            (and (= p r) (= s (+ 1 q)))
                                            (and (= q s) (= p (+ 1 r)))
                                            (and (= q s) (= r (+ 1 p)))
                                            (and (= q (+ 1 s)) (= r (+ 1 p)))
                                            (and (= s (+ 1 q)) (= r (+ 1 p)))))))

                ;; Axiom 5 things with different ids are different
                Ax5  (forall [id1 id2]
                            (iff (= id1 id2)
                                 (= (thing id1) (thing i2))))

                ;; premises describing the world
                P1  (C (thing 1))
                P2  (C (thing 2))
                P3  (C (thing 3))
                P4  (T (thing 4))

                ;; Arches
                P5  (A (thing 5))
                P6  (A (thing 6))

                ;; Premises for the cubes and the triangular prism
                P7  (Larger (thing 1) (thing 4))
                P8  (Larger (thing 2) (thing 4))
                P9  (Larger (thing 3) (thing 4))

                P10  (= (pos (thing 1)) (coord 5 3))
                P11  (= (pos (thing 2)) (coord 6 4))
                P12  (= (pos (thing 3)) (coord 5 5))
                P13  (= (pos (thing 4)) (coord 5 4))

                P14 (Larger (thing 2) (thing 4))
                P15 (Larger (thing 3) (thing 4))

                ;; Premises for the arches
                P16  (= (pos (thing 5)) (coord 4 3))
                P17  (= (pos (thing 6)) (coord 4 5))

                P18 (Larger (thing 4) (thing 5))
                P19 (Larger (thing 4) (thing 6))

                ;;; Premises for the cylinders
                P20  (Cb (thing 7))
                P21  (Cb (thing 8))
                P22  (Cb (thing 9))

                P23  (= (pos (thing 7)) (coord 4 4))
                P24  (= (pos (thing 8)) (coord 6 3))
                P25  (= (pos (thing 9)) (coord 6 5))

                P26 (Larger (thing 4) (thing 7))
                P27 (Larger (thing 4) (thing 8))
                P28 (Larger (thing 4) (thing 9))


                }

 :goal        (forall [x y z zz]
                      (if (and (and (not (= x y)) (not (= y z)) (not (= x z))) (and (C x) (C y) (C z))
                           (T zz)
                           (exists [w1 w2] (and (not (= w1 w2)) (A w1) (A w2) (G zz w1) (G zz w2)))
                           (forall
                            [u1 u2 u3]
                            (if (and (G zz u1) (G zz u2) (G zz u3)
                                     (Cb u1) (Cb u2) (Cb u3))
                              (forall [u]
                                      (if (and (G zz u) (Cb u))
                                        (or (= u u1) (= u u2) (= u u3)))))))
                        (and (G x zz)
                             (G y zz)
                             (G z zz))))}





{:name        "Tentacular AI Formal Model Demo Part 2"

 :description "Part 2 of the TAI Demo"

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

                ;; Axiom 6

                Ax6 (Knows! TAI (forall [id1 id2]
                                    (if (obscures (thing id1) (thing id2) r2)
                                      (not (Perceives! r2 (R2 (thing id2)))))))



                ;; Axiom 7
                  Ax7 (Knows! TAI (forall [id1 id2 agent y x1 x2 x3]
                                      (iff (and (= (pos (thing id1)) (coord x3 y))
                                               (= (pos (thing id2)) (coord x2 y))
                                               (= (pos agent)       (coord x1 y))
                                               (< x1 x2)
                                               (< x1 x3)
                                               (< x2 x3)
                                               (Larger (thing id1) (thing id2))
                                             )
                                        (obscures (thing id1) (thing id2) agent))))


                ;;;
                P0 (Common!  (and (< 5 6)(< 2 5)(< 2 6)))
                P14 (Knows! TAI (Larger (thing 2) (thing 4)))

                ;; Premise 1



                P2  (Knows! TAI (= (pos (thing 2)) (coord 6 4)))
                P4  (Knows! TAI (= (pos (thing 4)) (coord 5 6)))
                P5  (Knows! TAI (= (pos r2) (coord 2 4)))


                }

 :goal        (Knows! TAI (not (obscures (thing 2) (thing 4)  r2)))
 }







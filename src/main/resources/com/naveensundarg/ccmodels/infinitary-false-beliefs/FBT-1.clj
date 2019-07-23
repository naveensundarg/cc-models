{:name        "Level 1: False Belief Task "

 :description "Agent a1 puts an object o into b1 in plain view of a2.
               Agent a2 then leaves, and in the absence of a2, a1 moves o
               from b1 into b2 ; this movement isn’t perceived by a2 . Agent
               a2 now returns, and a is asked by the experimenter e: “If a2
               desires to retrieve o, which box will a2 look in?” If younger
               than four or five, a will reply “In b ” (which of course fails 2
               the task); after this age subjects respond with the correct “In b1.”

               Level1 Belief: a1 believes a2 believes o is in b1.
               "

 :date        "Monday July 22, 2019"

 :assumptions {
                :P1 (Perceives! a1 t1 (Perceives! a2 t1 (holds (In o b1) t1)))

                :P2 (Believes! a1 t2 (Believes! a2 t2 (not (exists [?e] (terminates ?e (In o b1))))))

                :P3 (holds (In o b1) t1)

                :C1 (Common! t0 (forall [?f ?t2 ?t2]
                                        (if (and (not (exists [?e] (terminates ?e ?f))) (holds ?f ?t1) (< ?t1 ?t2))
                                          (holds ?f ?t2))))

                :C2 (Common! t0 (and (< t1 t2) (< t2 t3) (< t1 t3)))
                }

 :goal        (Believes! a1 t3 (Believes! a2 t3 (holds (In o b1) t3)))}



################################################################
# factorialMem.asm
# Computes teh factorial of non-negative integer
#
#Register Usage:
#$to - number
#$t1 - product
#$t2 - counter
################################################################
.data                             # segundo segmento
num:      .word 5
fact:     .word 0                 # es como inicializar dos variables en 0


################################################################
# Text(code) segment
################################################################
.text
.globl main                        # significa public como en java - public main

main: 
          lw $t0, num              # load number from memory
          li $t1, 1                # initialize product
          li $t2, 1                # initialize counter
          
test_lp:  bgt $t2, $t0, end_lp    # exit loop when counter > number bgt - es igaul branch gereater
          mul $t1, $t1, $t2       # set product to product & counter    
          add $t2, $t2, 1         # iincrement counter by one - no se puede itercambiar pq en src1 no se puede guardar literal
          b test_lp               # go back to loop test       
          
           
            
end_lp:  sw $t1, fact        # stores product memory

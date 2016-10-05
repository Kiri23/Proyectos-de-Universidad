#####################################################################
# dotproduct.asm
# By Christian Nogueras
# Computes the dot product of two vector
# 
#
# Register use:
# $t0 - counter
# $t1 - result of the multiplication
# $t2 - acum
# $t3 - array length
# $t4 - pointer to current element
# $t5 - current element
# $v0 - system call code
# $a0 - system call argument
#####################################################################

#####################################################################
# Data Segment
#####################################################################
.data
len :      .word 5
vectA :     .word 1, 2, 3, -4, 5  
vectB :     .word 9, -8, 7, 6, 5
  
dot_msg:  .asciiz "Dot Produt of Vector A and Vectro B: "


#####################################################################
# Text (Code) Segment
#####################################################################
.text
.globl main

main:
          li $t0, 0               # initialize counter
          li $t1, 0               # initialize the product
          li $t2, 0               # initialize acum
          
          lw $t3, len             # load array length from memory
          la $t4, vectA           # point to first element
          la $t6, vectB
          
test_lp:  beq $t0, $t3, end_lp    # exit loop when counter == length
          lw $t5, ($t4)           # load element from memory
          lw $t7, ($t6)
          
          mul $t1, $t5, $t7       # multiply vectA and vectB and store the product in t1
          add $t2, $t2, $t1       # acummulate the total of the products
          
          b end_if                 # go to end if reacht the end of the list
          
          
end_if:   add $t0, $t0, 1         # increment counter by 1
          add $t4, $t4, 4         # point to next element
          add $t6, $t6, 4
          b test_lp               # go back to loop test

end_lp:   li $v0, 4               # set system call code to print string
          la $a0, dot_msg         # load string base address
          syscall                 # print sum_positives message
          
          li $v0, 1               # set system call code to print integer
          move $a0, $t2           # prepare integer for printing
          syscall                 # print sum_positives
                      
                      
          li $v0, 10              # set system call code to exit program
          syscall                 # exit program

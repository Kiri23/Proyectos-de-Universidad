#####################################################################
# factorialIO.asm
# By Antonio F. Huertas
# Computes the factorial of a non-negative integer.
# NOTE: This version uses system calls for input/output and memory
# for prompts and messages.
#
# Register use:
# $t0 - number
# $t1 - product
# $t2 - counter
# $v0 - system call code value
# $a0 - system call argument
#####################################################################

#####################################################################
# Data Segment
#####################################################################
.data
prompt:   .asciiz "Enter non-negative integer: "
fact_msg: .asciiz "Factorial of number is "
err_msg:  .asciiz "Error! Negative number."

#####################################################################
# Text (Code) Segment
#####################################################################
.text
.globl main

main:
          li $v0, 4               # set system call code to print string
          la $a0, prompt          # load string base address
          syscall                 # print prompt message
          
          li $v0, 5               # set system call code to read integer
          syscall                 # read integer
          
          blt $v0, $zero, error   # go to error label if number < 0
          
          move $t0, $v0           # initialize number
          li $t1, 1               # initialize product
          li $t2, 1               # initialize counter
          
test_lp:  bgt $t2, $t0, end_lp    # exit loop when counter > number
          mul $t1, $t1, $t2       # set product to product * counter
          add $t2, $t2, 1         # increment counter by 1
          b test_lp               # go back to loop test
          
end_lp:   li $v0, 4               # set system call code to print string
          la $a0, fact_msg        # load string base address
          syscall                 # print factorial message
          
          li $v0, 1               # set system call code to print integer
          move $a0, $t1           # prepare integer for printing
          syscall                 # print factorial
          
          b exit                  # exit program

error:    li $v0, 4               # set system call code to print string
          la $a0, err_msg         # load string base address
          syscall                 # print error message
          
exit:     li $v0, 10              # set system call code to exit program
          syscall                 # exit program
          
#####################################################################
# strlenIO.asm
# By Antonio F. Huertas
# Computes the length of a string entered by the user.
#
# Register use:
# $t0 - counter
# $t1 - pointer to current characer
# $t2 - current character (in low order byte)
# $v0 - system call code value
# $a0 - system call argument
#####################################################################

#####################################################################
# Data Segment
#####################################################################
.data
prompt:   .asciiz "Enter string: "
prompt2:  .asciiz "the result is " 
str:      .space 81             # una string de 80 espacio y el 0 que es 81
len_msg:  .asciiz "Length of string is "
result:   .space 81

#####################################################################
# Text (Code) Segment
#####################################################################
.text
.globl main

main:
          li $v0, 4               # set system call code to print string
          la $a0, prompt          # load string base address
          syscall                 # print prompt message

          li $v0, 8               # set system call code to read string
          la $a0, str             # load string base address
          li $a1, 81              # load buffer length
          syscall                 # read string
          
          
          li $t0, 0               # initialize counter
          move $t1, $a0           # point to first character un puntador que apunta a la direcion de la stirng

next_ch:  lb $t2, ($t1)           # load characer from memory - en ti no esta el valor - en ti esta la direcion del valor 

          beq $t2, $zero, end_str # exit loop when character == '\0' - si el caracter es 0 termine
                                  # increment counter by 1
          #
          sub $t2, $t2, 32
          sb $t2, ($t1) 
       
          #
         
          
          add $t1, $t1, 1         # point to next character
          add $t0, $t0, 1   
          
          b next_ch               # load next character

end_str:       # discount '\n' from counter - es el final cuando se acabbbo cuanod da 0

	  
	  sub $t1, $t1, $t0
	 
          li $v0, 4 
          la $a0, ($t1)              # set system call code to print string
          syscall                 # print length message
          
          
          li $v0, 10              # set system call code to exit program
          syscall                 # exit program

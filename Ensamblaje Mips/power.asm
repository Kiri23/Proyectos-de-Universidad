#####################################################################
# power.asm
# By Christian Nogueras Rosado
# Calcula el exponente de un numero
#
#
#Register use ; 
# $t1 - base
# $t2 - exponent
# $t3 - acum
# $t4 - counter
# $v0 - system call code value
# $a0 - system call argument
#####################################################################
#####################################################################

#####################################################################
# Data Segment
#####################################################################
.data 
prompt1:  .asciiz "Enter the base number "
prompt2:  .asciiz "Enter the exponential "
power_msg:  .asciiz " The result is "
error_msg:  .asciiz "Error! Invalid exponent."

#####################################################################
# Text (Code) Segment
#####################################################################
.text
.globl main

main: 
	li $v0, 4                 # set system call code to print string
	la $a0, prompt1           # load string base address
	syscall                   # print prompt1 message
	
	li $v0, 5                 # set system call code to read integer
	syscall                   # read integer
	 
	move $t1, $v0             # move base integer to register t1
	
	li $v0, 4                  # set system call code to print string
	la $a0, prompt2            # load string base address
	syscall                    # print prompt2 message
	
	li $v0, 5                  # set system call code to read integer
	syscall                    # read integer
	
	bltz $v0, error            # go to error if the exponent is less than zero 
	bgt $v0, 30, error         # go to error if the exponent if higher than 30
	
	
	 
	move $t2, $v0              # move exponet integer  to register t2  
	
	li $t3, 1                  #initialize acum
	li $t4, 1                  #initialize counter
	
operation: bgt $t4, $t2,end_lp     # test if the counter is less than exponent. if not go to end_lp
	   mul $t3, $t3, $t1       # multiply acum * base and store it in acum
	   add $t4,$t4, 1          # increment counter by 1
	   b operation             # test again 
	  	   
end_lp: li, $v0, 4                 # set system call code to print string                
	la, $a0, power_msg         # load string base addres
	syscall                    # print power message
	
	li, $v0, 1                 # set system call code to print integer 
	move, $a0, $t3             # move accum to register $a0
	syscall                    # print accumulator 
	b exit                     # go to exit
	
					
error:  li, $v0, 4                # set system call code to primt a string
        la, $a0, error_msg        # load string base address
        syscall                   # print error message
        
          
exit: li $v0, 10              # set system call code to exit program
      syscall                 # exit the program
             
	 
	   
	    














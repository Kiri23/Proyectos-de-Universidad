#####################################################################
# togglecase.asm
# By Christian Nogueras Rosado
# Convert the character of a string for lowercase to uppercase or uppercase to lowercase
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
str:      .space 81             
prompt2:  .asciiz "the result is " 


#####################################################################
# Text (Code) Segment
#####################################################################
.text
.globl main

main:
          li $v0, 4                         # set system call code to print string
          la $a0, prompt                    # load string base address
          syscall                           # print prompt message

          li $v0, 8                         # set system call code to read string
          la $a0, str                       # load string base address
          li $a1, 81                        # load buffer length
          syscall                           # read string
          
          
          li $t0, 0                         # initialize counter
          move $t1, $a0                     # point to first character un puntador que apunta a la direcion de la stirng

next_ch:  
          lb $t2, ($t1)                     # load characer from memory  
          beq $t2, $zero, end_str           # exit loop when character == '\0' 
          blt $t2, 65, ignoreCharacter      # if character is less than 65 (these are number and symbols) ignore these
          blt $t2, 91, lowerCaseCharacter   # if character is less than 91 ( these are UpperCase) change to lower
          bgt $t2, 96, upperCaseCharacter   # if character is greater than 96 ( these are LowerCase) change to upper                    
          
          
     
       
lowerCaseCharacter: 
	add $t2, $t2, 32        # substract 32 to the Ascii code of the character
        sb $t2, ($t1)           # store the new ASCII code 
        add $t1, $t1, 1         # point to next character
        add $t0, $t0, 1         # sum 1 to counter
        b next_ch	        # go to the next character
		       
upperCaseCharacter: 
	sub $t2, $t2, 32        # substract 32 to the Ascii code of the character
        sb $t2, ($t1)           # store the new ASCII code 
        add $t1, $t1, 1         # point to next character
        add $t0, $t0, 1         # sum 1 to counter
        b next_ch               # got to the next character
		       		       
          
ignoreCharacter: 
	  add $t1, $t1, 1         # point to next character
          add $t0, $t0, 1         # increment counter by one
          b next_ch               # load next character	
		          

end_str:       	  
	  li $v0, 4                 # set system call code to print a string 
	  la $a0, prompt2           # load string base address
	  syscall                   # print result message
	 
 	  sub $t1, $t1, $t0	    # return to the start of the stirng
          li $v0, 4                 # se system call code to print a string    
          la $a0, ($t1)             # put the string in the register $a0
          syscall                   # print the string
          
         
          
          
          
ends:     
          li $v0, 10              # set system call code to exit program
          syscall                 # exit program

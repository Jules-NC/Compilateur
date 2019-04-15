All:
	java -cp ./javacc.jar javacc Jagger.jj
	javac *.java
	
check : all
	echo "tests qui fonctionnent :"
	java Jagger < ./Tests/Passed/assign1
	java Jagger < ./Tests/Passed/assign2
	java Jagger < ./Tests/Passed/comp_str
	java Jagger < ./Tests/Passed/expr
	java Jagger < ./Tests/Passed/expr_comp
	java Jagger < ./Tests/Passed/ifThenElse_false
	java Jagger < ./Tests/Passed/ifThenElse_intoeachothers
	java Jagger < ./Tests/Passed/ifThenElse_true
	java Jagger < ./Tests/Passed/init_1_one_init
	java Jagger < ./Tests/Passed/init_2_multiple_init
	java Jagger < ./Tests/Passed/init_3_scopes
	java Jagger < ./Tests/Passed/init_i
	java Jagger < ./Tests/Passed/print
	java Jagger < ./Tests/Passed/print_expr
	java Jagger < ./Tests/Passed/print_str
	java Jagger < ./Tests/Passed/while
	
	echo "tests qui ne fonctionnent pas :"
	java Jagger < ./Tests/Failed/2var
	java Jagger < ./Tests/Failed/print
	java Jagger < ./Tests/Failed/type
	java Jagger < ./Tests/Failed/var




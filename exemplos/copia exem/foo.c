int foo(){
	int a; int b; int c;
	
	while(TRUE){
		if(a > 0){
			printf(a+b+c);
		} else if(b > 0){
			printf(b+c);
		} else{
			printf(c);
		}
	}
}

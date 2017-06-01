int main(){
	int a;
	int b;
	int c;
	boolean flag;
	
	a = 0; b = 0; c = 0; flag = TRUE;

	while(a < 10){
		if(flag == TRUE){
			while(b < 10){
				while(c < 10){
					c = c + 1;
				}
				b = b + 1;
			}
		}else{
			return 0;
		}
	a = a + 1;
	}

	return a+b;
}
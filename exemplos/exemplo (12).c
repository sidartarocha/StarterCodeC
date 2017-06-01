int main(){
	int a;
	int b;
	int c;
	
	a = 0; b = 0; c = 0;

	while(a < 10){
		while(b < 10){
			while(c < 10){
				c = c + 1;
			}
		b = b + 1;
		}
	a = a + 1;
	}

	return a+b;
}
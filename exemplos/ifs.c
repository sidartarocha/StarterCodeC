int main(){
	int a;
	int b;
	int c;

	if(a > 0){
		if(b > 0){
			if(c > 0){
				return 1;
			}
		}
	}else if(a < 0){
		if(b < 0){
			if(c < 0){
				return 2;
			}
		}
	}else{
		return 3;
	}
}
}
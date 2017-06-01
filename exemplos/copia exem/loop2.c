int main() {
	boolean flag;
	int count;
    flag = TRUE;
	count = 0;
    while(flag != FALSE){
      	printf(flag);
		count = count + 1;
		if(flag == FALSE){
			if(count >= 10){
				printf(count);
			}
		}
    }
}
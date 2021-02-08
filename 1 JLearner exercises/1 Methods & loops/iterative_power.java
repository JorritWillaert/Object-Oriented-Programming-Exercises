int iterative_power(int x, int y){
  	int power = 1;
	for (int i = 0; i < y; i++){
      power *= x;
    }
  	return power;
}

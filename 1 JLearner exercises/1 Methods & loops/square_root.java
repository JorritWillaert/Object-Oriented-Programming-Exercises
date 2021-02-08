int square_root(int x){
  	int sqrt = 0;
  	while (sqrt * sqrt <= x){
     	sqrt += 1;
    }
  	return sqrt - 1;
}

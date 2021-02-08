int recursive_power(int x, int y){
  	int power = x;
  	if (y == 1){
     	return power;
    }
 	return power * recursive_power(x, y - 1);
}

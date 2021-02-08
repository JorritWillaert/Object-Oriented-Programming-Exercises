class Vector{
  int x;
  int y;
}

int size(Vector vector){
 	 return square_root((vector.x * vector.x) + (vector.y * vector.y));
}

int square_root(int x){
  	int sqrt = 0;
  	while (sqrt * sqrt <= x){
     	sqrt += 1;
    }
  	return sqrt - 1;
}

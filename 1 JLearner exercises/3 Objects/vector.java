class Vector{
  int x;
  int y;
}

Vector sum_of_vectors(Vector vector1, Vector vector2){
	Vector sum_vector = new Vector();
  	sum_vector.x = vector1.x + vector2.x;
  	sum_vector.y = vector1.y + vector2.y;
  	return sum_vector;
}

Vector greatest_vector(Vector vector1, Vector vector2){
	if (size(vector1) < size(vector2)){
    	return vector1;
    } else{
      return vector2;
    }
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

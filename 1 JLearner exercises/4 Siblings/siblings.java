class Person{
 	int age;
  	Person nextOldestSibling;
}

int iterative_number_of_younger_siblings(Person person){
  	int count = 0;
	while (person.nextOldestSibling != null){
    	person = person.nextOldestSibling;
        count++;
    }
  	return count;
}

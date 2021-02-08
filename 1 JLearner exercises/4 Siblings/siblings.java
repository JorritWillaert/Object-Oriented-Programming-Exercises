class Person{
 	int age;
  	Person nextOldestSibling;
}

int recursive_number_of_younger_siblings(Person person){
	if (person.nextOldestSibling == null){
    	return 0;
    }
  	else{
    	return 1 + recursive_number_of_younger_siblings(person.nextOldestSibling);
    }
}

int iterative_number_of_younger_siblings(Person person){
  	int count = 0;
	while (person.nextOldestSibling != null){
    	person = person.nextOldestSibling;
        count++;
    }
  	return count;
}

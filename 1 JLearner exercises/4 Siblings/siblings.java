class Person{
 	int age;
  	Person nextOldestSibling;
}

void iterative_add_child(Person person){
	while (person.nextOldestSibling != null){
    	person = person.nextOldestSibling;
    }
  	Person baby = new Person();
  	person.nextOldestSibling = baby;
}

void recursive_increase_ages(Person person){
	person.age++;
  	if (person.nextOldestSibling!= null){
      	recursive_increase_ages(person.nextOldestSibling);
    }
}

void iterative_increase_ages(Person person){
  	person.age++;
	while (person.nextOldestSibling != null){
    	person = person.nextOldestSibling;
        person.age++;
    }
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

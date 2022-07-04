import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import Entity.Person;

public class ServiceOperation {

    private Map<String, Person> personMap = new LinkedHashMap<>();	
	
	public void AddPerson(Person newPerson) throws Exception {
        if (!personMap.containsKey(newPerson.getId()))
            personMap.put(newPerson.getId(), newPerson);
        else
            throw new Exception("Exception: Duplicated ID");
	}
	
	public void showAllPerson() {
		for (Person person : personMap.values()){
			System.out.println(person);
		}
	}
	
	public Person findPerson(String personId) {
		return personMap.get(personId);
	}
	
	public List<Person> findPersonByName(String name) {
		return personMap.values().stream().filter( p -> name.equals( p.getName() )).collect(Collectors.toList());
	}
	
	public List<Person> findPersonByName2(String name) {
		List<Person> persons = new ArrayList<Person>();		
		for (Person person : personMap.values()) {
			if (name.equals(person.getName())) {
				persons.add(person);
			}
		}		
		return persons;
	}

}

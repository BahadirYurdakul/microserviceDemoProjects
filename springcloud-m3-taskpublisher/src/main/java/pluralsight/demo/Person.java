package pluralsight.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {
	
	private String id;
	private String name;
	
	public Person() {
		
	}
	
	public Person(String id, String name) {
		this.setId(id);
		this.setName(name);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                "name='" + name +
                '}';
    }
}

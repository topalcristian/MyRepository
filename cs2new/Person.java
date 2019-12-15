public abstract class Person {

    // instance fields
    private String name;
    private int age;

    // constructor
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    // accessor methods
    public String getName(){ return name; }

    public int getAge(){ return age; }


    // mutator methods
    public void setName(String name) {
        this.name= name;
    }

    public void setAge(int age){
        this.age = age;
    }

    //toString method
    public String toString(){
        return "[Name: " + name + "], [Age: " + age + "]";
    }

    //equals method - test if objects have the same state
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }
        // casting the Object to Person in order to compare it
        Person person = (Person) obj;
        return name.equals(person.name) && age == person.age;
    }
}

package project2;

public class Customer {
    private String name;
    private char gender;
    private int age;
    private String phone;
    private String Email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void printCustomer() {
        System.out.println(getName()
                + "\t"+getGender()
                + "\t\t"+getAge()
                + "\t\t"+getPhone()
                + "\t\t"+getEmail());
    }
}

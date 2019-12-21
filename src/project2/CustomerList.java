package project2;

import java.util.Arrays;

public class CustomerList<getAllCustomers> {
    private Customer[] customers;
    private Customer[] customers1;
    private int customersIndex = 0;
    private int totalCustomerNumber;

    public CustomerList(int totalCustomerNumber) {
        this.totalCustomerNumber = totalCustomerNumber;
        customers = new Customer[this.totalCustomerNumber];
    }

    public CustomerList() {
    }

    public boolean addCustomer(Customer customer) {
        if (customersIndex > totalCustomerNumber) {
            return false;
        } else {
            customers[customersIndex] = customer;
            customersIndex++;
            return true;
        }
    }

    public boolean replaceCustomer(int index, Customer cust) {
        if (index > totalCustomerNumber) {
            System.out.println("索引超出边界，替换失败");
            return false;
        } else {
            customers[index - 1] = cust;
            return true;
        }
    }

    public boolean deleteCustomer(int index) {
        if (index > totalCustomerNumber) {
            System.out.println("索引超出边界，删除失败");
            return false;
        } else {
            if (index - 1 < customersIndex) {
                //customers[index-1] = null;
                for (int i = index - 1; i < customersIndex; i++) {
                    customers[i] = customers[i + 1];
                }
                customers[customersIndex] = null;
            } else if (index - 1 == customersIndex) {
                customers[customersIndex] = null;
            }
            customersIndex--;
            return true;
        }
    }

    public Customer[] getAllCustomers() {
//        return customers;
        int i = 0;
        for (; i < totalCustomerNumber; i++) {
            if (customers[i] == null) {
                break;
            }
        }
        customers1 = new Customer[i];
        for (int j = 0; j < i; j++) {
            customers1[j] = customers[j];
        }
        return customers1;
    }

    public Customer getCustomer(int index) {
        return this.customers1[index - 1];
    }

    public void printCustomerArrays(Customer[] customerArray) {
        for (int i = 0; i <customerArray.length; i++) {
            System.out.print(i+1 +"\t\t");
            customerArray[i].printCustomer();
        }
    }

 /*   //测试类
    public static void main(String[] args) {
        CustomerList customerList = new CustomerList(20);
        Customer customer1 = new Customer();
        customer1.setName("大罗");
        customer1.setGender('男');
        customer1.setAge(30);
        customer1.setPhone("13456789098");
        customer1.setEmail("daluo@163.com");

        Customer customer2 = new Customer();
        customer2.setName("小罗");
        customer2.setGender('男');
        customer2.setAge(27);
        customer2.setPhone("13456781111");
        customer2.setEmail("xiaoluo@163.com");

        Customer customer3 = new Customer();
        customer3.setName("孙雯");
        customer3.setGender('女');
        customer3.setAge(23);
        customer3.setPhone("13456789110");
        customer3.setEmail("sunwen@163.com");

        Customer customer4 = new Customer();
        customer4.setName("吴磊");
        customer4.setGender('男');
        customer4.setAge(27);
        customer4.setPhone("1345678000");
        customer4.setEmail("wulei@163.com");

        customerList.addCustomer(customer1);
        System.out.println(" 序号为：" + customerList.customersIndex);
        customerList.addCustomer(customer2);
        System.out.println(" 序号为：" + customerList.customersIndex);
        customerList.addCustomer(customer3);
        System.out.println(" 序号为：" + customerList.customersIndex);
//        customerList.replaceCustomer(3, customer4);
//        customerList.deleteCustomer(1);
//        customerList.deleteCustomer(1);
        customerList.printCustomerArrays(customerList.getAllCustomers());
        customerList.getCustomer(1).printCustomer();*/

//    }
}
package project2;

import java.util.Scanner;

/* ----------------客户信息管理软件----------------
       1 添 加 客 户
        2 修 改 客 户
        3 删 除 客 户
        4 客 户 列 表
        5 退 出
        请选择(1-5)：_*/
public class CustomerView {
    public CustomerView() {
        showCustomerView();
    }

    CMUtility cmUtility1 = new CMUtility();
    CustomerList customerList = new CustomerList(20);

    public void showCustomerView() {
        System.out.println("-----------------客户信息管理软件----------------");
        System.out.println("\t\t\t\t  1 添 加 客 户 ");
        System.out.println("\t\t\t\t  2 修 改 客 户");
        System.out.println("\t\t\t\t  3 删 除 客 户");
        System.out.println("\t\t\t\t  4 客 户 列 表");
        System.out.println("\t\t\t\t  5 退 出 ");
        System.out.println("\t\t\t\t  请选择(1-5)：_");
    }

    public void showAddCustomer() {
        System.out.println("\t\t\t\t  请选择(1-5)：1");
        System.out.println("-----------------添 加 客 户----------------");
        Customer customer = new Customer();
        System.out.print("姓名：");
        customer.setName(cmUtility1.readString(3));
        System.out.print("性别：");
        customer.setGender(cmUtility1.readChar());
        System.out.print("年龄：");
        customer.setAge(cmUtility1.readInt());
        System.out.print("电话：");
        customer.setPhone(cmUtility1.readString(11));
        System.out.print("邮箱：");
        customer.setEmail(cmUtility1.readString(15));
        customerList.addCustomer(customer);
        System.out.print("-----------------添 加 完 成----------------");
//        customer.printCustomer();
        customerList.printCustomerArrays(customerList.getAllCustomers());
        showCustomerView();
    }

    public void showModifyCustomer() {
        Customer customer = new Customer();
        System.out.println("\t\t\t\t  请选择待修改客户编号(-1退出)：");
        int number = cmUtility1.readInt();
        if (number == -1) {
            System.out.println("退出修改");
            showCustomerView();
        } else {
            if (number < 1 || number > customerList.getAllCustomers().length) {
                System.out.println("所查编号超出范围，请重新输入编号");
            } else {
                System.out.println("-----------------修 改 客 户----------------");
                System.out.println("姓名：" + customerList.getAllCustomers()[number - 1].getName());
                customer.setName(cmUtility1.readString(3));
                System.out.println("性别：" + customerList.getAllCustomers()[number - 1].getGender());
                customer.setGender(cmUtility1.readChar());
                System.out.println("年龄：" + customerList.getAllCustomers()[number - 1].getAge());
                customer.setAge(cmUtility1.readInt());
                System.out.println("电话：" + customerList.getAllCustomers()[number - 1].getPhone());
                customer.setPhone(cmUtility1.readString(11));
                System.out.println("邮箱：" + customerList.getAllCustomers()[number - 1].getEmail());
                customer.setEmail(cmUtility1.readString(15));
                customerList.replaceCustomer(number, customer);
                System.out.println("-----------------修 改 完 成----------------");
                showCustomerView();
            }
        }
    }

    public void showDeleteCustomer() {
        System.out.println("\t\t\t\t  请选择(1-5)：3");
        System.out.println("-----------------删 除 客 户----------------");
        System.out.println("请选择待删除客户编号(-1退出)：");
        int number = cmUtility1.readInt();
        if (number == -1) {
            System.out.println("退出删除");
            showCustomerView();
        } else {
            if (number < 1 || number > customerList.getAllCustomers().length) {
                System.out.println("所删除编号超出范围，请重新输入编号");
            } else {
                System.out.println("确认是否删除(Y/N)：");
                if(cmUtility1.readConfirmSelection()=='Y'||cmUtility1.readConfirmSelection()=='y'){
                    customerList.deleteCustomer(number);
                }else
                {
                    System.out.println("取消删除");
                    showCustomerView();
                }
                System.out.println("-----------------删 除 完 成----------------");
            }
        }
    }

    public void showAllCustomer() {
        System.out.println("-----------------客 户 列 表----------------");
        System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t邮箱\t\t");
        customerList.printCustomerArrays(customerList.getAllCustomers());
        System.out.println("-----------------客户列表完成----------------");
        showCustomerView();
    }

    public void exit() {
        System.out.println("-----------------退 出 系 统----------------");
        System.out.println("-----------------  再   见 -----------------");
    }

    public static void main(String[] args) {
        CMUtility cmUtility = new CMUtility();
        CustomerView customerView = new CustomerView();
        while (true) {
            switch (cmUtility.readMenuSelection()) {
                case '1':
                    customerView.showAddCustomer();
                    break;
                case '2':
                    customerView.showModifyCustomer();
                    break;
                case '3':
                    customerView.showDeleteCustomer();
                    break;
                case '4':
                    customerView.showAllCustomer();
                    break;
                case '5':
                    customerView.exit();
                    System.exit(0);
            }

        }
    }
}

package com.customer.repository.impl;

import com.customer.model.Customer;
import com.customer.repository.ICustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Repository
public class CustomerRepository implements ICustomerRepository {
    private static List<Customer> customerList = new ArrayList<>();

    static {
        customerList.add(new Customer(1, "ngân", 10));
        customerList.add(new Customer(2, "thuỷ", 11));
        customerList.add(new Customer(3, "hoài", 12));
        customerList.add(new Customer(4, "Nam", 13));
        customerList.add(new Customer(5, "Xanh", 14));
        customerList.add(new Customer(6, "Trang", 18));
        customerList.add(new Customer(7, "Quỳnh", 11));
        customerList.add(new Customer(8, "Khung", 9));
        customerList.add(new Customer(9, "Dien", 6));
    }

    public List<Customer> findAll() {
        return customerList;
    }

    @Override
    public void save(Customer customer) {
        customerList.add(customer);
    }

    @Override
    public Customer findById(Integer id) {
        for (Customer customer : customerList) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        return null;
    }
    @Override
    public void edit(Customer customer) {
        for (Customer cu : customerList) {
            if (cu.getId().equals(customer.getId())) {
                cu.setName(customer.getName());
                cu.setAge(customer.getAge());
                return;
            }
        }
    }
    @Override
    public void delete(Integer id) {
        customerList.remove(this.findById(id));
    }

    @Override
    public List<Customer> searchByName(String search) {
        List<Customer> customers = new ArrayList<>();
        for (Customer customer: customerList) {
            if (customer.getName().toLowerCase(Locale.ROOT).contains(search.toLowerCase(Locale.ROOT) )) {
                customers.add(customer);
            }
        }
        return customers;
    }
}

package com.task.account.service;

import com.task.account.dto.CustomerDto;
import com.task.account.dto.CustomerDtoConverter;
import com.task.account.exception.CustomerNotFoundException;
import com.task.account.model.Customer;
import com.task.account.repository.CustomerRepository;
import org.springframework.stereotype.Service;

//SOLID = Single Responsiblity her servis ve fonksiyonun kendi hizmet ettiği sadece 1 tane amacı olmalıdır
//Customer service bu yüzden var tüm customer işlemleri burada yapılır.
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter converter;

    public CustomerService(CustomerRepository customerRepository, CustomerDtoConverter converter) {
        this.customerRepository = customerRepository;
        this.converter = converter;
    }

    //içeride yapılacak dışarıya gönderilmeyecek işlemlerde entity nesnesini kullanabiliriz
    //protected sadece paket içerisinde kullanılabilir (yani service paketi içerisinde)
    protected Customer findCustomerById(String id) {
        return customerRepository.findById(id).orElseThrow(
                () -> new CustomerNotFoundException("Customer could not find by id:" + id));
    }

    public CustomerDto getCustomerById(String customerId) {
        return converter.convertToCustomerDto(findCustomerById(customerId));
    }
}

package sii.recruitment.back.customer;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final Gson gson = new Gson();

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void addCustomer (Customer customer) {
        customerRepository.save(customer);
    }

    public List<Customer> findAllWithEligibleForInput() {
        List <Customer> list = customerRepository.findAll();
        return list.stream()
                .filter(c -> calculateAge(c.getDateOfBirth()) >= 18 && calculateAge(c.getDateOfBirth()) <= 26)
                .peek(c -> c.setEligibleForDiscount(true)
                ).collect(Collectors.toList());
    }

    private static int calculateAge(LocalDate dateOfBirth) {
        LocalDate currentDate = LocalDate.now();
        return Period.between(dateOfBirth, currentDate).getYears();
    }

    public String turnIntoJsonInConsole(List<Customer> list) {
        return gson.toJson(list);
    }
}

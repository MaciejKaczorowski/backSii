package sii.recruitment.back;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sii.recruitment.back.customer.Customer;
import sii.recruitment.back.customer.CustomerRepository;
import sii.recruitment.back.customer.CustomerService;

import java.time.LocalDate;

@SpringBootApplication
public class BackApplication implements CommandLineRunner {

	private final CustomerService customerService;
	private final CustomerRepository customerRepository;

	public BackApplication(CustomerService customerService, CustomerRepository customerRepository) {
		this.customerService = customerService;
		this.customerRepository = customerRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(BackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		LocalDate date1 = LocalDate.parse("1985-03-28");
		LocalDate date2 = LocalDate.parse("2000-05-30");
		Customer customer1 = new Customer("John", "Bone", "New Street 1", "85032899087", date1, false);
		Customer customer2 = new Customer("Sally", "Good", "Old Street 2", "10053099555", date2, false);


		customerService.addCustomer(customer1);
		customerService.addCustomer(customer2);



		System.out.println(customerService.turnIntoJsonInConsole(customerService.findAllWithEligibleForInput()));

	}
}

package infrastructure.repositories;

import domain.models.Customer;
import domain.models.ProfilePhoto;
import domain.repositories.CustomerQuery;
import domain.repositories.CustomerRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class HibernateCustomerRepository implements CustomerRepository {
    @Override
    public List<Customer> find(CustomerQuery query) {
        return List.of(new Customer("customerId", List.of(new ProfilePhoto("profilePhotoId", "originalPhoto", "generatedPhoto"))));
    }
}

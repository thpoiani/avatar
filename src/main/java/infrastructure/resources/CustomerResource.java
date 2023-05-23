package infrastructure.resources;

import application.ApplicationService;
import application.dto.Customer;
import application.dto.ProfilePhoto;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.ResponseStatus;
import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.multipart.FileUpload;

import java.util.List;
import java.util.NoSuchElementException;

@Path("customers")
public class CustomerResource {
    private final ApplicationService service;

    public CustomerResource(ApplicationService service) {
        this.service = service;
    }

    @GET
    public List<Customer> searchCustomers() {
        return service.searchCustomers();
    }

    @GET
    @Path("/{id}")
    public Customer getCustomer(@PathParam("id") String id) {
        try {
            return service.getCustomer(id);
        } catch (NoSuchElementException exception) {
            throw new NotFoundException();
        }
    }

    @POST
    @Path("/{id}")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @ResponseStatus(RestResponse.StatusCode.ACCEPTED)
    public void persistProfilePhoto(@PathParam("id") String id,
                                    @RestForm("photo") FileUpload fileUpload) {
        service.persistProfilePhoto(id, ProfilePhoto.create(fileUpload));
    }
}

package com.github.danielsoro.resources;

import com.github.danielsoro.models.Person;
import com.github.danielsoro.services.PersonRepository;
import org.jnosql.artemis.ConfigurationUnit;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/person")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {

    @Inject
    @ConfigurationUnit(database = "people")
    private PersonRepository personRepository;

    @GET
    @Path("/{id}")
    public Person listPerson(@PathParam("id") final String id) {
        final Optional<Person> person = personRepository.findById(id);
        return person.orElseThrow(() -> new WebApplicationException(Response.Status.NOT_FOUND));
    }


    @POST
    public Person createPerson(Person person) {
        final Person result = personRepository.save(person);
        return result;
    }
}

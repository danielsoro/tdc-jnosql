package com.github.danielsoro.resources;

import com.github.danielsoro.models.Person;
import com.github.danielsoro.services.PersonRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/person")
public class PersonResource {

    @Inject
    private PersonRepository personRepository;

    @GET
    @Path("/{id}")
    public Person listPerson(@PathParam("id") final Long id) {
        final Optional<Person> person = personRepository.findById(id);
        return person.orElseThrow(() -> new WebApplicationException(Response.Status.NOT_FOUND));
    }

    @POST
    public Person createPerson(Person person) {
        final Person result = personRepository.save(person);
        return result;
    }
}

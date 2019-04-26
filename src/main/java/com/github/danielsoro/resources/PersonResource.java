package com.github.danielsoro.resources;

import com.github.danielsoro.models.Person;
import com.github.danielsoro.services.PersonRepository;
import org.jnosql.artemis.ConfigurationUnit;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/person")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {

    @Inject
    @ConfigurationUnit(database = "people")
    private PersonRepository personRepository;


    @GET
    public List<Person> listPerson() {
        return personRepository.findAll();
    }

    @POST
    public Person createPerson(Person person) {
        final Person result = personRepository.save(person);
        return result;
    }
}

package org.example;

import org.example.domain.Contact;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import java.net.URL;

import static javax.ws.rs.client.Entity.entity;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Arquillian.class) // 1
class AppIT {

    @ArquillianResource
    private URL deploymentURL;

    private String contactsResourcePath;
    private final String contactsUri = "api/contacts";

    @Before
    public void setup() {
        contactsResourcePath = deploymentURL + contactsUri;
    }

    @Deployment // 2: creeer een war zodat arq deze kan deployen
    public static Archive<?> createDeployment() {
        WebArchive warEmpty = ShrinkWrap.create(WebArchive.class, "AppIT.war");
        WebArchive warFilled = warEmpty
                .addPackages(true, App.class.getPackage()) // add all packages in my application
                // .addClass(App.class) // dont forget! // selectively add classes
                // .addClass(ContactsResource.class)
                // .addClass(Contact.class)
                .addAsWebInfResource("test-beans.xml", "beans.xml") // to activate CDI
                // .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                ;

        System.out.println(warFilled.toString(true));
        return warFilled;
    }

    @Test
    public void whenContactIsPostedICanGetIt() {
        // TODO
        Client postmanAlsHetWare = ClientBuilder.newClient();

        Contact c = Contact.builder().id(1L).name("Sammie").age(42).build();

        String postedContact = postmanAlsHetWare
                .target(contactsResourcePath) // URI
                .request().post(entity(c, APPLICATION_JSON), String.class);

        assertThat(postedContact, containsString("\"id\":\"1\""));
        assertThat(postedContact, containsString("\"name\":\"Sammie\""));
    }

}

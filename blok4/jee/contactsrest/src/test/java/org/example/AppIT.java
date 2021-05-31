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
import java.util.List;

import static javax.ws.rs.client.Entity.entity;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.assertj.core.api.Assertions.assertThat;
import static org.example.util.Util.pomDependency;

@RunWith(Arquillian.class) // 1
public class AppIT {

    @ArquillianResource
    private URL deploymentURL;

    private String contactsResourcePath;

    @Before
    public void setup() { contactsResourcePath = deploymentURL + "api/contacts"; }

    @Deployment // 2: creeer een war zodat arq deze kan deployen
    public static Archive<?> createDeployment() {
        WebArchive warEmpty = ShrinkWrap.create(WebArchive.class, "AppIT.war");
        WebArchive warFilled = warEmpty
                .addPackages(true, App.class.getPackage()) // Add all packages in my application
                // .addClass(App.class) // dont forget!    // OR selectively add classes
                // .addClass(ContactsResource.class)
                // .addClass(Contact.class)
                .addAsWebInfResource("beans-test.xml", "beans.xml") // to activate CDI
                // .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                .addAsLibraries(pomDependency("org.apache.logging.log4j", "log4j-slf4j-impl"));

        System.out.println(warFilled.toString(true));

        return warFilled;
    }

    @Test // 3: maak testjes
    @SuppressWarnings("unchecked")
    public void whenContactIsPostedItIsAddedAndICanGetItById() {
        final long ID = 10L;
        final String FIRST_NAME = "Sammie";

        Client httpClient = ClientBuilder.newClient();

        List<Contact> contactsBeforePost = httpClient
                .target(contactsResourcePath) // URI
                .request()
                .get(List.class);

        int before = contactsBeforePost.size();

        Contact c = Contact.builder().id(ID).firstName(FIRST_NAME).age(42).build();

        String postedContact = httpClient
                .target(contactsResourcePath)
                .request()
                .post(entity(c, APPLICATION_JSON), String.class);

        assertThat(postedContact).contains("\"id\":" + ID);
        assertThat(postedContact).contains("\"firstName\":\"" + FIRST_NAME + "\"");

        List<Contact> contactsAfterPost = httpClient
                .target(contactsResourcePath) // URI
                .request()
                .get(List.class);

        int after = contactsAfterPost.size();

        assertThat(after).isGreaterThan(before);

        Contact contact = httpClient
                .target(contactsResourcePath + "/" + ID)
                .request()
                .get(Contact.class);

        assertThat(contact).isNotNull();
    }

}

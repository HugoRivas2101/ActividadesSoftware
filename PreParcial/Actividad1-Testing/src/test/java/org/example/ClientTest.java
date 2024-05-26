package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ClientTest {
    private Address address=new Address("street A");
    private Address secondaddress= new Address("street B");
    private Client client;

    @BeforeEach
    void setUp(){
        client=new Client();
    }

    @Test
    void afterCreationShouldHaveNoAddress(){
        assertThat(client.getAddresses()).isEmpty();
    }
    @Test
    void shouldAllowToAddAddress(){
        client.addAddress(address);
        assertThat(client.getAddresses()).contains(address);
    }

    @Test
    void shouldAllowToAddManyAddress(){
        client.addAddress(address);
        client.addAddress(secondaddress);
        assertThat(client.getAddresses()).contains(address,secondaddress);
    }


}

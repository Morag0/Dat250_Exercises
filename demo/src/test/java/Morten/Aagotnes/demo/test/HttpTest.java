package Morten.Aagotnes.demo.test;

import Aagotnes.demo.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestClient;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpTest {



    private final RestClient restClient = RestClient.create();



    @Test
    public void createUserTest() {


        String url = "http://localhost:8080/users";

        User user = new User();
        user.setUsername("User1");
        user.setEmail("User1@email.com");

        ResponseEntity<User> response = restClient.post()
                .uri(url)
                .body(user)
                .retrieve()
                .toEntity(User.class);

        assertThat(response.getStatusCode()).isEqualTo(200);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getUsername()).isEqualTo("User1");
        assertThat(response.getBody().getEmail()).isEqualTo("User1@email.com");
    }

    @Test
    public void listUsersTest() {

        String url = "http://localhost:8080/users";

        ResponseEntity<User[]> response = restClient.get()
                .uri(url)
                .retrieve()
                .toEntity(User[].class);

        assertThat(response.getStatusCode()).isEqualTo(200);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().length).isGreaterThan(0);
    }
}

package sauce_demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerDetails {
    private final String firstName;
    private final String lastName;
    private final String postCode;

    public CustomerDetails(@JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName, @JsonProperty("postCode") String postCode) {
        this.firstName = firstName;
        this.lastName = "Mac"+lastName;
        this.postCode = postCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPostCode() {
        return postCode;
    }

    public static CustomerDetails about(String name) {
        return new CustomerDetails(name, name, "123-ABC");
    }

}

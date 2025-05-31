package Models.ResponseModels;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GetListUsers {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("page")
    public int page;

    @JsonProperty("per_page")
    public int perPage;

    @JsonProperty("total")
    public int total;

    @JsonProperty("total_pages")
    public int totalPages;

    @JsonProperty("data")
    public List<Data> data;

    @JsonProperty("support")
    public Support support;




    public static class Data {

        @JsonProperty("id")
        public Integer id;
        @JsonProperty("email")
        public String email;
        @JsonProperty("first_name")
        public String firstName;
        @JsonProperty("last_name")
        public String lastName;
        @JsonProperty("avatar")
        public String avatar;

    }

    public static class Support {

        @JsonProperty("url")
        public String url;
        @JsonProperty("text")
        public String text;

    }
}

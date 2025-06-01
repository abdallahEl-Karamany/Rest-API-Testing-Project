package Models.ResponseModels;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InvalidLoginResponseModel {
    @JsonProperty("error")
    public String error;
}

package com.luv2code.springdemo.mvc;

import com.luv2code.springdemo.mvc.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {

    private String firstName;

    @NotNull(message = "required")
    @Size(min=1, message = "required")
    private String lastName = "";

    @NotNull(message = "required")
    @Min(value=0, message="Must be >= 0")
    @Max(value=10, message = "Must be >= 10")
    private Integer freePasses;

    @Pattern(regexp="^[a-zA-Z0-9]{5}", message = "only 5 chars/digits")
    private String postalCode;

    @CourseCode(value="TOPS", message="must start with TOPS")
    private String courseCode;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public @NotNull(message = "required") @Size(min = 1, message = "required") String getLastName() {
        return lastName;
    }

    public void setLastName(@NotNull(message = "required") @Size(min = 1, message = "required") String lastName) {
        this.lastName = lastName;
    }
}

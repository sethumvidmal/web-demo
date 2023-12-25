package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private String batch;
    private String institute;
    private String firstName;
    private String lastName;
    private String age;

    public void setFirstName(String firstName) {
        if ("".equalsIgnoreCase(firstName) || null == firstName) {
            return;
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if ("".equalsIgnoreCase(lastName) || null == lastName) {
            return;
        }
        this.lastName = lastName;
    }

    public void setBatch(String batch) {
        if ("".equalsIgnoreCase(batch) || null == batch) {
            return;
        }
        this.batch = batch;
    }

    public void setInstitute(String institute) {
        if ("".equalsIgnoreCase(institute) || null == institute) {
            return;
        }
        this.institute = institute;
    }

    public void setAge(String age) {
        if ("".equalsIgnoreCase(age) || null == age || isNumber(age)) {
            return;
        }
        this.age = age;
    }

    private boolean isNumber(String value) {
        if (value.matches("\\d+")) {
            int number = Integer.parseInt(value);
            if (number < 10 || number > 90) {
                return true;
            }
            return false;
        }
        return true;
    }
}

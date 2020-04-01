package com.project.nairon.models.naironuser;

import java.io.Serializable;
import java.util.Objects;

public class NaironUserId implements Serializable {

    private Long naironUserId;

    private String email;

    public NaironUserId(){

    }

    public NaironUserId(Long naironUserId, String email){
        this.naironUserId = naironUserId;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NaironUserId that = (NaironUserId) o;
        return Objects.equals(naironUserId, that.naironUserId) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(naironUserId, email);
    }
}

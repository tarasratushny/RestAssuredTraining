package org.miamato.models.pet;

import java.io.Serializable;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name"
})
@Generated("jsonschema2pojo")
public class Tag implements Serializable {

    @JsonProperty("id")
    public Integer id;
    @JsonProperty("name")
    public String name;
    private final static long serialVersionUID = 4442896398527070759L;

    /**
     * No args constructor for use in serialization
     */
    public Tag() {
    }

    /**
     *
     */
    public Tag(Integer id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Tag withId(Integer id) {
        this.id = id;
        return this;
    }

    public Tag withName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Tag.class.getName()).append('@')
            .append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null) ? "<null>" : this.id));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null) ? "<null>" : this.name));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result * 31) + ((this.name == null) ? 0 : this.name.hashCode()));
        result = ((result * 31) + ((this.id == null) ? 0 : this.id.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Tag) == false) {
            return false;
        }
        Tag rhs = ((Tag) other);
        return (((this.name == rhs.name) || ((this.name != null) && this.name.equals(rhs.name)))
            && ((this.id == rhs.id) || ((this.id != null) && this.id.equals(rhs.id))));
    }

}
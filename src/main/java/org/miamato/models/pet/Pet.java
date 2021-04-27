package org.miamato.models.pet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "category",
    "name",
    "photoUrls",
    "tags",
    "status"
})
@Generated("jsonschema2pojo")
public class Pet implements Serializable {

    @JsonProperty("id")
    public Integer id;
    @JsonProperty("category")
    public Category category;
    @JsonProperty("name")
    public String name;
    @JsonProperty("photoUrls")
    public List<String> photoUrls = null;
    @JsonProperty("tags")
    public List<Tag> tags = null;
    @JsonProperty("status")
    public String status;
    private final static long serialVersionUID = 6964323899235781034L;

    /**
     * No args constructor for use in serialization
     */
    public Pet() {
    }

    /**
     *
     */
    public Pet(Integer id, Category category, String name, List<String> photoUrls, List<Tag> tags,
        String status) {
        super();
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    public Pet withId(Integer id) {
        this.id = id;
        return this;
    }

    public Pet withCategory(Category category) {
        this.category = category;
        return this;
    }

    public Pet withName(String name) {
        this.name = name;
        return this;
    }

    public Pet withPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
        return this;
    }

    public Pet withPhotoUrl(String photoUrl){
        if(photoUrls == null)
            photoUrls = new ArrayList<>();
        photoUrls.add(photoUrl);
        return this;
    }

    public Pet withTags(List<Tag> tags) {
        this.tags = tags;
        return this;
    }

    public Pet withTag(Tag tag){
        if(tags == null)
            tags = new ArrayList<>();
        this.tags.add(tag);
        return this;
    }

    public Pet withStatus(String status) {
        this.status = status;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Pet.class.getName()).append('@')
            .append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null) ? "<null>" : this.id));
        sb.append(',');
        sb.append("category");
        sb.append('=');
        sb.append(((this.category == null) ? "<null>" : this.category));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null) ? "<null>" : this.name));
        sb.append(',');
        sb.append("photoUrls");
        sb.append('=');
        sb.append(((this.photoUrls == null) ? "<null>" : this.photoUrls));
        sb.append(',');
        sb.append("tags");
        sb.append('=');
        sb.append(((this.tags == null) ? "<null>" : this.tags));
        sb.append(',');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null) ? "<null>" : this.status));
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
        result = ((result * 31) + ((this.photoUrls == null) ? 0 : this.photoUrls.hashCode()));
        result = ((result * 31) + ((this.name == null) ? 0 : this.name.hashCode()));
        result = ((result * 31) + ((this.id == null) ? 0 : this.id.hashCode()));
        result = ((result * 31) + ((this.category == null) ? 0 : this.category.hashCode()));
        result = ((result * 31) + ((this.tags == null) ? 0 : this.tags.hashCode()));
        result = ((result * 31) + ((this.status == null) ? 0 : this.status.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Pet) == false) {
            return false;
        }
        Pet rhs = ((Pet) other);
        return (
            ((((((this.photoUrls == rhs.photoUrls) || ((this.photoUrls != null) && this.photoUrls
                .equals(rhs.photoUrls))) && ((this.name == rhs.name) || ((this.name != null)
                && this.name.equals(rhs.name)))) && ((this.id == rhs.id) || ((this.id != null)
                && this.id.equals(rhs.id)))) && ((this.category == rhs.category) || (
                (this.category != null) && this.category.equals(rhs.category)))) && (
                (this.tags == rhs.tags) || ((this.tags != null) && this.tags.equals(rhs.tags))))
                && ((this.status == rhs.status) || ((this.status != null) && this.status
                .equals(rhs.status))));
    }

}
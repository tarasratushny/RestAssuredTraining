package org.miamato.models.order;

import java.io.Serializable;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "petId",
    "quantity",
    "shipDate",
    "status",
    "complete"
})
@Generated("jsonschema2pojo")
public class Order implements Serializable {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("petId")
    private Integer petId;
    @JsonProperty("quantity")
    private Integer quantity;
    @JsonProperty("shipDate")
    private String shipDate;
    @JsonProperty("status")
    private String status;
    @JsonProperty("complete")
    private Boolean complete;
    private final static long serialVersionUID = 8742398122086639323L;

    /**
     * No args constructor for use in serialization
     */
    public Order() {
    }

    /**
     *
     */
    public Order(Integer id, Integer petId, Integer quantity, String shipDate, String status,
        Boolean complete) {
        super();
        this.id = id;
        this.petId = petId;
        this.quantity = quantity;
        this.shipDate = shipDate;
        this.status = status;
        this.complete = complete;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    public Order withId(Integer id) {
        this.id = id;
        return this;
    }

    @JsonProperty("petId")
    public Integer getPetId() {
        return petId;
    }

    @JsonProperty("petId")
    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public Order withPetId(Integer petId) {
        this.petId = petId;
        return this;
    }

    @JsonProperty("quantity")
    public Integer getQuantity() {
        return quantity;
    }

    @JsonProperty("quantity")
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Order withQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    @JsonProperty("shipDate")
    public String getShipDate() {
        return shipDate;
    }

    @JsonProperty("shipDate")
    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public Order withShipDate(String shipDate) {
        this.shipDate = shipDate;
        return this;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    public Order withStatus(String status) {
        this.status = status;
        return this;
    }

    @JsonProperty("complete")
    public Boolean getComplete() {
        return complete;
    }

    @JsonProperty("complete")
    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public Order withComplete(Boolean complete) {
        this.complete = complete;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Order.class.getName()).append('@')
            .append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null) ? "<null>" : this.id));
        sb.append(',');
        sb.append("petId");
        sb.append('=');
        sb.append(((this.petId == null) ? "<null>" : this.petId));
        sb.append(',');
        sb.append("quantity");
        sb.append('=');
        sb.append(((this.quantity == null) ? "<null>" : this.quantity));
        sb.append(',');
        sb.append("shipDate");
        sb.append('=');
        sb.append(((this.shipDate == null) ? "<null>" : this.shipDate));
        sb.append(',');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null) ? "<null>" : this.status));
        sb.append(',');
        sb.append("complete");
        sb.append('=');
        sb.append(((this.complete == null) ? "<null>" : this.complete));
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
        result = ((result * 31) + ((this.petId == null) ? 0 : this.petId.hashCode()));
        result = ((result * 31) + ((this.quantity == null) ? 0 : this.quantity.hashCode()));
        result = ((result * 31) + ((this.id == null) ? 0 : this.id.hashCode()));
        result = ((result * 31) + ((this.shipDate == null) ? 0 : this.shipDate.hashCode()));
        result = ((result * 31) + ((this.complete == null) ? 0 : this.complete.hashCode()));
        result = ((result * 31) + ((this.status == null) ? 0 : this.status.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Order) == false) {
            return false;
        }
        Order rhs = ((Order) other);
        return (((((((this.petId == rhs.petId) || ((this.petId != null) && this.petId
            .equals(rhs.petId))) && ((this.quantity == rhs.quantity) || ((this.quantity != null)
            && this.quantity.equals(rhs.quantity)))) && ((this.id == rhs.id) || ((this.id != null)
            && this.id.equals(rhs.id)))) && ((this.shipDate == rhs.shipDate) || (
            (this.shipDate != null) && this.shipDate.equals(rhs.shipDate)))) && (
            (this.complete == rhs.complete) || ((this.complete != null) && this.complete
                .equals(rhs.complete)))) && ((this.status == rhs.status) || ((this.status != null)
            && this.status.equals(rhs.status))));
    }

}
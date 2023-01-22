
package jaeger.de.miel.HelloThymeleaf.model.org.themoviedb.lists.getdetails;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.processing.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "created_by",
    "description",
    "favorite_count",
    "id",
    "items",
    "item_count",
    "iso_639_1",
    "name",
    "poster_path"
})
@Generated("jsonschema2pojo")
public class ListResponse {

    @JsonProperty("created_by")
    private String createdBy;
    @JsonProperty("description")
    private String description;
    @JsonProperty("favorite_count")
    private Integer favoriteCount;
    @JsonProperty("id")
    private String id;
    @JsonProperty("items")
    private java.util.List<Item> items = null;
    @JsonProperty("item_count")
    private Integer itemCount;
    @JsonProperty("iso_639_1")
    private String iso6391;
    @JsonProperty("name")
    private String name;
    @JsonProperty("poster_path")
    private String posterPath;

    @JsonProperty("created_by")
    public String getCreatedBy() {
        return createdBy;
    }

    @JsonProperty("created_by")
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("favorite_count")
    public Integer getFavoriteCount() {
        return favoriteCount;
    }

    @JsonProperty("favorite_count")
    public void setFavoriteCount(Integer favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("items")
    public java.util.List<Item> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(java.util.List<Item> items) {
        this.items = items;
    }

    @JsonProperty("item_count")
    public Integer getItemCount() {
        return itemCount;
    }

    @JsonProperty("item_count")
    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }

    @JsonProperty("iso_639_1")
    public String getIso6391() {
        return iso6391;
    }

    @JsonProperty("iso_639_1")
    public void setIso6391(String iso6391) {
        this.iso6391 = iso6391;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("poster_path")
    public String getPosterPath() {
        return posterPath;
    }

    @JsonProperty("poster_path")
    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

}

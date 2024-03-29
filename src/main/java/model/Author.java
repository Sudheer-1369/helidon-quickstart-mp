package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@NamedEntityGraphs({
  @NamedEntityGraph(name = "graph.AuthorBooks", attributeNodes = @NamedAttributeNode("books")),
  @NamedEntityGraph(
      name = "graph.AuthorBooksReviews",
      attributeNodes = @NamedAttributeNode(value = "books", subgraph = "books"),
      subgraphs = @NamedSubgraph(name = "books", attributeNodes = @NamedAttributeNode("reviews")))
})
public class Author implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;

  @Version
  @Column(name = "version")
  private int version;

  @Column private String firstName;

  @Column private String lastName;

  @ManyToMany(mappedBy = "authors")
  private Set<Book> books = new HashSet<>();

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public int getVersion() {
    return this.version;
  }

  public void setVersion(final int version) {
    this.version = version;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Set<Book> getBooks() {
    return this.books;
  }

  public void setBooks(final Set<Book> books) {
    this.books = books;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Author)) {
      return false;
    }
    Author other = (Author) obj;
    if (id != null) {
      if (!id.equals(other.id)) {
        return false;
      }
    }
    return true;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public String toString() {
    String result = getClass().getSimpleName() + " ";
    if (firstName != null && !firstName.trim().isEmpty()) {
      result += "firstName: " + firstName;
    }
    if (lastName != null && !lastName.trim().isEmpty()) {
      result += ", lastName: " + lastName;
    }
    return result;
  }
}

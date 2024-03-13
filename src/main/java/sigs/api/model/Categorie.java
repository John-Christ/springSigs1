package sigs.api.model;


// import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "categorie")
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String nom;
    @Column
    // @JsonIgnore
    private String description;









    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }






    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }







    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}



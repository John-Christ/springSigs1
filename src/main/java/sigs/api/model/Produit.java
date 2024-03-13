package sigs.api.model;



// import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "produit")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String nom;
    @Column
   // @JsonIgnore
    private String description;


    @Column
    private Date date_creation;

    @Column
    private Integer seuil;
    @Column
   // @JsonIgnore
    private Integer qte;



    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;



    @ManyToOne
    @JoinColumn(name = "sous_categorie_id")
    private SousCategorie sousCategorie;




    @JsonIgnore
    @ManyToMany(mappedBy = "assignedProduits")
    private Set<Demande> demandeSet = new HashSet<>();



    @JsonIgnore
    @ManyToMany(mappedBy = "assignedProduits")
    private Set<Pret> pretSet = new HashSet<>();



    @JsonIgnore
    @ManyToMany(mappedBy = "assignedProduits")
    private Set<Stock> stockSet = new HashSet<>();




    @JsonIgnore
    @ManyToMany(mappedBy = "assignedProduits")
    private Set<Commande> commandeSet = new HashSet<>();








    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }



    public Integer getSeuil() {
        return seuil;
    }

    public void setSeuil(Integer seuil) {
        this.seuil = seuil;
    }





    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public Integer getQte() {
        return qte;
    }

    public void setQte(Integer qte) {
        this.qte = qte;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }




    public SousCategorie getSousCategorie() {
        return sousCategorie;
    }

    public void setSousCategorie(SousCategorie sousCategorie) {
        this.sousCategorie = sousCategorie;
    }



    public Set<Demande> getDemandeSet() {
        return demandeSet;
    }

    public void setDemandeSet(Set<Demande> demandeSet) {
        this.demandeSet = demandeSet;
    }



    public Set<Pret> getPretSet() {
        return pretSet;
    }

    public void setPretSet(Set<Pret> pretSet) {
        this.pretSet = pretSet;
    }




    public Set<Stock> getStockSet() {
        return stockSet;
    }

    public void setStockSet(Set<Stock> stockSet) {
        this.stockSet = stockSet;
    }





    public Set<Commande> getCommandeSet() {
        return commandeSet;
    }

    public void setCommandeSet(Set<Commande> commandeSet) {
        this.commandeSet = commandeSet;
    }




}


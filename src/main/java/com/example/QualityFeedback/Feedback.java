package com.example.QualityFeedback;

import javax.persistence.*;
import java.time.LocalDate;
// Object Feedback, to be stored in database, holds a piece of quality feedback on one specific product in H&M's assortment.
// The product is identified by the product number, which is found on the care label of a garment.
// We want many customers to be able to give feedback on the same product
// The primary key is a unique, automatically generated id.

@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name ="PRODUCTNUMBER")
    String productNumber;
    @Column(name ="GARMENTTYPE")
    String garmentType;
    @Column(name ="AGEOFGARMENT")
    Integer ageOfGarment;
    @Column(name ="LEVELOFUSE")
    Integer levelOfUse;
    Integer color;
    Integer seam;
    Integer print;
    Integer shrinkage;
    Integer material;
    String comment;
    @Column(name ="DATESUBMITTED")
    String dateSubmitted;

    public Feedback() {
    }

    public Feedback(String productNumber, String garmentType, Integer ageOfGarment, Integer levelOfUse, Integer color, Integer seam, Integer print, Integer shrinkage, Integer material, String comment, String dateSubmitted) {
        this.productNumber = productNumber;
        this.garmentType = garmentType;
        this.ageOfGarment = ageOfGarment;
        this.levelOfUse = levelOfUse;
        this.color = color;
        this.seam = seam;
        this.print = print;
        this.shrinkage = shrinkage;
        this.material = material;
        this.comment = comment;
        this.dateSubmitted = dateSubmitted;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getGarmentType() {
        return garmentType;
    }

    public void setGarmentType(String garmentType) {
        this.garmentType = garmentType;
    }

    public Integer getAgeOfGarment() {
        return ageOfGarment;
    }

    public void setAgeOfGarment(Integer ageOfGarment) {
        this.ageOfGarment = ageOfGarment;
    }

    public Integer getLevelOfUse() {
        return levelOfUse;
    }

    public void setLevelOfUse(Integer levelOfUse) {
        this.levelOfUse = levelOfUse;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public Integer getSeam() {
        return seam;
    }

    public void setSeam(Integer seam) {
        this.seam = seam;
    }

    public Integer getPrint() {
        return print;
    }

    public void setPrint(Integer print) {
        this.print = print;
    }

    public Integer getShrinkage() {
        return shrinkage;
    }

    public void setShrinkage(Integer shrinkage) {
        this.shrinkage = shrinkage;
    }

    public Integer getMaterial() {
        return material;
    }

    public void setMaterial(Integer material) {
        this.material = material;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDateSubmitted() {
        return dateSubmitted;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

// Date submitted is always set automatically to the current date.
    public void setDateSubmitted(String dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }
}
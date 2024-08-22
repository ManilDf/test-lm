package com.monprojet.product_api.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

@Data
@Document(collection = "produits")
@AllArgsConstructor
public class Produit {

    @Id
    private String id;
    @NotBlank
    private String nom;
    @NonNull
    @Min(0)
    private double prix;

}


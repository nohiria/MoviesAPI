/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.nohiria.movies.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author nohyv
 */
@Document(collection = "reviews")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    private ObjectId id;
    private String body;

    public Review(String body) {
        this.body = body;
    }
}

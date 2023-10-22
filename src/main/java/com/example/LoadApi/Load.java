package com.example.LoadApi;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Load {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
   String loadingPoint;
   String unloadingPoint;
   String productType;
   String truckType;
    int noOfTrucks;
     double weight;
    String comment;
   String shipperId;
    String date;

}

package org.challenge.pz.domain;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Temperature{
    
    @Id
    @SequenceGenerator(name = "tempcitySeq", sequenceName = "temp_city_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "tempcitySeq")
    private Long id;
    
    private String city;
    
    private Integer temperature;

    private Date date;


}

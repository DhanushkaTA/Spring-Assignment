package lk.ijse.gdse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class TechLead implements SuperEntity{
    @Id
    private String tId;
    @Column(nullable = false)
    private String tName;
    @Column(nullable = false)
    private String tAddress;
    @Column(nullable = false)
    private String tMail;

}

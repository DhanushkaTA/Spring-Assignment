package lk.ijse.gdse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class TechLeadDTO {
    private String tId;
    private String tName;
    private String tAddress;
    private String tMail;
}

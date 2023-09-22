package lk.ijse.gdse.spring.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ProjectDTO {
    private int pId;
    private String pName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private TechLeadDTO techLead;
}

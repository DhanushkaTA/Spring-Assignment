package lk.ijse.gdse.spring.service;

import lk.ijse.gdse.spring.dto.TechLeadDTO;

import java.util.List;
public interface TechLeadService {

    TechLeadDTO saveTechLead(TechLeadDTO techLeadDTO);

    TechLeadDTO updateTechLead(TechLeadDTO techLeadDTO);

    void deleteTechLeadByPk(String pk);

    List<TechLeadDTO> getAllTechLead();

    TechLeadDTO searchTechLeadByPk(String id);
}

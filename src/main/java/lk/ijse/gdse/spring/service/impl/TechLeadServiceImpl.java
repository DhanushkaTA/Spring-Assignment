package lk.ijse.gdse.spring.service.impl;

import lk.ijse.gdse.spring.dto.TechLeadDTO;
import lk.ijse.gdse.spring.entity.TechLead;
import lk.ijse.gdse.spring.exception.NotFoundException;
import lk.ijse.gdse.spring.repo.TechLeadRepo;
import lk.ijse.gdse.spring.service.TechLeadService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class TechLeadServiceImpl implements TechLeadService {

    @Autowired
    private TechLeadRepo techLeadRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TechLeadDTO saveTechLead(TechLeadDTO techLeadDTO) {

        techLeadDTO.setTId(UUID.randomUUID().toString());
        if (techLeadRepo.existsById(techLeadDTO.getTId()))
            throw new RuntimeException(techLeadDTO.getTId() + " Tech lead id already exist !");

        return modelMapper.map(techLeadRepo.save(modelMapper.map(techLeadDTO, TechLead.class)), TechLeadDTO.class);
    }

    @Override
    public TechLeadDTO updateTechLead(TechLeadDTO techLeadDTO) {

        if (!techLeadRepo.existsById(techLeadDTO.getTId()))
            throw new NotFoundException(techLeadDTO.getTId() + " Tech lead id doesn't exist !");

        return modelMapper.map(techLeadRepo.save(modelMapper.map(techLeadDTO, TechLead.class)), TechLeadDTO.class);
    }

    @Override
    public void deleteTechLeadByPk(String pk) {

        if (!techLeadRepo.existsById(pk))
            throw new NotFoundException(pk + " Tech lead id doesn't exist !");

        techLeadRepo.deleteById(pk);
    }

    @Override
    public List<TechLeadDTO> getAllTechLead() {

        return modelMapper.map(techLeadRepo.findAll(), new TypeToken<List<TechLeadDTO>>(){}.getType());
    }

    @Override
    public TechLeadDTO searchTechLeadByPk(String pk) {

        if (!techLeadRepo.existsById(pk))
            throw new NotFoundException(pk + " Tech lead id doesn't exist !");

        return modelMapper.map(techLeadRepo.findById(pk).get(), TechLeadDTO.class);
    }
}

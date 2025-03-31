package in.kanhajava.organizationservice.service.impl;

import in.kanhajava.organizationservice.dto.OrganizationDto;
import in.kanhajava.organizationservice.entiry.Organization;
import in.kanhajava.organizationservice.exception.ResourceNotFoundException;
import in.kanhajava.organizationservice.repository.OrganizationRepository;
import in.kanhajava.organizationservice.service.OrganizationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.ReadOnlyFileSystemException;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        Organization organization = modelMapper.map(organizationDto, Organization.class);
        Organization savedOrganization = organizationRepository.save(organization);
        return modelMapper.map(savedOrganization, OrganizationDto.class);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization = organizationRepository.findByorganizationCode(organizationCode).orElseThrow(
                () -> new ResourceNotFoundException("Organization with code " + organizationCode + " not found ! \nYou entered Wrong Organization Code !.")
        );
        return modelMapper.map(organization, OrganizationDto.class);
    }
}

package com.medicalDeclaration.service.impl;

import com.medicalDeclaration.model.MedicalDeclaration;
import com.medicalDeclaration.repository.IMedicalDeclarationRepository;
import com.medicalDeclaration.service.IMedicalDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalDeclarationService implements IMedicalDeclarationService {
    @Autowired
    private IMedicalDeclarationRepository medicalDeclarationRepository;

    @Override
    public List<String> getDayAll() {
        return medicalDeclarationRepository.getDayAll();
    }

    @Override
    public List<String> getMonthAll() {
        return medicalDeclarationRepository.getMonthAll();
    }

    @Override
    public List<String> getYearAll() {
        return medicalDeclarationRepository.getYearAll();
    }

    @Override
    public List<String> getGenderAll() {
        return medicalDeclarationRepository.getGenderAll();
    }

    @Override
    public List<String> getNationAll() {
        return medicalDeclarationRepository.getNationAll();
    }

    @Override
    public List<MedicalDeclaration> getMedicalAll(MedicalDeclaration medicalDeclaration) {
        return medicalDeclarationRepository.getMedicalAll(medicalDeclaration);
    }
}

package com.medicalDeclaration.service;

import com.medicalDeclaration.model.MedicalDeclaration;

import java.util.List;

public interface IMedicalDeclarationService {
    List<String> getDayAll();

    List<String> getMonthAll();

    List<String> getYearAll();

    List<String> getGenderAll();

    List<String> getNationAll();

    List<MedicalDeclaration> create(MedicalDeclaration medicalDeclaration);

    List<String> getTravelInformationAll();

    MedicalDeclaration findByIdCard(String idCard);

    List<MedicalDeclaration> findAll();

    void update(MedicalDeclaration medicalDeclaration);
}

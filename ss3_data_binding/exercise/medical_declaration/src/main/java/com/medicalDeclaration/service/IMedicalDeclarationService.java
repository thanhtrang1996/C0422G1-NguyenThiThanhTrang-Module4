package com.medicalDeclaration.service;

import com.medicalDeclaration.model.MedicalDeclaration;

import java.util.List;

public interface IMedicalDeclarationService {
    List<String> getDayAll();

    List<String> getMonthAll();

    List<String> getYearAll();

    List<String> getGenderAll();

    List<String> getNationAll();

    List<MedicalDeclaration> getMedicalAll(MedicalDeclaration medicalDeclaration);
}

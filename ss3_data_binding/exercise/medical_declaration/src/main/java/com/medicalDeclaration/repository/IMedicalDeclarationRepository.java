package com.medicalDeclaration.repository;

import com.medicalDeclaration.model.MedicalDeclaration;

import java.util.List;

public interface IMedicalDeclarationRepository {
    List<String> getDayAll();

    List<String> getMonthAll();

    List<String> getYearAll();

    List<String> getGenderAll();

    List<String> getNationAll();

    List<MedicalDeclaration> getMedicalAll(MedicalDeclaration medicalDeclaration);
}

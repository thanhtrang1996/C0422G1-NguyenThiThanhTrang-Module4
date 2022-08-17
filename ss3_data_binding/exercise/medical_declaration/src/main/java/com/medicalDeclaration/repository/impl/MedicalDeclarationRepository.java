package com.medicalDeclaration.repository.impl;

import com.medicalDeclaration.model.MedicalDeclaration;
import com.medicalDeclaration.repository.IMedicalDeclarationRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MedicalDeclarationRepository implements IMedicalDeclarationRepository {
    private static List<MedicalDeclaration> medicalDeclarationList = new ArrayList<>();
    private static List<String> dayList = new ArrayList<>();
    private static List<String> monthList = new ArrayList<>();
    private static List<String> yearList = new ArrayList<>();
    private static List<String> genderList = new ArrayList<>();
    private static List<String> nationList = new ArrayList<>();



    static  {
        dayList.add("1");
        dayList.add("2");
        dayList.add("3");
        dayList.add("4");
        dayList.add("5");
        dayList.add("6");
        dayList.add("7");
        dayList.add("8");
        dayList.add("9");
        dayList.add("10");
        dayList.add("11");
        dayList.add("12");
        dayList.add("13");
        dayList.add("14");
        dayList.add("15");
        dayList.add("16");
        dayList.add("17");
        dayList.add("18");
        dayList.add("19");
        dayList.add("20");
        dayList.add("21");
        dayList.add("22");
        dayList.add("23");
        dayList.add("24");
        dayList.add("25");
        dayList.add("26");
        dayList.add("27");
        dayList.add("28");
        dayList.add("29");
        dayList.add("30");
        dayList.add("31");
    }
    static {
        monthList.add("1");
        monthList.add("2");
        monthList.add("3");
        monthList.add("4");
        monthList.add("5");
        monthList.add("6");
        monthList.add("7");
        monthList.add("8");
        monthList.add("9");
        monthList.add("10");
        monthList.add("11");
        monthList.add("12");
    }
    static {
        yearList.add("1990");
        yearList.add("1991");
        yearList.add("1992");
        yearList.add("1993");
        yearList.add("1994");
        yearList.add("1995");
        yearList.add("1996");
        yearList.add("1997");
        yearList.add("1998");
        yearList.add("1999");
        yearList.add("2000");
        yearList.add("2001");
        yearList.add("2002");
        yearList.add("2003");
        yearList.add("2004");
        yearList.add("2005");
        yearList.add("2006");
        yearList.add("2007");
        yearList.add("2008");
        yearList.add("2009");
        yearList.add("2010");
        yearList.add("2011");
        yearList.add("2012");
        yearList.add("2013");
        yearList.add("2014");
        yearList.add("2015");
        yearList.add("2016");
        yearList.add("2017");
        yearList.add("2018");
        yearList.add("2019");
        yearList.add("2020");
        yearList.add("2021");
        yearList.add("2022");
    }
    static {
        genderList.add("male");
        genderList.add("female");
        genderList.add("other");

    }
    static{
        nationList.add("Viet Nam");
        nationList.add("Thai Lan");
        nationList.add("Laos");
        nationList.add("Singapore");
        nationList.add("America");
        nationList.add("China");
        nationList.add("Russia");
        nationList.add("Malaysia");
    }

    @Override
    public List<String> getDayAll() {
        return dayList;
    }

    @Override
    public List<String> getMonthAll() {
        return monthList;
    }
    @Override
    public List<String> getYearAll() {
        return yearList;
    }

    @Override
    public List<String> getGenderAll() {
        return genderList;
    }

    @Override
    public List<String> getNationAll() {
        return nationList;
    }

    @Override
    public List<MedicalDeclaration> getMedicalAll(MedicalDeclaration medicalDeclaration) {
        return medicalDeclarationList;
    }
}

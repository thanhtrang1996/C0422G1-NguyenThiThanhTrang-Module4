package com.medicalDeclaration.model;

public class MedicalDeclaration {
    private String name;
    private String dayOfBirth;
    private String gender;
    private String nation;
    private String idCard;
    private String travelInformation;
    private String vehicleNumber;
    private String seats;
    private String departureDay;
    private String departureMonth;
    private String departureYear;
    private String endDate;
    private String endMonth;
    private String endYear;
    private String information;

    public MedicalDeclaration() {
    }

    public MedicalDeclaration(String name, String dayOfBirth, String gender,
                              String nation, String idCard, String travelInformation,
                              String vehicleNumber, String seats, String departureDay,
                              String endDate, String information) {
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
        this.nation = nation;
        this.idCard = idCard;
        this.travelInformation = travelInformation;
        this.vehicleNumber = vehicleNumber;
        this.seats = seats;
        this.departureDay = departureDay;
        this.endDate = endDate;
        this.information = information;
    }

    public String getDepartureMonth() {
        return departureMonth;
    }

    public void setDepartureMonth(String departureMonth) {
        this.departureMonth = departureMonth;
    }

    public String getDepartureYear() {
        return departureYear;
    }

    public void setDepartureYear(String departureYear) {
        this.departureYear = departureYear;
    }

    public String getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(String endMonth) {
        this.endMonth = endMonth;
    }

    public String getEndYear() {
        return endYear;
    }

    public void setEndYear(String endYear) {
        this.endYear = endYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getTravelInformation() {
        return travelInformation;
    }

    public void setTravelInformation(String travelInformation) {
        this.travelInformation = travelInformation;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getDepartureDay() {
        return departureDay;
    }

    public void setDepartureDay(String departureDay) {
        this.departureDay = departureDay;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }


}

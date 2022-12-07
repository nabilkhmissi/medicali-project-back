package com.exemple.authApp.Dtos;


import com.exemple.authApp.entity.Doctor;
import com.exemple.authApp.entity.Speciality;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class DoctorDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private LocalDate creationDate;
    private String address;
    private String gouvernaurat;
    private String zipCode;
    private int prix_consultation;
    private String avatarUrl;
    private Speciality speciality;
    private String rpps_code;
    private boolean valid;


    public static Doctor toEntity(DoctorDto doctorDto){
        Doctor doctor = new Doctor();
        doctor.setId(doctorDto.getId());
        doctor.setFirstName(doctorDto.getFirstName());
        doctor.setLastName(doctorDto.getLastName());
        doctor.setAddress(doctorDto.getAddress());
        doctor.setGouvernaurat(doctorDto.getGouvernaurat());
        doctor.setPostalCode(doctorDto.getZipCode());
        doctor.setPhone(doctorDto.getPhone());
        doctor.setSpeciality(doctorDto.getSpeciality());
        doctor.setRpps_code(doctor.getRpps_code());
        doctor.setAvatarUrl(doctorDto.getAvatarUrl());
        doctor.setValid(doctorDto.isValid());
        doctor.setPrixConsultation(doctor.getPrixConsultation());
        return doctor;
    }

    public static DoctorDto fromEntity(Doctor doctor){
        return DoctorDto.builder()
                .id(doctor.getId())
                .address(doctor.getAddress())
                .firstName(doctor.getFirstName())
                .lastName(doctor.getLastName())
                .creationDate(doctor.getCreationDate())
                .phone(doctor.getPhone())
                .gouvernaurat(doctor.getGouvernaurat())
                .zipCode(doctor.getPostalCode())
                .speciality(doctor.getSpeciality())
                .rpps_code(doctor.getRpps_code())
                .avatarUrl(doctor.getAvatarUrl())
                .valid(doctor.isValid())
                .prix_consultation(doctor.getPrixConsultation())
                .build();
    }



}

package com.spring.covid19.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "covidstatus")
data class ApiCovidEntity(
    @Column(name = "RateHospitalizations")
    val RateHospitalizations: String = "",

    @Column(name = "RateConfirmations")
    val RateConfirmations: String = "",

    @Column(name = "CntSevereSymptoms")
    val CntSevereSymptoms: String = "",

    @Column(name = "CntDeaths")
    val CntDeaths: String = "",

    @Column(name = "RateSevereSymptoms")
    val RateSevereSymptoms: String = "",

    @Column(name = "CntHospitalizations")
    val CntHospitalizations: String = "",

    @Column(name = "CntConfirmations")
    val CntConfirmations: String = "",

    @Id
    @Column(name = "Mmddhh")
    val Mmddhh: String = "",

    @Column(name = "RateDeaths")
    val RateDeaths: String = ""
)

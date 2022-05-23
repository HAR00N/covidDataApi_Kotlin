package com.spring.covid19.repository

import com.spring.covid19.entity.ApiCovidEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CovidRepository : JpaRepository<ApiCovidEntity, Long>
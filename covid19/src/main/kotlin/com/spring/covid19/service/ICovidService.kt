package com.spring.covid19.service

import org.springframework.boot.configurationprocessor.json.JSONObject
import org.springframework.http.ResponseEntity
import java.net.URL

interface ICovidService {

    fun list(): ResponseEntity<*>?

    fun getList(url: URL): JSONObject?
}
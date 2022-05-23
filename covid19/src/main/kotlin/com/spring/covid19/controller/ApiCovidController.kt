package com.spring.covid19.controller

import com.spring.covid19.global.DaoKeyword
import com.spring.covid19.service.ICovidService
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.configurationprocessor.json.JSONObject
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URL

@RestController
@RequestMapping("/api/covid/")
class ApiCovidController (private val covidService: ICovidService) {

    @Value(value = "\${api.covid.url}")
    lateinit var covidUrl: String

    @Value(value = "\${api.covid.key}")
    lateinit var covidKey: String

    var param: ResponseEntity<*>? = null

    @GetMapping("get" + DaoKeyword.COMMON_LIST)
    fun getCovidList(): String? {
        val url = URL(covidUrl + covidKey)
        val items: JSONObject? = covidService.getList(url)

        return items.toString()
    }

    @GetMapping("/")
    fun getList() :ResponseEntity<*>? {
        param = covidService.list()
        
        return param
    }

}
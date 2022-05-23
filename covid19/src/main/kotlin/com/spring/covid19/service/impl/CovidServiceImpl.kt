package com.spring.covid19.service.impl

import com.spring.covid19.repository.CovidRepository
import com.spring.covid19.service.ICovidService
import org.springframework.boot.configurationprocessor.json.JSONObject
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

@Service
class CovidServiceImpl(val covidRepository: CovidRepository): ICovidService {
    override fun list(): ResponseEntity<*>? {
        val list = covidRepository.findAll()
        return ResponseEntity.ok(list)
    }

    override fun getList(url: URL): JSONObject? {
        val urlConnection = url.openConnection() as HttpURLConnection

        val streamReader = InputStreamReader(urlConnection.getInputStream())
        val buffered = BufferedReader(streamReader)

        val contents = StringBuffer()

        while (true) {
            var line = buffered.readLine() ?: break
            contents.append(line)
        }

        val root: JSONObject = JSONObject(contents.toString())

        val res = JSONObject(root.getJSONObject("response").toString())
        val item = JSONObject(res.getJSONArray("result")[0].toString())


        buffered.close()
        urlConnection.disconnect()

        return item
    }
}
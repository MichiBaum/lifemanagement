package com.michibaum.lifemanagementbackend.controller

import com.michibaum.lifemanagementbackend.ApplicationContextProvider
import org.springframework.boot.SpringApplication
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class ApplicationRestController(
    private val applicationContextProvider: ApplicationContextProvider
) {

    private val shutdown = fun() = SpringApplication.exit( applicationContextProvider.getApplicationContext() )

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = ["/lifemanagement/api/application/shutdown"], method = [RequestMethod.POST])
    fun shutdownEndpoint(): Int = shutdown()



}

package com.michibaum.lifemanagementbackend.user.controller.permission

import com.michibaum.lifemanagementbackend.user.converter.toDto
import com.michibaum.lifemanagementbackend.user.domain.Permission
import com.michibaum.lifemanagementbackend.user.dtos.ReturnPermissionDto
import com.michibaum.lifemanagementbackend.user.service.PermissionService
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.transaction.annotation.Isolation
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class PermissionRestController(
    private val permissionService: PermissionService
): PermissionRestControllerDocs {

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
    @PreAuthorize("hasAuthority('USER_MANAGEMENT')")
    @RequestMapping(value = ["/lifemanagement/api/permissions"], method = [RequestMethod.GET], produces = ["application/json" ])
    override fun allPermissions(): List<ReturnPermissionDto> =
        permissionService.findAll()
            .map(Permission::toDto)

}

package com.michibaum.lifemanagementbackend.user.controller

import com.michibaum.lifemanagementbackend.core.argumentresolver.ArgumentResolver
import com.michibaum.lifemanagementbackend.user.converter.toDto
import com.michibaum.lifemanagementbackend.user.domain.User
import com.michibaum.lifemanagementbackend.user.dtos.ReturnUserDto
import com.michibaum.lifemanagementbackend.user.dtos.UpdateUserDto
import com.michibaum.lifemanagementbackend.user.service.UserService
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

@RestController
class UserRestController(
    private val userService: UserService
) {

    @PreAuthorize("hasAuthority('USER_MANAGEMENT')")
    @RequestMapping(value = ["/lifemanagement/api/users"], method = [RequestMethod.GET])
    fun allUsers(): List<ReturnUserDto> =
        userService.findAll()
            .map(User::toDto)

    @RequestMapping(value = ["/lifemanagement/api/users/me"], method = [RequestMethod.GET])
    fun myUsers(@ArgumentResolver currentUser: User): ReturnUserDto =
        currentUser.toDto()

    @RequestMapping(value = ["/lifemanagement/api/users/{id}"], method = [RequestMethod.POST]) // TODO validation that no other user can change another
    fun change(@RequestBody userDto: UpdateUserDto, @PathVariable(name = "id") user: User): ReturnUserDto =
        userService.update(user, userDto)
            .let(userService::save)
            .toDto()

    @PreAuthorize("hasAuthority('USER_MANAGEMENT')")
    @RequestMapping(value = ["/lifemanagement/api/users/{id}/permissions"], method = [RequestMethod.POST])
    fun changePermissions(@RequestBody permissionIds: List<Long>, @PathVariable(name = "id") user: User): ReturnUserDto =
        userService.changePermissions(user, permissionIds)
            .let(userService::save)
            .toDto()

    //TODO create user endpoint
}

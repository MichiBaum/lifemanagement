package com.michibaum.lifemanagementbackend.user.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity(name = "PERMISSION")
class Permission(

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false, name = "permission_name")
    var name: PermissionName

) {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L

    @ManyToMany(mappedBy = "permissions")
    var users: MutableList<User> = arrayListOf()

}
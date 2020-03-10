package com.michibaum.lifemanagementbackend.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.*
import javax.persistence.*

@Entity(name="PERMISSION")
class Permission(

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false, name = "permission_name")
    var name: PermissionName

) {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0L

    @ManyToMany(mappedBy = "permissions", cascade = [CascadeType.MERGE])
    var users: List<User> = ArrayList()

}
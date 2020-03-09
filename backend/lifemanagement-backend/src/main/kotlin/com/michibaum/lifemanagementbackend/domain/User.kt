package com.michibaum.lifemanagementbackend.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity(name="LOGIN_USER")
class User(

    @Column(nullable = false, name = "name", unique = true)
    var name: String,

    @Column(nullable = false, name = "email_address", unique = true)
    var emailAddress: String,

    @Column(nullable = false, name = "password")
    var password: String,

    @Column(nullable = false, name = "enabled")
    var enabled: Boolean, permissions: MutableList<Permission>

) {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0L

    @Column(name = "LAST_LOGIN")
    var lastLogin: Long = 0

    @ManyToMany(cascade = [CascadeType.MERGE], fetch = FetchType.EAGER)
    var permissions: List<Permission> = permissions

}

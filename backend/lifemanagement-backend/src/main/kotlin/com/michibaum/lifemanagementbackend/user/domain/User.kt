package com.michibaum.lifemanagementbackend.user.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import com.michibaum.lifemanagementbackend.calendar.domain.Calendar
import javax.persistence.*

@Entity(name = "LOGIN_USER")
class User(

    @Column(nullable = false, name = "name", unique = true)
    var name: String,

    @Column(nullable = false, name = "email_address", unique = true)
    var emailAddress: String,

    @Column(nullable = false, name = "password")
    var password: String,

    @Column(nullable = false, name = "enabled")
    var enabled: Boolean,

    @ManyToMany(cascade = [CascadeType.MERGE], fetch = FetchType.LAZY)
    var permissions: MutableList<Permission> = arrayListOf(),

    @ManyToMany(cascade = [CascadeType.MERGE], fetch = FetchType.LAZY)
    var calendars: MutableList<Calendar> = arrayListOf()

) {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L

    @Column(name = "LAST_LOGIN")
    var lastLogin: Long = 0

}
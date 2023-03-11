package br.com.amazingapps.playground

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Ipv4Ipv6Test {

    private val service = Ipv4Ipv6()

    @Test
    fun testIpv4() {
        val addresses = listOf("192.168.0.1", "0.0.0.0")

        val result = service.validateAddresses(addresses)

        assertEquals(listOf("Ipv4", "Ipv4"), result)
    }
}
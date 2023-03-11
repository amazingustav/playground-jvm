package br.com.amazingapps.playground

/**
 * Given a inputted IP address list, it must return another list with the following content:
 * If the actual IP is a Ipv4  -> "IPv4"
 * If the actual IP is a Ipv6  -> "IPv6"
 * If the actual IP is invalid -> "Neither"
 *
 * Complete the 'validateAddresses' function below.
 *
 * The function is expected to return a STRING_ARRAY.
 * The function accepts STRING_ARRAY addresses as parameter.
 */
class Ipv4Ipv6 {

    fun validateAddresses(addresses: List<String>): List<String> {
        val results = mutableListOf<String>()

        addresses.forEach {
            results.add(
                when {
                    it.contains(":") -> validateIpv6(it)
                    it.contains(".") -> validateIpv4(it)
                    else -> "Neither"
                }
            )
        }

        return results
    }

    private fun validateIpv6(ip: String): String {
        TODO("Implement me $ip")
    }

    private fun validateIpv4(ip: String): String {
        var result = true

        ip.split(".").forEach {
            if (it == "") return "Neither"

            val intElement = it.toInt()

            if (intElement >= 8 && it.startsWith("0")) result = false

            if (intElement in 0..255) result = true
        }

        return if (result) "Ipv4" else "Neither"
    }
}

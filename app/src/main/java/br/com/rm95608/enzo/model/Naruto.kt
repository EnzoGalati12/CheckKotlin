package br.com.rm95608.enzo.model

class Naruto (
    val id: Int,
    val images: List<String>,
    val name: String,
    val personal: Personal,
)
data class Personal(
    val sex: String,
    val classification: String,
    val occupation: String,
    val affiliation: List<String>,
)
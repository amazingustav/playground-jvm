package br.com.amazingapps.playground.http

import org.springframework.stereotype.Repository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * You are required to write an API that will contain the following endpoint:
 * GET /users:
 * - endpoint should return status code 200 on a successful request;
 * - endpoint should return the data taken from the mocked-up database using the provided helper repository;
 * - endpoint should accept a query parameter "name" which will contain a string;
 * - when parameter "name" is provided, only users whose "name" property is equal to the "name" query parameter 
 * must be returned. If no users with the given "name" are found, an empty array must be returned.
 *
 * POST /users:
 * - accept a payload in JSON format;
 * - accept two properties in the payload: "name" and "age";
 * - return status code "400" if either "name" or "age" is missing;
 * - return status code "400" if the "name" is longer than 32 characters;
 * - return status code "400" if the "age" is less than 16;
 * - call the "repository.save" function if the above three conditions do not fail, and send the JSON body
 * with the object that is returned from the "save" function along with a "201" status code.
 * 
 * Hints
 * - You can assume that the "id", "name" and "role" properties of the users returned from the database are present 
 * and of the correct types. You do not have to verify them.
 * - You do not have to take care of unsuccessful requests; the response is always successful and the status code must equal "200".
 **/
@RestController
@RequestMapping("/users")
class UserRestController(private val repository: UserRepository) {

    @GetMapping
    fun getUsers(@RequestParam(required = false) name: String?): ResponseEntity<List<UserDto>> {
        val users = if (name != null) {
            repository.findAll().filter { it.name == name }
        } else {
            repository.findAll()
        }
        return ResponseEntity.ok(users)
    }

    @PostMapping
    fun create(@RequestBody user: CreateUserDto): ResponseEntity<Any> {
        try {
            user.validate()

            val savedUser = repository.save(user)
            return ResponseEntity.status(HttpStatus.CREATED).body(savedUser)
        } catch (e: IllegalArgumentException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.message)
        }
    }

    private fun CreateUserDto.validate() {
        when {
            this.name == null || this.age == null -> throw IllegalArgumentException("Name and age must be provided.")
            this.name.length > 32 -> throw IllegalArgumentException("Name exceeds the 32 character limit.")
            this.age < 16 -> throw IllegalArgumentException("Age must be 16 or above.")
        }
    }
}

@Repository
class UserRepository {

    fun findAll(): List<UserDto> {
        return listOf(
            UserDto(1, "Steve", "admin"),
            UserDto(2, "Tony", "developer"),
            UserDto(3, "Natasha", "developer"),
            UserDto(4, "Natasha", "admin"),
            UserDto(5, "Natasha", "designer")
        )
    }

    fun save(user: CreateUserDto): UserDto {
        return UserDto(1, user.name!!, "admin")
    }
}

data class UserDto(val id: Int, val name: String, val role: String)
data class CreateUserDto(val name: String?, val age: Int?)
package br.com.amazingapps.playground.http

import com.fasterxml.jackson.databind.ObjectMapper
import com.nhaarman.mockitokotlin2.given
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@WebMvcTest(UserRestController::class)
class UserRestControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var repository: UserRepository

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Test
    fun `getUsers returns all users when name is not specified`() {
        val users = listOf(
            UserDto(1, "Steve", "admin"),
            UserDto(2, "Tony", "developer")
        )

        given(repository.findAll()).willReturn(users)

        mockMvc.perform(get("/users"))
            .andExpect(status().isOk)
            .andExpect(content().json(objectMapper.writeValueAsString(users)))
    }

    @Test
    fun `create returns 400 when name or age is missing`() {
        val user = CreateUserDto(null, 19)

        mockMvc.perform(post("/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(user)))
            .andExpect(status().isBadRequest)
    }

    @Test
    fun `create returns 201 when valid user is provided`() {
        val user = CreateUserDto("Steve", 19)
        val savedUser = UserDto(1, "Steve", "admin")

        given(repository.save(user)).willReturn(savedUser)

        mockMvc.perform(post("/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(user)))
            .andExpect(status().isCreated)
            .andExpect(content().json(objectMapper.writeValueAsString(savedUser)))
    }
}
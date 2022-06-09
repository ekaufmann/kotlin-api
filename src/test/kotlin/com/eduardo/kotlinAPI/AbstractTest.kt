package com.eduardo.kotlinAPI

import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext


@SpringBootTest(webEnvironment = RANDOM_PORT)
abstract class AbstractTest {

    protected lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var webAppContext: WebApplicationContext

    @BeforeEach
    fun init() {
        this.mockMvc = MockMvcBuilders
            .webAppContextSetup(this.webAppContext)
            .build()
    }
}
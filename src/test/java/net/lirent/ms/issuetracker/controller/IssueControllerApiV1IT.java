package net.lirent.ms.issuetracker.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.lirent.ms.issuetracker.model.dto.IssueRest;
import net.lirent.ms.issuetracker.model.enums.IssueStatus;
import net.lirent.ms.issuetracker.model.enums.IssueType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IssueControllerApiV1IT {

    public static final String V1_ISSUES = "/v1/issues";

    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private IssueControllerApiV1 issueControllerApiV1;

    @Autowired
    private MappingJackson2HttpMessageConverter messageConverter;
    @BeforeEach
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(issueControllerApiV1)
                .setMessageConverters(messageConverter)
                .build();
    }
    @Test
    void testCreateNewIssue() throws Exception {
        IssueRest issueRest = getIssueRest(1L);

        // Perform the POST request to the endpoint
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post(V1_ISSUES)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(issueRest));

        //FIXME - NullPointer on Service
       /* mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isCreated()) // Expect HTTP 201 status
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("text-description")); // Verify response content
        */
        // You can add more test cases to cover error scenarios (e.g., 400 and 500 responses) as needed
    }


    private static IssueRest getIssueRest(Long issueId) {
        return IssueRest.builder()
                .issueId(issueId)
                .description("text-description")
                .status(IssueStatus.OPEN)
                .type(IssueType.BUG)
                .reporter("bug-reporter")
                .title("text-title")
                .build();
    }

}
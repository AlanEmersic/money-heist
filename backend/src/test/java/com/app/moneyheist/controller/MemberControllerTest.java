package com.app.moneyheist.controller;

import com.app.moneyheist.dto.MemberSkillDto;
import com.app.moneyheist.dto.SkillDto;
import com.app.moneyheist.model.Status;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getMember() throws Exception {
        Long id = 1L;
        String name = "Berlin";
        String sex = "M";
        String email = "berlin@gmail.com";
        Status status = Status.AVAILABLE;
        SkillDto mainSkill = new SkillDto(1L, "leadership");
        List<MemberSkillDto> skills = List.of(
                new MemberSkillDto(1L, 5L, "leadership"),
                new MemberSkillDto(2L, 3L, "combat"));

        this.mockMvc.perform(get("/api/members/" + id))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.sex").value(sex))
                .andExpect(jsonPath("$.email").value(email))
                .andExpect(jsonPath("$.status").value(status.toString()))
                .andExpect(jsonPath("$.mainSkill.id").value(mainSkill.id()))
                .andExpect(jsonPath("$.mainSkill.name").value(mainSkill.name()))
                .andExpect(jsonPath("$.skills[0].id").value(skills.get(0).id()))
                .andExpect(jsonPath("$.skills[0].level").value(skills.get(0).level()))
                .andExpect(jsonPath("$.skills[0].name").value(skills.get(0).name()))
                .andExpect(jsonPath("$.skills[1].id").value(skills.get(1).id()))
                .andExpect(jsonPath("$.skills[1].level").value(skills.get(1).level()))
                .andExpect(jsonPath("$.skills[1].name").value(skills.get(1).name()));
    }

    @Test
    void getAllMembers() throws Exception {
        this.mockMvc.perform(get("/api/members"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    void createMember() {
    }

    @Test
    void deleteMember() {
    }

    @Test
    void updateMemberSkills() {
    }
}

package com.project.nairon.service.naironuser;

import com.project.nairon.ServiceConfig;
import com.project.nairon.models.naironuser.NaironUser;
import com.project.nairon.repository.customer.NaironUserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;


/**
 * @author tobi
 */

@SpringBootTest(classes = ServiceConfig.class)
class NaironUserDetailsServiceImplImplTest {

    @Mock
    private NaironUserRepository naironUserRepository;

    NaironUser naironUser;

    @BeforeEach
    void setUp() {

        naironUser = new NaironUser();

        naironUserRepository = mock(NaironUserRepository.class);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {

        when(naironUserRepository.save(isA(NaironUser.class))).thenReturn(naironUser);
        naironUserRepository.save(naironUser);

        verify(naironUserRepository, times(1)).save(naironUser);

    }
}
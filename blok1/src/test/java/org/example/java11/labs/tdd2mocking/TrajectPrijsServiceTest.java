package org.example.java11.labs.tdd2mocking;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TrajectPrijsServiceTest {

    @InjectMocks
    private TrajectPrijsService target/* = new TrajectPrijsService()*/;

    @Mock
    private TrajectNaarTrajectEenhedenService esMock /*= Mockito.mock(TrajectNaarTrajectEenhedenService.class)*/;

    @Mock
    private TrajectEenhedenNaarPrijsService psMock;

    @Test
    void testGetTrajectPrijs() {
        // given
        when(esMock.getTrajectEenheden(eq("Ut"), eq("Am"))).thenReturn(10);
        // when(esMock.getTrajectEenheden(eq("Ut"), eq("En"))).thenReturn(20);
        when(psMock.getPriceTrajectEenheden(anyInt())).thenReturn(3);

        // when
        int trajectPrijs = target.getTrajectPrijs("Ut", "Am");

        // then
        assertThat(trajectPrijs).isEqualTo(30);
        verify(esMock).getTrajectEenheden(anyString(), anyString()/*, times(1)*/);
        verify(psMock).getPriceTrajectEenheden(anyInt());
    }
}

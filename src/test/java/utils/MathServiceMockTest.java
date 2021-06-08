package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class MathServiceMockTest {
    @Test
    @DisplayName("Testing add")
    public void addMockText(){
        MathService mathService = mock(MathService.class);


        when(mathService.add(2,3)).thenReturn(5);
        when(mathService.add(5,6)).thenReturn(5);
        assertEquals(mathService.add(2,3),5);
        assertEquals(mathService.add(5,6),5);
        verify(mathService,times(1)).add(2,3);//Mockito Verify methods are used to check that certain behavior happened.
        // We can use Mockito verify methods at the end of the testing method code to make sure that specified methods are called.
        // times(n)->to verify how many times it was run other:atLeast(),atMost(),never()
        //verifyNoMoreInteractions(mathService);
    }

}
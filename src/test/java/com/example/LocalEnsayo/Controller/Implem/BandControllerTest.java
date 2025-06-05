package com.example.LocalEnsayo.Controller.Implem;

import com.example.LocalEnsayo.Model.Band;
import com.example.LocalEnsayo.Service.Interfaces.IBandService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BandControllerTest {

    @InjectMocks
    private BandController bandController;

    @Mock
    private IBandService bandService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createBand_returnsCreatedBand() {
        Band inputBand = new Band();
        inputBand.setBandName("fakeBand");
        inputBand.setBandPhone(123456789L);
        inputBand.setBandMail("fake@band.com");

        Band savedBand = new Band();
        savedBand.setId(1L);
        savedBand.setBandName("fakeBand");
        savedBand.setBandPhone(123456789L);
        savedBand.setBandMail("fake@band.com");

        when(bandService.createBand(inputBand)).thenReturn(savedBand);

        Band result = bandController.createBand(inputBand);

        assertNotNull(result);
        assertEquals("fakeBand", result.getBandName());
        assertEquals(1L, result.getId());
        verify(bandService).createBand(inputBand);
    }

    @Test
    void findById_returnsBandIfExists() {
        Band band = new Band();
        band.setId(1L);
        band.setBandName("fakeBand");

        when(bandService.findById(1L)).thenReturn(Optional.of(band));

        Optional<Band> result = bandController.findById(1L);

        assertTrue(result.isPresent());
        assertEquals("fakeBand", result.get().getBandName());
        verify(bandService).findById(1L);
    }

    @Test
    void findById_returnsEmptyIfNotExists() {
        when(bandService.findById(99L)).thenReturn(Optional.empty());

        Optional<Band> result = bandController.findById(99L);

        assertFalse(result.isPresent());
        verify(bandService).findById(99L);
    }
}


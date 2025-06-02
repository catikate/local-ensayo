package com.example.LocalEnsayo.Service.Interfaces;

import com.example.LocalEnsayo.Model.Booking;
import com.example.LocalEnsayo.DTO.BookingDTO;

import java.util.List;
import java.util.Optional;

public interface IBookingService {
    Booking createBooking(BookingDTO dto);

    List<Booking> findAll();

    Optional<Booking> findById(Long id);

    void deleteById(Long id);
}

//
//interface Disco {
//    String girarDisco();
//}
//
//
//class Pua {}
//
//class DiscoDeVinilo implements Disco {
//    private Pua pua;
//
//    public DiscoDeVinilo(Pua pua) {
//        this.pua = pua;
//    }
//
//    @Override
//    public String girarDisco() {
//        return this.pua + "";
//    }
//}
//
//class Tocadiscos {
//    private Disco disco;
//
//    public Tocadiscos(Disco disco) {
//        this.disco = disco;
//    }
//
//    public String reproducir() {
//        System.out.println(this.disco.girarDisco() + " escuchando");
//    }
//}
//
//class TestDisco implements Disco {
//    String disco;
//
//    public TestDisco(String disco) {
//        this.disco = disco;
//    }
//
//    @Override
//    public String girarDisco() {
//        return disco;
//    }
//}
//
//class TocadiscosTest {
//    public void testReproducir() {
//        Disco testDisc = new TestDisco("quiero ese resultado");
//        Tocadiscos tocadiscos = new Tocadiscos(testDisc);
//        Assert.isTrue(tocadiscos.equals("quiero ese resultado"), tocadiscos.reproducir());
//    }
//}

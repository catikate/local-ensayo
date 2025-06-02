package com.example.LocalEnsayo.Repository;

import com.example.LocalEnsayo.Model.Band;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BandRepository extends JpaRepository <Band, Long> {
}

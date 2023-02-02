/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.unam.sa.autorizador.repository;

import mx.unam.sa.autorizador.entities.Subsistema;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author unam
 */
public interface SubsistemaRepo extends JpaRepository <Subsistema, Integer>{
    
}


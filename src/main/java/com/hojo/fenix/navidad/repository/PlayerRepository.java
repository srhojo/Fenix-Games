package com.hojo.fenix.navidad.repository;

import com.hojo.fenix.navidad.entity.PlayerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends CrudRepository<PlayerEntity,Long> {

    List<PlayerEntity> findAll();

    List<PlayerEntity> findAllByJuegadoFalse();

    Optional<PlayerEntity> findByNombre(String nombre);


    Optional<PlayerEntity> findByNombreAndJuegadoFalse(String nombre);

    @Query(value = "select p from PlayerEntity p where p.nombre not in  (select p.asigandoA from PlayerEntity p where p.asigandoA is not null) and p.nombre <> :name")
    List<PlayerEntity> findFreePlayers(@Param("name") String name);

}

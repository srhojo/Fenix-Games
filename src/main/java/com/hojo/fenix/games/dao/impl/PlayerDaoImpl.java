package com.hojo.fenix.games.dao.impl;

import com.hojo.fenix.games.dao.repository.PlayerRepository;
import com.hojo.fenix.games.dao.PlayerDao;
import com.hojo.fenix.games.domain.entity.PlayerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;

@Repository
@Transactional
public class PlayerDaoImpl implements PlayerDao {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerDaoImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public PlayerEntity save(@Valid PlayerEntity s) {
        s.setId(null);//Settear a null or throw Exception?
        return playerRepository.save(s);
    }

    @Override
    public PlayerEntity update(@Valid PlayerEntity s) {
        return playerRepository.findById(s.getId()).map(previous -> {
            //map only data who I want to update
            previous.setName(s.getName());
            return playerRepository.save(previous);
        }).orElseThrow(() -> new RuntimeException());
    }

    @Override
    public List<PlayerEntity> retrieveAll() {
        return playerRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        playerRepository.deleteById(id);
    }
}
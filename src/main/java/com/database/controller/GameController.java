package com.database.controller;

import com.database.entity.Action;
import com.database.entity.Game;
import com.database.entity.User;
import com.database.entity.dto.ActionDto;
import com.database.entity.dto.ForgetPasswordDto;
import com.database.entity.dto.GameDto;
import com.database.repository.ActionRepository;
import com.database.repository.GameRepository;
import com.database.repository.UserRepository;
import com.database.security.TokenManager;
import com.database.service.UserService;
import com.mail.Mail;
import com.mail.MailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Controller for password reset
 */
@RestController
@Api(value = "Password Reset Controller Documentation")
public class GameController {


    @Autowired
    GameRepository gameRepository;

    @Autowired
    ActionRepository actionRepository;

    @PostMapping("/addAction")
    public ResponseEntity<Game> addAction(@RequestBody ActionDto actionDto) {

        List<Game> games = gameRepository.findAll();
        for(Game game : games) {
            if (game.getUser1().equals(actionDto.getName()) || game.getUser2().equals(actionDto.getName())) {
                System.out.println(actionDto.getName() + actionDto.getType());
                Action action = new Action(actionDto.getName() , actionDto.getType(), actionDto.getDice1() , actionDto.getDice2(),game);
                actionRepository.save(action);
                return new ResponseEntity<>(game,HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(null , HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/getAction")
    public ResponseEntity<Action> getAction(@RequestBody GameDto gameDto) {

        Game game = gameRepository.findByUser1(gameDto.getName());
        if (game == null) {game = gameRepository.findByUser2(gameDto.getName());}
        if(game.getActions().size() == 0) return new ResponseEntity<>(null , HttpStatus.NOT_ACCEPTABLE);
        return new ResponseEntity<>(game.getActions().get(0),HttpStatus.OK );

    }

    @PostMapping("/deleteAction")
    public HttpStatus deleteAction(@RequestBody GameDto gameDto) {

        Game game = gameRepository.findByUser1(gameDto.getName());
        if (game == null) {game = gameRepository.findByUser2(gameDto.getName());}
        if(game.getActions().size() == 0) {
            return HttpStatus.NOT_ACCEPTABLE;
        }
        actionRepository.delete(game.getActions().get(0));
        return HttpStatus.OK;

    }
    @PostMapping("/findGame")
    public ResponseEntity<Game> findGames(@RequestBody GameDto gameDto) throws Exception {


        List<Game> games = gameRepository.findAll();
        if(games == null) {

            Game newGame = Game.fromDto(gameDto);
            gameRepository.save(newGame);
            return new ResponseEntity<>(newGame , HttpStatus.CREATED);
        }

        for(Game game : games) {
            if (game.getUser1().equals(gameDto.getName())) {
                if(game.isSearchUser() == false) {
                    return new ResponseEntity<>(game , HttpStatus.FOUND);
                }
                else {
                    return new ResponseEntity<>(game , HttpStatus.ALREADY_REPORTED);
                }

            }
            if(game.isSearchUser()) {

                game.matchUsers(gameDto.getName());
                gameRepository.save(game);
                return new ResponseEntity<>(game , HttpStatus.FOUND);
            }
        }
        Game newGame = new Game(gameDto.getName());
        gameRepository.save(newGame);
        return new ResponseEntity<>(newGame , HttpStatus.CREATED);

    }

    @GetMapping("/getGames")
    public ResponseEntity<List<Game>> processForgotPassword() throws Exception {
        return new ResponseEntity<>(gameRepository.findAll(),HttpStatus.OK);

    }

    @GetMapping("/deleteGames")
    public HttpStatus deleteGames() {
        gameRepository.deleteAll();
        return HttpStatus.OK;
    }


}

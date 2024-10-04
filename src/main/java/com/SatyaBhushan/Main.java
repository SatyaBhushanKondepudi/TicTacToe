package com.SatyaBhushan;

import com.SatyaBhushan.controller.GameController;
import com.SatyaBhushan.models.Bot;
import com.SatyaBhushan.models.Game;
import com.SatyaBhushan.models.Player;
import com.SatyaBhushan.models.Symbol;
import com.SatyaBhushan.models.enums.BotDifficultyLevel;
import com.SatyaBhushan.models.enums.GameStatus;
import com.SatyaBhushan.models.enums.PlayerType;
import com.SatyaBhushan.stratergies.winningStratergies.OrderOneColumnWinningStratergy;
import com.SatyaBhushan.stratergies.winningStratergies.OrderOneDiagonalWinningStrategy;
import com.SatyaBhushan.stratergies.winningStratergies.OrderOneRowWinningStrategy;

import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
        Create a game
        While gamestaus is inprogress
            Print the board
            print if undo
            if yes --> Call undo
            else --> move next player

            check status of game
            If winner --> Print winner
            Else --> Print draw
         */
        GameController gameController = new GameController();
        Scanner scanner = new Scanner(System.in);
//        Game game = gameController.createGame();


        Game game ;
        List<Player> playersInputlist = List.of(new Player(new Symbol('X') , "Satya" , PlayerType.HUMAN),
                new Bot(new Symbol('O') , "Bot" , BotDifficultyLevel.EASY ));
        try{
            game = gameController.createGame(
                    3 , playersInputlist,
                    List.of(new OrderOneDiagonalWinningStrategy(3, playersInputlist) ,
                            new OrderOneRowWinningStrategy(3, playersInputlist),
                            new OrderOneColumnWinningStratergy(3, playersInputlist))
            );
        }catch(Exception ex){
            System.out.println("Something went wrong");
            return;
        }


        System.out.println("-------------- Game is starting --------------");

        while(gameController.getGameStatus(game).equals(GameStatus.IN_PROGRESS)){
            System.out.println("This is how board looks like:");
            // print board
            gameController.displayBoard(game);
            // print if undo
            System.out.println("Do you want to UNDO ? (Y/N)");
            // if yes -> call undo
            String input = scanner.next();
            if (input.equalsIgnoreCase("Y")){
                gameController.undo(game);
            }else{
                // move next player
                gameController.makeMove(game);
            }
        }
        // check status of game


        gameController.printResult(game);
        gameController.displayBoard(game);
        // else -> print draw

    }
}
package com.invaders.api;

import com.invaders.api.database.Connect;
import com.invaders.api.model.Player;
import com.invaders.api.Config;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
 * @project py-api
 * @author Patrity - https://github.com/Patrity
 * Created on - 10/30/2020
 */

@RequestMapping("api/player")
@RestController
public class PlayerController {


    @PostMapping
    public void addPlayer(@RequestBody Player player) throws SQLException {
        Connection con = Connect.make();
        String statement = "INSERT INTO highscores (player_name, score) VALUES (?, ?)";
        PreparedStatement ps = con.prepareStatement(statement);
        ps.setString(1, player.getName());
        ps.setInt(2, player.getScore());
        ps.execute();
        System.out.println("name: " + player.getName() + " score: " + player.getScore());
    }

    @GetMapping
    public List<Player> getTopTen() throws SQLException {
        List<Player> players = new ArrayList<Player>();
        String query = "SELECT player_name, score FROM highscores ORDER BY score DESC LIMIT 10";
        Connection con = Connect.make();

        try (Statement statement = con.createStatement()) {
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                players.add(new Player(rs.getString(1), rs.getInt(2)));
            }
        }
        return players;
    }
}

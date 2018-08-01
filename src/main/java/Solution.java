import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Solution {
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";
    private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/test2?serverTimezone=UTC&useSSL=false";
    private static final String INSERT_NEW = "INSERT INTO films VALUES(?,?,?,?,?)";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");

        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://itunes.apple.com/us/tv-season/all-the-way/id1110849356");
        Film film = new Film(chromeDriver, "https://itunes.apple.com/us/tv-season/all-the-way/id1110849356");

        try(Connection connection = DriverManager.getConnection(CONNECTION_URL, USER_NAME, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW)){
            preparedStatement.setInt(1, film.getId());
            preparedStatement.setString( 2,film.getFilmUrl());
            preparedStatement.setString(3,film.getTitle());
            preparedStatement.setString(4,film.getDescription());
            preparedStatement.setString(5,film.getPrice());
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }

        chromeDriver.quit();
    }
}

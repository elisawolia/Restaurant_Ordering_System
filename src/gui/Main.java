package gui;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Main {
	public static void main(String[] args) {
		try{
             Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
             try (Connection conn = getConnection()){

                System.out.println("Connection succesfull!");
             }
         }
         catch(Exception ex){
             System.out.println("Connection failed...");
             System.out.println(ex);
         }


		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MainFrame();
			}
		});
	}

	public static Connection getConnection() throws SQLException, IOException {

		Properties props = new Properties();
		try(InputStream in = Files.newInputStream(Paths.get("gui/database.properties"))){
			props.load(in);
		}
		String url = props.getProperty("url");
		String username = props.getProperty("username");
		String password = props.getProperty("password");

		return DriverManager.getConnection(url, username, password);
	}
}

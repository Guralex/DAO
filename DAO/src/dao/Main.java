package dao;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WeatherDAO w= new WeatherDAO();
		    
		    System.out.println(w.averByArea(200)); 
		}

}

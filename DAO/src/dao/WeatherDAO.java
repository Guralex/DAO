package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WeatherDAO extends AbstractDAO<Integer, Weather> {
	  public static final String SQL_SELECT_ALL_ABONENTS="SELECT * FROM weather";
	  public static final String SQL_SELECT_WEATHER_BY_REG=
			  "SELECT * FROM weather WHERE region=?";
	  public static final String SQL_SELECT_SNOW=
			  "SELECT * FROM weather WHERE region=? AND temp<? AND temp<0 AND water>0";
	  public static final String SQL_SELECT_LANG=
			  " SELECT * FROM WEATHER WHERE REGION IN( SELECT NAME FROM REGIONS WHERE HABITATS =( SELECT NAME FROM HABITATS WHERE LANGUAGE = ?) AND DATE > (curdate()-INTERVAL 7 DAY))";
	  
	  public static final String SQL_SELECT_area=
			  " SELECT * FROM WEATHER WHERE REGION IN( SELECT NAME FROM REGIONS WHERE AREA>?)";
	 
	  @Override
	public List<Weather> findAll() {
	  List<Weather>  weathers= new ArrayList<>();
	  Connection cn=null;
	  Statement st=null;
	  try {
	cn=ConnectorDB.getConnection();
	st=cn.createStatement();
	ResultSet rs= st.executeQuery(SQL_SELECT_ALL_ABONENTS);
	while(rs.next()){
		 int id =rs.getInt(1);
		 int temp=rs.getInt(4);
		 int water=rs.getInt(5);
		 String region=rs.getString(2);
		 String date=rs.getString(3);
	weathers.add(new Weather(id,temp,water,region,date));
	}

	} catch (SQLException e) {
	System.err.println("SQL Exeption (request or table failed):"+e);
	}
	  
	return weathers;
	}


private void getString(int i) {
		// TODO Auto-generated method stub
		
	}


	public Weather findWeatherByReg(String reg){
	Weather weather = new Weather();
	Connection cn=null;
	PreparedStatement st=null;
	try {
	cn=ConnectorDB.getConnection();
	st=cn.prepareStatement(SQL_SELECT_WEATHER_BY_REG);
	st.setString(1, reg);
	ResultSet resultSet = st.executeQuery();
	resultSet.next();
	
	weather.setId(resultSet.getInt("id"));
	weather.setRegion(reg);
	weather.setTemp(resultSet.getInt("temp"));
	weather.setWater(resultSet.getInt("water"));
	weather.setDate(resultSet.getString("date"));
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	System.err.println("SQL exception (request or table failed):"+e);
	}

	
	return weather;

	}

	public  List<Weather> snow(String reg,int t){
	
		List<Weather>  weathers= new ArrayList<>();
		  Connection cn=null;
		  PreparedStatement st=null;
		  try {
		cn=ConnectorDB.getConnection();
		st=cn.prepareStatement(SQL_SELECT_SNOW);
		st.setString(1, reg);
		st.setLong(2, t);
		ResultSet rs= st.executeQuery();
		while(rs.next()){
			 int id =rs.getInt(1);
			 int temp=rs.getInt(4);
			 int water=rs.getInt(5);
			 String region=rs.getString(2);
			 String date=rs.getString(3);
		weathers.add(new Weather(id,temp,water,region,date));
		}

		} catch (SQLException e) {
		System.err.println("SQL Exeption (request or table failed):"+e);
		}
		
		  System.out.println("Snow in "+reg);
		  return weathers;
	}
	
	
	
	public  List<Weather> findByLanguage(String lang){
		
		List<Weather>  weathers= new ArrayList<>();
		  Connection cn=null;
		  PreparedStatement st=null;
		  try {
		cn=ConnectorDB.getConnection();
		st=cn.prepareStatement(SQL_SELECT_LANG);
		st.setString(1, lang);
		
		ResultSet rs= st.executeQuery();
		while(rs.next()){
			 int id =rs.getInt(1);
			 int temp=rs.getInt(4);
			 int water=rs.getInt(5);
			 String region=rs.getString(2);
			 String date=rs.getString(3);
		weathers.add(new Weather(id,temp,water,region,date));
		}

		} catch (SQLException e) {
		System.err.println("SQL Exeption (request or table failed):"+e);
		}
		
		  System.out.println("Snow lang "+lang);
		  return weathers;
	}
	
	public  int averByArea(int ar){
		
		int res=0;
		List<Weather>  weathers= new ArrayList<>();
		  Connection cn=null;
		  PreparedStatement st=null;
		  try {
		cn=ConnectorDB.getConnection();
		st=cn.prepareStatement(SQL_SELECT_area);
		st.setInt(1, ar);
		
		ResultSet rs= st.executeQuery();
		while(rs.next()){
			 int id =rs.getInt(1);
			 int temp=rs.getInt(4);
			 int water=rs.getInt(5);
			 String region=rs.getString(2);
			 String date=rs.getString(3);
		weathers.add(new Weather(id,temp,water,region,date));
		}

		} catch (SQLException e) {
		System.err.println("SQL Exeption (request or table failed):"+e);
		}
		
		 for(Weather weather:weathers) {res+=weather.getTemp(); System.out.println(weather.getTemp());}
		 
		 res=res/weathers.size();
		  
		  System.out.println("Aver temp in regions with area< "+ar);
		  return res;
	}
	
	
	
	
	@Override
	public boolean delete(Weather entity) {
		System.out.println("Я ленивый");
		return false;
	}

	@Override
	public boolean create(Weather entity) {
		System.out.println("Я ленивый");
		return false;
	}

	@Override
	public Weather update(Weather entity) {
		System.out.println("Я ленивый");
		return null;
	}


	@Override
	public Weather findEntityById(Integer Id) {
		System.out.println("Я ленивый");
		return null;
	}


	@Override
	public boolean delete(Integer Id) {
		System.out.println("Я ленивый");
		return false;
	}

	}

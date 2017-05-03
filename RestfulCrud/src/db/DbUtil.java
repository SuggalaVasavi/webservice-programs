package db;



import java.sql.Connection;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import dao.DbConnection;



public class DbUtil {



	public static void close(DbConnection connection) {

		if (connection != null) {

			try {

				connection.close();

			} catch (SQLException e) {

				

			}

		}

	}



	public static void close(Statement ps) {

		if (ps != null) {

			try {

				ps.close();

			} catch (SQLException e) {

				

			}

		}

	}



	public static void close(ResultSet resultSet) {

		if (resultSet != null) {

			try {

				resultSet.close();

			} catch (SQLException e) {

				

			}

		}

	}



	

}
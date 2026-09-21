package com.apinest.Config;

import java.io.IOException;
import java.util.Properties;

import org.jdbi.v3.core.Jdbi;

import com.apinest.Model.User;
import com.apinest.Model.Enum.UserRole;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariConfigMXBean;
import com.zaxxer.hikari.HikariDataSource;

public class Database {
  private static Jdbi jdbi;
  private static HikariDataSource dataSource;

  public static Jdbi getJdbi() {
    if (jdbi == null) {
      jdbi.create(getDataSource());
      jdbi.registerColumnMapper(User.class, (rs, col, ctx) -> UserRole.valueOf(rs.getString(col)));
    }
  }

  public static Properties loadPorperties() {
    Properties props = new Properties();
    try (InputStream input = Database.class.getResourceAsStream("/application.properties")) {
      if (input != null) {
        props.load(input);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    if (System.getenv("DB_URL") != null)
      props.setProperty("db.url", System.getenv("DB_URL"));
    if (System.getenv("DB_USER") != null)
      props.setProperty("db.user", System.getenv("DB_USER"));
    if (System.getenv("DB_PASSWORD") != null)
      props.setProperty("db.password", System.getenv("DB_PASSWORD"));
    if (System.getenv("JWT_SECRET") != null)
      props.setProperty("jwt.secret", System.getenv("JWT_SECRET"));
    return props;
  }

  public static HikariDataSource getDataSource() {
    if (dataSource == null) {
      Properties props = Database.loadPorperties();
      HikariConfig config = new HikariConfig();
      config.setDriverClassName("org.postgresql.Driver");
      config.setJdbcUrl(props.getProperty("db.url"));
      config.setUsername(props.getProperty("db.user"));
      config.setPassword(props.getProperty("db.password"));

      dataSource = new HikariDataSource(config);
    }
    return dataSource;
  }
}

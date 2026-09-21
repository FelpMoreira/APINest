package com.apinest.Model;

public class User {
  private Long id;
  private String username;
  private String email;
  private String role;
  private boolean ativo;

  public User() {}

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public String getUsername() { return username; }
  public void setUsername(String username) { this.username = username; }

  public String getEmail() { return email; }
  public void setEmail(String email) { this.email = email; }

  public String getRole() { return role; }
  public void setRole(String role) { this.role = role; }

  public boolean getAtivo() { return ativo; }
  public void setAtivo(boolean ativo) { this.ativo = ativo; }
}

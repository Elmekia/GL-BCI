package com.gl.bci.entity;


import com.gl.bci.dto.UserDtoCreate;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name = "users")
@Builder
public class User {

  @Id
  private UUID id;

  @Column()
  private LocalDateTime created;

  @Column(name = "last_login")
  private LocalDateTime lastLogin;

  @Column()
  private String token;

  @Column(name = "is_active")
  private boolean isActive;

  @Column()
  private String name;

  @Column()
  private String email;

  @Column()
  private String password;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
  private List<Phone> phones;

  @PrePersist
  void onCreate() {
    LocalDateTime localDateTime = LocalDateTime.now();
    this.created = localDateTime;
    this.lastLogin = localDateTime;
  }

}
